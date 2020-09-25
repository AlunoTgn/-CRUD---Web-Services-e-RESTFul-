package br.com.prog3.trabalho04.dto;

import br.com.prog3.trabalho04.domain.Empregado;
import br.com.prog3.trabalho04.enums.Categoria;

public class EmpregadoDTO {

	private Long id;
	private String nome;
	private Integer idade;
	private Integer salario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	private Categoria categoria;

	public EmpregadoDTO(Empregado empregado) {
		this.id = empregado.getId();
		this.nome = empregado.getNome();
		this.idade = empregado.getIdade();
		this.salario = empregado.getSalario();
		this.categoria = empregado.getCategoria();
	}

}
