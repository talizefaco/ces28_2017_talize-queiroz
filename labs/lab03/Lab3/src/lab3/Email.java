package lab3;

public abstract class Email {
	protected String email;
	
	public Email(String email) {
		this.email = email;
	}

	public abstract String getEmail();
}
