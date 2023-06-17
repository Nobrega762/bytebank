package br.com.unpbankdigital.domain.repository;

import br.com.unpbankdigital.domain.entity.Cliente;
import br.com.unpbankdigital.domain.entity.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ContaRepository extends CrudRepository<Conta,Long> {

    Boolean existsByNumero(Integer numemo);

    Cliente findByTitular(Integer numero);

    Double findBySaldo(Integer numero);
}
