package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties p;
	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		try {
		FileInputStream myFile = new FileInputStream(file);
		p = new Properties();
		p.load(myFile);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getUserName() {
		String username = p.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}
	public String getBaseUrl() {
		String url = p.getProperty("baseUrl");
		return url;
	}
	public String getChDriverPath() {
		String ChDriverPath = p.getProperty("ChDriverPath");
		return ChDriverPath;
	}
	public String getFfDriverPath() {
		String FfDriverPath = p.getProperty("FfDriverPath");
		return FfDriverPath;
	}
}