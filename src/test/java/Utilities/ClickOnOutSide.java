package Utilities;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickOnOutSide extends BaseTest {
    public ClickOnOutSide(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}
