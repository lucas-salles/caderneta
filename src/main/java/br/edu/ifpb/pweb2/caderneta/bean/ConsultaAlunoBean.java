package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;

@Named(value = "consAlunoBean")
@ViewScoped
public class ConsultaAlunoBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aluno> alunos;
	private Integer id;
	
	@Inject 
	private AlunoController alunoController;

	
	public void init() {
		if(id == null)
			alunos = alunoController.findAll();
		else
			alunos = Collections.singletonList(alunoController.find(id));
	}

	public String excluir(Aluno aluno) {
		alunoController.excluir(aluno);
		this.addInfoMessage("Aluno excluído com sucesso!");
		this.init();
		return null;
	}
	
	public String editar(Aluno aluno) {
		this.putFlash("aluno", aluno);
		return "cadAluno?faces-redirect=true";
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
}
