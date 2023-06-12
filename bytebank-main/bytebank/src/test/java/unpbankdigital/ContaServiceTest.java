package unpbankdigital;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.unpbankdigital.domain.cliente.Cliente;
import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;
import br.com.unpbankdigital.domain.conta.Conta;
import br.com.unpbankdigital.domain.conta.ContaService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContaServiceTest {
	
	public void testConsultarSaldo(){
		DadosCadastroCliente dados = new DadosCadastroCliente("João", "123456789", "joao@example.com");
		
		
		
		ContaService contaService = new ContaService();
		
		Integer numeroConta = 2001;
		
		BigDecimal saldoEsperado = new BigDecimal("1000.00");
		
		Conta conta = new Conta(numeroConta,new Cliente(dados));
		
		conta.depositar(new BigDecimal("1000.00"));
		
		BigDecimal saldoAtual = contaService.consultarSaldo(numeroConta);
		
		Assertions.assertTrue(saldoEsperado.compareTo(saldoAtual) == 0);
		
		
		
	}
}