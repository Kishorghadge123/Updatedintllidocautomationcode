package Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

///pages classs
public class AnalyticsPage {
    WebDriver driver;
    AnalyticsPage analyticsPage;

    public AnalyticsPage(WebDriver driver) {
        this.driver = driver;
    }

    public static By AnalyticsBtn = By.xpath("(//img[contains(@class,'mat-tooltip-trigger')])[9]");
    public static By SelectProject = By.xpath("//input[@placeholder='Search']//following::span[1]");
    By projectListDropDownArrow = By.xpath("//div[@class='col-sm-8 project_list']//span[@class='mat-button-wrapper']");

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-tooltip-trigger mat-paginator-navigation-last mat-icon-button mat-button-base ng-star-inserted']")
            public WebElement items;

    By userCount = By.xpath("(//div[contains(text(),' Users ')])[1]//following::div[1]");

    public double Verify_progress_bar_Count_and_Total_Count_Of_Documents_for_all_Project(String DocumentType, String status) {
        String style = switch (status) {
            case "ready" ->
                    driver.findElement(By.xpath("//div[text()=' " + DocumentType + " ']/following::div[@role='progressbar' and contains(@class,'bg_" + status + "')][1]")).getAttribute("style");
            case "processed" ->
                    driver.findElement(By.xpath("//div[text()=' " + DocumentType + " ']/following::div[@role='progressbar' and contains(@class,'bg_" + status + "')][1]")).getAttribute("style");
            case "rejected" ->
                    driver.findElement(By.xpath("//div[text()=' " + DocumentType + " ']/following::div[@role='progressbar' and contains(@class,'bg_" + status + "')][1]")).getAttribute("style");
            default -> null;
        };
        assert style != null;
        style = style.split("width: ")[1].split("%")[0];
        System.out.println("count: " + style);
        return Double.parseDouble(style);
    }

    public double getCountFromProgresBar(String projectType, double satusPercent) {
        String totalCount_of_Statistics = driver.findElement(By.xpath("//div[text()=' " + projectType + " ']/span[contains(text(),'Total')][1]")).getText().split("Total: ")[1];
        double totalCount_of_Statistics1 = Double.parseDouble(totalCount_of_Statistics);
        return (totalCount_of_Statistics1 / 100.000) * satusPercent;
    }

    public void verfy_TotalCountofDocuments_in_Organization_Statistics() {
        String ProssesCount = (driver.findElement(By.xpath("(//div[@class='bold font-16'])[3]")).getText());
        String Rejected = (driver.findElement(By.xpath("(//div[@class='bold font-16'])[4]")).getText());
        String Ready_to_Process = (driver.findElement(By.xpath("(//div[@class='bold font-16'])[5]")).getText());
        String ActualtotalCount = (driver.findElement(By.xpath("(//div[@class='bold font-16'])[2]")).getText());
        String proccesCount = ProssesCount.replace(",", "");
        String rejected = Rejected.replace(",", "");
        String ready_to_Process = Ready_to_Process.replace(",", "");
        String actualtotalCount = ActualtotalCount.replace(",", "");
        int actualDocumentcount = Integer.parseInt(actualtotalCount);
        int expactedDocumentCount = Integer.parseInt(proccesCount) + Integer.parseInt(ready_to_Process) + Integer.parseInt(rejected);
        Assert.assertEquals(actualDocumentcount, expactedDocumentCount);
    }

    public void verfiy_TotalPercentageCount_Of_Organization_Statistics() {

        List<WebElement> list = driver.findElements(By.cssSelector("tspan[class='ng-star-inserted']:nth-child(1)"));
        double i;
        double j = 0;
        for (WebElement s : list) {
            i = Double.parseDouble(s.getText());
            j = j + i;
        }
        Assert.assertEquals((j - 200.0), 100.0);
    }

    public int verfiyThatTotalCountOfProjectDocisequleToTotalCountOfProccessReadyRejectDoc() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(projectListDropDownArrow).click();
        Thread.sleep(2000);
        driver.findElement(SelectProject).click();
        String processedCount = driver.findElement(By.xpath("(//div[@class='row'] //div[@class='col-md-2 mb-3 px-2']//h5)[2]")).getText();
        String ReadytoProcessCount = driver.findElement(By.xpath("(//div[@class='row'] //div[@class='col-md-2 mb-3 px-2']//h5)[3]")).getText();
        String RejectedCount = driver.findElement(By.xpath("(//div[@class='row'] //div[@class='col-md-2 mb-3 px-2']//h5)[4]")).getText();
        return Integer.parseInt(processedCount) + Integer.parseInt(ReadytoProcessCount) + Integer.parseInt(RejectedCount);
    }

    public String verfyWhenuserClickondaiyButtonAccordingThatResultisDiaplayinDocProccessing(String text) {
        driver.findElement(By.xpath("//span[contains(text(),'" + text + "')]")).click();
        return driver.findElement(By.xpath("//span[contains(text(),'" + text + "')]")).getText();
    }

    public int verifyTotalcountOfreadyToProccessDocisequalToTotalcountofDocinTable() throws InterruptedException {
        Thread.sleep(200);
        List<WebElement> allelement = driver.findElements(By.xpath("//div[@class='example-container readyTable h-100']//table/tbody/tr/td[1]"));
        return allelement.size();
    }

    @Step("Click Analytics Button")
    public void ClickAnalyticsBtn() throws Exception {
        driver.findElement(AnalyticsBtn).click();
    }

    public String getUserCounts() {
        return driver.findElement(userCount).getText();
    }

    public void clickOnDropDowns(int index) {
        driver.findElement(By.xpath("(//span[contains(@class,'mat-expansion-indicator ng-tns-c')])[" + index + "]")).click();
    }
}