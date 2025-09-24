package com.forge.mapper;

import com.forge.entity.Medicine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicineMapper {

    @Select("SELECT * FROM medicine")
    List<Medicine> findAll();

    @Select("SELECT * FROM medicine WHERE id = #{id}")
    Medicine findById(Long id);

    @Insert("INSERT INTO medicine(name, description, price, stock, manufacturer, expire_date, create_time) " +
            "VALUES(#{name}, #{description}, #{price}, #{stock}, #{manufacturer}, #{expireDate}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Medicine medicine);

    @Update("UPDATE medicine SET name=#{name}, description=#{description}, price=#{price}, " +
            "stock=#{stock}, manufacturer=#{manufacturer}, expire_date=#{expireDate} WHERE id=#{id}")
    void update(Medicine medicine);

    @Delete("DELETE FROM medicine WHERE id = #{id}")
    void deleteById(Long id);

    @Select("SELECT * FROM medicine WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Medicine> findByNameContaining(String name);
}