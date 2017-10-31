package aula10;

public class SingletonThread {
	private static SingletonThread  _singleton = null;
	private static boolean instanceFlag = false;
	
	private SingletonThread() {
		
	}
	
	public static synchronized SingletonThread getSing() {
		if (!instanceFlag) {
			return create();
		}
		else {
			return _singleton;
		}
	}
	
	protected void finalize() throws Throwable {
		try {
			instanceFlag = false;
		} finally {
			super.finalize();
		}
	}
	
	private static SingletonThread create() {
		_singleton = new SingletonThread();
		instanceFlag = true;
		return _singleton;
	}
	
	public static SingletonThread singleton1, singleton2;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				singleton1 = SingletonThread.getSing();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				singleton2 = SingletonThread.getSing();
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		if(singleton1 == singleton2) {
			System.out.println("Alohomora!");
		}
		else {
			System.out.println("Alomohora!");
		}
	}


}


