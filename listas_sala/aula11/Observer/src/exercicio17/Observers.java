package exercicio17;

import java.util.Observable;
import java.util.Observer;

public class Observers implements Observer {
	private Observable subject;
	private String id;
	public Observers(String id, Observable sub) {
		this.subject = sub;
		this.id = id;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == subject) {
			System.out.println(this.id + ": recebi \"" + (String) arg + "\"");
		}
	}

}
