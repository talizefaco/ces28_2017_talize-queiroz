package bd;

import java.util.List;

import imposto.CategoriaTributaria;
import imposto.Imposto;
import produtoservico.ProdutoServico;

public abstract class BDImposto {
	
	private static BDImposto _singletonBDImposto;
	private static boolean _instanceFlag = false;
	
	private BDImposto() {}
	
	public static BDImposto getInstance() {
		if(_singletonBDImposto == null) {
			

		}
		return _singletonBDImposto;
	}
	
	public abstract List<Imposto> getImposto(CategoriaTributaria categoriaTributaria);
	
	public abstract float getAliquota(ProdutoServico PS);
}
