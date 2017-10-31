package lab3;

import enus.DateENUS;
import ptbr.DatePTBR;

public abstract class Date {
	protected String day;
	protected String month;
	protected String year;
	
	protected Date(int day, int month, int year) {
		this.day = Integer.toString(day);
		this.month = Integer.toString(month);
		this.year = Integer.toString(year);
	}
	
	public static class DateBuilder {
		private int day;
		private int month;
		private int year;
		private Languages language;
		
		public DateBuilder(int day, int month, int year) { 
			this.day = day;
			this.month = month;
			this.year = year;
			this.language = Languages.ENUS; //default
		}
		
		public DateBuilder language(Languages language) {
			this.language = language;
			return this;
		}
		
		public Date build() {
			switch (language){
				case PTBR:
					return new DatePTBR(day, month, year);
				case ENUS:
					return new DateENUS(day, month, year);
				default:
					return null;
				
			}
		}
	}
	
	public static Date dateBuilder(Languages language, int day, int month, int year) {
		switch (language){
			case PTBR:
				return new DatePTBR(day, month, year);
			case ENUS:
				return new DateENUS(day, month, year);
			default:
				return null;
			
		}
	}

	public abstract String toPrint();
}
