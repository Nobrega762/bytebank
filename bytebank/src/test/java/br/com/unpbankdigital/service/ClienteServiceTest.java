package br.com.unpbankdigital.service;
import br.com.unpbankdigital.domain.entity.Cliente;
import br.com.unpbankdigital.domain.repository.ClienteRepository;
import br.com.unpbankdigital.exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteServiceTest {

    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    void testCriarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");

        clienteService.criarCliente(cliente);

        Mockito.verify(clienteRepository, Mockito.times(1)).save(cliente);
    }

    @Test
    void testDeletarClienteExistente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        clienteService.deletarCliente(cliente, 1L);

        Mockito.verify(clienteRepository, Mockito.times(1)).delete(cliente);
    }

    @Test
    void testDeletarClienteInexistente() {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RegraDeNegocioException.class, () -> clienteService.deletarCliente(new Cliente(), 1L));
    }
}
