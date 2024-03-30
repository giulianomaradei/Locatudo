package org.example;

public class Movie extends Leaseable {

    public Movie(String code, String title, Double price, Integer duration, String[] genres, Integer quantity) {
        super(code, title, price, duration, genres, quantity);
    }

    @Override
    public String getDetails() {
        return "Codigo: " + getCode() + "\n" +
                "Titulo: " + getTitle() + "\n" +
                "Preço: R$" + getPrice() + "\n" +
                "Duração: " + getDuration() + " min" + "\n" +
                "Generos: " + String.join(", ", getGenres()) + "\n" +
                "Quantidade: " + getQuantity() + "\n" +
                "Total Alugados: " + getRentedQuantity() + "\n";
    }
}
