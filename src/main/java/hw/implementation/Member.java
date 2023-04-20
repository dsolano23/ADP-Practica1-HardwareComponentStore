package hw.implementation;

/**
 * ENUNCIADO: Para estos, (ADEMAS) el sistema registra el número de socio y 
 * el año en el que se dieron de alta como socios de la tienda
 * Extiende de cliente, ya que son  un tipo especial de cliente
 */
public class Member extends Client {

	protected final Integer memberNumber;
	protected final Integer affiliationYear;
	
	protected Double priceDiscount = 0.90d;
	/**
	 * ENUNCIADO: Un subconjunto de clientes son socios de la tienda.
	 * 			  Para estos, el sistema registra el número de socio y
	 * 			  el año en el que se dieron de alta como socios de la tienda
	 * JUSTIFICACION: Al ser un tipo de cliente, se extiende de Client y se llama a su constructor
	 * @param dni
	 * @param name
	 * @param memberNumber
	 * @param affiliationYear
	 */
	public Member(String dni, String name, Integer memberNumber, Integer affiliationYear) {
		super(dni, name);
		this.memberNumber = memberNumber;
		this.affiliationYear = affiliationYear;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public Integer getAffiliationYear() {
		return affiliationYear;
	}
}
