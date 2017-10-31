package Mercado;

import Infraestrutura.IBancoDados;
import Infraestrutura.IMercado;

public class MercadoFacade implements IMercado {
	private static MercadoFacade    _theFacade = null;
	
	private Mercado mercado_;
	private MercadoFacade() {
		// 
		mercado_ = new Mercado();
	}
	
	public static MercadoFacade    getMercado() {
		if (_theFacade == null) {
			_theFacade = new MercadoFacade();
		}
	        	return _theFacade;       
	   	 }
	
	public void registraComprador(String name, int id) {
			mercado_.registraNovoCliente(name, id);
		}
		// realizar uma compra
	public void compra(int cliId, int prodId) {
		mercado_.adicionaProduto(cliId, prodId);
	}
		// fechar compra
	public void fecharCompra(int cliId) {
		mercado_.processarPagamento(cliId);
	}

	@Override
	public int registraNovoCliente(String nome, int id) {
		mercado_.registraNovoCliente(nome, id);
		return id;
	}

	@Override
	public void adicionaProduto(int idCliente, int idProduto) {
		mercado_.adicionaProduto(idCliente, idProduto);
	}

	@Override
	public void processarPagamento(int idCliente) {
		mercado_.processarPagamento(idCliente);
	}

	@Override
	public IBancoDados setIBanco(String nomebanco) {
		return mercado_.setIBanco(nomebanco);
	}
		
}//MercadoFacade

