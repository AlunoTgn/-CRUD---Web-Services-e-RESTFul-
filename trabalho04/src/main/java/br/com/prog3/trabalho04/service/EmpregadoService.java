package br.com.prog3.trabalho04.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalho04.domain.Empregado;
import br.com.prog3.trabalho04.dto.EmpregadoDTO;
import br.com.prog3.trabalho04.enums.Categoria;
import br.com.prog3.trabalho04.repository.EmpregadoRepository;

@Service

public class EmpregadoService {

	@Autowired
	private EmpregadoRepository empregadoRepository;

	public Empregado save(Empregado empregado) {
		return empregadoRepository.save(empregado);
	}

	public List<EmpregadoDTO> findAll() {
		return empregadoRepository.findAll().stream().map(empregado -> new EmpregadoDTO(empregado))
				.collect(Collectors.toList());
	}

	public Optional<Empregado> findById(Long id) {
		return empregadoRepository.findById(id);
	}

	public Empregado update(Empregado empregado) {
		return empregadoRepository.save(empregado);
	}

	public void deleteById(Long id) {
		empregadoRepository.deleteById(id);
	}

	public List<Empregado> findByCategoria(Categoria categoria) {
		return (List<Empregado>) empregadoRepository.findByCategoria(categoria);
	}

}
