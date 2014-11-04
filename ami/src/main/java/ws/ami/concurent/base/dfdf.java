package ws.ami.concurent.base;

/**
 * 上面的类展示了final字段应该如何使用。一个正在执行reader方法的线程保证看到f.x的值为3
 * ，因为它是final字段。它不保证看到f.y的值为4，因为f.y不是final字段。
 * @author hp
 *
 */
class FinalFieldExample {
	final int x;
	int y;
	static FinalFieldExample f;

	public FinalFieldExample() {
		x = 3;
		y = 4;
	}
	
	
	
/*
 * 如果FinalFieldExample的构造方法像这样：
 * 那么，从global.obj中读取this的引用线程不会保证读取到的x的值为3。	
	public FinalFieldExample() { // bad!
		  x = 3;
		  y = 4;
		  // bad construction - allowing this to escape
		  global.obj = this;
		}*/

	static void writer() {
		f = new FinalFieldExample();
	}

	static void reader() {
		if (f != null) {
			int i = f.x;
			int j = f.y;
		}
	}
}
