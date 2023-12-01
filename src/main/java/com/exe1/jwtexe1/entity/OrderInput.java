package com.exe1.jwtexe1.entity;

import java.util.List;

public class OrderInput {

    private String fullName;
    private String fullAdresse;
    private String contactNumber;
    private String alternateContactNumber;

    private List<OrderProductQuantity> orderProductQuantities;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullAdresse() {
        return fullAdresse;
    }

    public void setFullAdresse(String fullAdresse) {
        this.fullAdresse = fullAdresse;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public List<OrderProductQuantity> getOrderProductQuantities() {
        return orderProductQuantities;
    }

    public void setOrderProductQuantities(List<OrderProductQuantity> orderProductQuantities) {
        this.orderProductQuantities = orderProductQuantities;
    }
}
