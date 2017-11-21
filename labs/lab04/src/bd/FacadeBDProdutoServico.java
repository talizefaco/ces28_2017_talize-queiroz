package bd;

import produtoservico.ProdutoServico;

/*
 * Facade para o BD de Produto/Servico.
 * Cliente não acessa o BD diretamente, apenas o Facade.
 * É Singleton
 */
public class FacadeBDProdutoServico {
	private static FacadeBDProdutoServico _FacadeBDProdutoServico = null;
	private static boolean _instanceFlag = false;
	private static BDProdutoServico _bd;
	
	private FacadeBDProdutoServico() {
		_bd = BDProdutoServico.getInstance();
	}
	
	public static FacadeBDProdutoServico getInstance() {
		if(!_instanceFlag) {
			_FacadeBDProdutoServico = new FacadeBDProdutoServico();
			_instanceFlag = true;
		}
		return _FacadeBDProdutoServico;
	}
	
	private FacadeBDProdutoServico(BDProdutoServico bd) {
		_bd = bd;
	}
	
	public static FacadeBDProdutoServico getInstance(BDProdutoServico bd) {
		if(!_instanceFlag) {
			_FacadeBDProdutoServico = new FacadeBDProdutoServico(bd);
			_instanceFlag = true;
		}
		return _FacadeBDProdutoServico;
	}
	
	public ProdutoServico getPS(String nomePS) {
		return _bd.createPS(nomePS);
	}
}
