package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AulaController;
import br.edu.ifpb.pweb2.caderneta.model.Aula;

@Named(value = "consAulaBean")
@ViewScoped
public class ConsultarAulaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aula> aulas;
	private Integer id;
	
	@Inject
	private AulaController aulaController;
	
	public void init() {
		if(id == null)
			aulas = aulaController.findAll();
		else
			aulas = Collections.singletonList(aulaController.find(id));
	}
	
	public String registarPresenca(Aula aula) {
		if(!aula.getAlunos().isEmpty()) {
			this.addInfoMessage("A chamada já foi feita para essa aula!");
			return null;
		}
		this.putFlash("aula", aula);
		return "regPresenca?faces-redirect=true";
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
