package hw.implementation;

import java.sql.Date;

public abstract class Served extends ShoppingCart {
	Integer price;

	public Served(Date date, Integer hour, Integer price) {
		super(date, hour);
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
