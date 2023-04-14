package hw.implementation;

import java.sql.Date;
import java.util.List;
/**
 * JUSTIFICACION : Es un tipo de shoping cart que representa un carro de la compra que no esta a la espera de stock y que por lo tanto 
 * se puede calcular el price, por eso price existe aqui y no existe en StockWaiting.
 * 
 * @author dpena
 *
 */
public abstract class Served extends ShoppingCart {
	/**
	 * Todas las clases hijas deben poder tener acceso a esta propiedad
	 */
	protected Integer price;
	/**
	 * ENUNCIADO:En el caso de las compras servidas, el sistema almacena su precio,
	 * Por lo que calculamos el precio en el constructor
	 * @param date
	 * @param hour
	 * @param price
	 * @param components
	 */
	public Served(Date date, Integer hour, List<ComponentInShoppingCart> components) {
		super(date, hour, components);
	}

	@Override
	public Integer getPrice(Client client) {
		return Double.valueOf(calculateBrutePrice()*client.getDiscount()).intValue();
	}

}
