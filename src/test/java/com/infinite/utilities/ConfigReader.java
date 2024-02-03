package com.infinite.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        InputStream input = null;
        try {
            input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties");
            if (input != null) {
                properties.load(input);
            } else {
                System.out.println("Sorry, unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}


