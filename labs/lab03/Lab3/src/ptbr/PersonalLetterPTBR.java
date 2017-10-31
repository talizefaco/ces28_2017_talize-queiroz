package ptbr;

import lab3.Address;
import lab3.Date;
import lab3.Languages;
import lab3.Person;
import lab3.PersonalLetter;

public class PersonalLetterPTBR extends PersonalLetter {
	public PersonalLetterPTBR(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress, Date date) {
		super(Languages.PTBR, sender, destinatary, senderAddress, destinataryAddress, date);
	}

	@Override
	protected String getCompliments() {
		return "Como vai, mano?\n";
	}

	@Override
	protected String getBye() {
		return "Falous broder\n";
	}
}
