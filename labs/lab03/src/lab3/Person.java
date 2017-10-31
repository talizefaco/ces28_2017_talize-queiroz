package lab3;

import enus.PersonENUS;
import ptbr.PersonPTBR;

public abstract class Person {
	protected Name name;
	protected Phone phone;
	protected Email email;
	
	protected Person(PersonBuilder builder) {
		this.name = builder.name;
		this.phone = builder.phone;
		this.email = builder.email;
	}
	
	public static class PersonBuilder {
		private String firstName;
		private String lastName;
		private Name name;
		private Email email;
		private String phoneNumber;
		private Phone phone;
		private String emailStr;
		private Languages language;
		private PhoneFormat phoneFormat;
		private NameFormat nameFormat;
		private EmailFormat emailFormat;
		
		public PersonBuilder (String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			language = Languages.ENUS;
			phoneFormat = PhoneFormat.A;
			nameFormat = NameFormat.A;
			emailFormat = EmailFormat.A;
		}
		
		public PersonBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public PersonBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public PersonBuilder phone(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public PersonBuilder email(String email) {
			this.emailStr = email;
			return this;
		}
		
		public PersonBuilder language(Languages language) {
			this.language = language;
			return this;
		}
		
		public PersonBuilder phoneFormat(PhoneFormat format) {
			this.phoneFormat = format;
			return this;
		}
		
		private void buildPhone() {
			switch (this.phoneFormat) {
				case A:
					this.phone = new PhoneA(phoneNumber);
					break;
				case B:
					this.phone = new PhoneB(phoneNumber);
					break;
			}
		}
		
		public PersonBuilder nameFormat(NameFormat nameFormat) {
			this.nameFormat = nameFormat;
			return this;
		}
		
		private void buildName() {
			switch (this.nameFormat) {
				case A:
					this.name = new NameA(this.firstName, this.lastName);
					break;
			}
		}
		
		public PersonBuilder emailFormat(EmailFormat emailFormat) {
			this.emailFormat = emailFormat;
			return this;
		}
		
		private void buildEmail() {
			switch (this.emailFormat) {
				case A:
					this.email = new EmailA(this.emailStr);
					break;
			}
		}
		
		public Person build() {
			this.buildPhone();
			this.buildName();
			this.buildEmail();
			
			switch (this.language) {
				case PTBR:
					return new PersonPTBR(this);
				case ENUS:
					return new PersonENUS(this);
				default:
					return null;
			}	
		}
	}
	
	public String getFirstName() {
		return name.getFirstName();
	}
	
	public abstract String getName();

	public String getPhone() {
		return phone.getPhone();
	}

	public String getEmail() {
		return email.getEmail();
	}
}
