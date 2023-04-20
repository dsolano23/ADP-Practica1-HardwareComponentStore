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
 */
public class Client {

	/**
	 * JUSTIFICACION:
	 * protected -> 
	 * Las clases hijas necesitan poder acceder a esta propiedad en cualquier momento.
	 * final -> 
	 * Son inmutables, siempre trabajamos con un objeto java que representa un cliente
	 * y ninguna pieza del código puede modificar estos datos.
	 * (por eso no existe setter para estas properties)
	 */
	protected final String dni;
	protected final String name;

	/*
	 * JUSTIFICACION: Son inmutables, siempre trabajamos con un objeto java que
	 * representa un cliente y ninguna pieza del codigo puede modificar estos datos
	 */
	/**
	 * Todos los clientes (independientemente del tipo (por esto esta en la clase
	 * padre) pueden mostrar su interés por un componente. Se almacena el componentId 
	 * del componente y una lista de fechas en las que mostró o quitó 
	 * su interés por cierto componente
	 */
	Map<String, List<Interest>> interestingComponents = new HashMap<String, List<Interest>>();

	/**
	 * En el diagrama 1 cliente puede tener * Shopping Cart
	 */
	List<ShoppingCart> shoppingCarts;

	protected Double priceDiscount = 1d;

	/**
	 * ENUNCIADO: 
	 * Los clientes de la tienda se identifican con su dni y también proporcionan su nombre
	 * JUSTIFICAION: 
	 * El constructor tiene que obligar que esos campos sean necesarios y obligagorios,
	 * por lo tanto son campos del constructor, es decir sin esos campos no se puede
	 * crear un cliente
	 * 
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
	 * Registra los intereses de un cliente sobre un componente en un momento determinado.
	 * El método es público por si se quiere consultar desde otras clases externas
	 * 
	 * @param componentId
	 * @param interesting
	 */
	public void addInteresting(String componentId, Interest interesting) {
		// Si no existe interés previo en este componente se da de alta
		if (interestingComponents.get(componentId) == null)
			interestingComponents.put(componentId, new ArrayList<Interest>());

		// Registro para una fecha un tipo de interés o desinterés para un componente.
		interestingComponents.get(componentId).add(interesting);
	}

	/**
	 * Busca para una fecha determinada, busca los componentes en los que estaba
	 * interesado el cliente en ese periodo, si la fecha date está dentro de ese periodo
	 * se almacena como componente interesado y se retorna en el método.
	 * 
	 * @param date
	 * @return
	 */
	public Set<String> interestedComponentsPerDate(Date date) {
		Set<String> components = new HashSet<String>();

		/*
		 * Miro para cada componente su histórico de intereses y
		 * miro si la fecha coincide con un registro Interest favorable
		 */
		for (Entry<String, List<Interest>> entry : interestingComponents.entrySet()) {
			for (Interest i : entry.getValue()) {
				if (insidePeriod(i.getInitialDate(), i.getEndDate(), date)) {
					components.add(entry.getKey());
				}

			}
		}
		return components;
	}

	/*
	 * Retorna true si el date esta dentro del periodo initialDAte y
	 * endDate (endDate puede ser nulo si no se ha perdido el interés a dia de hoy)
	 */
	public boolean insidePeriod(Date initialDate, Date endDate, Date date) {
		/*
		 * endDate==null indica que no se a perdido el interés,
		 * por lo tanto sigue interesado a dia de hoy
		 */
		if (date.after(initialDate) && (endDate == null || date.before(endDate))) {
			return true;
		}
		return false;
	}
}
