package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.dao.UsuarioDAO;
import br.edu.ifpb.pweb2.caderneta.model.Usuario;

public class UsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Transactional
	public void excluir(Usuario usuario) {
		usuarioDAO.delete(usuario);
	}
	
	@Transactional
	public void update(Usuario usuario) {
		usuarioDAO.update(usuario);
	}
	
	public void refresh(Usuario usuario) {
		usuarioDAO.refresh(usuario);
	}
	
	public List<Usuario> findAll() {
		return usuarioDAO.findAll();
	}

	public Usuario find(Integer id) {
		return usuarioDAO.find(id);
	}
	
	public Usuario findByLoginAndPassword(String login, String senha) {
		return usuarioDAO.findByLoginAndPassword(login, senha);
	}

	@Transactional
	public Usuario insert(Usuario usuario) {
		return usuarioDAO.insert(usuario);
	}
	
	@Transactional
	public void saveOrUpdate(Usuario usuario) {
		if(usuario.getId() != null) {
			usuario = usuarioDAO.update(usuario);
		} else {
			usuarioDAO.insert(usuario);
		}
	}
}
