package bd;

import nota_fiscal.NFNaoFinalizada;

/*
 * Facade para o BD dos Impostos.
 * Cliente não acessa o BD diretamente, apenas o Facade.
 * É Singleton
 */
public class FacadeBDNotaFiscal {
	private static FacadeBDNotaFiscal _FacadeBDNotaFiscal = null;
	private static boolean _instanceFlag = false;
	private static BDNotaFiscal _bancodedados = null;
	
	private FacadeBDNotaFiscal() {
		this._bancodedados = BDNotaFiscal.getInstance();
	}
	
	public static FacadeBDNotaFiscal getInstance() {
		if(!_instanceFlag) {
			_FacadeBDNotaFiscal = new FacadeBDNotaFiscal();
			_instanceFlag = true;
		}
		return _FacadeBDNotaFiscal;
	}
	
	private FacadeBDNotaFiscal(BDNotaFiscal bd) {
		this._bancodedados = bd;
	}
	
	public static FacadeBDNotaFiscal getInstance(BDNotaFiscal bd) {
		if(!_instanceFlag) {
			_FacadeBDNotaFiscal = new FacadeBDNotaFiscal(bd);
			_instanceFlag = true;
		}
		return _FacadeBDNotaFiscal;
	}
	
	public int gerarProxID() {
		return _bancodedados.gerarProxID();
	}

	public boolean validar(NFNaoFinalizada notafiscal) {
		return _bancodedados.validar(notafiscal);
	}
}