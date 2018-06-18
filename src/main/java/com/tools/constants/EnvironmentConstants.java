package com.tools.constants;

import com.tools.persistence.PropertyFileReader;

public interface EnvironmentConstants {

	public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
	public static final String RESOURCES_FOLDER = "\\src\\test\\resources\\files\\";
	public static final String RESOURCES_PATH = System.getProperty("user.dir") + RESOURCES_FOLDER;
	public static final String MULTIPART_CODE = "208322840018787";	
	public static final String MULTIPART_BOUNDRY = "boundary=---------------------------" + MULTIPART_CODE;
	public static final String CSV_RESOURCES_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\csv\\";
	
}
