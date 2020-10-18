package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.CoordenadorDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Coordenador;

public class CoordenadorController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CoordenadorDAO coordenadorDAO;
	
	@Transactional
	public void excluir(Coordenador coordenador) {
		coordenadorDAO.delete(coordenador);
	}
	
	@Transactional
	public void update(Coordenador coordenador) {
		coordenadorDAO.update(coordenador);
	}
	
	public void refresh(Coordenador coordenador) {
		coordenadorDAO.refresh(coordenador);
	}
	
	public List<Coordenador> findAll() {
		return coordenadorDAO.findAll();
	}

	public Coordenador find(Integer id) {
		return coordenadorDAO.find(id);
	}

	@Transactional
	public Coordenador insert(Coordenador coordenador) {
		return coordenadorDAO.insert(coordenador);
	}
	
	@Transactional
	public void saveOrUpdate(Coordenador coordenador) {
		if(coordenador.getId() != null) {
			coordenador = coordenadorDAO.update(coordenador);
		} else {
			coordenadorDAO.insert(coordenador);
		}
	}
}
