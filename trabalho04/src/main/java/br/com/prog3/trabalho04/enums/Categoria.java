package br.com.prog3.trabalho04.enums;

public enum Categoria {
	
	HOMEOFFICE("remoto"), //0
	ESTAGIARIO("Emprego meio periodo"), //1
	MICROEMPREDOR("Pequeno Empresario"); //2
	

	private String descricao;

	private Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}



