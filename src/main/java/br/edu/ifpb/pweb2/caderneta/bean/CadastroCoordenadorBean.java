package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.CoordenadorController;
import br.edu.ifpb.pweb2.caderneta.model.Coordenador;

@Named(value = "cadCoordenadorBean")
@ViewScoped
public class CadastroCoordenadorBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Coordenador coordenador;
	
	@Inject
	private CoordenadorController coordenadorController;
	
	@PostConstruct
	public void init() {
		Coordenador coordenadorFlash = (Coordenador) this.getFlash("coordenador");
		if(coordenadorFlash != null)
			this.coordenador = coordenadorFlash;
	}
	
	public String cadastrar() {		
		Integer id = coordenador.getId();
		coordenador.setTipo("Coordenador");
		coordenador.setAtivo(true);
		coordenadorController.saveOrUpdate(coordenador);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Coordenador cadastrado com sucesso!");
		else
			this.addInfoMessage("Coordenador atualizado com sucesso!");
		
		coordenador = new Coordenador();

		return "/index?faces-redirect=true";
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
}
