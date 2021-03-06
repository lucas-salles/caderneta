package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.AulaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Aula;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@Named(value = "regPresencaBean")
@ViewScoped
public class RegistrarPresencaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aluno> alunos;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	
	@Inject
	private Aula aula;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject 
	private AlunoController alunoController;
	
	@Inject
	private AulaController aulaController;
	
	@PostConstruct
	public void init() {
		Aula aulaFlash = (Aula) this.getFlash("aula");
		Disciplina disciplinaFlash = (Disciplina) this.getFlash("disciplina");
		if(aulaFlash != null) {
			this.aula = aulaFlash;
			alunos = aula.getTurma().getAlunos();
		}
		if(disciplinaFlash != null) {
			this.disciplina = disciplinaFlash;
		}
	}
	
	public String registrar() {
		Aluno aluno = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				aluno = alunoController.find(id);
				aluno.add(aula);
				aula.add(aluno);
				
				alunoController.update(aluno);
				aulaController.update(aula);
			}
		}
		checked.clear();
		
		this.KeepMessages();
		this.addInfoMessage("Presença registrada com sucesso!");
		return "/professor/home?faces-redirect=true";
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Map<Integer, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(Map<Integer, Boolean> checked) {
		this.checked = checked;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
