package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameDetails;
import model.GameItem;
import model.Player;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GameDetailsHelper dao = new GameDetailsHelper();
		GameItemHelper gih = new GameItemHelper();
		PlayerHelper ph =new PlayerHelper();
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		
		GameDetails listToUpdate = dao.searchForGameDetailsById(tempId);
		String newListName = request.getParameter("gameListName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String playerName = request.getParameter("playerName");
		
		Player newPlayer = ph.findPlayer(playerName);
		LocalDate ld;
		try{
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
			}
		catch(NumberFormatException ex) {
			ld = LocalDate.now();
			}
		try{
			String[] selectedItems =request.getParameterValues("allItemsToAdd");
			List<GameItem> selectedItemsInList = new ArrayList<GameItem>();
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				GameItem g =gih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(g);
				}
			
			listToUpdate.setListOfGames(selectedItemsInList);
			}
		catch(NullPointerException ex) {
			List<GameItem> selectedItemsInList = new ArrayList<GameItem>();
			listToUpdate.setListOfGames(selectedItemsInList);
			}
		listToUpdate.setGameListName(newListName);
		listToUpdate.setDateAdded(ld);
		listToUpdate.setPlayer(newPlayer);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
	
}