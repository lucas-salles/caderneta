package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AulaController;
import br.edu.ifpb.pweb2.caderneta.model.Aula;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@Named(value = "consAulaBean")
@ViewScoped
public class ConsultarAulaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aula> aulas = new ArrayList<>();
	private Integer id;
	
	@Inject
	private AulaController aulaController;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	public void init() {
		for(Disciplina d: loginUsuarioBean.getProfessor().getDisciplinas()) {
			if(d.getTurma() != null) {
				List<Aula> aulasTurma = aulaController.getAulasByTurmaId(d.getTurma().getId());
				for(Aula a: aulasTurma) {
					aulas = a.getTurma().getAulas();				
				}
			}
		}
	}
	
	public String registarPresenca(Aula aula) {
		if(!aula.getAlunos().isEmpty()) {
			this.addInfoMessage("A chamada já foi feita para essa aula!");
			return null;
		}
		disciplina = aula.getTurma().getDisciplina();
		this.putFlash("aula", aula);
		this.putFlash("disciplina", disciplina);
		return "regPresenca?faces-redirect=true";
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
