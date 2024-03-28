package org.example;

public class Series extends Product {

    private String[] pieces;

    public Series(String title, Integer duration, String[] genres, Double price, String code, String[] pieces, Integer quantity) {
        super(code, title, price, duration, genres, quantity);

        this.pieces = pieces;
    }

    public String[] getPieces() {
        return pieces;
    }
}
