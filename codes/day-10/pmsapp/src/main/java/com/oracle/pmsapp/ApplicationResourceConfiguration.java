package com.oracle.pmsapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.glassfish.jersey.server.ResourceConfig;

//please add this class name in the web.xml file in the <servlet> element
/*
 *  		<init-param>
            <param-name>jakarta.ws.rs.Application</param-name>
            <param-value>com.oracle.pmsapp.ApplicationResourceConfiguration</param-value>
        </init-param>
 */
public class ApplicationResourceConfiguration extends ResourceConfig {
	public static final Properties DB_SETTINGS = new Properties();
	public static final Properties DB_QUERIES = new Properties();

	// if the files are in the resources directory, just mention the name
	// since the files will be present in the class path (classes directory)
	// where this code's .class file will be present
	private static final String DB_SETTINGS_RESOURCE_NAME = "database.properties";
	private static final String DB_QUERIES_RESOURCE_NAME = "dbquery.properties";

	public ApplicationResourceConfiguration() throws IOException {
		ApplicationServicesBinderConfiguration binderConfiguration = new ApplicationServicesBinderConfiguration();
		this.register(binderConfiguration);
	
		loadFromPropertiesFile(DB_SETTINGS_RESOURCE_NAME, DB_SETTINGS);
		loadFromPropertiesFile(DB_QUERIES_RESOURCE_NAME, DB_QUERIES);
		
		//scan for classes, interfaces and other types of the application from the given
		//package and its sub-packages (nested packages)
		//same is mentioned in the web.xml file already
		//this.packages("com.oracle.pmsapp");
	}

	private void loadFromPropertiesFile(String resourceName, Properties properties) throws IOException {
		InputStream stream = null;

		try {
			Class<?> clsInfo = (Class<?>) this.getClass();
			ClassLoader loader = clsInfo.getClassLoader();
			stream = loader.getResourceAsStream(resourceName);
			properties.load(stream);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (stream != null)
				stream.close();
		}
	}
}
