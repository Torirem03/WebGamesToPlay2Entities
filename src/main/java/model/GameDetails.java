package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author torirem - aaustin5
 * CIS175 - Fall 2023
 * Oct 4, 2023
 */
@Entity
public class GameDetails {
	@Id
	@GeneratedValue
	private int id;
	private String gameListName;
	private LocalDate dateAdded;
@ManyToOne(cascade=CascadeType.PERSIST)
	private Player player;
@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<GameItem> listOfGames;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the gameListName
	 */
	public String getGameListName() {
		return gameListName;
	}

	/**
	 * @param gameListName the gameListName to set
	 */
	public void setGameListName(String gameListName) {
		this.gameListName = gameListName;
	}

	/**
	 * @return the dateAdded
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the listOfGames
	 */
	public List<GameItem> getListOfGames() {
		return listOfGames;
	}

	/**
	 * @param listOfGames the listOfGames to set
	 */
	public void setListOfGames(List<GameItem> listOfGames) {
		this.listOfGames = listOfGames;
	}

	public GameDetails() {
		super();
	}
	
	public GameDetails(int id, String gameListName, LocalDate dateAdded, Player player, List<GameItem> listOfGames) {
		super();
		this.id = id;
		this.gameListName = gameListName;
		this.dateAdded = dateAdded;
		this.player = player;
		this.listOfGames = listOfGames;
	}
	
	public GameDetails(String gameListName, LocalDate dateAdded, Player player, List<GameItem> listOfGames) {
		super();
		this.gameListName = gameListName;
		this.dateAdded = dateAdded;
		this.player = player;
		this.listOfGames = listOfGames;
	}
	
	public GameDetails(String gameListName, LocalDate dateAdded, Player player) {
		super();
		this.gameListName = gameListName;
		this.dateAdded = dateAdded;
		this.player = player;
	}

	@Override
	public String toString() {
		return "GameDetails [id=" + id + ", gameListName=" + gameListName + ", dateAdded=" + dateAdded + ", player="
				+ player + ", listOfGames=" + listOfGames + "]";
	}
}
