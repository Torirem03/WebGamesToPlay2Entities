package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

/**
 * @author torirem - aaustin5
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
public class PlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GamesToPlay");
	
	public void insertPlayer(Player p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers(){
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT p FROM Player p").getResultList();
		return allPlayers;
	}
	
	public Player findPlayer(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("SELECT pl from Player pl where pl.playerName = :selectedName", Player.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Player foundPlayer;
		try {
			foundPlayer = typedQuery.getSingleResult();
		} catch (NoResultException ex){
			foundPlayer = new Player(nameToLookUp);
		}
		em.close();
		
		return foundPlayer;
	}
}
