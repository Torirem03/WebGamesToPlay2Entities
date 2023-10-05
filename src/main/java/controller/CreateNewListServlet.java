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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		GameItemHelper gih =new GameItemHelper();
		String gameListName = request.getParameter("gameListName");
		System.out.println("List Name: "+ gameListName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String playerName =request.getParameter("playerName");
		LocalDate ld;
		try{
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
			}
		catch(NumberFormatException ex) {
			ld = LocalDate.now();
			}
		String[] selectedItems =request.getParameterValues("allItemsToAdd");
		List<GameItem> selectedItemsInList = new ArrayList<GameItem>();
		
		if (selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				GameItem g = gih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(g);
				}
			}
		Player player = new Player(playerName);
		GameDetails gld =new GameDetails(gameListName, ld, player); 
		gld.setListOfGames(selectedItemsInList);
		GameDetailsHelper glh = new GameDetailsHelper();
		glh.insertNewListDetails(gld);
		System.out.println("Success!");
		System.out.println(gld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
