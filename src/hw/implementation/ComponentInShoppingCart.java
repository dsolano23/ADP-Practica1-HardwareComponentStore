package hw.implementation;

import java.sql.Date;

public abstract class ComponentInShoppingCart extends ShoppingCart {
	Integer units;

	public ComponentInShoppingCart(Date date, Integer hour, Integer units) {
		super(date, hour);
		this.units = units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Integer getUnits() {
		return units;
	}

}
