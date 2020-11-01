package com.inetBanking.testCases;



import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class ClassDP {
	@DataProvider(name = "Data")
	public static String[][] getData() {
		return getValues();
	}
	public static String[][] getValues() {
		String[][] myData = new String[3][2];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				myData[i][j] = "V" +i + " " + j;
			}
		}
		return myData;
	}
}
