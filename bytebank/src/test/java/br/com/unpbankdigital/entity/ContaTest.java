package br.com.unpbankdigital.entity;

import br.com.unpbankdigital.domain.entity.Cliente;
import br.com.unpbankdigital.domain.entity.Conta;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Mock
    private Conta contaMock;

    @Test
    void testConta() {
        contaMock = new Conta();

        contaMock.setNumero(123);
        contaMock.setSaldo(1000.0);
        Cliente clienteMock = new Cliente();
        contaMock.setTitular(clienteMock);

        assertEquals(123, contaMock.getNumero());
        assertEquals(1000.0, contaMock.getSaldo());
        assertSame(clienteMock, contaMock.getTitular());
    }

    @Test
    void testContaComErro() {
        contaMock = new Conta();

        contaMock.setNumero(null);
        contaMock.setSaldo(null);
        Cliente clienteMock = new Cliente();
        contaMock.setTitular(clienteMock);


        assertNotEquals(123, contaMock.getNumero());
        assertNotEquals(1000.0, contaMock.getSaldo());

    }
}
