package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String codigo;
	private String curso;
	private Integer cargaHoraria;
	
	@OneToOne
	private Turma turma;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<Professor> professores = new ArrayList<>();
	
	public Disciplina() {}
	
	public Disciplina(String nome, String codigo, String curso, Integer cargaHoraria) {
		this.nome = nome;
		this.codigo = codigo;
		this.curso = curso;
		this.cargaHoraria = cargaHoraria;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", curso=" + curso + ", cargaHoraria="
				+ cargaHoraria + "]";
	}
}
