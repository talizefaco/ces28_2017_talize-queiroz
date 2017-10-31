package lab3;

import enus.AddressENUS;
import ptbr.AddressPTBR;

public abstract class Address {
	protected String street;
	protected String zipcode;
	protected String city;
	protected String state;
	protected String country;
	protected String number;
	protected Languages language;
	
	protected Address(AddressBuilder addressBuilder) {
		this.street = addressBuilder.street;
		this.zipcode = addressBuilder.zipcode;
		this.city = addressBuilder.city;
		this.state = addressBuilder.state;
		this.country = addressBuilder.country;
		this.number = addressBuilder.number;
		this.language = addressBuilder.language;
	}
	
	public static class AddressBuilder {
		private String street;
		private String zipcode;
		private String city;
		private String state;
		private String country;
		private String number;
		private Languages language;
		
		public AddressBuilder (String street, String number, String zipcode) {
			this.street = street;
			this.zipcode = zipcode;
			this.number = number;
			this.city = new String();
			this.state = new String();
			this.country = new String();
			this.language = Languages.ENUS; // default
		}
		
		public AddressBuilder language(Languages language) {
			this.language = language;
			return this;
		}
		
		public AddressBuilder city(String city) {
			this.city = city;
			return this;
		}
		
		public AddressBuilder state(String state) {
			this.state = state;
			return this;
		}
		
		public AddressBuilder country(String country) {
			this.country= country;
			return this;
		}
		
		public Address build() {
			switch (this.language) {
				case PTBR:
					return new AddressPTBR(this);
				case ENUS:
					return new AddressENUS(this);
				default:
					return null;
			}
		}
	}
	
	public abstract String toPrint();

}
