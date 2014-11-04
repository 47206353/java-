package ws.ami.guava;

import com.google.common.util.concurrent.AbstractIdleService;

public class Bootstrap extends AbstractIdleService {

	@Override
	protected void shutDown() throws Exception {
		
		System.out.println("停止");
	
		// TODO Auto-generated method stub

	}

	@Override
	protected void startUp() throws Exception 	{
		System.out.println("启动");
	
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.startAsync();
		try {
			Object lock = new Object();
			synchronized (lock) {
				while (true) {
					lock.wait();
				}
			}
		} catch (InterruptedException ex) {
			System.out.println("hello");
		}
	}

}
