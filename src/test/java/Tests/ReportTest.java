package Tests;

import Pages.ReportPage;
import Utilities.ClickOnOutSide;
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

public class ReportTest extends BaseTest {
    ReportPage reportPage;
    ClickOnOutSide clickOnOutSide;
    VerifyTextOfTable verifyTextOfTable;
    SortingLists sortingLists;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 001 - Total Count Of All Document In Analytics Section in ReportTab")
    @Description("verify_user_able_to_count_all_Documents_in_Analytics_section_in_report_tab")
    @Test(priority = 1, groups = "smoke", description = "verify_user_able_to_count_all_Documents_in_Analytics_section_in_report_tab")
    public void verifyTotalCountOfAllDocInAnalyticsSectionInReportTab() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        Thread.sleep(10000);
        reportPage.clickOnProjectDropdown();
        Thread.sleep(1000);
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            reportPage.selectProjectFromDropDown(i);
            Thread.sleep(3000);
            reportPage.verifyTotalCountOfAllDocInAnalyticsSection();
            reportPage.clickOnProjectDropdown();
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 002 - Verify Report is Downloaded")
    @Description("verify_user_able_to_Download_Report")
    @Test(priority = 2, groups = "smoke", description = "verify_user_able_to_Download_Report", enabled = true)
    public void verifyReportIsDownload() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.verifyUserableDownloadreport();
        Thread.sleep(10000);
        Assert.assertTrue(reportPage.isFileDownloaded("final_report.xlsx"));//final_report
        Thread.sleep(10000);
        reportPage.deleteReportFile("final_report.xlsx");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 003 - verifyTheDropDownOfReportTab")
    @Description("verifyTheDropDownOfReportTab")
    @Test(priority = 3, groups = "smoke", description = "verifyTheDropDownOfReportTab", enabled = true)
    public void verifyTheDropDownOfReportTab() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        reportPage.clickOnReportTab();
        Thread.sleep(2000);
        reportPage.ClickOnDropDownsInReportTab();
        Thread.sleep(2000);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004 - verifyTheDocStatusAsPerFilters")
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
        verifyTextOfTable.verfiyDisplayStatusOfDoc("Processed", 4);
        reportPage.clickOnStatusDropDown();
        reportPage.SelectStatusInReportTab(2);
        reportPage.SelectStatusInReportTab(3);
        clickOnOutSide.clickOutside();
        reportPage.clickOnApplyFilter();
        Thread.sleep(2000);
        reportPage.clickOnStatusDropDown();
        reportPage.SelectStatusInReportTab(3);
        reportPage.SelectStatusInReportTab(4);
        clickOnOutSide.clickOutside();
        reportPage.clickOnApplyFilter();
        Thread.sleep(2000);
        verifyTextOfTable.verfiyDisplayStatusOfDoc("Rejected", 4);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 005 - verifyTheClearFilterButtonInFilter")
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
        reportPage.selectDateRange("2022", "OCT", "20", "1");
        reportPage.selectDateRange("2022", "OCT", "23", "2");
        reportPage.clickOnClearButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mat-input-3']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='mat-select-value-1']")).getText(), "");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 005 - verify the user able to sort the table from data")
    @Description("verify_the_user_able_to_sort_the_table_from_data")
    @Test(priority = 5, groups = "smoke", description = "verify_the_user_able_to_sort_the_table_from_data")
    public void verifytableDataisSorting() throws Exception {
        waitForloadSpinner();
        reportPage = new ReportPage(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        sortingLists = new SortingLists(driver);
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
        reportPage.verifySortsortingofTableData(2);
        sortingLists.sortingListInOrder("ascending", 1);
        reportPage.verifySortsortingofTableData(2);
    }





    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 006 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 6, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        //scrollPage = new Scroll_Page(driver);
        reportPage = new ReportPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        reportPage.clickOnReportTab();
       waitForloadSpinner();
   /* docobj.clickonGridIcon();
    Thread.sleep(5000);*/
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
}