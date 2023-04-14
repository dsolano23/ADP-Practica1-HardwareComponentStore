package hw.implementation;

import java.sql.Date;

public abstract class ShoppingCart {
	Date date;
	Integer hour;

	public ShoppingCart(Date date, Integer hour) {
		this.date = date;
		this.hour = hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getHour() {
		return hour;
	}

}
