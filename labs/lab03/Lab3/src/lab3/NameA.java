package lab3;

public class NameA extends Name {
	public NameA(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

}
