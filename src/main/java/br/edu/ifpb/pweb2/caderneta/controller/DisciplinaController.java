package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.DisciplinaDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;

public class DisciplinaController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DisciplinaDAO disciplinaDAO;
	
	@Transactional
	public void excluir(Disciplina disciplina) {
		disciplinaDAO.delete(disciplina);
	}
	
	@Transactional
	public void update(Disciplina disciplina) {
		disciplinaDAO.update(disciplina);
	}
	
	public void refresh(Disciplina disciplina) {
		disciplinaDAO.refresh(disciplina);
	}
	
	public List<Disciplina> findAll() {
		return disciplinaDAO.findAll();
	}

	public Disciplina find(Integer id) {
		return disciplinaDAO.find(id);
	}

	@Transactional
	public Disciplina insert(Disciplina disciplina) {
		return disciplinaDAO.insert(disciplina);
	}
	
	@Transactional
	public void saveOrUpdate(Disciplina disciplina) {
		if(disciplina.getId() != null) {
			disciplina = disciplinaDAO.update(disciplina);
		} else {
			disciplinaDAO.insert(disciplina);
		}
	}
}
