package Tests;

import Pages.AuditPage;
import Utilities.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AuditTest extends BaseTest {
    AuditPage auditPage;
    SortingLists sortingLists;
    ClickOnOutSide clickOnOutSide;
    VerifyTextOfTable verifyTextOfTable;
    SelectDates selectDateRange;
    Custome_Wait custom;
    SoftAssert softAssert;
    Scroll_Page scroll_page;

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
    @Story("story_id: 001 - verify Drop Downs Of Analytics And Filters In AuditPage")
    @Description("verify Drop Downs Of Analytics And Filters In AuditPage")
    @Test(priority = 1, groups = "smoke", description = "verify Drop Downs Of Analytics And Filters In AuditPage")
    public void verifyDropDownsOfAnalyticsAndFiltersInAuditPage() throws Exception {
        auditPage = new AuditPage(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(1);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'row user-info-container ng-tns-c')])[1]")).isDisplayed());
        auditPage.ClickOnDropDownsInAuditPage(2);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'row user-info-container ng-tns-c')])[2]")).isDisplayed());
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 002 - verify total Count Of Audited and Audit Pending documents")
    @Description("verify_total_Count_of_Audited_and_Audit_Pending_documents")
    @Test(priority = 2, groups = "smoke", description = "verify_total_Count_of_Audited_and_Audit_Pending_documents")
    public void verifyTotalCountOfAuditedAndAuditPendingDoc() throws Exception {
        auditPage = new AuditPage(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.selectProject();
        waitForloadSpinner();
        Assert.assertEquals(Integer.parseInt(auditPage.verifyTheTotalCountOfAuditedAndAuditPendingDoc(2)) + Integer.parseInt(auditPage.verifyTheTotalCountOfAuditedAndAuditPendingDoc(3)),
                Integer.parseInt(auditPage.verifyTheTotalCountOfAuditedAndAuditPendingDoc(1)));
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 003 - verify All Filters Of Filter DropDown")
    @Description("verify_all_filters_of_filter_DropDown")
    @Test(priority = 3, groups = "smoke", description = "verify_all_filters_of_filter_DropDown")
    public void verifyAllFiltersOfFilterDropDown() throws Exception {
        auditPage = new AuditPage(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(2);
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'text-right ng-tns-c')]//span[contains(text(),'Apply')]")).getText(), "Apply");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'text-right ng-tns-c')]//span[contains(text(),'Clear')]")).getText(), "Clear");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004 - verify the user able to sort the table from data")
    @Description("verify_the_user_able_to_sort_the_table_from_data")
    @Test(priority = 4, groups = "smoke", description = "verify_the_user_able_to_sort_the_table_from_data")
    public void verifytableDataisSorting() throws Exception {
        auditPage = new AuditPage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        custom=new Custome_Wait(driver);
        sortingLists = new SortingLists(driver);
        Scroll_Page scroll_page = new Scroll_Page(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        Thread.sleep(5000);
        auditPage.selectProject();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(2);
        custom.waitVisibility(driver,driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')])[2]")));
        auditPage.clickStatusDropDownArrow();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        Thread.sleep(2000);
        clickOnOutSide.clickOutside();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-flat-button mat-button-base mat-primary')]//span[contains(text(),'Apply')])[2]")));
        auditPage.clickOnApplyFilter();
       waitForloadSpinner();
        auditPage.verifySortsortingofTableData(1);
        sortingLists.sortingListInOrder("ascending", 1);
      waitForloadSpinner();
        auditPage.verifySortsortingofTableData(1);
        sortingLists.sortingListInOrder("descending", 2);
       waitForloadSpinner();
        auditPage.verifySortsortingofTableData(2);
        sortingLists.sortingListInOrder("ascending", 2);
     waitForloadSpinner();
        auditPage.verifySortsortingofTableData(2);
        sortingLists.sortingListInOrder("descending", 2);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 005 - verfiy Doc Status Is Diaplay In Table As Per Filters")
    @Description("verfiyDocStatusIsDiaplayInTableAsPerFilter")
    @Test(priority = 5, groups = "smoke", description = "verfiyDocStatusIsDiaplayInTableAsPerFilter")
    public void verfiyDocStatusIsDiaplayInTableAsPerFilter() throws Exception {
        auditPage = new AuditPage(driver);
        custom=new Custome_Wait(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.selectProject();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(2);
        auditPage.clickStatusDropDownArrow();
     custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
     auditPage.clickOnPendingStatus();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));

        auditPage.clickOnPendingStatus();
        clickOnOutSide.clickOutside();
        Thread.sleep(2000);
        auditPage.clickOnApplyFilter();
        waitForloadSpinner();
        verifyTextOfTable.verfiyDisplayStatusOfDoc("Pending", 3);
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')])[2]")));
        auditPage.clickStatusDropDownArrow();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnAuditedStatus();
        clickOnOutSide.clickOutside();
        Thread.sleep(2000);
        auditPage.clickOnApplyFilter();
       waitForloadSpinner();
        verifyTextOfTable.verfiyDisplayStatusOfDoc("Audited", 3);
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 006 - verify Text Of Audit Tab")
    @Description("verify Text Of Audit Tab")
    @Test(priority = 6, groups = "smoke", description = "verify Text Of Audit Tab")
    public void verifyTextOfAuditTab() throws Exception {
        auditPage = new AuditPage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        SoftAssert softAssert = new SoftAssert();
        custom=new Custome_Wait(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.selectProject();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(2);
        auditPage.clickStatusDropDownArrow();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        clickOnOutSide.clickOutside();
       custom.waitVisibility(driver, driver.findElement(By.xpath("(//table/tbody/tr/td[8])[1]")));
        auditPage.clickOnActionButtoninTable();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),' Save Draft')]")).getText(), "Save Draft");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).getText(), "Submit");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Release')]")).getText(), "Release");
        softAssert.assertAll();
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 007 - verify_That_Data_Extracted_From_Document")
    @Description("verify_That_Data_Extracted_From_Document")
    @Test(priority = 7, groups = "smoke", description = "verify_That_Data_Extracted_From_Document")
    public void verify_That_Data_Extracted_From_Document() throws Exception {
        auditPage = new AuditPage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        custom=new Custome_Wait(driver);
        scroll_page = new Scroll_Page(driver);
        SoftAssert softAssert = new SoftAssert();
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.selectProject();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(2);
        auditPage.clickStatusDropDownArrow();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Pending ')]")));
        auditPage.clickOnPendingStatus();
        clickOnOutSide.clickOutside();
        Thread.sleep(2000);
        auditPage.clickOnActionButtoninTable();
        waitForloadSpinner();
        auditPage.clickOnClassificationTab();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//div[contains(@role,'listbox')]")));
        auditPage.SelectChatsDropDown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')]//div[contains(@class,'mat-select-arrow ng-tns')])[1]")));
        auditPage.SelectChatLevelFlagsDropDown();
        Thread.sleep(2000);
        auditPage.SelectChatLevelFlags(1);
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(@class,'mat-expansion-indicator ng-tns-c')]")));
        auditPage.clickOnChatCardDropDown();
        Thread.sleep(2000);
        softAssert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'chronicConditionsTable ng-star-inserted')]")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Kordus, Elaine M')])[1]")).getText().split("Elaine")[0].strip(), "Kordus,");
        Thread.sleep(2000);
        scroll_page.ScrollUpDown(auditPage.ssn);
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 008 - verifyTheClearFilterButtonInFilter")
    @Description("verifyTheClearFilterButtonInFilter")
    @Test(priority = 8, groups = "smoke", description = "verifyTheClearFilterButtonInFilter", enabled = true)
    public void verifyTheClearFilterButtonInFilter() throws Exception {
        auditPage = new AuditPage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        verifyTextOfTable = new VerifyTextOfTable(driver);
        selectDateRange = new SelectDates(driver);
        custom=new Custome_Wait(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
        auditPage.ClickOnDropDownsInAuditPage(2);
        custom.waitVisibility(driver,driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//input[contains(@type,'text')])[2]")));
        auditPage.enterDocName("Medical Chat");
        custom.waitVisibility(driver,driver.findElement(By.xpath("(//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')]//div[contains(@class,'mat-select-arrow ng-tns-c')])[1]")));
        auditPage.clickOnassigneeDropDown();
        custom.waitVisibility(driver,driver.findElement(By.xpath("(//mat-option[contains(@class,'mat-option mat-focus-indicator mat-option-multiple mat-active')])[1]")));
        auditPage.clickInCheckBoxOnAssignees();
        clickOnOutSide.clickOutside();
        Thread.sleep(4000);
        selectDateRange.selectDateRange("2022", "OCT", "20", "1");
        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),'Clear')]")));
        auditPage.clickOnClearButton();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mat-input-3']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='mat-select-value-1']")).getText(), "");
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 006 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 6, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        auditPage = new AuditPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
        waitForloadSpinner();
//        auditPage.clickonGridIcon();
//        Thread.sleep(2000);
        auditPage.clickOnTableArrowDropDown(" Documents ");
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 1);
        auditPage.clickOnTableArrowDropDown(" Documents ");
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(4000);
        sortingLists.sortingListInOrder("ascending", 2);
        auditPage.clickOnTableArrowDropDown(" Auditor ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Auditor ']")).isEnabled());
        sortingLists.sortingListInOrder("descending ", 2);
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Auditor ");
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Status ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Status ']")).isEnabled());
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Status ");
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Size ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Size ']")).isEnabled());
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Size ");
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Updated ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Received ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Received ']")).isEnabled());
        Thread.sleep(1000);
        auditPage.clickOnTableArrowDropDown(" Received ");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 005 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 5, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        //scrollPage = new Scroll_Page(driver);
        auditPage = new AuditPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        auditPage.clickOnauditTab();
       waitForloadSpinner();
   /* docobj.clickonGridIcon();
    Thread.sleep(5000);*/
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(5000);
        auditPage.clickOnDropDown();
        auditPage.selectDropDownValue();
        auditPage.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = auditPage.getUserCountOfatomperPage();
        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }

}