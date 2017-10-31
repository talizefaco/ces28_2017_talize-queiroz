package ex6;

public class Main {
	public static void main(String[] args) {
		SMSService sms = new SMSService();
		EmailService email = new EmailService();
		
		MyApplication appSMS = new MyApplication(email);
		MyApplication appEmail = new MyApplication(sms);
		
		appEmail.processMessages("Oi Didi", "dicksi@no.br");
		appSMS.processMessages("Oi Didi", "123456789");
	}
}
