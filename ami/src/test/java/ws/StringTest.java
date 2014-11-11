package ws;

import org.junit.Test;

public class StringTest {
	
	
	@Test
	public void test()
	{
		String a = "aa:aa bb-bb";
		System.out.println(a);
		 a = a.replace(":", "");
		 a = a.replace("-", "");
		System.out.println(a);
	}

}
