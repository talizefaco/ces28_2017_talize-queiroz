package ex6;

public class SMSService implements MessageService {

	public void sendMessage(String message, String receiver){
        // Logic to send email
		System.out.println("SMS sent to "+ receiver);
		System.out.println("----------------------------------");
		System.out.println("Message: " + message);
	}
}

