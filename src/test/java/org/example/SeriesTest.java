package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SeriesTest {

    private final String[] pieces = { "Episódio 1", "Episódio 2", "Episódio 3" };
    private final String[] genres = { "Drama", "Aventura" };
    private final Series series = new Series("001", "Breaking Bad", 20.0, 60, genres, 10, pieces);

    @Test
    void testIsAvailable() {
        assertTrue(series.isAvailable());

        for (int i = 0; i < 10; i++) {
            series.rent();
        }

        assertFalse(series.isAvailable());
    }

    @Test
    void testRent() {
        assertEquals(0, series.getRentedQuantity());
        series.rent();
        assertEquals(1, series.getRentedQuantity());
    }

    @Test
    void returnProduct() {
        series.rent();
        assertEquals(1, series.getRentedQuantity());
        series.returnProduct();
        assertEquals(0, series.getRentedQuantity());
    }

    @Test
    void testGetDetails() {
        String expected = "Código: 001\n" +
                "Título: Breaking Bad\n" +
                "Preço: R$20.0\n" +
                "Duração: 60 min\n" +
                "Gêneros: Drama, Aventura\n" +
                "Pedaços: Episódio 1, Episódio 2, Episódio 3\n" +
                "Quantidade: 10\n" +
                "Total Alugados: 0\n";

        assertEquals(expected, series.getDetails());
    }
}
