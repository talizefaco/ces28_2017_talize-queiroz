package Q1.pubV1;

public class Drink {
	
	private static final String ONE_BEER = "hansa";
    private static final String ONE_CIDER = "grans";
    private static final String A_PROPER_CIDER = "strongbow";
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";
	
    private String _drink;
	private int _value;
	
	public Drink(String drink) {
		this._drink=drink;
		if (drink.equals(ONE_BEER)) {
			this._value = 74;
		}
		
		else if (drink.equals(ONE_CIDER)) {
			this._value = 103;
		}
		
		else if (drink.equals(A_PROPER_CIDER)) {
			this._value = 110;
		}
		
		else if (drink.equals(GT)) {
			this._value = (85+20+10); //ingredient6() + ingredient5() + ingredient5()
		}
		
		else if (drink.equals(BACARDI_SPECIAL)) {
			this._value = (85+65+10+10); //ingredient6() + ingredient1() + ingredient2() + ingredient3()
		}
		
		else {
			throw new RuntimeException("No such drink exists");
		}
		
	}
	
	public String getDrink() {
		return this._drink;
	}
	
	public int getValue() {
		return this._value;
	}
	
	
	public void setDrink(String drink){
		this._drink = drink;
	}
	public void setValue(int value){
		this._value = value;
	}
	
	

}
