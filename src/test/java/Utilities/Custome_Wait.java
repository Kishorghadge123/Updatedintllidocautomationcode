package Utilities;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Custome_Wait extends BaseTest {


     WebDriver driver;
     WebDriverWait wait;

    public Custome_Wait(WebDriver driver) {
        this.driver = driver;
    }

    public  void waitVisibility(WebDriver driver, WebElement element) {
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public  void waitUpToelementClickable(WebDriver driver, WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
//    public static void wait(WebDriver driver, By locator) {
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.DAYS.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, 45);
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    public static void page_load_wait(WebDriver driver) {
//        WebDriver.Timeouts time = driver.manage().timeouts();
//        time.pageLoadTimeout(10, TimeUnit.SECONDS);
//
//    }
//
//    public static void wait1() {
//        try {
//            wait = new WebDriverWait(driver, 5000L);
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Please wait...'] ")))); // wait for loader to
//            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='Please wait...'] ")))); // wait for loader to disappear
////			this.Logout.click();
//        } catch (Exception e) {
//            System.out.println("Spinar Not Appear");
//        }
////        Thread.sleep(5000);
//    }




//	public static void fluentwait(WebDriver driver) {
//		//Declare and initialise a fluent wait
//		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
//		WebElement element=wait.until(new Function<WebDriver, WebElement>() {
//		public WebElement apply(WebDriver driver){
//	}
}