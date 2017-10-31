package exercicio12;

import java.util.Observable;

public class Usuario extends Observable {
	private String msg;
	
	public Usuario() {
		
	}

	public void setMsg(String msg) {
		this.msg = msg;
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getMsg() {
		return this.msg;
	}
}
