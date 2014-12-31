public class LockClass {

	private static void say() {
		System.out.println("say hello");
	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(new Runnable() {
			public void run() {

				synchronized (LockClass.class) {

					for (int i = 0; i < 100; i++) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("say lock");
					}

				}

			}

		});

	/*	Thread thread2 = new Thread(new Runnable() {
			public void run() {

				synchronized (LockClass.class) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int i = 0; i < 100; i++)
						System.out.println("say hello");

				}

			}

		});*/

		thread1.start();

		//thread2.start();
		
		for (int i = 0; i < 100; i++)
		{
			try {
				Thread.sleep(10);
				//Thread.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread id = "+Thread.currentThread().getId() +"thread name ="+thread1.currentThread().getName()+" say hello");
		}

	}

}
