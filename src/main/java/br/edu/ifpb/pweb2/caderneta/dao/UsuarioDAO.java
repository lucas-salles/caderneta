package br.edu.ifpb.pweb2.caderneta.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.caderneta.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> {
	private static final long serialVersionUID = 1L;
	
	public Usuario findByLoginAndPassword(String login, String senha) {
		try{
			Query q = entityManager.createQuery("select u from Usuario u where u.login= :x and u.senha= :y");
			q.setParameter("x", login);
			q.setParameter("y", senha);
			return (Usuario) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
}
