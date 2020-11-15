package com.inetBanking.testCases;

import org.testng.annotations.DataProvider;

public class ClassDP2 {
	@DataProvider(name = "Data")
	public static Object[][] getData() {
		return new Object[][] {
			{"", "", ""},
			{"12345", "12345", ""},
			{"12345", "", "12345"},
			{"", "12345", "12345"},
			{"12345", "1234", "1234"},
			//{"123456@", "123456_", "123456_"},
			{"123456@", "12345", "1"}
		};
	}
}