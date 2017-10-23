package Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CommentDAO;
import DAO.DishesDAO;
import Entities.Customer;
import Entities.Dishes;
import Entities.Restaurant;


public class MenuUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Restaurant r;
  
    public MenuUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Restaurant r=(Restaurant)request.getSession().getAttribute("rest");
		this.r=r;
		DishesDAO disd=new DishesDAO();
		String name=r.getName();
		
		String sql="select *"
				+ " from bbq.dishes,bbq.restaurant "
				+ "	where dishes.m_ID=restaurant.rst_ID and restaurant.R_NAME=?";
		
		List list=disd.query(sql).setParameter(0,name).list();	
		
		request.getSession().setAttribute("Umenu", list);
		
		request.getRequestDispatcher("/menuUpdate.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String dishName=request.getParameter("dish");
		int price=Integer.parseInt(request.getParameter("price"));
		String description=request.getParameter("desc"); 
		
		Dishes dis=new Dishes();
		DishesDAO disd=new DishesDAO();
		dis.setDescription(description);
		dis.setDishName(dishName);
		dis.setPrice(price);
		dis.setRestaurant(r);
		disd.save(dis);
		
		String name=r.getName();
		
		String sql="select *"
				+ " from bbq.dishes,bbq.restaurant "
				+ "where dishes.m_ID=restaurant.rst_ID and restaurant.R_NAME=?";
		
		List list=disd.query(sql).setParameter(0,name).list();	
		
		request.getSession().setAttribute("Umenu", list);
		
		request.getRequestDispatcher("/menuUpdate.jsp").forward(request, response);
		
		
	}

}
