package hw.implementation;

public abstract class Menber extends Client {

	Integer memberNumber;
	Integer affiliationYear;

	public Menber(String dni, String name, Integer memberNumber, Integer affiliationYear) {
		super(dni, name);
		this.memberNumber = memberNumber;
		this.affiliationYear = affiliationYear;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

	public void setAffiliationYear(Integer affiliationYear) {
		this.affiliationYear = affiliationYear;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public Integer getAffiliationYear() {
		return affiliationYear;
	}

}
