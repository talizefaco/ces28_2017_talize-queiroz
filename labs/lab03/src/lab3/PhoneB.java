package lab3;

public class PhoneB extends Phone {

	public PhoneB(String number) {
		super(number);
	}

	@Override
	public String getPhone() {
		return this.phone.replace('-', ' ');
	}

}
