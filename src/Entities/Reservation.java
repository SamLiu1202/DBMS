package Entities;

import java.io.Serializable;
import java.util.Date;


public class Reservation implements Serializable{
	
	@Override
	public String toString() {
		return "Reservation [ReservationID=" + ReservationID + ", ReservationTime=" + ReservationTime + ", PeopleNum="
				+ PeopleNum + ", customer=" + customer + ", restaurant=" + restaurant + "]";
	}



	private int ReservationID;
	private String ReservationTime;
	private int PeopleNum;
	private Customer customer;
	private Restaurant restaurant;
	
	
	public Reservation() {
		super();
	}



	public int getReservationID() {
		return ReservationID;
	}

	public void setReservationID(int reservationID) {
		ReservationID = reservationID;
	}

	public int getPeopleNum() {
		return PeopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		PeopleNum = peopleNum;
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



	public String getReservationTime() {
		return ReservationTime;
	}



	public void setReservationTime(String reservationTime) {
		ReservationTime = reservationTime;
	}
		
}
