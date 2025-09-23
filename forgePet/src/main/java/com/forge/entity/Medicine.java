// src/main/java/com/forge/entity/Medicine.java
package com.forge.entity;

import java.util.Date;

public class Medicine {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String manufacturer;
    private Date expireDate;
    private Date createTime;

    // Constructors
    public Medicine() {}

    public Medicine(Long id, String name, String description, Double price, Integer stock,
                    String manufacturer, Date expireDate, Date createTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.manufacturer = manufacturer;
        this.expireDate = expireDate;
        this.createTime = createTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public Date getExpireDate() { return expireDate; }
    public void setExpireDate(Date expireDate) { this.expireDate = expireDate; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
