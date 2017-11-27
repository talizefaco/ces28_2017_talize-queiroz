package presenter;

import java.util.Observable;
import model.*;

// FUNCIONA COMO A CLOUD
public class Presenter extends Observable {

    private IARP _arp;
    private UTMCTR _ctr;
    private boolean valido;
    private boolean _flagGetMapa = false;
    private String mapa;
    
    public Presenter() {
    	bind();
    }

    public void bind() { 
    	this._arp = new ARPConcrete();
    	_ctr = UTMCTR.getUTMCTR();
    }
	public void setARP(ARPConcrete arp ) {
		this._arp = arp;
	}
	
	public void getMapa() {
        if(_arp != null && _ctr!=null) {
            mapa = _ctr.SAinfo(_arp);
            valido = true;
        } else {
        	valido = false;
        }
        _flagGetMapa = true;
		this.setChanged();
		this.notifyObservers(mapa);
	}
	
	public IARP getARP() {
		return _arp;
	}
	
	public UTMCTR getUTMCTR() {
		return _ctr;
	}
	
	public boolean getFlag() {
		return _flagGetMapa;
	}

}
