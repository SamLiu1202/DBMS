package Control;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CommentDAO;
import Entities.Comment;
import Entities.Customer;
import Entities.Restaurant;


/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
    private String param;
    private Restaurant rest;
	private Customer c;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer c=(Customer) request.getSession().getAttribute("customer");
		this.c=c;
		
		String param=request.getParameter("param");
		this.param=param;
		HashMap<String,Restaurant> hm =(HashMap<String, Restaurant>) request.getSession().getAttribute("restaurants");
		
		Restaurant rest=hm.get(this.param);
		this.rest=rest;
		
		String name=this.rest.getName();
		CommentDAO cm=new CommentDAO();
		
		String sql="select * from bbq.comment,bbq.restaurant "
				+ "where comment.coms_ID=restaurant.rst_ID AND restaurant.R_NAME=?";
		List list=cm.query(sql).setParameter(0, name).list();
		
		request.setAttribute("comment", list);
		request.getRequestDispatcher("/comment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content=request.getParameter("cont");

		Comment ct=new Comment();
		CommentDAO ctd=new CommentDAO();
		 
		 ct.setContent(content);
		 ct.setCommentTime(new Date());
		 ct.setCustomer(c);
		 ct.setRestaurant(rest);
		 ctd.save(ct);
		 
		 String name=this.rest.getName();
			CommentDAO cm=new CommentDAO();
			
			String sql="select * from bbq.comment,bbq.restaurant "
					+ "where comment.coms_ID=restaurant.rst_ID AND restaurant.R_NAME=?";
			List list=cm.query(sql).setParameter(0, name).list();
			
			request.setAttribute("comment", list);
			request.getRequestDispatcher("/comment.jsp").forward(request, response);
		 
		
	}

}
