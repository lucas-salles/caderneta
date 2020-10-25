package br.edu.ifpb.pweb2.caderneta.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.caderneta.model.Aula;

public class AulaDAO extends GenericDAO<Aula, Integer> {
	private static final long serialVersionUID = 1L;
	
	public List<Aula> getAulasByTurmaId(Integer id) {
		try {
//			Query q = entityManager.createQuery("select a from Aula a where a.turma_id= :x");
//			q.setParameter("x", id);
			
			Query q = entityManager.createNativeQuery("select * from aula where turma_id= :x", Aula.class);
			q.setParameter("x", id);
			return (List<Aula>) q.getResultList();	
		} catch(NoResultException e) {
			return null;
		}
	}
}
