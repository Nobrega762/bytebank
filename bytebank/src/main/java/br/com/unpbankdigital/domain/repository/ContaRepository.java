package br.com.unpbankdigital.domain.repository;

import br.com.unpbankdigital.domain.entity.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta,Long> {
}
