package ws;

import org.junit.Test;

import com.ami.en.BankAccountType;

public class entest {
	
	
	@Test
	public void test() {
		
		BankAccountType aString = BankAccountType.explain("BNK4");
		
		String ss = BankAccountType.explainType("1");
		
		
		System.out.println(aString.name());
		
	}
	
	

}
