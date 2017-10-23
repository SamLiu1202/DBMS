package Entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable{
	
	
	private int Id;
	
	private String Name;
	
	private String Address;
	
	private String phone;
	
	private Set<Order> OrderBy;
	
	private Set<Comment> commented;
	
	private Set<Reservation> reserved;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer() {
		super();
	}
	

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	
	public Set<Reservation> getReserved() {
		return reserved;
	}
	public void setReserved(Set<Reservation> reserved) {
		this.reserved = reserved;
	}
	public Set<Comment> getCommented() {
		return commented;
	}
	public void setCommented(Set<Comment> commented) {
		this.commented = commented;
	}
	public Set<Order> getOrderBy() {
		return OrderBy;
	}
	public void setOrderBy(Set<Order> orderBy) {
		OrderBy = orderBy;
	}

	
}
