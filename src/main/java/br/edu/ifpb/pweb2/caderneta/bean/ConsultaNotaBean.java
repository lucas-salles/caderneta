package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Nota;

@Named(value = "consNotaBean")
@ViewScoped
public class ConsultaNotaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Set<Nota> notas;
	
	@Inject
	private LoginUsuarioBean loginUsuarioBean;
	
	@PostConstruct
    public void init() {
        Aluno aluno = loginUsuarioBean.getAluno();
        notas = aluno.getNotas();
    }

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}

	public LoginUsuarioBean getLoginUsuarioBean() {
		return loginUsuarioBean;
	}

	public void setLoginUsuarioBean(LoginUsuarioBean loginUsuarioBean) {
		this.loginUsuarioBean = loginUsuarioBean;
	}
}
