package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustomerDAO;
import DAO.RestaurantDAO;
import Entities.Restaurant;

/**
 * Servlet implementation class RestaurantLogin
 */
@WebServlet("/RestaurantLogin")
public class RestaurantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("restname");
		RestaurantDAO rd=new RestaurantDAO();
		
		String sql="select * from bbq.restaurant where restaurant.r_name=?";
		List list=rd.query(sql).setParameter(0, name).list();
		
		if(!list.isEmpty()){
			Restaurant re=(Restaurant)list.get(0);
			
			request.getSession().setAttribute("rest", re);
			request.getRequestDispatcher("/restaurant.jsp").forward(request, response);
		}else{
			response.getWriter().write("The restaurant has not existed");
			request.getRequestDispatcher("/restaurantRegister.jsp").forward(request, response);
		}
	}

}
