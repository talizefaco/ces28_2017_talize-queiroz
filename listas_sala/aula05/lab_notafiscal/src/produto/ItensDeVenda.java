package produto;
public class ItensDeVenda {
	private int _quantidade;
	private float _desconto;
	private Item _item;
	
	public ItensDeVenda(Item item, int quantidade, float desconto) {
		_item = item;
		_quantidade = quantidade;
		_desconto = desconto;
	}
	
	public Item getItem() {
		return _item;
	}
	
	public int getQuantidade() {
		return _quantidade;
	}
	
	public float getDesconto() {
		return _desconto;
	}
	
	public float getPreco() {
		return _item.getPreco();
	}
	
	public void adicionar(int quantidade) {
		_quantidade += quantidade;
	}
	
	public boolean equals(Object anObject) {
		if (!(anObject instanceof ItensDeVenda))
			return false;
		ItensDeVenda outroItem = (ItensDeVenda) anObject;
		
		return _item.equals(outroItem.getItem());
	}
}