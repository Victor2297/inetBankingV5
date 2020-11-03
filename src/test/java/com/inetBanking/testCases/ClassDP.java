package com.inetBanking.testCases;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class ClassDP {
	@DataProvider(name = "Data")
	public static Object[][] getData() {
		return new Object[][] {
			{"", "123", "Test1"},
			{"45678", "", "Test1"},
			{"", "", ""},
			{"test", "123", "Test1"},
			{"45678", "123V", "Test1"},
			{"45678", "123", "34567"}
		};
	}
}