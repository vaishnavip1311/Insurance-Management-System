package com.hexaware.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DbProperties {
	
	private static Properties props=null;
	static {
		props=getDbProperties();
	}
	
	private static Properties getDbProperties() {
		Properties props = new  Properties();
		try {
			props.load(new FileReader("src/hexadb.properties"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return props;
	}
	
	public static String getDriver() {
		return props.getProperty("driver");
	}
	
	public static String getDbURL() {
		return props.getProperty("dburl");
	}
	
	public static Properties getProps() {
		return props;
	}

}
