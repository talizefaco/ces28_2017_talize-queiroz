package enus;

import lab3.Address;
import lab3.Date;
import lab3.Languages;
import lab3.Person;
import lab3.PersonalLetter;

public class PersonalLetterENUS extends PersonalLetter {
	public PersonalLetterENUS(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress, Date date) {
		super(Languages.ENUS, sender, destinatary, senderAddress, destinataryAddress, date);
	}

	@Override
	protected String getCompliments() {
		return "How you are you, dude?\n";
	}

	@Override
	protected String getBye() {
		return "See ya,\n";
	}
}
