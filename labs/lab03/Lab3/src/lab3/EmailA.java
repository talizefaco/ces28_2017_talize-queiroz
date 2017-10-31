package lab3;

public class EmailA extends Email {

	public EmailA(String email) {
		super(email);
	}

	@Override
	public String getEmail() {
		return this.email;
	}

}
