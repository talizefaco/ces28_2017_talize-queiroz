package produtoservico;

import imposto.CategoriaTributaria;
import nota_fiscal.ItemDeVenda;

public class Produto extends ProdutoServico {
	private final String _info;
	
	public Produto(String nome, float preco, CategoriaTributaria categTrib, String info) {
		super(nome,preco,categTrib);
		this._info = info;
		
	}
}
