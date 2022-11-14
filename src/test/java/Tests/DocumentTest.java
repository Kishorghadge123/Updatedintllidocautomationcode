package Tests;

import Pages.DocumentPage;
import Utilities.Custome_Wait;
import Utilities.Scroll_Page;
import Utilities.SelectDates;
import Utilities.SortingLists;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DocumentTest extends BaseTest {
    DocumentPage docobj;
    SoftAssert softAssert;
    Custome_Wait custom;
    SortingLists sortingLists;
    Scroll_Page scrollPage;

    @BeforeMethod
    public void setupmethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 001 - verify_Data_Extracted_From_Document")
    @Description("verify_Data_Extracted_From_Document")
    @Test(priority = 1, groups = "smoke", description = "verify_Data_Extracted_From_Document")
    public void verify_Data_Extracted_From_Document() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnSize();
        Thread.sleep(3000);
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text() ,' Save Draft')]")));
        docobj.clickOnSaveDraftButton();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 002 - Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    @Test(priority = 2, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    public void Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnSave();
        Thread.sleep(2000);
        softAssert.assertTrue(docobj.npierromsg.isDisplayed());
        softAssert.assertTrue(docobj.doctorerrmsg.isDisplayed());
        softAssert.assertTrue(docobj.startdateerrmsg.isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 003 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 3, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Verify_Working_Of_Diagnosis_Without_Adding_Date_Encounter_Details() throws Exception {

        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnSave();
        Thread.sleep(2000);
        docobj.enterNpiNo("122");
        docobj.enterDoctorName("Sinha");
        docobj.clickOnSave();
        softAssert.assertTrue(docobj.startdateerrmsg.isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 4, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Edit_Encounter_Details() throws Exception {
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnSave();
        Thread.sleep(2000);
        docobj.enterNpiNo("122");
        docobj.enterDoctorName("Sinha");
        docobj.clickOnCancel();
        Thread.sleep(2000);
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 005 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 5, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Without_Adding_HCC_Details() throws Exception {

        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 006 - Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Description("Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Test(priority = 6, groups = "smoke", description = "Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    public void Verify_Without_Adding_DiagnosisName_In_HCC_Details() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        docobj.clickOnHCCSaveBtn();


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 007 - Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Description("Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Test(priority = 7, groups = "smoke", description = "Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    public void Add_HCC_Details() throws Exception {

        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@name=\"Diagnosis\"]")));
        docobj.eneterDiasesname("CUFF");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));
        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("e11");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(), 'Type 2 diabetes mellitus with hyperosmolarity with coma')]")));
        docobj.selectDescriptionType();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 008 - Delete_HCC_Details")
    @Description("Delete_HCC_Details")
    @Test(priority = 8, groups = "smoke", description = "Delete_HCC_Details")
    public void Delete_HCC_Details() throws Exception {

        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));

        docobj.clickOnAddHccPlusBtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@name=\"Diagnosis\"]")));
        docobj.eneterDiasesname("CUFF");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));

        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("e11");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(), 'Type 2 diabetes mellitus with hyperosmolarity with coma')]")));
        docobj.selectDescriptionType();
        Thread.sleep(2000);
        docobj.clickOnHCCSaveBtn();
        Thread.sleep(3000);
        docobj.deleteDiagnosis();
        Thread.sleep(1000);

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 09  - verify that user able to Check Document ")
    @Description("verify_that_user_able_to_Check_Document")
    @Test(priority = 9, groups = "smoke", description = "verify_that_user_able_to_Check_Document")
    public void verifyDocumentOnUserPage() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        docobj = new DocumentPage(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentPage();
        waitForloadSpinner();
        docobj.clickOnSearchDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation BRE ')]")));
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        docobj.clickOnKeyboardArrayDown();
        softAssert.assertTrue(docobj.validateFilter.isDisplayed());
        softAssert.assertTrue(docobj.validateDocumnetName.isDisplayed());
        softAssert.assertTrue(docobj.validateAssignee.isDisplayed());
        Thread.sleep(2000);
        docobj.clickOnAssigneeDropDown();
        Thread.sleep(1000);
        docobj.clickUnassignedCheckBox();
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnStatusDropDown();
        docobj.clickOnReadyCheckBox();
        docobj.clickOnRejectedCheckBox();
        ;
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnApplyButton();
        waitForloadSpinner();
        docobj.clickOnStatusDropDown();
        Thread.sleep(2000);
        docobj.clickOnRejectedCheckBox();
        docobj.clickOnProcessedCheckBox();
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnApplyButton();
        softAssert.assertAll();
    }


//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: 010  - verify that user able to Check Document ")
//    @Description("verify_that_user_able_to_Check_Document")
//    @Test(priority = 10, groups = "smoke", description = "verify_that_user_able_to_Check_Document")
//    public void verifyTotalCountOfDocumentTab() throws Exception {
//        docobj = new DocumentPage(driver);
//        softAssert = new SoftAssert();
//        waitForloadSpinner();
//        docobj.clickOnDocumentPage();
//        waitForloadSpinner();
//        docobj.clickOnDropdown();
//        Thread.sleep(2000);
//        for (int i = 1; i < 5; i++) {
//            Thread.sleep(1000);
//            docobj.selectProjectFromDropDown(i);
//            Thread.sleep(1000);
////            docobj.verifyTotalCountOfAllDocInAnalyticsSection();
////            Thread.sleep(3000);
////            docobj.clickOnDropdown();discuss
//        }
//
//    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 011 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 11, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Edit_Diagnosis_Details() throws Exception {

        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        docobj.clickOnAddDiagnosisName();
        Thread.sleep(2000);
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 012 - verifyActionButtonWorking")
    @Description("verifyActionButtonWorking")
    @Test(priority = 12, groups = "smoke", description = "verifyActionButtonWorking")
    public void verifyActionButtonWorking() throws Exception {

        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnActionButton();
        waitForloadSpinner();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        softAssert.assertEquals(url, "https://alpha.neutrino-ai.com/#/home/documents/processed-forms?faxPageId=6331536c22fa465b7feb999b&imageName=MedicalReady.pdf&type=pdf&size=1-Pages&invalidFileFormat=false&corruptedFile=false&_st=Ready&navigationLink=.%2Fhome%2Fdocuments");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 13 - verifySubmitButtonFunctinality")
    @Description("verifySubmitButtonFunctinality")
    @Test(priority = 13, groups = "smoke", description = "verifySubmitButtonFunctinality")
    public void verifySubmitButtonFunctinality() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        docobj = new DocumentPage(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentPage();
        waitForloadSpinner();
        docobj.clickOnSearchDropdown();
        Thread.sleep(2000);
        docobj.clickonsearchProjectName();
        Thread.sleep(2000);
        docobj.clickOnKeyboardArrayDown();
        softAssert.assertTrue(docobj.validateFilter.isDisplayed());
        softAssert.assertTrue(docobj.validateDocumnetName.isDisplayed());
        softAssert.assertTrue(docobj.validateAssignee.isDisplayed());
        Thread.sleep(2000);
        docobj.clickOnStatusDropDown();
        docobj.clickOnProcessedCheckBox();
        Thread.sleep(1000);
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnApplyButton();
        Thread.sleep(2000);
        softAssert.assertAll();
        docobj.clickOnClearButton();
        Thread.sleep(1000);
        docobj.clickOnStatusDropDown();
        docobj.clickOnProcessedCheckBox();
        Thread.sleep(1000);
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnApplyButton();

    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 014 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 14, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        docobj = new DocumentPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
//        auditPage.clickonGridIcon();
//        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Documents ");
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 1);
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Documents ");
        sortingLists.sortingListInOrder("descending", 1);
        sortingLists.sortingListInOrder("ascending", 2);
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Assignee ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Assignee ']")).isEnabled());
        sortingLists.sortingListInOrder("descending ", 2);
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Assignee ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Status ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Status ']")).isEnabled());
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Status ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Size ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Size ']")).isEnabled());
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Size ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Updated ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Received ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Received ']")).isEnabled());
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Received ");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 015 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 15, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        scrollPage = new Scroll_Page(driver);
        softAssert = new SoftAssert();
        docobj = new DocumentPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
   /* docobj.clickonGridIcon();
    Thread.sleep(5000);*/
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(5000);
        docobj.clickOnDropDown();
        docobj.selectDropDownValue();
        docobj.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = docobj.getUserCountOfatomperPage();
//        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }


}
