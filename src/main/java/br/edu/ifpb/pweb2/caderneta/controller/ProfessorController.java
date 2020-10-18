package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.ProfessorDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Professor;

public class ProfessorController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProfessorDAO professorDAO;
	
	@Transactional
	public void excluir(Professor professor) {
		professorDAO.delete(professor);
	}
	
	@Transactional
	public void update(Professor professor) {
		professorDAO.update(professor);
	}
	
	public void refresh(Professor professor) {
		professorDAO.refresh(professor);
	}
	
	public List<Professor> findAll() {
		return professorDAO.findAll();
	}

	public Professor find(Integer id) {
		return professorDAO.find(id);
	}

	@Transactional
	public Professor insert(Professor professor) {
		return professorDAO.insert(professor);
	}
	
	@Transactional
	public void saveOrUpdate(Professor professor) {
		if(professor.getId() != null) {
			professor = professorDAO.update(professor);
		} else {
			professorDAO.insert(professor);
		}
	}
}
