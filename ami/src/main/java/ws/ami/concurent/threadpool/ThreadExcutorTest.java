package ws.ami.concurent.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 * 
 * @author hp
 *
 */

public class ThreadExcutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Executor e = Executors.newCachedThreadPool();

		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(
				10);

		Executor poolExecutor = new ThreadPoolExecutor(5, 10, 0,
				TimeUnit.SECONDS, workQueue, new MyThreadFactrory(),
				new MyRejectPolicy());

		for (int i = 0; i < 200; i++) {

			Runnable runnable = new Runnable() {
				int j = 0;

				public void run() {
					while (j < 20) {
						try {
							Thread.sleep(5000);
							j++;
							System.out.println("ThreadName = "+Thread.currentThread().getName() +" j = " + j);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					
					}

				}
			};

			System.out.println("向线程池中加入第 " + (i+1) + " 线程");
			poolExecutor.execute(runnable);
			
			System.out.println("workQueue 中的线程数目 = "+workQueue.size());

		}

	}

}
