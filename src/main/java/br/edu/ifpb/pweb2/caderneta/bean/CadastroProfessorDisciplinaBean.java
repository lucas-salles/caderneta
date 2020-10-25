package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.utils.Utils;

@Named(value = "cadProfDisciplinaBean")
@ViewScoped
public class CadastroProfessorDisciplinaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	@Named("professor")
	private Professor professor;
	
	private String nomeDisciplina;
	private String nomeProfessor;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	@Inject
	private ProfessorController professorController;
	
	public String cadastrar() {
		disciplina = disciplinaController.find(Utils.getId(nomeDisciplina));
		professor = professorController.find(Utils.getId(nomeProfessor));
		
		if(!professor.getDisciplinas().contains(disciplina)) {
			disciplina.add(professor);
			professor.add(disciplina);
			
			disciplinaController.update(disciplina);
			professorController.update(professor);
			
			this.KeepMessages();
			this.addInfoMessage("Professor cadastrado na disciplina com sucesso!");
			
			return "/coordenador/home?faces-redirect=true";
		} else {
			this.KeepMessages();
			this.addInfoMessage("Professor já foi cadastrado na disciplina!");
			
			return null;
		}
	}
	
	public List<String> getDisciplinas() {
		List<String> disciplinas = new ArrayList<>();
		for(Disciplina d: disciplinaController.findAll())
			disciplinas.add(d.getId() + " - " + d.getNome());
		return disciplinas;
	}
	
	public List<String> getProfessores() {
		List<String> professores = new ArrayList<>();
		for(Professor p: professorController.findAll())
			professores.add(p.getId() + " - " + p.getNome());
		return professores;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
}
