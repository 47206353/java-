package ws.ami.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.swing.text.Element;

@Documented
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.PARAMETER)
public @interface ParamenterAnnotation {
	
	String name ="paremeter";
	String value();

}
