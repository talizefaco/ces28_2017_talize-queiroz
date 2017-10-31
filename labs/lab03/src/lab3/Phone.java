package lab3;

public abstract class Phone {
	protected String phone;
	
	public Phone(String phone) {
		this.phone = phone;
	}

	public abstract String getPhone();
}
