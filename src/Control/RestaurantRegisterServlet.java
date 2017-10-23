package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RestaurantDAO;
import Entities.Restaurant;

/**
 * Servlet implementation class RestaurantRegister
 */
@WebServlet("/RestaurantRegister")
public class RestaurantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantRegisterServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("restname");
		String style=request.getParameter("style");
		String address=request.getParameter("restaddress");
		
		Restaurant r=new Restaurant();
		r.setName(name);
		r.setStyle(style);
		r.setAddress(address);
		RestaurantDAO rd=new RestaurantDAO();
		rd.save(r);		
		
		request.getRequestDispatcher("/restaurantLogin.jsp").forward(request, response);
	
	}

}
