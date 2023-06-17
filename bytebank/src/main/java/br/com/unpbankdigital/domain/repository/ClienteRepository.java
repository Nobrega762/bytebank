package br.com.unpbankdigital.domain.repository;

import br.com.unpbankdigital.domain.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
