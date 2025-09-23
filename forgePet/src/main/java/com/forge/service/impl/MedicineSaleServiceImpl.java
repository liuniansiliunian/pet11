// src/main/java/com/forge/service/impl/MedicineSaleServiceImpl.java
package com.forge.service.impl;

import com.forge.dto.MedicineSaleDto;
import com.forge.entity.Medicine;
import com.forge.entity.MedicineSale;
import com.forge.mapper.MedicineMapper;
import com.forge.mapper.MedicineSaleMapper;
import com.forge.service.IMedicineSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MedicineSaleServiceImpl implements IMedicineSaleService {

    @Autowired
    private MedicineSaleMapper medicineSaleMapper;

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    @Transactional
    public boolean sellMedicine(MedicineSaleDto saleDto) {
        // 检查库存
        Medicine medicine = medicineMapper.findById(saleDto.getMedicineId());
        if (medicine == null || medicine.getStock() < saleDto.getQuantity()) {
            return false; // 库存不足
        }

        // 创建销售记录
        MedicineSale sale = new MedicineSale();
        sale.setMedicineId(saleDto.getMedicineId());
        sale.setMedicineName(medicine.getName());
        sale.setQuantity(saleDto.getQuantity());
        sale.setUnitPrice(medicine.getPrice());
        sale.setTotalPrice(medicine.getPrice() * saleDto.getQuantity());
        sale.setClientId(saleDto.getClientId());
        sale.setEmployeeId(saleDto.getEmployeeId());
        sale.setSaleTime(new Date());

        // 更新库存
        medicine.setStock(medicine.getStock() - saleDto.getQuantity());
        medicineMapper.update(medicine);

        // 保存销售记录
        medicineSaleMapper.insert(sale);

        return true;
    }

    @Override
    public List<MedicineSale> getSalesByClientId(Long clientId) {
        return medicineSaleMapper.findByClientId(clientId);
    }

    @Override
    public List<MedicineSale> getSalesByDateRange(Date startDate, Date endDate) {
        return medicineSaleMapper.findByDateRange(startDate, endDate);
    }

    @Override
    public List<MedicineSale> getAllSales() {
        return medicineSaleMapper.findAll();
    }
}
