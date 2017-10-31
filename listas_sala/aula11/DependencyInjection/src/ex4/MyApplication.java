package ex4;

public class MyApplication {
	
	public MyApplication(EmailService email) {
		this._email = email;
	}
	
	public void processMessages(String message, String receiver) {
		// Do some msg validation, manipulation logic etc.
		this._email.sendEmail(message, receiver);
	}
	private EmailService _email = null;
}

