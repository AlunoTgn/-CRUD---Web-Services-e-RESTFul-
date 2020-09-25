package br.com.prog3.trabalho04.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.trabalho04.domain.Dependente;

@Repository

public interface DependenteRepository extends CrudRepository<Dependente, Long> {

}
