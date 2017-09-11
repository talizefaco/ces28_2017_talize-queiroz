package Q1.pubV2;

import java.util.LinkedHashMap;
public class Ingredients {
	
	private LinkedHashMap<String, Integer> _ingredients;
	
	
	public Ingredients() {
		_ingredients = new LinkedHashMap<String, Integer>();
		_ingredients.put("rum", 65);
		_ingredients.put("grenadine", 10);
		_ingredients.put("lime juice", 10);
		_ingredients.put("green stuff", 10);
		_ingredients.put("tonic water", 20);
		_ingredients.put("gin", 85);
// Caso queira adicionar mais ingredientes com seus respectivos valores o desenvolvedor basta adicioná-lo nesse HashMap com o comando _ingredients.put(...).
// Caso queira remover algum ingrediente, basta removê-lo do HashMap com o comando 	_ingredients.remove(...).
	}

	public LinkedHashMap<String, Integer> getIngredients() {
		return this._ingredients;
	}
	

}
