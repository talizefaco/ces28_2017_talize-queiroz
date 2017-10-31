package enus;

import lab3.CommercialLetter;
import lab3.Address;
import lab3.Date;
import lab3.Languages;
import lab3.Person;

public class CommercialLetterENUS extends CommercialLetter {
	public CommercialLetterENUS(Person sender, Person destinatary, Address senderAddress, 
			Address destinataryAddress, Date date) {
		super(Languages.ENUS, sender, destinatary, senderAddress, destinataryAddress, date);
	}

	@Override
	protected String getDear() {
		return "Dear";
	}

	@Override
	protected String getSincerely() {
		return "Sincerely";
	}
	
	
}
