package com.pro.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;

	public ConfigDataProvider() {

		File src = new File("./src/test/resources/Configuration/Config.Properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			System.out.println("Unable to read config" + e.getMessage());
		}

	}

	/*
	 * public String getdatafromconfig(String Key) {
	 * 
	 * return prop.getProperty(Key);
	 * 
	 * }
	 */
	public String getbrowser() {

		return prop.getProperty("browser");

	}

	public String getUrl() {

		return prop.getProperty("Url");

	}

}
