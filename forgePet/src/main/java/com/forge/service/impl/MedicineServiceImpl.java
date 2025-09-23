// src/main/java/com/forge/service/impl/MedicineServiceImpl.java
package com.forge.service.impl;

import com.forge.entity.Medicine;
import com.forge.mapper.MedicineMapper;
import com.forge.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineMapper.findAll();
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineMapper.findById(id);
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        medicine.setCreateTime(new Date());
        medicineMapper.insert(medicine);
        return true;
    }

    @Override
    public boolean updateMedicine(Medicine medicine) {
        medicineMapper.update(medicine);
        return true;
    }

    @Override
    public boolean deleteMedicine(Long id) {
        medicineMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Medicine> searchMedicines(String keyword) {
        return medicineMapper.findByNameContaining(keyword);
    }
}
