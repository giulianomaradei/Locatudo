package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class LeaseTest {

    private ArrayList<Product> leasedItems = new ArrayList<Product>();
    private final Lease lease = new Lease("Número do Contrato", "Data de Início", "Data de Retorno", null, leasedItems);

    @Test
    void testAddLeasedItem() {
        Product newProduct = new Product("PROD124", "Produto Exemplo 2", 200.0, 120,
                new String[] { "Genêro 3", "Genêro 4" }, 20);
        lease.addLeasedItem(newProduct);

        // Verifica se o produto foi adicionado à lista de itens alugados
        assertTrue(lease.getLeasedItems().contains(newProduct));
        assertEquals(lease.getTotalValue(), newProduct.getPrice());
    }

    @Test
    void testRemoveLeasedItem() {
        Product product = new Product("PROD124", "Produto Exemplo 2", 200.0, 120,
                new String[] { "Genêro 3", "Genêro 4" }, 20);
        lease.addLeasedItem(product);
        
    }
}
