package com.forge.entity;

import java.util.Date;

public class MedicineSale {
    private Long id;
    private Long medicineId;
    private String medicineName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Long clientId;
    private Long employeeId;
    private Date saleTime;

    // Constructors
    public MedicineSale() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMedicineId() { return medicineId; }
    public void setMedicineId(Long medicineId) { this.medicineId = medicineId; }

    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Date getSaleTime() { return saleTime; }
    public void setSaleTime(Date saleTime) { this.saleTime = saleTime; }
}