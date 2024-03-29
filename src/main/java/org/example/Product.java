package org.example;

 public class Product {

    private String title, code;

    public Integer duration;

    private String[] genres;

    private Double price;

    private Integer quantity, rentedQuantity = 0;

    public Product(String code, String title, Double price, Integer duration, String[] genres, Integer quantity) {
        this.title = title;
        this.duration = duration;
        this.genres = genres;
        this.price = price;
        this.code = code;

        this.quantity = quantity;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public String[] getGenres() {
        return this.genres;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getRentedQuantity() {
        return this.rentedQuantity;
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

}
