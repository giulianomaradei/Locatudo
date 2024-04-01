package org.example;

public class Movie extends Leaseable {

    private Integer duration;
    private String[] genres;

    public Movie(String code, String title, Double price, Integer duration, String[] genres, Integer quantity) {
        super(code, title, price, quantity);

        this.duration = duration;
        this.genres = genres;
    }

    @Override
    public String getDetails() {
        return "Codigo: " + getCode() + "\n" +
                "Titulo: " + getTitle() + "\n" +
                "Preço: R$" + getPrice() + "\n" +
                "Duração: " + duration + " min" + "\n" +
                "Generos: " + String.join(", ", genres) + "\n" +
                "Quantidade: " + getQuantity() + "\n" +
                "Total Alugados: " + getRentedQuantity() + "\n";
    }
}
