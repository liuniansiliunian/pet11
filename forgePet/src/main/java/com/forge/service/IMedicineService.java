package com.forge.service;

import com.forge.entity.Medicine;
import java.util.List;

public interface IMedicineService {
    List<Medicine> getAllMedicines();
    Medicine getMedicineById(Long id);
    boolean addMedicine(Medicine medicine);
    boolean updateMedicine(Medicine medicine);
    boolean deleteMedicine(Long id);
    List<Medicine> searchMedicines(String keyword);
}