package ws;

import javax.validation.constraints.NotNull;

import org.junit.Test;

import ws.ami.validate.IValidator;
import ws.ami.validate.ValidationException;
import ws.ami.validate.ValidatorImpl;

public class ValidateTest {

	

	@NotNull
	private String name;

	@NotNull
	private String sex;

	@Test
	public void test() throws ValidationException {
		
		System.out.println("dd");

		try {
			
			IValidator v = new ValidatorImpl();
			//ValidateTest test = new ValidateTest();
			//v.validate(test);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
