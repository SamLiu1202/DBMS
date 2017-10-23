package Service;
import Entities.*;

import java.io.Serializable;
import java.util.Date;

import java.util.List;



import DAO.*;
public class CustomerService {
	
	Customer register(String name,String address,String phone ){
		Customer c=new Customer();
		c.setName(name);
		c.setAddress(address);
		c.setPhone(phone);
		CustomerDAO cd=new CustomerDAO();
		cd.save(c);
		return c;
		
	}
	void Login(Customer c){
		String name=c.getName();
		CustomerDAO cd=new CustomerDAO();
		String sql="select * from Customer where Customer.User=?";
		List list=cd.query(sql).setParameter(0, name).list();
		if(list.isEmpty()){
			System.out.println("please sign-up first");
			return;
		}
		System.out.println("sign-in successful ");
			
	}
	
	void findALLrest(){
		RestaurantDAO rd=new RestaurantDAO();
		String sql="select * from bbq.restaurant";
		List list=rd.query(sql).list();
		for(Object obj:list){
			Restaurant re=(Restaurant)obj;
			System.out.println(re.getName()+re.getAddress()+re.getStyle());
		}
		
	}
	
	void Search(String name){
		
		RestaurantDAO rd=new RestaurantDAO();
		String sql="select * from restaurant where restaurant.r_name=?";
		List list=rd.query(sql).setParameter(0, name).list();
		for(Object obj:list){
			Restaurant re=(Restaurant)obj;
			System.out.println(re.getName()+re.getAddress()+re.getStyle());
		}
		
	}
	void viewDishes(String name){
		
		DishesDAO disd=new DishesDAO();
		String sql="select *"
				+ " from bbq.dishes,bbq.restaurant "
				+ "where dishes.m_ID=restaurant.rst_ID and restaurant.R_NAME=?";
		List list=disd.query(sql).setParameter(0, name).list();
		for(Object obj:list){
			Dishes dis=(Dishes)obj;
			System.out.println(dis.getDish_id()+dis.getDescription()+dis.getDishName()+dis.getPrice());
		}
		
		
	}
	
	void writeComment(Customer c,Restaurant r,String content){
	  
		 Comment ct=new Comment();
		 CommentDAO ctd=new CommentDAO();
		 
		 ct.setContent(content);
		 ct.setCommentTime(new Date());
		 ct.setCustomer(c);
		 ct.setRestaurant(r);
		 ctd.save(ct);

	}
	
	void checkComment(String name){
		
		CommentDAO cm=new CommentDAO();
		String sql="select * from bbq.comment,bbq.restaurant "
				+ "where comment.coms_ID=restaurant.rst_ID AND restaurant.R_NAME=?";
		List list=cm.query(sql).setParameter(0, name).list();
		for(Object obj:list){
			Comment cmt=(Comment)obj;
			System.out.println(cmt.getCommentId()+cmt.getContent()+cmt.getCommentTime());
		}
	}
		
	
		

	void reserveTable(Customer c,Restaurant r,int people){
		 
		 Reservation res=new Reservation();
		 ReservationDAO rvd=new ReservationDAO();
		 
		 res.setPeopleNum(people);
		 res.setReservationTime(new Date().toString());
		 res.setCustomer(c);
		 res.setRestaurant(r);
		
		 rvd.save(res);

	 }
	
}
