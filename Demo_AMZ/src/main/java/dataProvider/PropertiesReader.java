package main.java.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;

    /**
     * Used to Load all the properties
     */
    public static void getProperties() {
        try {
            properties = new Properties();
            try {
                InputStream configFile = new FileInputStream("configs/Configuration.properties");
                InputStream data = new FileInputStream("src/main/resources/elements.properties");
                properties.load(data);
                properties.load(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the configured value for implicit wait
     *
     * @return
     */
    public static long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    /**
     * Return the configured application url
     *
     * @return
     */

    public static String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    /**
     * Used to return the properties of the element
     *
     * @param key
     * @return
     */
    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
