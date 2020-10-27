package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AulaController;
import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.model.Aula;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.utils.Utils;

@Named(value = "regAulaBean")
@ViewScoped
public class RegistrarAulaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Aula aula;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private AulaController aulaController;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	private String nomeDisciplina;
	
	public String cadastrar() {
		disciplina = disciplinaController.find(Utils.getId(nomeDisciplina));
		
		if(disciplina.getTurma() == null) {
			this.KeepMessages();
			this.addInfoMessage("Disciplina não possui turma cadastrada. Informe ao coordenador para que ele cadastre uma turma!");
			
			return null;
		}
		
		aula.setTurma(disciplina.getTurma());
		disciplina.getTurma().add(aula);
		
		aulaController.saveOrUpdate(aula);
		disciplinaController.update(disciplina);
		
		this.KeepMessages();
		this.addInfoMessage("Aula registrada com sucesso!");
		
		this.putFlash("aula", aula);
		this.putFlash("disciplina", disciplina);
		return "regPresenca?faces-redirect=true";
	}
	
	public List<String> getDisciplinas() {
		List<String> disciplinas = new ArrayList<>();
		for(Disciplina d: loginUsuarioBean.getProfessor().getDisciplinas())
			disciplinas.add(d.getId() + " - " + d.getNome());
		return disciplinas;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
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
