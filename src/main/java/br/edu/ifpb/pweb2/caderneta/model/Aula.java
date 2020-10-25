package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String assunto;
	
	@Column(name = "dt_aula")
	@Temporal(TemporalType.DATE)
	private Date dataAula;
	
	@ManyToOne
	private Turma turma;
	
	@ManyToMany(mappedBy = "aulas", fetch=FetchType.EAGER)
	private List<Aluno> alunos = new ArrayList<>();
	
	public Aula() {}

	public Aula(String assunto, Date dataAula) {
		this.assunto = assunto;
		this.dataAula = dataAula;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getDataAula() {
		return dataAula;
	}

	public void setDataAula(Date dataAula) {
		this.dataAula = dataAula;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", assunto=" + assunto + ", dataAula=" + dataAula + ", turma=" + turma + ", alunos="
				+ alunos + "]";
	}
}
