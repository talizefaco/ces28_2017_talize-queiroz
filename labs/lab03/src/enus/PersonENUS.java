package enus;

import lab3.Person;

public class PersonENUS extends Person {

	public PersonENUS(PersonBuilder personBuilder) {
		super(personBuilder);
	}

	@Override
	public String getName() {
		return "Mr(s) " + name.getName();
	}
}
