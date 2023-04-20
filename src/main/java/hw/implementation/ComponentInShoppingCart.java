package hw.implementation;

import java.util.Date;

/**
 * ENUNCIADO: En el diagrama dice que ComponentInShoppingCart IsTypeOf
 * Component, por eso extiende de component.
 */
public class ComponentInShoppingCart extends Component {
	Integer units;
	Date date;
	Integer hour;

	public ComponentInShoppingCart(String name, String description, Integer price, Integer stock,
								   Date date, Integer hour, Integer units) {
		super(name, description, price, stock);
		this.date = date;
		this.hour = hour;
		/**
		 * ENUNCIADO: El número de unidades de un componente en una compra es superior a 0
		 */
		if (units == 0) {
			throw new RuntimeException("El número de unidades de un componente en una compra debe ser superior a 0");
		} else {
			this.units = units;
		}
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Integer getUnits() {
		return units;
	}
}
