package com.example.motorizapp.models;

public class Order {
    private String quantity;
    private String productName;
    private String address;

    public Order(String quantity, String productName, String address) {
        this.quantity = quantity;
        this.productName = productName;
        this.address = address;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
