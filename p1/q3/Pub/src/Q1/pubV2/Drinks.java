package Q1.pubV2;
import java.util.LinkedHashMap;

public class Drinks {
	
	private static final String ONE_BEER = "hansa";
    private static final String ONE_CIDER = "grans";
    private static final String A_PROPER_CIDER = "strongbow";
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";
    //Caso queira adicionar mais drinks, adicionar aqui a variável para substituir a string desejada
	
	private LinkedHashMap<String, Integer> _drinks;
	
	
	public Drinks() {
		Ingredients ingredients = new Ingredients();
		_drinks = new LinkedHashMap<String, Integer>();
		_drinks.put(ONE_BEER, 74);
		_drinks.put(ONE_CIDER, 103);
		_drinks.put(A_PROPER_CIDER,  110);
		_drinks.put(GT, ingredients.getIngredients().get("gin")+ingredients.getIngredients().get("tonic water")+ingredients.getIngredients().get("green stuff"));
		_drinks.put(BACARDI_SPECIAL, ingredients.getIngredients().get("gin")+ingredients.getIngredients().get("rum")+ingredients.getIngredients().get("grenadine")+ingredients.getIngredients().get("lime juice"));
		// Caso queira adicionar mais drinks com seus respectivos valores o desenvolvedor basta adicioná-lo nesse HashMap com o comando _drinks.put(...),
		// O valor também pode ser somado pelos valores dos ingredientes, acessando o HashMap por ingredients.getIngredients().
		// Caso queira remover algum drink, basta removê-lo do HashMap com o comando 	_drinks.remove(...)
	}

	public LinkedHashMap<String, Integer> getDrinks() {
		return this._drinks;
	}
	


}
