package com.tools.utils;

import com.tools.persistence.PropertyFileReader;

public class TestConfigConstants {

	public static final String USER = PropertyFileReader.getTestConstantsItem("USER");
	public static final String PASS = PropertyFileReader.getTestConstantsItem("PASS");
	public static final String USER_NAME = PropertyFileReader.getTestConstantsItem("USER_NAME");

}
