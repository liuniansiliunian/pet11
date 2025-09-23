// src/main/java/com/forge/mapper/MedicineSaleMapper.java
package com.forge.mapper;

import com.forge.entity.MedicineSale;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface MedicineSaleMapper {

    @Select("SELECT * FROM medicine_sale")
    List<MedicineSale> findAll();

    @Select("SELECT * FROM medicine_sale WHERE client_id = #{clientId}")
    List<MedicineSale> findByClientId(Long clientId);

    @Insert("INSERT INTO medicine_sale(medicine_id, medicine_name, quantity, unit_price, total_price, client_id, employee_id, sale_time) " +
            "VALUES(#{medicineId}, #{medicineName}, #{quantity}, #{unitPrice}, #{totalPrice}, #{clientId}, #{employeeId}, #{saleTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(MedicineSale sale);

    @Select("SELECT * FROM medicine_sale WHERE sale_time BETWEEN #{startDate} AND #{endDate}")
    List<MedicineSale> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
