package br.com.unpbankdigital.service;

import br.com.unpbankdigital.domain.entity.Cliente;
import br.com.unpbankdigital.domain.entity.Conta;
import br.com.unpbankdigital.domain.repository.ContaRepository;
import br.com.unpbankdigital.exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ContaServiceTest {

	@MockBean
	private ContaRepository repository;

	@MockBean
	private Conta conta;

	@InjectMocks
	private ContaService service;

	@BeforeEach
	void setMockOutPut() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void TestarContaPorId() {
		conta = new Conta();
		conta.setId(22l);
		when(service.contas(conta.getId())).thenReturn(Optional.of(conta));
	}

	@Test
	public void testRetornaClienteContaExistente() {
		int conta = 12345;

		when(repository.existsByNumero(anyInt())).thenReturn(true);

		Cliente clienteMock = new Cliente();
		when(repository.findByTitular(anyInt())).thenReturn(clienteMock);

		Cliente result = service.retornaCliente(conta);


		verify(repository).existsByNumero(conta);
		verify(repository).findByTitular(conta);

		assertNotNull(result);
		assertEquals(clienteMock, result);
	}

	@Test
	public void testRetornaClienteContaInexistente() {
		int conta = 12345;


		when(repository.existsByNumero(anyInt())).thenReturn(false);


		RegraDeNegocioException exception = assertThrows(RegraDeNegocioException.class, () -> {
			service.retornaCliente(conta);
		});


		assertEquals("Não existe essa conta", exception.getMessage());


		verify(repository).existsByNumero(conta);
		verify(repository, never()).findByTitular(anyInt());
	}


	@Test
	public void testRetornaOSaldoContaExistente() {
		int conta = 12345;
		double saldoMock = 1000.0;

		when(repository.findBySaldo(anyInt())).thenReturn(saldoMock);

		Double result = service.retornaOSaldo(conta);

		verify(repository).findBySaldo(conta);

		assertNotNull(result);
		assertEquals(saldoMock, result);
	}

	@Test
	public void testRetornaOSaldoContaInexistente() {
		int conta = 12345;

		when(repository.findBySaldo(anyInt())).thenReturn(null);

		Double result = service.retornaOSaldo(conta);

		verify(repository).findBySaldo(conta);

		assertNull(result);
	}

	@Test
	public void testCriarConta() {
		Integer numeroConta = 12345;
		
		Mockito.when(repository.existsByNumero(numeroConta)).thenReturn(null);

		service.criarConta(numeroConta);

		Mockito.verify(repository).save(Mockito.any(Conta.class));
	}


	@Test
	public void testDeletarConta() {
		Long idConta = 1L;

		Mockito.when(repository.findById(idConta)).thenReturn(Optional.ofNullable(conta));

		service.deletarConta(idConta);

		Mockito.verify(repository).delete(Mockito.any(Conta.class));
	}



}



