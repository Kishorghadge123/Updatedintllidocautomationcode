package Utilities;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SortingLists extends BaseTest {
    public SortingLists(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver = null;

    public void sortingListInOrder(String order, int index) throws InterruptedException {
        boolean sorted = true;
        List<WebElement> listofuser = driver.findElements(By.xpath("//table/tbody/tr/td[" + index + "]"));
        if (order.equalsIgnoreCase("ascending")) {
            for (int i = 0; i < listofuser.size() - 1; i++) {
                if (listofuser.get(i).getText().toUpperCase().compareTo(listofuser.get(i + 1).getText().toUpperCase()) > 0) {
                    sorted = false;
                    break;
                }
            }
        }
        if (order.equalsIgnoreCase("descending")) {
            for (int i = 0; i < listofuser.size() - 1; i++) {
                if (listofuser.get(i).getText().toUpperCase().compareTo(listofuser.get(i + 1).getText().toUpperCase()) < 0) {
                    sorted = false;
                    break;
                }
            }
            if (sorted = true) {
                System.out.println("It is sorted list");
            } else {
                System.out.println("It is not sorted list");
            }
            Assert.assertTrue(sorted);

        }
    }
}
