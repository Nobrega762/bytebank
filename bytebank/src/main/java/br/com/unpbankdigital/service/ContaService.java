package br.com.unpbankdigital.service;

import java.math.BigDecimal;
import java.util.Optional;


import br.com.unpbankdigital.domain.entity.Cliente;
import br.com.unpbankdigital.domain.repository.ContaRepository;
import br.com.unpbankdigital.domain.entity.Conta;
import br.com.unpbankdigital.exceptions.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaService {

   private ContaRepository repository;


    public Optional<Conta> contas(Long id) {
        return repository.findById(id);

    }

    public Cliente retornaCliente(Integer conta){
        if(repository.existsByNumero(conta)){
            return repository.findByTitular(conta);
        }
        else {
            throw new RegraDeNegocioException("Não existe essa conta");
        }
    }

    public Double retornaOSaldo(Integer conta){
        return repository.findBySaldo(conta);
    }

    public void criarConta(Integer numero){
        Conta conta = new Conta();
        if(repository.existsByNumero(numero) == null){
            repository.save(conta);
        }
        else {
            throw new RegraDeNegocioException("Essa conta já existe");
        }
    }

    public void deletarConta(Long id){
        Conta conta = new Conta();
        if(repository.findById(id).isEmpty()){
            throw new RegraDeNegocioException("Não pode deletar pois a conta não existe");

        }
        else{
            repository.delete(conta);
        }
    }

}
