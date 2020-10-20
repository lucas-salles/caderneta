package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Turma;
import br.edu.ifpb.pweb2.utils.Utils;

@Named(value = "matAlunoBean")
@ViewScoped
public class MatricularAlunoBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Aluno aluno;
	
	@Inject
	private Turma turma;
	
	private String nomeAluno;
	private String codigoTurma;
	
	@Inject
	private AlunoController alunoController;
	
	@Inject
	private TurmaController turmaController;
	
	public String cadastrar() {
		aluno = alunoController.find(Utils.getId(nomeAluno));
		turma = turmaController.find(Utils.getId(codigoTurma));
		
		aluno.setTurma(turma);
		turma.add(aluno);
		
		alunoController.update(aluno);
		turmaController.update(turma);
		
		this.KeepMessages();
		this.addInfoMessage("Aluno matriculado com sucesso!");
		
		return "/home/homeCoordenador?faces-redirect=true";
	}
	
	public List<String> getAlunos() {
		List<String> alunos = new ArrayList<>();
		for(Aluno a: alunoController.findAll())
			alunos.add(a.getId() + " - " + a.getNome());
		return alunos;
	}
	
	public List<String> getTurmas() {
		List<String> turmas = new ArrayList<>();
		for(Turma t: turmaController.findAll())
			turmas.add(t.getId() + " - " + t.getCodigo());
		return turmas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
}
