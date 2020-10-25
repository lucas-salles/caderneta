package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	
	@OneToOne(mappedBy = "turma")
	private Disciplina disciplina;
	
	@ManyToMany(mappedBy = "turmas", fetch=FetchType.EAGER)
	private List<Aluno> alunos = new ArrayList<>();
	
	@OneToMany(mappedBy = "turma")
	private List<Aula> aulas = new ArrayList<>();
	
	@OneToMany(mappedBy = "turma", fetch=FetchType.EAGER)
	private Set<Nota> notas = new  HashSet<>();
	
	public Turma() {}
	
	public Turma(String codigo) {
		this.codigo = codigo;
	}
	
	public void add(Aluno a) {
		alunos.add(a);
	}
	
	public void remover(Aluno a) {
		alunos.remove(a);
	}
	
	public Aluno localizarAluno(int id) {
		for(Aluno a : alunos) {
			if(a.getId() == id)
				return a;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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
		return "Turma [id=" + id + ", codigo=" + codigo + "]";
	}
}
