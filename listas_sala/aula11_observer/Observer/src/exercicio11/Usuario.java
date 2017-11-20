package exercicio11;

import java.util.ArrayList;

public class Usuario {
	private ArrayList<Observer> observers;
	private String msg;
	
	public Usuario() {
		observers = new ArrayList<Observer>();
	}
	
	public void add(Observer obs) {
		observers.add(obs);
	}
	
	public void remove(Observer obs) {
		observers.remove(obs);
	}
	
	protected void obsNotify() {
		for(Observer observer: observers) {
			observer.update();
		}
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		this.obsNotify();
	}
	
	public String getMsg() {
		return this.msg;
	}
}
