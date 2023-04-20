package hw.implementation;

import java.sql.Date;
import java.util.List;

/**
 * ENUNCIADO: Las compras que hacen los clientes se identifican por la fecha y la hora.
 * Las compras pueden estar en espera de stock de alguno de los componentes o servidas
 * Hay 2 tipos de Shopping Cart,
 * - Las que están pendientes de stock (StockWaiting)
 * - Las que ya están llenas y vendidas (Served)
 */
public abstract class ShoppingCart {
	Date date;
	Integer hour;

	/**
	 * EN el diagrama de clases dice que ShoppingCart has 1..*, asi que por eso esta esto aqui.
	 */
	List<ComponentInShoppingCart> components;

	/**
	 * Para crear una shopping Cart es necesario que tenga componentes seleccionados,
	 * es decir no tiene sentido crear uan shopping cart sin componentes añadidos,
	 * por eso el parametro es obligatorio en el constructor
	 * 
	 * @param date
	 * @param hour
	 * @param components
	 */

	public ShoppingCart(Date date, Integer hour, List<ComponentInShoppingCart> components) {
		this.date = date;
		this.hour = hour;
		this.components = components;
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

	public List<ComponentInShoppingCart> getComponents() {
		return components;
	}

	/**
	 * Metodo comun y basico de calcular el precio independientemente de cualquier otro factor.
	 */
	protected Integer calculateBrutePrice() {
		int total = 0;
		for (ComponentInShoppingCart csc : components) {
			total = total + (csc.getUnits() * csc.getUnits());
		}
		return total;
	}

	/**
	 * Cada tipo de carrito puede implementar su cálculo de precio. Llamar al getPrice 
	 * solo tiene sentido cuando se asigna a una venta, es decir a un cliente, 
	 * por eso necesita un cliente. Se hace abstracto, por si hubiera otro tipo de carritos, 
	 * por ejemplo un BlackFridayCart: en este caso el carrito puede tener un descuento propio y 
	 * luego además aplicar el descuento adicional si el usuario que lo va a coger tuviera 
	 * más privilegios de descuento.
	 * @param client
	 * @return
	 */
	public Integer getPrice(Client client) {
		return Double.valueOf(calculateBrutePrice() * client.getDiscount()).intValue();
	}
}
