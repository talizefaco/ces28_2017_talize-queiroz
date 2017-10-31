package lab3;

public abstract class Name {
	protected String firstName;
	protected String lastName;
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public abstract String getName();
	public abstract String getFirstName();

}
