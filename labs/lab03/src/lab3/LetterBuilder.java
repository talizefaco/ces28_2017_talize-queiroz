package lab3;

public abstract class LetterBuilder {
	protected Person _sender;
	protected Person _destinatary;
	protected Address _senderAddress;
	protected Address _destinataryAddress;
	protected Date _date;
	
	public LetterBuilder(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress, Date date) {
		_sender = sender;
		_destinatary = destinatary;
		_senderAddress = senderAddress;
		_destinataryAddress = destinataryAddress;
		_date = date;
	}

	public String model() {
		return buildHeader() + buildBody() + buildConclusion() + buildSignature();
	}
	
	protected abstract String buildHeader();
	protected abstract String buildBody();
	protected abstract String buildConclusion();
	protected abstract String buildSignature();
}
