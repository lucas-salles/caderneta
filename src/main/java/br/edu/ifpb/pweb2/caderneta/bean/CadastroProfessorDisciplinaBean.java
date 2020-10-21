package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Turma;
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
	
	@Inject
	private Turma turma;
	
	private String nomeDisciplina;
	private String nomeProfessor;
	private String codigoTurma;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	@Inject
	private ProfessorController professorController;
	
	@Inject
	private TurmaController turmaController;
	
	public String cadastrar() {
		disciplina = disciplinaController.find(Utils.getId(nomeDisciplina));
		professor = professorController.find(Utils.getId(nomeProfessor));
		turma = turmaController.find(Utils.getId(codigoTurma));
		
		if(!professor.getTurmas().contains(turma)) {
			disciplina.setTurma(turma);
			professor.add(turma);
			turma.add(professor);
			
			disciplinaController.update(disciplina);
			professorController.update(professor);
			turmaController.update(turma);
			
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
	
	public List<String> getTurmas() {
		List<String> turmas = new ArrayList<>();
		for(Turma t: turmaController.findAll())
			turmas.add(t.getId() + " - " + t.getCodigo());
		return turmas;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
}
