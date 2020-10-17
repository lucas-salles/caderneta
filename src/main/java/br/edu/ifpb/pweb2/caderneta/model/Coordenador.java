package br.edu.ifpb.pweb2.caderneta.model;

import javax.persistence.Entity;

@Entity
public class Coordenador extends Professor {
	private static final long serialVersionUID = 1L;
	
	private Boolean ativo = true;

	public Coordenador() {}

	public Coordenador(String login, String senha, String nome, String email) {
		super(login, senha, nome, email);
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Coordenador [ativo=" + ativo + "]";
	}
}
