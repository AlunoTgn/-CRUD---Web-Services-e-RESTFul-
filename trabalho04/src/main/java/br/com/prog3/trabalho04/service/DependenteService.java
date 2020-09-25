package br.com.prog3.trabalho04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalho04.domain.Dependente;
import br.com.prog3.trabalho04.repository.DependenteRepository;

@Service

public class DependenteService {

	@Autowired
	private DependenteRepository dependenteRepository;

	public Dependente save(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}

	public List<Dependente> findAll() {
		return (List<Dependente>) dependenteRepository.findAll();
	}

	public Optional<Dependente> findById(Long id) {
		return dependenteRepository.findById(id);
	}

	public Dependente update(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}

	public void deleteById(Long id) {
		dependenteRepository.deleteById(id);
	}
}
