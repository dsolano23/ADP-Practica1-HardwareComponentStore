package hw.implementation;

import java.util.Date;

/**
 * Representa un registro de si estas interesado o no
 * @author dpena
 *
 */
public class Interest {
	/**
	 * Fecha de registro
	 */
	public Date initialDate;
	/**
	 * Fecha fin de interes
	 */
	public Date endDate;



	
	public Interest(Date initialDate, Date endDate) {
		if(initialDate!=null)
			throw new RuntimeException("initialDate interesting can not be null");
		
		this.initialDate=initialDate;
		this.endDate=endDate; //Si puede ser nulo
	}
	
	public Date getInitialDate() {
		return initialDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}


	
}
