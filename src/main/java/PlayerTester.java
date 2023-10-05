import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.GameDetailsHelper;
import controller.PlayerHelper;
import model.GameDetails;
import model.GameItem;
import model.Player;

/**
 * @author torirem - aaustin5
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
public class PlayerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player amber = new Player("Amber");
		
		GameDetailsHelper gdh = new GameDetailsHelper();
		
		GameItem wow = new GameItem("World of Warcraft", "MMO");
		GameItem ow = new GameItem("Overwatch 2", "FPS");
		
		List<GameItem> ambersitems = new ArrayList<GameItem>();
		ambersitems.add(wow);
		ambersitems.add(ow);
		
		GameDetails ambersList = new GameDetails("Amber's Game List", LocalDate.now(), amber);
		ambersList.setListOfGames(ambersitems);
		
		gdh.insertNewListDetails(ambersList);
		
		List<GameDetails> allLists = gdh.getLists();
		for (GameDetails a: allLists) {
			System.out.println(a.toString());
		}
	}

}
