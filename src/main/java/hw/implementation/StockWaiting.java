package hw.implementation;

import java.sql.Date;
import java.util.List;

/**
 * ENUNCIADO: En el caso de las compras en espera de stock, el sistema registra los componentes que se están esperando
 * 
 * 
 * @author dpena
 *
 */
public class StockWaiting extends ShoppingCart {
	/**
	 * Los componentes en espera de stock de una compra tienen que ser componentes de
		aquella compra
	 * @param date
	 * @param hour
	 * @param components
	 */
	public StockWaiting(Date date, Integer hour, List<ComponentInShoppingCart> components) {
		super(date, hour, components);
	}

	@Override
	public Integer getPrice(Client client) {
		
	}

}
