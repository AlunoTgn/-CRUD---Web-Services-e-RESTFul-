package br.com.prog3.trabalho04.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.trabalho04.domain.Empregado;
import br.com.prog3.trabalho04.dto.EmpregadoDTO;
import br.com.prog3.trabalho04.enums.Categoria;
import br.com.prog3.trabalho04.service.EmpregadoService;

@RestController
@RequestMapping("/api/v1/empregado")

public class EmpregadoResource {

	@Autowired

	private EmpregadoService empregadoService;

	@PostMapping
	public Empregado save(@RequestBody Empregado empregado) {
		return empregadoService.save(empregado);
	}

	@GetMapping
	public ResponseEntity<List<EmpregadoDTO>> findAll() {
		List<EmpregadoDTO> empregado = empregadoService.findAll();
		if (empregado == null || empregado.isEmpty()) {
			return new ResponseEntity<List<EmpregadoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpregadoDTO>>(empregado, HttpStatus.OK);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return empregadoService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Empregado> update(@PathVariable("id") Long id, @RequestBody Empregado empregado) {
		return empregadoService.findById(id).map(record -> {
			record.setNome(empregado.getNome());
			record.setIdade(empregado.getIdade());
			record.setSalario(empregado.getSalario());
			record.setCategoria(empregado.getCategoria());
			Empregado updated = empregadoService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return empregadoService.findById(id).map(record -> {
			empregadoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(path = { "categoria/{categoria}" })
	public ResponseEntity<?> findByCategoria(@PathVariable("categoria") Categoria categoria) {
		List<Empregado> empregados = empregadoService.findByCategoria(categoria);
		return empregados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(empregados);
	}

}
