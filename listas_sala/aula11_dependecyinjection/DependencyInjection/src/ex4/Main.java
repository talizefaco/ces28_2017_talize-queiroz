package ex4;

public class Main {
	public static void main(String[] args) {
		EmailService email = new EmailService();
		MyApplication app = new MyApplication(email);
		app.processMessages("Oi Didi", "dicksi@no.br");
	}
}
