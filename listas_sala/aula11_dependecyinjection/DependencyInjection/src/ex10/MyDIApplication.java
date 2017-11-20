package ex10;

public class MyDIApplication implements Consumer {
	private MessageService service;

	public MyDIApplication(MessageService svc) {
		this.service = svc;
	}

	@Override
	public void processMessages(String msg, String rec) {
		// Do some msg validation, manipulation logic etc 
		this.service.sendMessage(msg, rec);
	}
}
