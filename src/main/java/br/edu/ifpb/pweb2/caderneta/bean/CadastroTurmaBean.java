package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "cadTurmaBean")
@ViewScoped
public class CadastroTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Turma turma;
	
	@Inject
	private TurmaController turmaController;
	
	public String cadastrar() {
		turmaController.insert(turma);
		
		return "/coordenador/home?faces-redirect=true";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
