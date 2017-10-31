package enus;

import lab3.Address;

public class AddressENUS extends Address {

	public AddressENUS (AddressBuilder addressBuilder) {
		super(addressBuilder);
	}
	
	@Override
	public String toPrint() {
		return number + " St " + street + ", " + zipcode + ", " + city + ", " + state + ", " + country;
	}

}