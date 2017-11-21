package imposto;

import java.util.List;

import bd.FacadeBDImposto;
import nota_fiscal.ItemDeVenda;
import produtoservico.ProdutoServico;

public abstract class Imposto {
	protected final FacadeBDImposto bd;
	protected final String _nome;
	protected float total;
	protected IData idata;
	
	protected Imposto(String nome, IData idata) {
		this._nome = nome;
		bd = FacadeBDImposto.getInstance();
		this.idata = idata;
	}
	
	public abstract float getImposto(List<ItemDeVenda> itens, ItemDeVenda item);

	public void visit(ProdutoServico ps) {
		
		switch(ps.getCategoriaTributaria()) {
			case ELETRO:
				this.eletrovisit(ps);
				break;
			case COMIDA:
				this.comidavisit(ps);
				break;
			case ROUPA:
				this.roupavisit(ps);
				break;
		}
	}
	
	public String getNome() {
		return this._nome;
	}
	
	protected abstract void roupavisit(ProdutoServico ps);

	protected abstract void comidavisit(ProdutoServico ps);

	protected abstract void eletrovisit(ProdutoServico ps);
}
