package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectDates {
    WebDriver driver;
    public SelectDates(WebDriver driver) {
        this.driver = driver;
    }
    public void selectDateRange(String year, String month, String date, String selectCalender) {
        driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[" + selectCalender + "]")).click();
        driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//div[@class='mat-calendar-arrow']")).click();
        List<WebElement> allyears = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement years : allyears) {
            if (years.getText().equals(year)) {
                years.click();
                break;
            }
        }
        List<WebElement> allmonth = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement months : allmonth) {
            if (months.getText().equals(month)) {
                months.click();
                break;
            }
        }
        List<WebElement> alldays = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement days : alldays) {
            if (days.getText().equals(date)) {
                days.click();
                break;
            }
        }
    }

}
