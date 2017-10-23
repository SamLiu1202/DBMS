package Entities;


import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{

	
	private int CommentId;
	
	private String Content;
	
	private Date CommentTime;
	
	private Customer customer;
	private Restaurant restaurant;
	
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		this.CommentId = commentId;
	}

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	public Date getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(Date commentTime) {
		CommentTime = commentTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	
}
