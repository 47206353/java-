package com.ami.reflect;

import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据转换的工具类
 * <p/>
 * Created by hp on 2014/9/26.
 */
public class ObjectConverterHelper {

	/**
	 * @param o
	 *            需要设置的参数
	 * @param fildName
	 *            指定的属性赋值
	 * @param value
	 *            指定的值
	 */
	public static void setValue(Object o, String fildName, Object value)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field field = o.getClass().getDeclaredField(fildName);
		field.setAccessible(true);
        
   /* 
		System.out.println("fName="+field.getName());
		System.out.println(" fType="+field.getType());
		System.out.println(" vType"+value.getClass());*/
		
		if(field.getType().equals(value.getClass()))
		field.set(o, value);
		
		//有父类
		
		while(o.getClass().getSuperclass() != null)
		{
			Class parentObject = o.getClass().getSuperclass() ;
			Field pfield = parentObject.getDeclaredField(fildName);
			pfield.setAccessible(true);
			if(pfield.getType().equals(value.getClass()))
				pfield.set(o, value);
		}

	}

	/**
	 * 转换指定的类
	 * 
	 * @param source
	 * @param targetType
	 * @return
	 */
	public static Object convert(Object source, Class targetType)
			throws Exception {
		// try {

		System.out.println("开始");
		Object target = targetType.newInstance();
		Field[] tFields = targetType.getDeclaredFields();
		System.out.println("fields.length=" + tFields.length);
		for (Field tField : tFields) {

			String fName = tField.getName();
			tField.setAccessible(true);
			Field sField = source.getClass().getDeclaredField(fName);
			sField.setAccessible(true);
			Object value = sField.get(source);
			setValue(target, fName, value);

		}
		
		
		if(targetType.getSuperclass() != null)
		{
			
		}
			
		
		

		return target;
		/*
		 * } catch (Exception e) { e.printStackTrace(); return null; }
		 */
	}

	/**
	 * 将字符串转换成数字
	 *
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static int string2int(String source) throws Exception {

		Integer i = new Integer(source);
		return i.intValue();

	}

	public static long interval2Long(String interval) {
		long i = 1l;
		for (String c : interval.split("\\*")) {

			i = i * new Integer(c);
		}
		return i;
	}

	public static long string2Long(String source) throws Exception {

		Long i = new Long(source);
		return i.longValue();

	}

	/**
	 * 将字符串转换为int，“5*60“转换为300
	 *
	 * @param source
	 * @param splic
	 *            *
	 * @return
	 * @throws Exception
	 */
	public static int string2int(String source, String splic) throws Exception {

		int result = 0;
		;
		for (String s : source.split("[" + splic + "]")) {
			if (result == 0)
				result = 1;
			result = result * string2int(s);

		}

		return result;

	}

	/**
	 * 解析时间。date格式：yyyyMMddHHmmss
	 *
	 * @param date
	 * @return date类型的时间
	 */
	public static Date parse(String date) throws Exception {
		Format format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return (Date) format.parseObject(date);
		} catch (Exception e) {
			throw new Exception("无法解析输入的日期类型，请已匹配格式输出：yyyyMMddHHmmss");
		}

	}

}
