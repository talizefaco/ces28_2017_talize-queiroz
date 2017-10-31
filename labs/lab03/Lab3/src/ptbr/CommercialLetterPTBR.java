package ptbr;

import lab3.CommercialLetter;
import lab3.Address;
import lab3.Date;
import lab3.Languages;
import lab3.Person;

public class CommercialLetterPTBR extends CommercialLetter {
	public CommercialLetterPTBR(Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date) {
		super(Languages.PTBR, sender, destinatary, senderAddress, destinataryAddress, date);
	}

	@Override
	protected String getDear() {
		return "Querido ";
	}

	@Override
	protected String getSincerely() {
		return "Atenciosamente";
	}
	
}
