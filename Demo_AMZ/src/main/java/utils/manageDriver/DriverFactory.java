package main.java.utils.manageDriver;

public class DriverFactory {

    public static DriverManager getDriverManager(String browserType) {
        DriverManager driverManager = null;
        try {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    driverManager = new ChromeManager();
                    break;
                case "firefox":
                    driverManager = new FirefoxManager();
                    break;
                case "safari":
                    driverManager = new SafariManager();
                default:
                    throw new Exception("no such browser is present to be initialize. Browser name: " + browserType);
            }
        } catch (Exception e) {

        }
        return driverManager;
    }
}
