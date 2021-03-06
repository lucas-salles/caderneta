package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;

@Named(value = "cadAlunoBean")
@ViewScoped
public class CadastroAlunoBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Aluno aluno;
	
	@Inject
	private AlunoController alunoController;
	
	@PostConstruct
	public void init() {
		Aluno alunoFlash = (Aluno) this.getFlash("aluno");
		if(alunoFlash != null)
			this.aluno = alunoFlash;
	}
	
	public String cadastrar() {		
		Integer id = aluno.getId();
		aluno.setTipo("Aluno");
		alunoController.saveOrUpdate(aluno);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Aluno cadastrado com sucesso!");
		else
			this.addInfoMessage("Aluno atualizado com sucesso!");
		
		aluno = new Aluno();

		return "alunos?faces-redirect=true";
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
