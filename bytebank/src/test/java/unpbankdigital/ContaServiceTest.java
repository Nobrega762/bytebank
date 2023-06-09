package unpbankdigital;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.unpbankdigital.domain.conta.ContaService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContaServiceTest {

	ContaService contaService = new ContaService();
}
