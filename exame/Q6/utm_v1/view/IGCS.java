package view;

import java.util.Observer;
import presenter.Presenter;

public interface IGCS extends Observer {
	public void init(Presenter presenter);
	void printMapa(String mapa);
	public void recebeMapa();
}
