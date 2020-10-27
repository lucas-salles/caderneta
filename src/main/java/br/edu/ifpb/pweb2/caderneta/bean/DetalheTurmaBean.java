package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@Named(value = "detalheTurmaBean")
@ViewScoped
public class DetalheTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aluno> alunos;
	private Integer id;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	public void init() {
		if(id != null) {
			disciplina = disciplinaController.find(id);
			alunos = disciplina.getTurma().getAlunos();
		}
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
