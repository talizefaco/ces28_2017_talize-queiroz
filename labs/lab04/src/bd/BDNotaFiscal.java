package bd;

import java.util.List;
import nota_fiscal.NFFinal;
import nota_fiscal.NFNaoFinalizada;

public abstract class BDNotaFiscal {
	private static BDNotaFiscal _bd;
	
	public BDNotaFiscal() {
		
	}
	
	public static BDNotaFiscal getInstance() {
		if(_bd == null) {
			
		}
		return _bd;
	}
	
	public abstract int gerarProxID();
	
	protected abstract void submeterPrefeitura();

	public abstract boolean validar(NFNaoFinalizada notafiscal);
}
