//package BrowserDriverFactory;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
////import org.apache.commons.io.IOUtils
//public class BrowserFactory {
//    public WebDriver createBrowserInstance(String browser) {
//        WebDriver driver = null;
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//           driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver=new FirefoxDriver();
//        }else {
//            System.out.println("Need select correct browser");
//        }
//        return driver;
//    }
//
//}
//
//
