package com.tools.constants;

import com.tools.persistence.PropertyFileReader;

public interface EnvironmentConstants {

	public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
}