package Utilities;
import Tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;




public class Functions extends BaseTest {
    BaseTest baseTest;
    public  void takescreenshot(String testname) throws IOException {
        baseTest=new BaseTest();
        File myfile = ((TakesScreenshot) baseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(myfile, new File (System.getProperty("user.dir")+"\\HTMLReport\\"+testname+"_fail.png"));
    }
    public  boolean isElementPresent(By locator){
        try{
            baseTest.driver.findElement(locator).isDisplayed();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public  String getCurrentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = formatter.format(new Date());
        return date;
    }
////    public void entertext(WebElement locator, String input){
////        waitUpToelementClickable(baseTest.driver,locator);
////        baseTest.driver.findElement(locator).click();
////        baseTest.driver.findElement(locator).clear();
////        baseTest.driver.findElement(locator).sendKeys(input);
////        locator.click();
//        locator.clear();
//        locator.sendKeys(input);
//    }
}