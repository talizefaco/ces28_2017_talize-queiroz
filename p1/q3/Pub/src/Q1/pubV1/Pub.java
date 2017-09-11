package Q1.pubV1;


public class Pub {


    private static final String ONE_BEER = "hansa";
    private static final String ONE_CIDER = "grans";
    private static final String A_PROPER_CIDER = "strongbow";
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";

    public int computeCost(String drink, boolean student, int amount) {
    	Drink dr = new Drink(drink);
    	
        if (amount > 2 && (dr.getDrink() == GT || dr.getDrink() == BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        price = dr.getValue();
        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price = price - price/10;
        }
        return price*amount;
    }

    //one unit of rum
    private int ingredient1() {
        return 65;
    }

    //one unit of grenadine
    private int ingredient2() {
        return 10;
    }

    //one unit of lime juice
    private int ingredient3() {
        return 10;
    }

    //one unit of green stuff
    private int ingredient4() {
        return 10;
    }

    //one unit of tonic water
    private int ingredient5() {
        return 20;
    }

    //one unit of gin
    private int ingredient6() {
        return 85;
    }
}
