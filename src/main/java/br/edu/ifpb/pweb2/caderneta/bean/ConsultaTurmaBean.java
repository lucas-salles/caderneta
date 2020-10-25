package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "consTurmaBean")
@ViewScoped
public class ConsultaTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Turma> turmas = new ArrayList<>();
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	public void init() {
		for(Disciplina d: loginUsuarioBean.getProfessor().getDisciplinas()) {
			if(d.getTurma() != null) {
				turmas.add(d.getTurma());
			}
		}
	}
	
	public String regNota(Disciplina disciplina) {
		this.putFlash("disciplina", disciplina);
		return "regNota?faces-redirect=true";
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
