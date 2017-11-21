package nota_fiscal;

import java.util.List;

import imposto.Imposto;
import produtoservico.ProdutoServico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * Private Class Data
 */
public class NFFinal implements NotaFiscal{
	private final List<ItemDeVenda> _listaItemDeVenda; // Final deixa o objeto imutável
	private final int _ID; // Final deixa o objeto imutável
	private final float _valor;
	private final Object outros;
	private final HashMap<Imposto, Float> _mapaImposto;
	
	protected NFFinal(List<ItemDeVenda> lista, int ID, float valor, Object outros, HashMap<Imposto, Float> mapaImposto) {
		this._listaItemDeVenda = lista;
		this._ID = ID;
		this._valor = valor;
		this.outros = outros;
		this._mapaImposto = mapaImposto;
	}
	
	public List<ItemDeVenda> getListaItemDeVenda() {
		return Collections.unmodifiableList((new ArrayList<ItemDeVenda>(_listaItemDeVenda)));
																// A lista não pode ser modificada,
																// pois é unmodifiableList. Além disso,
																// os objetos nao podem ser alterados, pois
																// os atributos de ItemDeVenda sao 'final'
	}
	
	public float getValor() {
		return this._valor;
	}
	
	public int getID() {
		return this._ID;
	}
	
	public Object getOutros() {
		return this.outros;
	}
	
	public void print() {
		System.out.println("Nota Fiscal ID: " + Integer.toString(_ID));
		System.out.println("Valor Total: " + Float.toString(this._valor));
		for (Object i : this._mapaImposto.keySet().toArray()) {
			System.out.println("Valor " + ((Imposto) i).getNome() + ": " + _mapaImposto.get(i));
		}
		for(ItemDeVenda item : this._listaItemDeVenda) {
			System.out.println("Item de Venda"
					+ "\nQuantidade: " + item.getQuantidade() + "\nValor: " + 
					item.getValor() +  "\nProdutos e Servicos: ");
					item.getProdutoServico().accept(this);
		}
	}
	
	public static class NFFinalBuilder {
		private List<ItemDeVenda> _listaItemDeVenda; // Final deixa o objeto imutável
		private int _ID; // Final deixa o objeto imutável
		private float _valor;
		private Object outros;
		private HashMap<Imposto, Float> _mapaImposto;
		
		public NFFinalBuilder(List<ItemDeVenda> lista, int id) {
			this._ID = id;
			this._listaItemDeVenda = lista;
			this._valor = -1;
			this.outros = null;
			this._mapaImposto = null;
		}
		
		public NFFinalBuilder setValor(float valor) {
			this._valor = valor;
			return this;
		}
		
		public NFFinalBuilder setOutros(Object outros) {
			this.outros = outros;
			return this;
		}
		
		public NFFinalBuilder setMapaImposto(HashMap<Imposto, Float> mapa) {
			this._mapaImposto = mapa;
			return this;
		}
		
		public NFFinal build() {
			return new NFFinal(this._listaItemDeVenda, this._ID, this._valor, this.outros, this._mapaImposto);
		}
	}

	public void visit(ProdutoServico ps) {
		System.out.println("  -" + ps.getNome());
	}
}
