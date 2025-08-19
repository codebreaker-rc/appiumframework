package org.example.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties = new Properties();

    public Properties getProperty() throws IOException {

        InputStream inputStream = null;
        String propertyFileName = "config.properties";
        if(properties.isEmpty()){
            try{
                inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                inputStream.close();
            }
        }
        return properties;
    }
}
