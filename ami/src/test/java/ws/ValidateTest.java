package ws;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import ws.ami.validate.IValidator;
import ws.ami.validate.ValidationException;
import ws.ami.validate.ValidatorImpl;

public class ValidateTest {

	

	@Length(min=6,max=6,message="名称只能为6个字符")
	@NotEmpty(message ="name 不能为空")
	private String name;
	
	@NotNull(message = "sex 不能为空")
	boolean sex;
	
	@Pattern(regexp ="^\\d{4}((0[1-9])|(1[0-2]))(([0-2][0-9])|(3[0-1]))([0-1][0-9]|[2][0-3])([0-5][0-9]){2}$",message="时间格式错误")
	private String time;

	 @Pattern(regexp = "^(?:01|02)$",message = "代收付类型取值范围：01,02")
	 String arg;

	@Test
	public void test() throws ValidationException {
		
		System.out.println("dd");
		
		ValidateTest test = new ValidateTest();
		test.name = "ssssss";
		System.out.println(test.sex);
		test.arg="01";
		
		

		test.time ="20140206101010";
		try {
			
			IValidator v = new ValidatorImpl();
			v.validate(test);
			//ValidateTest test = new ValidateTest();
			//v.validate(test);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
