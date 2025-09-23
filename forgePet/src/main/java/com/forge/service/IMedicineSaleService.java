// src/main/java/com/forge/service/IMedicineSaleService.java
package com.forge.service;

import com.forge.dto.MedicineSaleDto;
import com.forge.entity.MedicineSale;
import java.util.Date;
import java.util.List;

public interface IMedicineSaleService {
    boolean sellMedicine(MedicineSaleDto saleDto);
    List<MedicineSale> getSalesByClientId(Long clientId);
    List<MedicineSale> getSalesByDateRange(Date startDate, Date endDate);
    List<MedicineSale> getAllSales();
}
