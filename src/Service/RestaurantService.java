package Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import DAO.*;
import Entities.*;

public class RestaurantService {

	Restaurant register(String Name,String Style, String address){
		Restaurant r=new Restaurant();
		r.setName(Name);
		r.setStyle(Style);
		r.setAddress(address);
		RestaurantDAO rd=new RestaurantDAO();
		rd.save(r);	
		return r;
	}
	
	void Login(Restaurant r){
		String name=r.getName();
		RestaurantDAO rd=new RestaurantDAO();
		String sql="select * from bbq.restaurant where restaurant.r_name=?";
		
		List list=rd.query(sql).setParameter(0, name).list();
		if(list.isEmpty()){
			System.out.println("please sign-up");
			return;
		}
		System.out.println("sign-in successfully");
		
	}
	
	void update(String name,String style,String address){
		RestaurantDAO rd=new RestaurantDAO();
		rd.update(name, style, address);
	}
	
	void checkOrder(Customer c,Restaurant r,double price){
		
		 Order o=new Order();
		 OrderDAO od=new OrderDAO();
		 o.setOrderPrice(price);
		 o.setOrderTime(new Date().toString()); 
		 o.setOrders(c);
		 o.setProcesses(r);
		 od.save(o);	 
	 }
	
	void SetDishes(String description,String dishName,int price,Restaurant r){
		
		Dishes dis=new Dishes();
		DishesDAO disd=new DishesDAO();
		dis.setDescription(description);
		dis.setDishName(dishName);
		dis.setPrice(price);
		dis.setRestaurant(r);
		disd.save(dis);
		
	}
	
	
}
