package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductTest {

    private final Product product = new Product("PROD123", "Produto Exemplo", 100.0, 60, new String[]{"Genêro 1", "Genêro 2"}, 1);

    @Test
    void testIsAvailable() {
        assertTrue(product.isAvailable());
        product.rent();
        assertFalse(product.isAvailable());
    }

    @Test
    void testRent() {
        assertEquals(0, product.getRentedQuantity());
        product.rent();
        assertEquals(1, product.getRentedQuantity());
    }
}
