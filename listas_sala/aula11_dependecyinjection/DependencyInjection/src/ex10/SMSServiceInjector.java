package ex10;

public class SMSServiceInjector implements MessageServiceInjector {
	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}
}

