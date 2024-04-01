package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LeaseTest {

    private final Movie product = new Movie("PROD124", "Produto Exemplo 2", 200.0, 120,
    new String[] { "Genêro 3", "Genêro 4" }, 20);
    private final ArrayList<Leaseable> leasedItems = new ArrayList<Leaseable>(Arrays.asList(product));
    private final Lease lease = new Lease("Número do Contrato", "Data de Início", "Data de Retorno", null, leasedItems);

    @Test
    void testRemoveLeasedItem() {
        // Verifique se o valor total é igual ao preço do produto
        assertEquals(200.0, lease.getTotalValue());

        // Remova o produto do contrato de locação
        lease.removeLeasedItem(product);

        // Verifique se o valor total é agora 0
        assertEquals(0.0, lease.getTotalValue());

        // Verifique se o produto foi removido da lista de produtos alugados
        assertFalse(lease.getLeasedItems().contains(product));
    }
}