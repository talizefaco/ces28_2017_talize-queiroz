package Q1.pubV2;

import java.util.LinkedHashMap;

public class Pub {


    private static final String ONE_BEER = "hansa";
    private static final String ONE_CIDER = "grans";
    private static final String A_PROPER_CIDER = "strongbow";
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";
  //Caso queira adicionar mais drinks, adicionar aqui a variável para substituir a string desejada

    public int computeCost(String drink, boolean student, int amount) {
    	Drinks drinks = new Drinks();
    	if(drinks.getDrinks().containsValue(drink)) {
    	
    		if (amount > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
    			throw new RuntimeException("Too many drinks, max 2.");
    		}
    		int price;
    		price = drinks.getDrinks().get(drink);
    		if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
    			price = price - price/10;
    		}
    		return price*amount;
    	}
    	else {
    		throw new RuntimeException("No such drink exists");
    	}

    }
}

