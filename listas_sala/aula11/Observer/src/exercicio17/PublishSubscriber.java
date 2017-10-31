package exercicio17;

import java.util.Observable;
import java.util.Observer;

public class PublishSubscriber extends Observable implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}

}
