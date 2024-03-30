package org.example;

public abstract class Leaseable {
    
    private Integer quantity, rentedQuantity = 0;
    private Double price;
    private String code, title;

    public Leaseable(String code, String title, Double price, Integer quantity) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public void rent() {
        this.rentedQuantity++;
    }

    public void returnProduct() {
        this.rentedQuantity--;
    }

    public boolean isAvailable() {
        return this.quantity > this.rentedQuantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getRentedQuantity() {
        return this.rentedQuantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract String getDetails();

}
