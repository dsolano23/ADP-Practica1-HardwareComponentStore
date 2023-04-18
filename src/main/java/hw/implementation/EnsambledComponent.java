package hw.implementation;

import java.util.HashSet;
import java.util.Set;

public class EnsambledComponent extends Component{
	/**
	 * ENUNCIADO: En un producto ensamblado no puede haber ni de forma directa ni de forma indirecta el mismo producto ensamblado
	 * JUSTIFICACION: Se usa la estructura Set que no permite elementos repetidos (componentes repetidos) y no permite conentes repetidos
	 */
	Set<Component> components = new HashSet<Component>();
	
	private EnsambledComponent(String name, String description, Integer price, Integer stock) {
		super(name, description, price, stock);
	}
	
	/**
	 * El constructor de ensambledComponent cambia externamente, ya que solo se puede crear un ensambledcomponent a partir de un listado de componentes
	 * @param name
	 * @param description
	 * @param component
	 * @param stock
	 */
	public EnsambledComponent(String name, String description, Set<Component> component, Integer stock) {
		this(name, description,calculatePrice(component), stock);
	}
	/**
	 * Ayuda a calcular el precio total a partir de la suma de sus compoentnes
	 * @param components
	 * @return
	 */
	protected static Integer calculatePrice(Set<Component> components) {
		int total = 0;
		for(Component c: components)
			total = total+c.getPrice();
		return total;
	}
}
