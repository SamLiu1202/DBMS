package Entities;

import java.io.Serializable;


public class Dishes implements Serializable {
	
@Override
	public String toString() {
		return "Dishes [Dish_id=" + Dish_id + ", DishName=" + DishName + ", Price=" + Price + ", Description="
				+ Description + ", restaurant=" + restaurant + "]";
	}
public Dishes() {
		super();
	}

	private int Dish_id;
	private String DishName;
	private int Price;
	private String Description;
	private Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getDishName() {
		return DishName;
	}
	public void setDishName(String dishName) {
		DishName = dishName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getDish_id() {
		return Dish_id;
	}
	public void setDish_id(int dish_id) {
		Dish_id = dish_id;
	}
}
