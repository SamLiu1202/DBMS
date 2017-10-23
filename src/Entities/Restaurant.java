package Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Restaurant implements Serializable{
	
	
	private int Id;

	private String name;
	
	private String address;

	private String style;
	
	private Set<Dishes> menu;
	
	private Set<Order> OrderList;
	
	private Set<Comment> comments;
	
	private Set<Reservation> reserves;
	
	public Restaurant() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Set<Dishes> getMenu() {
		return menu;
	}

	public void setMenu(Set<Dishes> menu) {
		this.menu = menu;
	}

	public Set<Order> getOrderList() {
		return OrderList;
	}

	public void setOrderList(Set<Order> orderList) {
		OrderList = orderList;
	}

	

	public Set<Reservation> getReserves() {
		return reserves;
	}

	public void setReserves(Set<Reservation> reserves) {
		this.reserves = reserves;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	
}
