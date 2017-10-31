package ptbr;

import lab3.Address;

public class AddressPTBR extends Address {

	public AddressPTBR (AddressBuilder addressBuilder) {
		super(addressBuilder);
	}

	@Override
	public String toPrint() {
		return "Rua " + street + " " +  number + ", " + zipcode + ", " + city + ", " + state + ", " + country;
	}

}