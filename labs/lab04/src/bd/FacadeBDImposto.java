package bd;

import java.util.List;

import imposto.CategoriaTributaria;
import imposto.Imposto;
import produtoservico.ProdutoServico;

/*
 * Facade para o BD dos Impostos.
 * Cliente não acessa o BD diretamente, apenas o Facade.
 * É Singleton
 */
public class FacadeBDImposto {
	private static FacadeBDImposto _facadeBDImposto = null;
	private static boolean _instanceFlag = false;
	private static BDImposto _bd;
	
	private FacadeBDImposto() {
		_bd = BDImposto.getInstance();
	}
	
	private FacadeBDImposto(BDImposto bd) {
		_bd = bd;
	}
	
	public static FacadeBDImposto getInstance() {
		if(!_instanceFlag) {
			_facadeBDImposto = new FacadeBDImposto();
			_instanceFlag = true;
		}
		return _facadeBDImposto;
	}

	public static FacadeBDImposto getInstance(BDImposto bd) {
		if(!_instanceFlag) {
			_facadeBDImposto = new FacadeBDImposto(bd);
			_instanceFlag = true;
		}
		return _facadeBDImposto;
	}
	
	public List<Imposto> getImposto(CategoriaTributaria categoriaTributaria) {
		return _bd.getImposto(categoriaTributaria);
	}
	
	public float getAliquota(ProdutoServico ps) {
		return _bd.getAliquota(ps);
	}
}
