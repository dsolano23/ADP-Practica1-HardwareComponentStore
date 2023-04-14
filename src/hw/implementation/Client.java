package hw.implementation;

public abstract class Client {
	String dni;
	String name;

	public Client(String dni, String name) {
		this.dni = dni;
		this.name = name;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

}
