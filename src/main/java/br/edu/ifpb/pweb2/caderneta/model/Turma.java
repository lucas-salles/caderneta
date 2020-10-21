package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	
	@OneToMany(mappedBy = "turma", fetch=FetchType.EAGER)
	private List<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy = "turma")
	private List<Aula> aulas;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Professor> professores;
	
	@OneToMany(mappedBy = "turma")
	private List<Nota> notas;
	
	public Turma() {}
	
	public Turma(String codigo) {
		this.codigo = codigo;
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
	
	public void add(Professor p) {
		professores.add(p);
	}
	
	public void remover(Professor p) {
		professores.remove(p);
	}
	
	public Professor localizarProfessor(int id) {
		for(Professor p : professores) {
			if(p.getId() == id)
				return p;
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", codigo=" + codigo + "]";
	}
}
