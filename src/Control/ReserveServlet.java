package Control;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReservationDAO;
import Entities.Customer;
import Entities.Reservation;
import Entities.Restaurant;


public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String param;
	private Customer c;
	private Restaurant r;
	
	
    public ReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer c=(Customer) request.getSession().getAttribute("customer");
		this.c=c;
		String param=request.getParameter("param");
		this.param=param;
		
		HashMap<String,Restaurant> hm =(HashMap<String, Restaurant>) request.getSession().getAttribute("restaurants");
		
		Restaurant r=hm.get(this.param);
		this.r=r;
		request.getRequestDispatcher("/reserve.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int people=Integer.parseInt(request.getParameter("rsv"));
		
		 Reservation res=new Reservation();
		 ReservationDAO rvd=new ReservationDAO();
		 
		 res.setPeopleNum(people);
		 res.setReservationTime(new Date().toString());
		 res.setCustomer(c);
		 res.setRestaurant(r);	
		 rvd.save(res);
		 
		 response.getWriter().write("reserve successfully");
		 
		 request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
