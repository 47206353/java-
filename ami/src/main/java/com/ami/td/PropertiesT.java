package com.ami.td;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesT {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		Properties pps = System.getProperties();
		try {
			//pps.load(new FileInputStream("app.properties"));
		} catch (Exception e) {

			e.printStackTrace();
		}

		pps.list(System.out);
		String value = pps.getProperty("l");
		System.out.println(value);

	}
}
