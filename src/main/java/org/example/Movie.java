package org.example;

 public class Movie extends Leaseable {

    public Integer duration;

    private final String[] genres;

    public Movie(String code, String title, Double price, Integer duration, String[] genres, Integer quantity) {
        super(code, title, price, quantity);

        this.duration = duration;
        this.genres = genres;
    }


     @Override
     public String getDetails() {
         return "Titulo: " + this.title + "\n" +
                 "Codigo: " + this.code + "\n" +
                 "Preço: " + this.price + "\n" +
                 "Duração: " + this.duration + "\n" +
                 "Generos: " + String.join(", ", this.genres) + "\n" +
                 "Quantidade: " + this.quantity + "\n" +
                 "Total Alugados: " + this.rentedQuantity + "\n";
     }
 }
