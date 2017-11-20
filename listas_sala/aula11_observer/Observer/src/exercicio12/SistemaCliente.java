package exercicio12;

import java.util.Observable;
import java.util.Observer;

public class SistemaCliente implements Observer {
	private String id;
	private Usuario subject;
	
	public SistemaCliente(String id, Usuario sub) {
		this.id = id;
		this.subject = sub;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o == subject) {
			System.out.println(id + " notificado");
			System.out.println(">>> " + subject.getMsg());
		}
	}
}
