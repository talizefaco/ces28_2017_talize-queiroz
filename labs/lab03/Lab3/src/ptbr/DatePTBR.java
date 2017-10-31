package ptbr;

import lab3.Date;

public class DatePTBR extends Date {

	public DatePTBR(int day, int month, int year) {
		super(day,month,year);
	}

	@Override
	public String toPrint() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
