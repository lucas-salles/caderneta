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

@Named(value = "cadTurmaBean")
@ViewScoped
public class CadastroTurmaBean extends GenericCadernetaBean implements Serializable {
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
	
	public String cadastrar() {
		disciplina = disciplinaController.find(Utils.getId(nomeDisciplina));
		
		if(disciplina.getTurma() != null) {
			this.KeepMessages();
			this.addInfoMessage("Disciplina já possui turma cadastrada!");
			
			return null;
		}

		turma.setDisciplina(disciplina);
		disciplina.setTurma(turma);
		
		turmaController.saveOrUpdate(turma);
		disciplinaController.update(disciplina);
		
		this.KeepMessages();
		this.addInfoMessage("Turma cadastrada com sucesso!");
		
		return "/coordenador/home?faces-redirect=true";
	}
	
	public List<String> getDisciplinas() {
		List<String> disciplinas = new ArrayList<>();
		for(Disciplina d: disciplinaController.findAll())
			if(d.getTurma() != null)
				disciplinas.add(d.getId() + " - " + d.getNome() + "(turma " + d.getTurma().getCodigo() + ")");
			else
				disciplinas.add(d.getId() + " - " + d.getNome());
		return disciplinas;
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
}
