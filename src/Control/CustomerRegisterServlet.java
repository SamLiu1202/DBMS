package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustomerDAO;
import Entities.Customer;



public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String address=request.getParameter("address");
		String phone=request.getParameter("telephone");
		Customer c=new Customer();
		c.setName(name);
		c.setAddress(address);
		c.setPhone(phone);
		CustomerDAO cd=new CustomerDAO();
		cd.save(c);
		
		request.getRequestDispatcher("/customerLogin.jsp").forward(request, response);;
	}

}
