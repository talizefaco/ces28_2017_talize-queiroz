package model;


public class UTMCTR {
	
	private static UTMCTR _UTMCTR = null;
	private String _mapa;
	
	//Aplicando Singleton:	
	private UTMCTR() {	
	}

	public static UTMCTR getUTMCTR() {
		if (_UTMCTR == null) {
			_UTMCTR = new UTMCTR();
		}
		return _UTMCTR;       
	}

	
	
	public String SAinfo(IARP arp) {
		// Alguma logica de implementacao de Mapa
		_mapa = "Mapa com a posicao: \n" + arp.selfstatus();
		return _mapa;
	}
	

}
