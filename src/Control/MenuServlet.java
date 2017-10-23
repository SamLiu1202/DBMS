package Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DishesDAO;
import Entities.Restaurant;

/**
 * Servlet implementation class menu
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String param;
	private Restaurant rest;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param=request.getParameter("param");
		this.param=param;
		HashMap<String,Restaurant> hm =(HashMap<String, Restaurant>) request.getSession().getAttribute("restaurants");
		
		Restaurant rest=hm.get(this.param);
		this.rest=rest;
		
		String name=this.rest.getName();
		
		DishesDAO disd=new DishesDAO();
		String sql="select *"
				+ " from bbq.dishes,bbq.restaurant "
				+ "where dishes.m_ID=restaurant.rst_ID and restaurant.R_NAME=?";
		
		List list=disd.query(sql).setParameter(0,name).list();
		
		request.getSession().setAttribute("menu", list);
		
		request.getRequestDispatcher("/menu.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
