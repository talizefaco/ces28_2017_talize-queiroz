package lab3;

import enus.PersonalLetterENUS;
import ptbr.PersonalLetterPTBR;
import lab3.Address.AddressBuilder;
import lab3.Date.DateBuilder;
import lab3.Person.PersonBuilder;

public abstract class PersonalLetter {
	protected Person _sender;
	protected Person _destinatary;
	protected Address _senderAddress;
	protected Address _destinataryAddress;
	protected Date _date;
	protected Languages _language;
	
	protected PersonalLetter (Languages language, Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date) {
		_sender = sender;
		_destinatary = destinatary;
		_senderAddress = senderAddress;
		_destinataryAddress = destinataryAddress;
		_date = date;
		_language = language;
	}
	
	public static PersonalLetter getLetter(Languages language, PersonBuilder senderB, PersonBuilder destinataryB,
			AddressBuilder senderAddressB, AddressBuilder destinataryAddressB, DateBuilder dateB) {
		PersonalLetter letter = null;
		Person sender = senderB.language(language).build();
		Person destinatary = destinataryB.language(language).build();
		Address senderAddress = senderAddressB.language(language).build();
		Address destinataryAddress = destinataryAddressB.language(language).build();
		Date date = dateB.language(language).build();
		
		switch(language) {
			case PTBR:
				letter = new PersonalLetterPTBR(sender, destinatary, senderAddress, destinataryAddress, date);
				break;
			case ENUS:
				letter = new PersonalLetterENUS(sender, destinatary, senderAddress, destinataryAddress, date);
				break;
		}
		return letter;
	}
	
	protected String buildHeader() {
		return _date.toPrint() + "\n\n" + _sender.getName()+ "\n" +
				_senderAddress.toPrint() + "\n" + _destinatary.getName() +
				"\n" + _destinataryAddress.toPrint() + "\n\n";
	}
	
	protected String buildBody() {
		return this.getCompliments();
	}
	
	protected String buildConclusion() {
		return this.getBye();
	}
	
	protected String buildSignature() {
		return "\n\n                    ---------\n"
				+ _sender.getFirstName();
	}
	
	public String model() {
		return buildHeader() + buildBody() + buildConclusion() + buildSignature();
	}
	
	protected abstract String getCompliments();
	protected abstract String getBye();
}
