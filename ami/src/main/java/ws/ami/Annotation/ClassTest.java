package ws.ami.Annotation;

import java.lang.annotation.Annotation;

@ClassAnnotation(classValue = "test")
public class ClassTest {
	
	
	
	
	public static void main(String[] args) {
		ClassAnnotation annotation = ClassTest.class.getAnnotation(ClassAnnotation.class);
		
		System.out.println(annotation.classValue());
		
	}

}
