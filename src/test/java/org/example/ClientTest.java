package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClientTest {

    private final Client client = new Client("Fulano", "123", null);
    private final Lease lease = new Lease("Número do Contrato", "Data de Início", "Data de Retorno", client, null);

    @Test
    void testAddLease() {
        client.addLease(lease);
        assertTrue(client.getLeases().contains(lease));
    }

    @Test
    void testRemoveLease() {
        client.addLease(lease);
        client.removeLease(lease);
        assertFalse(client.getLeases().contains(lease));
    }
}
