package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@Named(value = "consDisciplinaBean")
@ViewScoped
public class ConsultaDisciplinaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Disciplina> disciplinas;
	private Integer id;
	
	@Inject 
	private DisciplinaController disciplinaController;

	public void init() {
		if(id == null)
			disciplinas = disciplinaController.findAll();
		else
			disciplinas = Collections.singletonList(disciplinaController.find(id));
	}

	public String excluir(Disciplina disciplina) {
		disciplinaController.excluir(disciplina);
		this.addInfoMessage("Disciplina excluída com sucesso!");
		this.init();
		return null;
	}
	
	public String editar(Disciplina disciplina) {
		this.putFlash("disciplina", disciplina);
		return "cadDisciplina?faces-redirect=true";
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
