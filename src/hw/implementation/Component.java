package hw.implementation;

public abstract class Component {
	String name;
	String description;
	Integer price;
	Integer stock;

	public Component(String name, String description, Integer price, Integer stock) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
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
