package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AulaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Aula;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "consFaltaBean")
@ViewScoped
public class ConsultaFaltaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aula> aulas = new ArrayList<>();
	
	@Inject
	private Aluno aluno;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	@Inject
	private AulaController aulaController;
	
	@PostConstruct
    public void init() {
        aluno = loginUsuarioBean.getAluno();
        buscarFaltas();
    }
	
	public void buscarFaltas() {
		for(Turma turma: aluno.getTurmas()) {
			List<Aula> aulasTurma = aulaController.getAulasByTurmaId(turma.getId());
			for(Aula aula: aulasTurma) {
				Boolean contem = false;
				for(Aluno a: aula.getAlunos())
					if(a.getId() == aluno.getId()) contem = true;
				
				if(!contem) aulas.add(aula);
			}
		}
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
