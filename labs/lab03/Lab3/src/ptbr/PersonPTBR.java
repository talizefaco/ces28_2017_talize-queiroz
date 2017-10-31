package ptbr;

import lab3.Person;

public class PersonPTBR extends Person {

	public PersonPTBR(PersonBuilder personBuilder) {
		super(personBuilder);
	}
	
	@Override
	public String getName() {
		return "Sr(a) " + name.getName();
	}
}
