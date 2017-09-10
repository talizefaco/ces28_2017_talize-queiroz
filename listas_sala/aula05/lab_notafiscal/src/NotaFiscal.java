import java.util.ArrayList;

import produto.BDProduto;
import produto.Item;
import produto.ItensDeVenda;
import cliente.Cliente;

class excecao extends Exception {
	   public excecao(String msg){
	      super(msg);
   }
}

public class NotaFiscal {
	private int _numero;
	private float _valor;
	private Cliente _cliente;
	
	private ArrayList<ItensDeVenda> _lista;
	
	public NotaFiscal(ArrayList<ItensDeVenda> lista, Cliente cliente) throws excecao{
		if(lista.size()==0)
			throw new excecao("Nota Fiscal não pode conter lista vazia.");
		else {
			_lista =  lista;
			_cliente = cliente;
			
			this.calculaPreco();
		}
	}
	
	public void deletaItem(ItensDeVenda item) throws excecao{
		for( ItensDeVenda noh : _lista )
		{
		      if(noh.equals(item)) {
		    	  if (_lista.size() > 1) {
		    		  _lista.remove(_lista.indexOf(noh));
			    	  this.calculaPreco();
		    	  }
		    	  else {
		    		  throw new excecao("Nota fiscal não pode ficar vazia.");
		    	  }
		      }
		}
		this.calculaPreco();
	}
	
	public void adicionaItem(ItensDeVenda item, BDProduto bancoDados) throws excecao {
		boolean achou = false;
		if (!bancoDados.existeProduto(item.getItem())) {
			throw new excecao("Produto não cadastrado no banco de dados.");
		}
		else {
			for( ItensDeVenda noh : _lista )
			{
			      if(noh.equals(item)) {
			    	  noh.adicionar(item.getQuantidade());
			    	  achou = true;
			      }		    	  
			}
			if(!achou) {
				_lista.add(item);
			}
			this.calculaPreco();
		}
		
	}
	
	private void calculaPreco() {
		_valor = 0;
		for( ItensDeVenda item : _lista )
		{
		      _valor += item.getPreco() * item.getQuantidade() * (1 - item.getDesconto());
		}
		
	}
	
	public int getTamanho() {
		return _lista.size();
	}
	
	public float getValor() {
		return _valor;
	}
	
	public boolean contem(ItensDeVenda item) {
		for( ItensDeVenda noh : _lista )
		{
		      if(noh.equals(item)) {
		    	  return true;
		      }		    	  
		}
		return false;
	}
}