package ws.ami.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.fasterxml.classmate.Annotations;

public class ParameterTest {

	public void set(@ParamenterAnnotation(value = "23") String name) {
		System.out.println("name =" + name);

	}

	public static void main(String[] args) {

		ParameterTest pt = new ParameterTest();

		Method[] methods = pt.getClass().getMethods();

		System.out.println("method number =" + methods.length);

		for (Method method : methods) {
			System.out.println("method =" + method.getName());

			Class[] lClass = method.getParameterTypes();

			Annotation[][] annotations = method.getParameterAnnotations();
			for (Annotation[] ans : annotations)
				for (Annotation an : ans) {
					System.out.println("method name =" + method.getName() + " "
							+ "annotation name =" + an);
				}

		}
	}

}
