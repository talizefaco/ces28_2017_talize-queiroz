package view;

import java.util.Observable;
import presenter.Presenter;

public class GCSConcrete implements IGCS {
	

	private Presenter _presenter;
    private String _mapa;
    
    public void init(Presenter presenter) {
    	this._presenter = presenter;
    	_presenter.addObserver(this);
    }

    public void recebeMapa() {
    	_presenter.getMapa();
    }
    
    public void printMapa(String mapa) {
    	System.out.println("Mapa aparece na tela:\n" + mapa);
	}
    
	@Override
	public void update(Observable arg0, Object arg1) {
			printMapa((String) arg1);
	}

}
