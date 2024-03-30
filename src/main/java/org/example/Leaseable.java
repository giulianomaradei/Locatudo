package org.example;

public abstract class Leaseable {
    
    private Integer quantity, duration, rentedQuantity = 0;
    private Double price;
    private String code, title;
    private String[] genres;

    public Leaseable(String code, String title, Double price, Integer duration, String[] genres, Integer quantity) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.duration = duration;
        this.genres = genres;
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

    public Integer getDuration() {
        return this.duration;
    }

    public String[] getGenres() {
        return this.genres;
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
