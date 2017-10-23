package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.*;
import Entities.*;


public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
     
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		
		CustomerDAO cd=new CustomerDAO();
		String sql="select * from Customer where Customer.User=?";
		
		List<Customer> list=cd.query(sql).setParameter(0, name).list();
		
			
		if(!list.isEmpty()){
			
			request.getSession().setAttribute("customer",list.get(0));
			RestaurantDAO rd=new RestaurantDAO();
			
			String sql2="select * from bbq.restaurant";
			
			List<Restaurant> restaurants=rd.query(sql2).list();
			
			
			request.getSession().setAttribute("rests", restaurants);
			
			request.getRequestDispatcher("/success.jsp").forward(request, response);		
			
		}else{
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
		
		
	}

}
