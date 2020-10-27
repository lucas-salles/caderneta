package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToOne
	private Turma turma;
	
	@OneToMany(mappedBy = "avaliacao", fetch=FetchType.EAGER)
	private List<Nota> notas = new ArrayList<>();
	
	public Avaliacao() {}
	
	public Avaliacao(String nome) {
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", nome=" + nome + ", notas=" + notas + "]";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
