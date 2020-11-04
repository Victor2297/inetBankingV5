package com.inetBanking.testCases;

import org.testng.annotations.DataProvider;

public class ClassDP1 {
	@DataProvider(name = "Data")
	public static Object[][] getData() {
		return new Object[][] {
			{" ", " ", " "},
			{" ", "23", "Extragere de bani"},
			{"35796", " ", "Extragere de bani"},
			{"35758", "23 ", " "},
			{"salut", " ", " "},
			{" ", "salut", " "}
		};
	}
}
