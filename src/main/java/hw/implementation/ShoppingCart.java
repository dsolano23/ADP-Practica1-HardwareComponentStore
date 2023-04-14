package hw.implementation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 * ENUNCIADO: Las compras que hacen los clientes se identifican por la fecha y la hora. Las compras pueden estar
en espera de stock de alguno de los componentes o servidas
	
	Hay 2 tipos de Shopping Cart, 
		- Las que esta pendientes de stock (StockWaiting)
		- Las que ya estan llenas y vendidad (Served)
	
 * @author dpena
 *
 */
public abstract class ShoppingCart {
	Date date;
	Integer hour;
	/**
	 * EN el diagrama de clases dice que ShoppingCart has 1..*, asi que por eso esta esto aqui.
	 */
	List<ComponentInShoppingCart> components; 
	/**
	 * Para crear una shopping Cart es necesario que tenga componentes seleccionados, es decir no tiene sentido
	 * crear uan shopping cart sin componentes añadidos, por eso el parametro es obligatorio en el constructor
	 * @param date
	 * @param hour
	 * @param components
	 */
	public ShoppingCart(Date date, Integer hour, List<ComponentInShoppingCart> components) {
		this.date = date;
		this.hour = hour;
		this.components=components;
		
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
		for(ComponentInShoppingCart csc: components) {
			total = total + (csc.getUnits()*csc.getUnits());
		}
		return total;
	}

	/**
	 * Cada tipo de carrito puede implementar su calculo de precio.
	 * Llamar al getPrice solo tiene sentido cuando se asgina a una venta, es decir a un cliente, por eso necestia un cliente.
	 * se hace abstracto por si hubiera otro tipo de carritos, por ejemplo un BlackFridayCart : en este caso el carrito puede tener un descuento propio
	 * y luego ademas aplicar el descuento adicional si el usuario que lo va a coger tuviera mas privilegios de descuento.
	 * @param client
	 * @return
	 */
	public abstract Integer getPrice(Client client);
	
	
}
