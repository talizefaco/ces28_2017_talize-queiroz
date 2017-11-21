package imposto;

import java.util.List;

import nota_fiscal.ItemDeVenda;
import produtoservico.ProdutoServico;

public class ImpostoCidade extends Imposto {

	public ImpostoCidade() {
		super("Imposto Cidade", IDataCidade.getInstance());
	}

	@Override
	public float getImposto(List<ItemDeVenda> itens, ItemDeVenda item) {
		total = 0;
		float resultado;
		ProdutoServico ps = item.getProdutoServico();
		ps.accept(this);
		
		
		if(itens.indexOf(item) != 0 && itens.get(itens.indexOf(item) - 1).getProdutoServico().getCategoriaTributaria() == CategoriaTributaria.COMIDA) {
			resultado =  total * item.getQuantidade() *  0.5f;
		}
		else {
			resultado = total * item.getQuantidade();
		}
		idata.update(resultado);
		return resultado;
		
	}

	@Override
	protected void roupavisit(ProdutoServico ps) {
		total += bd.getAliquota(ps) * ps.getPreco();
	}

	@Override
	protected void comidavisit(ProdutoServico ps) {
		total += bd.getAliquota(ps) * ps.getPreco();
	}

	@Override
	protected void eletrovisit(ProdutoServico ps) {
		total += bd.getAliquota(ps) * ps.getPreco();
	}

}
