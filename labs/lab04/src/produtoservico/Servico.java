package produtoservico;

import imposto.CategoriaTributaria;
import nota_fiscal.ItemDeVenda;

public class Servico extends ProdutoServico {
	private final String _natureza;
	
	public Servico(String nome, float preco, CategoriaTributaria categTrib, String natureza) {
		super(nome,preco,categTrib);
		this._natureza = natureza;
		
	}
}
