package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Aula() {}

	public Aula(String assunto, Date dataAula) {
		this.assunto = assunto;
		this.dataAula = dataAula;
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

	@Override
	public String toString() {
		return "Aula [id=" + id + ", assunto=" + assunto + ", data=" + dataAula + "]";
	}
}
