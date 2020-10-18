package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.AlunoDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;

public class AlunoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void excluir(Aluno aluno) {
		alunoDAO.delete(aluno);
	}
	
	@Transactional
	public void update(Aluno aluno) {
		alunoDAO.update(aluno);
	}
	
	public void refresh(Aluno aluno) {
		alunoDAO.refresh(aluno);
	}
	
	public List<Aluno> findAll() {
		return alunoDAO.findAll();
	}

	public Aluno find(Integer id) {
		return alunoDAO.find(id);
	}

	@Transactional
	public Aluno insert(Aluno aluno) {
		return alunoDAO.insert(aluno);
	}
	
	@Transactional
	public void saveOrUpdate(Aluno aluno) {
		if(aluno.getId() != null) {
			aluno = alunoDAO.update(aluno);
		} else {
			alunoDAO.insert(aluno);
		}
	}
}
