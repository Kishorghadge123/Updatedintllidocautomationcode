package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class VerifyTextOfTable {
    WebDriver driver;

    public VerifyTextOfTable(WebDriver driver) {
        this.driver = driver;
    }

    public void verfiyDisplayStatusOfDoc(String status, int index) {
        List<WebElement> listOfWebElements = driver.findElements(By.xpath("//table/tbody/tr/td[" + index + "]"));
        List<Object> list = new ArrayList<>();
        for (WebElement e : listOfWebElements) {
            list.add(e.getText());
        }
        System.out.println(list);
        list.forEach(s -> Assert.assertTrue(s.toString().contains(status)));
    }
}