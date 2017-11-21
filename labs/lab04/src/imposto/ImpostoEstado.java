package imposto;

import java.util.List;

import nota_fiscal.ItemDeVenda;
import produtoservico.ProdutoServico;

public class ImpostoEstado extends Imposto {

	public ImpostoEstado() {
		super("Imposto Estado", IDataEstado.getInstance());
	}

	@Override
	public float getImposto(List<ItemDeVenda> itens, ItemDeVenda item) {
		total = 0;
		float resultado = 0;
		ProdutoServico ps = item.getProdutoServico();
		ps.accept(this);
		
		if(idata.getValor() > 180.0f)
			total += 10;
		resultado = total * item.getQuantidade();
		idata.update(resultado);
		return total * item.getQuantidade();
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
