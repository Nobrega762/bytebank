package unpbankdigital;

import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;
import br.com.unpbankdigital.domain.conta.DadosAberturaConta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.unpbankdigital.domain.conta.ContaService;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContaServiceTest {

	@MockBean
	ContaService contaService;

	@Test
	public void verificarContaAberta(){
		
		DadosCadastroCliente dadosCliente = new DadosCadastroCliente("Joao","12345","Joaodoido@gmail.com");
		DadosAberturaConta dados = new DadosAberturaConta(2001,dadosCliente);

		DadosAberturaConta dadosEsperado = new DadosAberturaConta(2001,dadosCliente);

		assertEquals(dadosEsperado,dados);
	}
}