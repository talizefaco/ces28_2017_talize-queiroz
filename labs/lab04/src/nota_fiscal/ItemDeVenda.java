package nota_fiscal;

import bd.FacadeBDProdutoServico;
import produtoservico.ProdutoServico;

public class ItemDeVenda {
	private final ProdutoServico _produtoServico; // Final deixa o objeto imutável
	private final int _quantidade; // Final deixa o objeto imutável
	private float valor;
	protected ItemDeVenda(String nomePS, int quantidade) {
		this._produtoServico = FacadeBDProdutoServico.getInstance().getPS(nomePS);
		this._quantidade = quantidade;
	}
	
	public ProdutoServico getProdutoServico() {
		return _produtoServico;
	}
	
	public int getQuantidade() {
		return this._quantidade;
	}
	
	protected void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValor() {
		return this.valor;
	}
}
