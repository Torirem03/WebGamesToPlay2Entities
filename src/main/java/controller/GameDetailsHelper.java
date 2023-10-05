package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameDetails;

/**
 * @author torirem - aaustin5
 * CIS175 - Fall 2023
 * Oct 4, 2023
 */
public class GameDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GamesToPlay");
	
	public void insertNewListDetails(GameDetails g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<GameDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<GameDetails> allDetails = em.createQuery("SELECT g FROM GameDetails g").getResultList();
		return allDetails;
	}
	
	public void deleteList(GameDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GameDetails> typedQuery = em.createQuery("select detail from ListDetailsdetail where detail.id = :selectedId", GameDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		
		GameDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public GameDetails searchForGameDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GameDetails found = em.find(GameDetails.class, tempId);
		em.close();
		return found;
		}
	
	public void updateList(GameDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
