package produto;

public class Item {
	private String _nome;
	private float _preco;

	
	public boolean equals(Object anObject) {
		if (!(anObject instanceof Item))
			return false;
		Item outroItem = (Item) anObject;
		
		return _nome.equals(outroItem.getNome());
	}
	
	public String getNome() {
		return _nome;
	}
	
	public float getPreco() {
		return _preco;
	}
	
	
}
