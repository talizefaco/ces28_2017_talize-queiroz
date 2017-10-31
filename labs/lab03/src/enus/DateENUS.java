package enus;

import lab3.Date;

public class DateENUS extends Date{

	public DateENUS(int day, int month, int year) {
		super(day,month,year);
	}

	@Override
	public String toPrint() {
		return this.month + "/" + this.day + "/" + this.year;
	}

}
