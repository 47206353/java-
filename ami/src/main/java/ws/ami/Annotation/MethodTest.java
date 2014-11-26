package ws.ami.Annotation;

import java.lang.reflect.Method;
import java.util.jar.Attributes.Name;

public class MethodTest {

	@MethodAnnotation(value = "h")
	public void say(String name) {
		System.out.println("name");

	}

	public static void main(String[] args) {

		Method[] methods = MethodTest.class.getMethods();

		System.out.println("class annotation ="+MethodTest.class
				.getAnnotation(MethodAnnotation.class));

		for (Method method : methods) {
			System.out.println();
			System.out.print("name = " + method.getName() + "  ");
			if (method.isAnnotationPresent(MethodAnnotation.class)) {
				MethodAnnotation annotation = method
						.getAnnotation(MethodAnnotation.class);
				System.out.print("annotation name =" + annotation.name
						+ " ananotation value = " + annotation.value());
			}

		}
		System.out.println("s");

	}

}
