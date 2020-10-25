package br.edu.ifpb.pweb2.caderneta.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String matricula;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Turma> turmas = new ArrayList<>();
	
	@ManyToMany
	private List<Aula> aulas = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Nota> notas = new  HashSet<>();
	
	public Aluno() {}
	
	public Aluno(String login, String senha, String tipo, String nome, String matricula) {
		super(login, senha, tipo);
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void add(Turma t) {
		turmas.add(t);
	}
	
	public void remover(Turma t) {
		turmas.remove(t);
	}
	
	public Turma localizarTurma(int id) {
		for(Turma t : turmas) {
			if(t.getId() == id)
				return t;
		}
		return null;
	}
	
	public void add(Aula a) {
		aulas.add(a);
	}
	
	public void remover(Aula a) {
		aulas.remove(a);
	}
	
	public Aula localizarAula(int id) {
		for(Aula a : aulas) {
			if(a.getId() == id)
				return a;
		}
		return null;
	}
	
	public void add(Nota n) {
		notas.add(n);
	}
	
	public void remover(Nota n) {
		notas.remove(n);
	}
	
	public Nota localizarNota(int id) {
		for(Nota n : notas) {
			if(n.getId() == id)
				return n;
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + "]";
	}
}
