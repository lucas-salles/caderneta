package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

@Named(value = "consAlunoDisciplinaBean")
@ViewScoped
public class ConsultaAlunoDisciplinaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Disciplina> disciplinas;
	
	@Inject
	private Aluno aluno;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;

	@PostConstruct
	public void init() {
		if(loginUsuarioBean.getAluno().getTurma() != null) {
			disciplinas = loginUsuarioBean.getAluno().getTurma().getDisciplinas();		
		}
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
