package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Turma;
import br.edu.ifpb.pweb2.utils.Utils;

@Named(value = "cadDiscTurmaBean")
@ViewScoped
public class CadastroDisciplinaTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Turma turma;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private TurmaController turmaController;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	private String nomeDisciplina;
	private String codigoTurma;
	
	public String cadastrar() {
		disciplina = disciplinaController.find(Utils.getId(nomeDisciplina));
		turma = turmaController.find(Utils.getId(codigoTurma));
		
		disciplina.setTurma(turma);
		turma.add(disciplina);
		
		disciplinaController.update(disciplina);
		turmaController.update(turma);
		
		return "/coordenador/home?faces-redirect=true";
	}
	
	public List<String> getDisciplinas() {
		List<String> disciplinas = new ArrayList<>();
		for(Disciplina d: disciplinaController.findAll())
			disciplinas.add(d.getId() + " - " + d.getNome());
		return disciplinas;
	}
	
	public List<String> getTurmas() {
		List<String> turmas = new ArrayList<>();
		for(Turma t: turmaController.findAll())
			turmas.add(t.getId() + " - " + t.getCodigo());
		return turmas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
}
