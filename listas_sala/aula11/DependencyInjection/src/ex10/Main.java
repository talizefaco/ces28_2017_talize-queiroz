package ex10;

public class Main {
	
	public static void main(String[] args) {
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages("Oi Didi!", "dicksi@no.br");
		
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages("Oi Didi!", "123456789");
	}

}
