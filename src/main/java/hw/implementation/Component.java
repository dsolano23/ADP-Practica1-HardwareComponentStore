package hw.implementation;
/**
 * ENUNCIADO: Identificar un componente solo depende de su nombre, como las propiedades son comunes no veo motivo para crear subcases
 * de component por eso no  la hago abstracta 
 * @author dpena
 *
 */
public class Component {
	final String name;
	final String description;
	final Integer price;
	final Integer stock;

	public Component(String name, String description, Integer price, Integer stock) {
		this.name = name;
		this.description = description;
		//ENUNCIADO: El stock y precio de un componente es superior a 0, no se pueden crear componentes con esos parametros
		if(price <=0 || stock <=0) {
			throw new RuntimeException("El stock y precio de un componente es superior a 0");
		}
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}
}
