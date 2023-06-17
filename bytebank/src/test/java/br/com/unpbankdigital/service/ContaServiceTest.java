package br.com.unpbankdigital.service;

import br.com.unpbankdigital.domain.entity.Conta;
import br.com.unpbankdigital.domain.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@SpringBootTest
public class ContaServiceTest {

	@MockBean
	private ContaRepository repository;

	@MockBean
	private Conta conta;

	@InjectMocks
	private ContaService service;

	@BeforeEach
	void setMockOutPut(){
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void TestarContaPorId(){
		conta = new Conta();
		conta.setId(22l);
		Mockito.when(service.contas(conta.getId())).thenReturn(Optional.of(conta));
	}
}
