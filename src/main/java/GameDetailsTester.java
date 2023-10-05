import java.time.LocalDate;
import java.util.List;

import controller.GameDetailsHelper;
import controller.PlayerHelper;
import model.GameDetails;
import model.Player;

/**
 * @author torirem - aaustin5
 * CIS175 - Fall 2023
 * Oct 4, 2023
 */
public class GameDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player amber = new Player("Amber");
		
		PlayerHelper ph = new PlayerHelper();
		
		ph.insertPlayer(amber);
		
		GameDetailsHelper gdh = new GameDetailsHelper();
		
		GameDetails amberList = new GameDetails("Amber's List", LocalDate.now(), amber);
		
		gdh.insertNewListDetails(amberList);
		
		List<GameDetails> allLists = gdh.getLists();
		
		for (GameDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
