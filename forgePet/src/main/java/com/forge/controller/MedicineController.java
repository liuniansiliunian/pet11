package com.forge.controller;

import com.forge.common.Result;
import com.forge.entity.Medicine;
import com.forge.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    @GetMapping("/list")
    public Result list() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        return Result.success(medicines); // 使用新的success方法返回数据
    }

    @PostMapping("/add")
    public Result add(@RequestBody Medicine medicine) {
        boolean result = medicineService.addMedicine(medicine);
        if (result) {
            return Result.success("药品添加成功");
        } else {
            return Result.error("药品添加失败");
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody Medicine medicine) {
        boolean result = medicineService.updateMedicine(medicine);
        if (result) {
            return Result.success("药品更新成功");
        } else {
            return Result.error("药品更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        boolean result = medicineService.deleteMedicine(id);
        if (result) {
            return Result.success("药品删除成功");
        } else {
            return Result.error("药品删除失败");
        }
    }

    @GetMapping("/search")
    public Result search(@RequestParam String keyword) {
        List<Medicine> medicines = medicineService.searchMedicines(keyword);
        return Result.success(medicines); // 使用新的success方法返回数据
    }

    // 添加根据ID获取药品的接口
    @GetMapping("/{id}")
    public Result getMedicineById(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine != null) {
            return Result.success(medicine);
        } else {
            return Result.error("药品不存在");
        }
    }
}
