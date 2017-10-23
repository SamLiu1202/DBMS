package Entities;

import java.io.Serializable;

public class Order implements Serializable{
	
	
	private int OrderID;
	private double OrderPrice;
	private String OrderTime;
	private Customer orders;
	private Restaurant processes;
	
	
	public Order() {
		super();
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	public Restaurant getProcesses() {
		return processes;
	}
	public void setProcesses(Restaurant processes) {
		this.processes = processes;
	}
	public Customer getOrders() {
		return orders;
	}
	public void setOrders(Customer orders) {
		this.orders = orders;
	}
	public double getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		OrderPrice = orderPrice;
	}
	
	
	
}
