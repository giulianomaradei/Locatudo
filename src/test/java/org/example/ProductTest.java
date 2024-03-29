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

    @Test
    public void testReturnProduct() {
        // Crie um produto
        Product product = new Product("PROD124", "Produto Exemplo 2", 200.0, 120,
        new String[] { "Genêro 3", "Genêro 4" }, 20);

        // Alugue o produto
        product.rent();

        // Verifique se a quantidade alugada é 1
        assertEquals(1, product.getRentedQuantity());

        // Retorne o produto
        product.returnProduct();

        // Verifique se a quantidade alugada é agora 0
        assertEquals(0, product.getRentedQuantity());
    }
}
