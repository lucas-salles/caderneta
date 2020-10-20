package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@Named(value = "cadDisciplinaBean")
@ViewScoped
public class CadastroDisciplinaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	@PostConstruct
	public void init() {
		Disciplina disciplinaFlash = (Disciplina) this.getFlash("disciplina");
		if(disciplinaFlash != null)
			this.disciplina = disciplinaFlash;
	}
	
	public String cadastrar() {		
		// Usa o dao para inserir a disciplina
		Integer id = disciplina.getId();
		disciplinaController.saveOrUpdate(disciplina);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Discilina cadastrada com sucesso!");
		else
			this.addInfoMessage("disciplina atualizada com sucesso!");
		
		// Limpa objeto do formulário
		disciplina = new Disciplina();

		// Retorna para página de consulta de disciplinas
		return "disciplinas?faces-redirect=true";
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
