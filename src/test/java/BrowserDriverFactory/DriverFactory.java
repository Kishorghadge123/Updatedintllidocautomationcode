//package BrowserDriverFactory;
//
//import Pages.LoginPage;
//import Pages.ProjectPage;
//import Utilities.ReadProps;
//import org.openqa.selenium.WebDriver;
//
//public class DriverFactory {
//    ProjectPage ProjectPageObj;
//    LoginPage loginPageObjects;
//
//    BrowserFactory bf = new BrowserFactory();
//
//    private DriverFactory() {
//
//    }
//    private static DriverFactory instance = new DriverFactory();
//    public static DriverFactory getInstance()
//    {
//        return instance;
//    }
//    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//    public void setDriver(WebDriver driverpara)
//    {
//        driver.set(driverpara);
//    }
//    public WebDriver getDriver() {
//        return driver.get();
//    }
//    public void closeBrowser() {
//        driver.get().close();
//        driver.remove();
//    }
//
//}
