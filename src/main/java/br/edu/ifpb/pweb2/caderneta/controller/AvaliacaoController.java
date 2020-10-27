package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.AvaliacaoDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Avaliacao;

public class AvaliacaoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AvaliacaoDAO avaliacaoDAO;
	
	@Transactional
	public void excluir(Avaliacao avaliacao) {
		avaliacaoDAO.delete(avaliacao);
	}
	
	@Transactional
	public void update(Avaliacao avaliacao) {
		avaliacaoDAO.update(avaliacao);
	}
	
	public void refresh(Avaliacao avaliacao) {
		avaliacaoDAO.refresh(avaliacao);
	}
	
	public List<Avaliacao> findAll() {
		return avaliacaoDAO.findAll();
	}

	public Avaliacao find(Integer id) {
		return avaliacaoDAO.find(id);
	}

	@Transactional
	public Avaliacao insert(Avaliacao avaliacao) {
		return avaliacaoDAO.insert(avaliacao);
	}
	
	@Transactional
	public void saveOrUpdate(Avaliacao avaliacao) {
		if(avaliacao.getId() != null) {
			avaliacao = avaliacaoDAO.update(avaliacao);
		} else {
			avaliacaoDAO.insert(avaliacao);
		}
	}
}
