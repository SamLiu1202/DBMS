package Service;

import DAO.RestaurantDAO;
import Entities.*;
public class ServiceTest {
	public static void main(String[] args) {
		CustomerService CS=new CustomerService();
		RestaurantService rs=new RestaurantService();
		
		
		Customer c=CS.register("Sam", "109 Saint Stephen", "6172508973");
		Restaurant r=rs.register("Five Guys", "American", "306 Huntington AVE");
	
		
		CS.Login(c);
		rs.Login(r);
		
		CS.Search("Five Guys");
		
		rs.SetDishes("steak,pototoes", "cs5200", 12, r);
		
		rs.checkOrder(c, r,12.5);
		
		CS.writeComment(c, r, "Fries is very yummy");
		
		CS.reserveTable(c, r, 3);
		
		rs.update("Five Guys","African", "Beijing");
		}
	}
	