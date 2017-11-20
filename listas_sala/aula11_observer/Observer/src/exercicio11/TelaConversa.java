package exercicio11;

public class TelaConversa extends Observer {
	private String id;
	
	public TelaConversa(String id, Usuario sub) {
		this.id = id;
		this.usuario = sub;
	}
	
	public void update() {
		System.out.println(id + " notificado");
		System.out.println(">>> " + usuario.getMsg());
	}
}
