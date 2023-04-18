package hw.implementation;

import java.util.List;

/**
 * 
 * No es clase abstracta, porque se pueden crear clientes que solo tengan dni y name
 * 
 * @author dpena
 *
 */
public class Client {
	
	//JUSTIFICACION: 
	//protected  ->  Las clases hijas necesitan poder acceder a esta propiedad en cualquier momento. 
	//final  ->  Son inmutables, siempre trabajamos con un objeto java que representa un cliente y ninguna pieza del codigo puede modificar estos datos. (por eso no existe setter para estas properties)
	protected final String dni;  
	
	//JUSTIFICACION: 
	//protected  ->  Las clases hijas necesitan poder acceder a esta propiedad en cualquier momento. 
	//final  ->  Son inmutables, siempre trabajamos con un objeto java que representa un cliente y ninguna pieza del codigo puede modificar estos datos. (por eso no existe setter para estas properties)
	protected final String name; //JUSTIFICACION: Son inmutables, siempre trabajamos con un objeto java que representa un cliente y ninguna pieza del codigo puede modificar estos datos
	
	/**
	 * En el diagrama 1 cliente puede tener * Shopping Cart
	 */
	List<ShoppingCart> shoppingCarts;
	
	protected Double priceDiscount = 1d;
	/**
	 * ENUNCIADO: Los clientes de la tienda se identifican con su dni y también proporcionan su nombre
	 * JUSTIFICAION: El constructor tiene que obligar que esos campos sean necesarios y obligagorios, por lo tanto son campos del constructor, es decir sin esos campos no se puede crear un cliente
	 * @param dni
	 * @param name
	 */
	public Client(String dni, String name) {
		this.dni = dni;
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}
	
	public double getDiscount() {
		return priceDiscount;
	}

}
