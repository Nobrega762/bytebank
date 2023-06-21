package br.com.unpbankdigital.service;

import br.com.unpbankdigital.domain.entity.Cliente;
import br.com.unpbankdigital.domain.repository.ClienteRepository;
import br.com.unpbankdigital.exceptions.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClienteService {

    ClienteRepository repository;

    public void criarCliente(Cliente cliente){
        repository.save(cliente);
    }

    public void deletarCliente(Cliente cliente,Long id){
        if(repository.findById(id).isPresent()){
            repository.delete(cliente);
        }
        else{
            throw new RegraDeNegocioException("Esse cliante não existe");
        }
    }
}
