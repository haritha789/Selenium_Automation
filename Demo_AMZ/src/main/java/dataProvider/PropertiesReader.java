package main.java.dataProvider;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;
    private static final String propertyFilePath=  "";
    public static Properties testData = null;
    public static Properties elements = null;

    public static void getProperties(){
        try {
             properties = new Properties();
             testData = new Properties();
            elements= new Properties();
            try {
                InputStream configFile = new FileInputStream("configs/Configuration.properties");
                InputStream data = new FileInputStream("src/main/resources/elements.properties");
                elements.load(data);
                properties.load(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public static long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public static String getApplicationUrl() {
        String url = properties.getProperty("app_url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getElements(String key) {
        return elements.getProperty(key);
    }
}
