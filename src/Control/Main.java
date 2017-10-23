package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DishesDAO;
import DAO.RestaurantDAO;

/**
 * Servlet implementation class main
 */

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("Rname");
		RestaurantDAO rd=new RestaurantDAO();
		String sql="select * from restaurant where restaurant.r_name=?";
		List list=rd.query(sql).setParameter(0, name).list();
		
		request.getSession().setAttribute("R_name", list.get(0));
		request.getRequestDispatcher("/Search.jsp").forward(request, response);
		
		
	}

}
