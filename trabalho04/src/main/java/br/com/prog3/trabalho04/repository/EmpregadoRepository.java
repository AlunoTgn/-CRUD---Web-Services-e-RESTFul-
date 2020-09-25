package br.com.prog3.trabalho04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.trabalho04.domain.Empregado;
import br.com.prog3.trabalho04.enums.Categoria;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	List<Empregado> findByCategoria(Categoria categoria);

}
