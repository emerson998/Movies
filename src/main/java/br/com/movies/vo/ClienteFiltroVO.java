package br.com.movies.vo;

import java.io.Serializable;

public class ClienteFiltroVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String cpf;

	public boolean isFiltrosInexistentes() {
		return !incluiNome() && !incluiCpf();
	}

	public boolean incluiNome() {
		return nome != null && !nome.isBlank();
	}

	public boolean incluiCpf() {
		return cpf != null && !cpf.isBlank();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
