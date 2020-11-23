package com.inetBanking.testCases;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class ClassDP2 {
	@DataProvider(name = "Data")
	public static String[][] getData(Method m) {
		if(m.getName().contentEquals("n_displayMiniStatement")) {
		return new String[][] {
			{"23456783", ""},
			{"      ", ""},
			{"dfdf3456", ""},
			{"124", ""}
		};
		}
		else {
			return new String[][] {
					{"245678", ""}
			};
		}
	}
}