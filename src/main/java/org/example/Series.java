package org.example;

public class Series extends Leaseable {

    private Integer duration;
    private String[] genres;
    private String[] pieces;

    public Series(String code, String title, Double price, Integer duration, String[] genres, Integer quantity,
            String[] pieces) {
        super(code, title, price, quantity);

        this.duration = duration;
        this.genres = genres;
        this.pieces = pieces;
    }

    @Override
    public String getDetails() {
        return "Código: " + getCode() + "\n" +
                "Título: " + getTitle() + "\n" +
                "Preço: R$" + getPrice() + "\n" +
                "Duração: " + duration + " min" + "\n" +
                "Gêneros: " + String.join(", ", genres) + "\n" +
                "Pedaços: " + String.join(", ", this.pieces) + "\n" +
                "Quantidade: " + getQuantity() + "\n" +
                "Total Alugados: " + getRentedQuantity() + "\n";
    }
}
