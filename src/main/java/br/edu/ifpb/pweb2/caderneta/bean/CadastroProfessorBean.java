package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.model.Professor;

@Named(value = "cadProfessorBean")
@ViewScoped
public class CadastroProfessorBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@Named("professor")
	private Professor professor;
	
	@Inject
	private ProfessorController professorController;
	
	@PostConstruct
	public void init() {
		Professor professorFlash = (Professor) this.getFlash("professor");
		if(professorFlash != null)
			this.professor = professorFlash;
	}
	
	public String cadastrar() {		
		Integer id = professor.getId();
		professor.setTipo("Professor");
		professorController.saveOrUpdate(professor);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Professor cadastrado com sucesso!");
		else
			this.addInfoMessage("Professor atualizado com sucesso!");
		
		professor = new Professor();

		return "/index?faces-redirect=true";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
