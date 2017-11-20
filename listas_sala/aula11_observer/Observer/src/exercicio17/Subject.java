package exercicio17;

import java.util.Observable;

public class Subject extends Observable {
	private String msg;
	private String id;
	
	public Subject(String id) {
		this.id = id;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		this.setChanged();
		this.notifyObservers(msg);
	}

}
