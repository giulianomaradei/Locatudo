package org.example;

abstract public class Leaseable {
    protected Integer quantity, rentedQuantity = 0;
    protected Double price;

    protected final String code, title;

    public Leaseable(String code, String title, Double price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
        this.code = code;
        this.title = title;
    }

    public abstract String getDetails();

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getRentedQuantity() {
        return this.rentedQuantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public boolean isAvailable() {
        return this.quantity > this.rentedQuantity;
    }

    public void rent() {
        this.rentedQuantity++;
    }

    public void returnProduct() {
        this.rentedQuantity--;
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

}
