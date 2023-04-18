package hw.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	 * Todos los clientes (independientemente del tipo (por esto esta en la clase padre) pueden mostrar su interes por un componente. Se almacena  el nombre del componente y una lista de fechas en las que mostro o quito su interes por ciert
	 * componente
	 */
	Map<String, List<Interest>> interestingComponents = new HashMap<String, List<Interest>>();
	
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
	/**
	 * Registra los intereses de un cliente sobre un componente en unmomento determinado del tiempo.
	 * El metodo es publico por si se quiere consultar desde otras clases externas
	 * @param componentName
	 * @param interesting
	 */
	public void addInteresting(String componentName, Interest interesting) {
		//Si no existe interes previo en eses componente se da de alta
		if(interestingComponents.get(componentName)==null)
			interestingComponents.put(componentName, new ArrayList<Interest>());
		
		//Registro para una fecha un tipo de interes o desinteres para un componente.
		interestingComponents.get(componentName).add(interesting);
	}
	
	/**
	 * Busca para una fecha determinada, busca los componentes en los que estaba interesado el cliente en ese periodo, 
	 * si la fecha date esta dentro de ese periodo se alamacena como componente interesado y se retorna en el metodo.
	 * @param date
	 * @return
	 */
	public Set<String> interestedComponentsPerDate(Date date) {
		Set<String> components = new HashSet<String>();
		
		//Miro para cada componente su historico de intereses y miro si la fecha coincide con un registro Interest favorable
		for (Entry<String, List<Interest>> entry : interestingComponents.entrySet()) {
		    for(Interest i: entry.getValue()) {
		    	if(insidePeriod(i.getInitialDate(),i.getEndDate(),date)) {
		    		components.add(entry.getKey());
		    	}
		    		
		    }
		}
		
		return components;
		
	}
	/*
	 *  Retorna true si el date esta dentro del periodo initialDAte y endDate (endDate puede ser nulo si no se ha perdido el interes a dia de hoy)
	 */
	public boolean insidePeriod(Date initialDate, Date endDate, Date date) {
		if(date.after(initialDate) && (endDate == null || date.before(endDate))){  //endDate==null indica que no se a perdido el interes , por lo tanto sigue interesado a dia de hoy
			return true;
		}
		return false;
	}

}
