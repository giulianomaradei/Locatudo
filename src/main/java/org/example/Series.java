package org.example;

public class Series extends Leaseable {

    private String[] pieces;

    public Series(String code, String title, Double price, Integer duration, String[] genres, Integer quantity,
            String[] pieces) {
        super(code, title, price, duration, genres, quantity);

        this.pieces = pieces;
    }

    @Override
    public String getDetails() {
        return "Código: " + getCode() + "\n" +
                "Título: " + getTitle() + "\n" +
                "Preço: R$" + getPrice() + "\n" +
                "Duração: " + getDuration() + " min" + "\n" +
                "Gêneros: " + String.join(", ", getGenres()) + "\n" +
                "Pedaços: " + String.join(", ", this.pieces) + "\n" +
                "Quantidade: " + getQuantity() + "\n" +
                "Total Alugados: " + getRentedQuantity() + "\n";
    }
}
