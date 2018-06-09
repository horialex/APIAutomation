package com.tests;

import org.junit.Before;

public class BaseTest {
	
	@Before
	public void setup() {
		System.setProperty("http.proxyHost", "localhost");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "localhost");
		System.setProperty("https.proxyPort", "8080");
	}

}
