package br.edu.ifpb.pweb2.caderneta.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Named
@Entity
public class Professor extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Disciplina> disciplinas = new  HashSet<>();
	
	public Professor() {}
	
	public Professor(String login, String senha, String tipo, String nome, String email) {
		super(login, senha, tipo);
		this.nome = nome;
		this.email = email;
	}
	
	public void add(Disciplina d) {
		disciplinas.add(d);
	}
	
	public void remover(Disciplina d) {
		disciplinas.remove(d);
	}
	
	public Disciplina localizarDisciplina(int id) {
		for(Disciplina d : disciplinas) {
			if(d.getId() == id)
				return d;
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", email=" + email + "]";
	}
}
