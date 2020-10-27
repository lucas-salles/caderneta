package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Nota;

@Named(value = "alunoDisciplinaBean")
@ViewScoped
public class AlunoDisciplinaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String status;
	private Double media = 0.0;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	public void init() {
		if(id != null) {
			disciplina = disciplinaController.find(id);
			calculaStatus();
		}
	}
	
	public void calculaStatus() {
		if(disciplina.getTurma().getAtivo()) {
			status = "Cursando";
		} else {
			Double somaNotas = 0.0;
			Integer nmNotas = 0;
			for(Nota n: loginUsuarioBean.getAluno().getNotas()) {
				if(n.getAvaliacao().getTurma().getDisciplina().getId() == disciplina.getId()) {
					somaNotas += n.getNota();
					nmNotas++;
				}
			}
			media = somaNotas / nmNotas;
			if(media >= 7) {
				status = "Aprovado";
			} else if(media >= 4) {
				status = "Final";
			} else {
				status = "Reprovado";
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}
}
