package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.dao.TurmaDAO;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

public class TurmaController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TurmaDAO turmaDAO;
	
	@Transactional
	public void excluir(Turma turma) {
		turmaDAO.delete(turma);
	}
	
	@Transactional
	public void update(Turma turma) {
		turmaDAO.update(turma);
	}
	
	public void refresh(Turma turma) {
		turmaDAO.refresh(turma);
	}
	
	public List<Turma> findAll() {
		return turmaDAO.findAll();
	}

	public Turma find(Integer id) {
		return turmaDAO.find(id);
	}

	@Transactional
	public Turma insert(Turma turma) {
		return turmaDAO.insert(turma);
	}
	
	@Transactional
	public void saveOrUpdate(Turma turma) {
		if(turma.getId() != null) {
			turma = turmaDAO.update(turma);
		} else {
			turmaDAO.insert(turma);
		}
	}
}
