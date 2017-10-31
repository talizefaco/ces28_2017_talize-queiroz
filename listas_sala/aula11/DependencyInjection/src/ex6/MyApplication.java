package ex6;

public class MyApplication {
	
	public MyApplication(MessageService service) {
		this._service = service;
	}
	
	public void processMessages(String message, String receiver) {
		// Do some msg validation, manipulation logic etc.
		this._service.sendMessage(message, receiver);
	}
	private MessageService _service = null;
}

