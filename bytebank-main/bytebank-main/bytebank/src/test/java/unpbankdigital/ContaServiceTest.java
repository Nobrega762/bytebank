package unpbankdigital;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.unpbankdigital.domain.cliente.Cliente;
import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;
import br.com.unpbankdigital.domain.conta.Conta;
import br.com.unpbankdigital.domain.conta.ContaService;
import br.com.unpbankdigital.domain.conta.DadosAberturaConta;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContaServiceTest {
	
	@Test
	public void testConsultarSaldo(){
		ContaService contaService = new ContaService();
		
		DadosCadastroCliente dados = new DadosCadastroCliente("Joao","123456","joaolegal@google.com");
		
		Conta conta = new Conta(2001, new Cliente(dados));
		
		DadosAberturaConta abrirConta = new DadosAberturaConta(2001,dados);
		
		contaService.abrir(abrirConta);
		contaService.realizarDeposito(2001, new BigDecimal("1500.00"));
		BigDecimal saldoAtual = contaService.consultarSaldo(2001);
		BigDecimal saldoEsperado = new BigDecimal("1500.00");
		
		assertEquals(saldoEsperado, saldoAtual);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}