package nota_fiscal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFNaoFinalizada implements NotaFiscal {
	private List<ItemDeVenda> _listaItemDeVenda; // Array com todos os itens de venda
	private Object outros;
	
	public NFNaoFinalizada(NFBuilder builder) {
		this._listaItemDeVenda = builder._lista;
		this.outros = builder.outros;
	}
	
	// Permite adicionar novos items Ã  nota fiscal
	public void addItemDeVenda (int quant, String nomePS) {
		this._listaItemDeVenda.add(new ItemDeVenda(nomePS, quant));
	}
	
	public Object getOutros() {
		return this.outros;
	}
	
	// Permite retirar items da nota fiscal
	public void deleteItemDeVenda (String nomePS) {
		ItemDeVenda item_aux = null;
		for(ItemDeVenda item : _listaItemDeVenda) {
			if(item.getProdutoServico().getNome() == nomePS) {
				item_aux = item;
			}
		}
		try {
			if(item_aux != null) {
				if (_listaItemDeVenda.size() > 1) {
					this._listaItemDeVenda.remove(item_aux);
				} else {
					throw new Exception("Não é possível existir uma NF vazia.");
				}
			}
			else {
				throw new Exception("Não existe item com esse nome.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ItemDeVenda> getListaItemDeVenda() {
		return Collections.unmodifiableList((new ArrayList<ItemDeVenda>(_listaItemDeVenda)));
	}
	
	public static class NFBuilder {
		private Object outros;
		private List<ItemDeVenda> _lista;
		public NFBuilder() {
			this._lista = new ArrayList<ItemDeVenda>();
			this.outros = null;
		}
		
		public NFBuilder adicionarItem(int quant, String nomePS) {
			this._lista.add(new ItemDeVenda(nomePS, quant));
			return this;
		}
		
		public NFBuilder addOutros(Object outros) {
			this.outros = outros;
			return this;
		}
		
		public NFNaoFinalizada build() {
			try {
				if (_lista.isEmpty()) {
					throw new Exception("Não é possível criar uma NF vazia.");
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
			return new NFNaoFinalizada(this);
		}
	}
}