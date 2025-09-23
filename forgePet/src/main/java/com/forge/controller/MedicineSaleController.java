package com.forge.controller;

import com.forge.common.Result;
import com.forge.dto.MedicineSaleDto;
import com.forge.entity.MedicineSale;
import com.forge.service.IMedicineSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine-sale")
public class MedicineSaleController {

    @Autowired
    private IMedicineSaleService medicineSaleService;

    @PostMapping("/sell")
    public Result sell(@RequestBody MedicineSaleDto saleDto) {
        boolean result = medicineSaleService.sellMedicine(saleDto);
        if (result) {
            return Result.success("药品销售成功");
        } else {
            return Result.success("药品销售失败，库存不足");
        }
    }

    @GetMapping("/list")
    public Result list() {
        List<MedicineSale> sales = medicineSaleService.getAllSales();
        return Result.success("获取销售记录成功", sales);
    }

    @GetMapping("/client/{clientId}")
    public Result getByClient(@PathVariable Long clientId) {
        List<MedicineSale> sales = medicineSaleService.getSalesByClientId(clientId);
        return Result.success("获取客户销售记录成功", sales);
    }
}
