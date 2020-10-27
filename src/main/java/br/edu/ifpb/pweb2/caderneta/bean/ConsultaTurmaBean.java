package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "consTurmaBean")
@ViewScoped
public class ConsultaTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Turma> turmas = new ArrayList<>();
	
	@Inject
	private TurmaController turmaController;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	public void init() {
		for(Disciplina d: loginUsuarioBean.getProfessor().getDisciplinas()) {
			if(d.getTurma() != null) {
				turmas.add(d.getTurma());
			}
		}
	}
	
	public String registrarNota(Disciplina disciplina) {
		this.putFlash("disciplina", disciplina);
		return "regNota?faces-redirect=true";
	}
	
	public String fecharDisciplina(Disciplina disciplina) {
		if(!disciplina.getTurma().getAtivo()) {
			this.KeepMessages();
			this.addInfoMessage("Disciplina já foi fechada!");
			
			return null;
		}
		
		if(disciplina.getCargaHoraria() <= 50 && disciplina.getTurma().getAvaliacoes().size() < 2) {
			this.KeepMessages();
			this.addInfoMessage("Disciplina com até 50 hrs. Cadastre pelo menos 2 notas!");
			
			return null;
		}
		
		if(disciplina.getCargaHoraria() > 50 && disciplina.getTurma().getAvaliacoes().size() < 3) {
			this.KeepMessages();
			this.addInfoMessage("Disciplina com mais de 50 hrs. Cadastre pelo menos 3 notas!");
			
			return null;
		}
		
		disciplina.getTurma().setAtivo(false);
		
		turmaController.update(disciplina.getTurma());
		
		this.KeepMessages();
		this.addInfoMessage("Disciplina foi encerrada com sucesso!");
		
		return null;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
