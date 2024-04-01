package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MovieTest {

    private final Leaseable movie = new Movie("123", "O Senhor dos Anéis", 10.0, 180,
            new String[] { "Ação", "Aventura" }, 5);

    @Test
    void testIsAvailable() {
        assertTrue(movie.isAvailable());

        for (int i = 0; i < 5; i++) {
            movie.rent();
        }

        assertFalse(movie.isAvailable());
    }

    @Test
    void testRent() {
        assertEquals(0, movie.getRentedQuantity());
        movie.rent();
        assertEquals(1, movie.getRentedQuantity());
    }

    @Test
    void returnProduct() {
        movie.rent();
        assertEquals(1, movie.getRentedQuantity());
        movie.returnProduct();
        assertEquals(0, movie.getRentedQuantity());
    }

    @Test
    void testGetDetails() {
        String expected = "Codigo: 123\n" +
                "Titulo: O Senhor dos Anéis\n" +
                "Preço: R$10.0\n" +
                "Duração: 180 min\n" +
                "Generos: Ação, Aventura\n" +
                "Quantidade: 5\n" +
                "Total Alugados: 0\n";

        assertEquals(expected, movie.getDetails());
    }
}
