package lab3;

import enus.CommercialLetterENUS;
import lab3.Address.AddressBuilder;
import lab3.Date.DateBuilder;
import lab3.Person.PersonBuilder;
import ptbr.CommercialLetterPTBR;

public abstract class CommercialLetter {
	protected Person _sender;
	protected Person _destinatary;
	protected Address _senderAddress;
	protected Address _destinataryAddress;
	protected Date _date;
	protected Languages _language;
	
	protected CommercialLetter (Languages language, Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date) {
		_sender = sender;
		_destinatary = destinatary;
		_senderAddress = senderAddress;
		_destinataryAddress = destinataryAddress;
		_date = date;
		_language = language;
	}
	
	public static CommercialLetter getLetter(Languages language, PersonBuilder senderB, PersonBuilder destinataryB,
			AddressBuilder senderAddressB, AddressBuilder destinataryAddressB, DateBuilder dateB) {
		CommercialLetter letter = null;
		Person sender = senderB.language(language).build();
		Person destinatary = destinataryB.language(language).build();
		Address senderAddress = senderAddressB.language(language).build();
		Address destinataryAddress = destinataryAddressB.language(language).build();
		Date date = dateB.language(language).build();
		
		switch(language) {
			case PTBR:
				letter = new CommercialLetterPTBR(sender, destinatary, senderAddress, destinataryAddress, date);
				break;
			case ENUS:
				letter = new CommercialLetterENUS(sender, destinatary, senderAddress, destinataryAddress, date);
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
		return this.getDear() + _destinatary.getFirstName() + "\n";
	}
	
	protected String buildConclusion() {
		return "\n" + this.getSincerely() + ",";
	}
	
	protected String buildSignature() {
		return "\n\n                    ---------\n"
				+ _sender.getFirstName() + "\n            " + _sender.getPhone() +
				"\n            email:" + _sender.getEmail();
	}
	
	public String model() {
		return buildHeader() + buildBody() + buildConclusion() + buildSignature();
	}
	
	protected abstract String getDear();
	protected abstract String getSincerely();
}
