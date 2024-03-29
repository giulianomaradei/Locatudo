package org.example;

public class Series extends Leaseable {

    private final String[] pieces;
    public Integer duration;

    private final String[] genres;

    public Series(String title, Integer duration, String[] genres, Double price, String code, String[] pieces, Integer quantity) {
        super(code, title, price, quantity);

        this.pieces = pieces;
        this.genres = genres;
    }

    @Override
    public String getDetails() {
        return "Titulo: " + this.title + "\n" +
                "Codigo: " + this.code + "\n" +
                "Preço: " + this.price + "\n" +
                "Duração: " + this.duration + "\n" +
                "Generos: " + String.join(", ", this.genres) + "\n" +
                "Pedacos: " + String.join(", ", this.pieces) + "\n" +
                "Quantidade: " + this.quantity + "\n" +
                "Total Alugados: " + this.rentedQuantity + "\n";
    }
}
