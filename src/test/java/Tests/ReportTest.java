package Tests;

import Pages.ReportPage;
import Utilities.ClickOnOutSide;
import Utilities.DateTimeUtils;
import Utilities.SortingLists;
import Utilities.VerifyTextOfTable;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ReportTest extends BaseTest {
    ReportPage reportPage;
    ClickOnOutSide clickOnOutSide;
    VerifyTextOfTable verifyTextOfTable;
    SortingLists sortingLists;
    SoftAssert softAssert;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: R001 - Total Count Of All Document In Analytics Section in ReportTab")
//    @Description("verify_user_able_to_count_all_Documents_in_Analytics_section_in_report_tab")
//    @Test(priority = 1, groups = "smoke", description = "verify_user_able_to_count_all_Documents_in_Analytics_section_in_report_tab")
//    public void verifyTotalCountOfAllDocInAnalyticsSectionInReportTab() throws Exception {
//        waitForloadSpinner();
//        reportPage = new ReportPage(driver);
//        reportPage.clickOnReportTab();
//        waitForloadSpinner();
//        reportPage.clickOnProjectDropdown();
//        Thread.sleep(1000);
//        reportPage.selectProjectFromDropDown();
//        Thread.sleep(3000);
//        reportPage.verifyTotalCountOfAllDocInAnalyticsSection();
//        reportPage.getTotalPercentage();
//
//    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R002 - Verify Report is Downloaded")
    @Description("verify_user_able_to_Download_Report")
    @Test(priority = 2, groups = "smoke", description = "verify_user_able_to_Download_Report", enabled = true)
    public void verifyReportIsDownload() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.verifyUserableDownloadreport();
        Thread.sleep(10000);
        reportPage.deleteReportFile("final_report.xlsx");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R003 - verifyTheDropDownOfReportTab")
    @Description("verifyTheDropDownOfReportTab")
    @Test(priority = 3, groups = "smoke", description = "verifyTheDropDownOfReportTab", enabled = true)
    public void verifyTheDropDownOfReportTab() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.ClickOnDropDownsInReportTab();
        Thread.sleep(2000);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R004 - verifyTheDocStatusAsPerFilters")
    @Description("verifyTheDocStatusAsPerFilters")
    @Test(priority = 4, groups = "smoke", description = "verifyTheDocStatusAsPerFilters", enabled = true)
    public void verifyTheDocStatusAsPerFilters() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.selectProject();
        Thread.sleep(1000);
        reportPage.clickOnFilterDropDownArrow();
        reportPage.clickOnStatusDropDown();
        reportPage.SelectStatusInReportTab(3);
        reportPage.SelectStatusInReportTab(1);
        clickOnOutSide.clickOutside();
        reportPage.clickOnApplyFilter();
        Thread.sleep(2000);
        verifyTextOfTable.verfiyDisplayStatusOfDoc("Ready", 4);
        reportPage.clickOnStatusDropDown();
        reportPage.SelectStatusInReportTab(1);
        reportPage.SelectStatusInReportTab(2);
        clickOnOutSide.clickOutside();
        reportPage.clickOnApplyFilter();
        Thread.sleep(2000);
        verifyTextOfTable.verfiyDisplayStatusOfDoc("Pending", 4);
//        reportPage.clickOnStatusDropDown();
//        reportPage.SelectStatusInReportTab(2);
//        reportPage.SelectStatusInReportTab(3);
//        clickOnOutSide.clickOutside();
//        reportPage.clickOnApplyFilter();
//        Thread.sleep(2000);
//        reportPage.clickOnStatusDropDown();
//        reportPage.SelectStatusInReportTab(3);
//        reportPage.SelectStatusInReportTab(4);
//        clickOnOutSide.clickOutside();
//        reportPage.clickOnApplyFilter();
//        Thread.sleep(2000);
//        verifyTextOfTable.verfiyDisplayStatusOfDoc("Rejected", 4);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R005 - verifyTheClearFilterButtonInFilter")
    @Description("verifyTheClearFilterButtonInFilter")
    @Test(priority = 5, groups = "smoke", description = "verifyTheClearFilterButtonInFilter", enabled = true)
    public void verifyTheClearFilterButtonInFilter() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.selectProject();
        Thread.sleep(1000);
        reportPage.clickOnFilterDropDownArrow();
        reportPage.EnterDocumentName("Meadical Document");
        reportPage.clickOnassigneeDropDown();
        Thread.sleep(2000);
        reportPage.clickInCheckBoxOnAssignees();
        clickOnOutSide.clickOutside();
        Thread.sleep(2000);
        reportPage.selectDateRange("2022", "OCT", "20", "1");
        reportPage.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(1000);
        reportPage.clickOnClearButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mat-input-3']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='mat-select-value-1']")).getText(), "");
    }

//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: R006 - verify the user able to sort the table from data")
//    @Description("verify_the_user_able_to_sort_the_table_from_data")
//    @Test(priority = 6, groups = "smoke", description = "verify_the_user_able_to_sort_the_table_from_data")
//    public void verifytableDataisSorting() throws Exception {
//        waitForloadSpinner();
//        reportPage = new ReportPage(driver);
//        verifyTextOfTable = new VerifyTextOfTable(driver);
//        clickOnOutSide = new ClickOnOutSide(driver);
//        sortingLists = new SortingLists(driver);
//        reportPage.clickOnReportTab();
//        waitForloadSpinner();
//        reportPage.selectProject();
//        Thread.sleep(1000);
//        reportPage.clickOnFilterDropDownArrow();
//        reportPage.clickOnStatusDropDown();
//        reportPage.SelectStatusInReportTab(3);
//        reportPage.SelectStatusInReportTab(1);
//        clickOnOutSide.clickOutside();
//        reportPage.clickOnApplyFilter();
//        Thread.sleep(2000);
//        verifyTextOfTable.verfiyDisplayStatusOfDoc("Ready", 4);
//        reportPage.clickOnStatusDropDown();
//        reportPage.SelectStatusInReportTab(1);
//        reportPage.SelectStatusInReportTab(2);
//        clickOnOutSide.clickOutside();
//        reportPage.clickOnApplyFilter();
//        Thread.sleep(2000);
//        reportPage.verifySortsortingofTableData(2);
//        Thread.
//        driver.navigate().refresh();
//        sortingLists.sortingListInOrder("ascending", 1);
//        reportPage.verifySortsortingofTableData(2);
//    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: R007 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 7, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        //scrollPage = new Scroll_Page(driver);
        reportPage = new ReportPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(5000);
        reportPage.clickOnDropDown();
        reportPage.selectDropDownValue();
        reportPage.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = reportPage.getUserCountOfatomperPage();
        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: R008 -verify The Spelling")
    @Description("verifyTheSpelling")
    @Test(priority = 8, groups = "smoke", description = "verifyTheSpelling")
    public void verifyTheSpelling() throws Exception {
        sortingLists = new SortingLists(driver);
        reportPage = new ReportPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@class=\"ml-2 primary-font-color\"]")).getText(), "Analytics");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-panel-title[contains(@class,'mat-expansion-panel-header-title justify-content-start bold ng-tns-c')])[2]")).getText(), "Filter");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[1]")).getText(), "Documents");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[2]")).getText(), "Assignee");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[3]")).getText(), "Status");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[4]")).getText(), "Updated Date");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[5]")).getText(), "Received Date");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base\"]")).getText(), "Ready");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base\"])[2]")).getText(), "Rejected");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base docStatus-Processed']")).getText(), "Processed");
      //  softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R009 - verifyTilesInanAlyticsSection")
    @Description("verifyTheClearFilterButtonInFilter")
    @Test(priority = 9, groups = "smoke", description = "")
    public void verifyTilesInanAlyticsSection() throws Exception {
        softAssert = new SoftAssert();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.selectProject();
        Thread.sleep(1000);
        reportPage.clickOnFilterDropDownArrow();
        reportPage.EnterDocumentName("Prada-25-Regression");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='infobox'])[1]")).getText(), "Total");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='infobox'])[2]")).getText(), "Ready");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='infobox'])[3]")).getText(), "Processed");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='infobox'])[4]")).getText(), "Audit Pending");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='infobox'])[5]")).getText(), "Audited");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='infobox'])[6]")).getText(), "Rejected");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R010 - verifyTheClearFilterButtonInFilter")
    @Description("verifyTheClearFilterButtonInFilter")
    @Test(priority = 10, groups = "smoke", description = "verifyTheClearFilterButtonInFilter", enabled = true)
    public void verifyTheFilterLabels() throws Exception {
        softAssert = new SoftAssert();
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.selectProject();
        Thread.sleep(1000);
        reportPage.clickOnFilterDropDownArrow();
        softAssert.assertEquals(driver.findElement(By.xpath("(//input[@type='text'])[2]//preceding::mat-label[1]")).getText(), "Document Name");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[1]//preceding::mat-label[1]")).getText(), "Assignee");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[2]//preceding::mat-label[1]")).getText(), "Auditor");
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[1]//preceding::mat-label[1]")).getText(), "Received Date");
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[2]//preceding::mat-label[1]")).getText(), "Updated Date");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[3]//preceding::mat-label[1]")).getText(), "Status");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R011 - verifyTheClearFilterButtonInFilter")
    @Description("verifyTheClearFilterButtonInFilter")
    @Test(priority = 11, groups = "smoke", description = "verifyTheClearFilterButtonInFilter", enabled = true)
    public void verify() throws Exception {
        softAssert = new SoftAssert();
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        Assert.assertTrue(DateTimeUtils.verifyDateFormat(reportPage.getCreatedDateOfSearchedUserInGridView())
                , "Date is not in correct format.");


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R012 - verifyTheFilterButtonInFilter")
    @Description("verifyTheFilterButtonInFilter")
    @Test(priority = 12, groups = "smoke", description = "verifyTheFilterButtonInFilter", enabled = true)
    public void verifyTheFilterButtonInFilter() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.selectProject();
        Thread.sleep(1000);
        reportPage.clickOnFilterDropDownArrow();
        reportPage.EnterDocumentName("Meadical Document");
        reportPage.clickOnassigneeDropDown();
        Thread.sleep(2000);
        reportPage.clickInCheckBoxOnAssignees();
        clickOnOutSide.clickOutside();
        reportPage.clickOnAuditorDropdown();
        Thread.sleep(1000);
        reportPage.selectAuditor();
        Thread.sleep(1000);
        clickOnOutSide.clickOutside();
        reportPage.selectDateRange("2022", "OCT", "20", "1");
        reportPage.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(1000);
        reportPage.clickOnApplyFilter();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: R013 - verifyTheFilterButtonInFilter")
    @Description("verifyTheFilterButtonInFilter")
    @Test(priority = 13, groups = "smoke", description = "verifyTheFilterButtonInFilter", enabled = true)
    public void verifyLabelOfDocuments() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        softAssert = new SoftAssert();
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[contains(@class,\"mat-sort-header-content ng-tns\")])[1]")).getText(), "Documents");
    }}