package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    void testGetFullAddress() {
        Address address = new Address("Exemplo", "Exemplo", "12345-678", "Apto 101", "123");

        String expected = "Rua Exemplo, n° 123, Bairro Exemplo, CEP 12345-678, Apto 101";
        String actual = address.getFullAddress();

        assertEquals(expected, actual);
    }
}
