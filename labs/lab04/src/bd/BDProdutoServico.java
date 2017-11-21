package bd;

import produtoservico.ProdutoServico;

public abstract class BDProdutoServico {
	private static BDProdutoServico _SingletonBDProdutoServico;
	private static boolean _instanceFlag = false;
	
	private BDProdutoServico() {
 
	}
	
	public static BDProdutoServico getInstance() {
		if(_SingletonBDProdutoServico == null) {
			_instanceFlag = true;
		}
		return _SingletonBDProdutoServico;
	}
	
	public abstract ProdutoServico createPS(String nome);
	
	public abstract String existeNoBD(String nome);
	
	public abstract String categoriaTributaria(String nome);
}
