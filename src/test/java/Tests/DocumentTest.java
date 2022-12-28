package Tests;

import Pages.DocumentPage;
import Pages.Project_Module;
import Utilities.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
        driver.close();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc01 - verify_Data_Extracted_From_Document")
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
      Thread.sleep(1000);


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc02 - Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    @Test(priority = 2, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    public void Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details() throws Exception {
        docobj = new DocumentPage(driver);
        scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
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
    @Story("story_id: Doc03 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 3, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Verify_Working_Of_Diagnosis_Without_Adding_Date_Encounter_Details() throws Exception {
        scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
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
    @Story("story_id: Doc04 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 4, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Edit_Encounter_Details() throws Exception {
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
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
    @Story("story_id: Doc05 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 5, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Without_Adding_HCC_Details() throws Exception {
        scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));

        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc06 - Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Description("Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Test(priority = 6, groups = "smoke", description = "Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    public void Verify_Without_Adding_DiagnosisName_In_HCC_Details() throws Exception {
        docobj = new DocumentPage(driver);
        scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
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
    @Story("story_id: Doc07 - Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Description("Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Test(priority = 7, groups = "smoke", description = "Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    public void Add_HCC_Details() throws Exception {
scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
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
    @Story("story_id: Doc08 - Delete_HCC_Details")
    @Description("Delete_HCC_Details")
    @Test(priority = 8, groups = "smoke", description = "Delete_HCC_Details")
    public void Delete_HCC_Details() throws Exception {
scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
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
    @Story("story_id: Doc09  - verify that user able to Check Document ")
    @Description("verify_that_user_able_to_Check_Document")
    @Test(priority = 9, groups = "smoke", description = "verify_that_user_able_to_Check_Document")
    public void verifyDocumentOnUserPage() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        docobj = new DocumentPage(driver);
        scrollPage=new Scroll_Page(driver);
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
        Thread.sleep(1000);
        docobj.clickOnRejectedCheckBox();
        Thread.sleep(1000);
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnApplyButton();
        softAssert.assertAll();
    }


//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: Doc010  - verify that user able to Check Document ")
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
//        docobj.selectProjectFromDropDown(i);
//        for (int i = 1; i < 5; i++) {
//            Thread.sleep(1000);
//
//            Thread.sleep(1000);
////            docobj.verifyTotalCountOfAllDocInAnalyticsSection();
////            Thread.sleep(3000);
////            docobj.clickOnDropdown();discuss
//        }
//
//    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc011 - Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    @Test(priority = 11, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Adding_Encounter_Details")
    public void Edit_Diagnosis_Details() throws Exception {
scrollPage=new Scroll_Page(driver);
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
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisName();
        Thread.sleep(2000);
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc012 - verifyActionButtonWorking")
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





    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: Doc014 -All DropDown Arrow In Table")
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
//        Thread.sleep(1000);
//        sortingLists.sortingListInOrder("ascending", 1);
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Documents ");
//        sortingLists.sortingListInOrder("descending", 1);
//        sortingLists.sortingListInOrder("ascending", 2);
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Assignee ");
//        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Assignee ']")).isEnabled());
//        sortingLists.sortingListInOrder("descending ", 2);
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Assignee ");
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Status ");
//        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Status ']")).isEnabled());
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Status ");
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Size ");
//        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Size ']")).isEnabled());
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Size ");
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Updated ");
//        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Updated ");
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Received ");
//        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Received ']")).isEnabled());
//        Thread.sleep(2000);
//        docobj.clickOnTableArrowDropDown(" Received ");
//        softAssert.assertAll();
//    }
//
//
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: Doc015 -The Total Count Of User in UserTab")
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
        Thread.sleep(3000);
//        docobj.clickOnDropdown();
     docobj.clickOnDropDown();
        docobj.selectDropDownValue();
        docobj.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = docobj.getUserCountOfatomperPage();
//        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc016 - Verify_the_Encounter_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    @Description("Verify_the_Encounter_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    @Test(priority = 16, groups = "smoke", description = "Verify_the_Encounter_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    public void verifyEncounterCountInPDFAnalytics() throws Exception {
        docobj = new DocumentPage(driver);
        //softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        Thread.sleep(2000);
        docobj.clickOnDropdown();
        docobj.selectProjectFromDropDown("888-Medical");
        docobj.openAnalyticsScreenOfADoc("B");
        waitForloadSpinner();
        docobj.clickOnChartData();
        docobj.clickOnDiagnosisTab();
        System.out.println("Number of Encounters in Diagnosis tab: "+docobj.getTotalEncounterCountFromDiagnosisTab());
        System.out.println("Total Encounter Count: "+docobj.getTotalEncounterCount());
        Assert.assertEquals(docobj.getTotalEncounterCountFromDiagnosisTab(), docobj.getTotalEncounterCount()
                ,"Encounter Count does not match.");
    }
//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: Doc017 - Verify_the_ICD_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
//    @Description("Verify_the_ICD_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
//    @Test(priority = 17, groups = "smoke", description = "Verify_the_ICD_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
//    public void verifyICDCountInPDFAnalytics() throws Exception {
//        docobj = new DocumentPage(driver);
//        //softAssert = new SoftAssert();
//        waitForloadSpinner();
//        docobj.clickOnDocumentTab();
//        waitForloadSpinner();
//        Thread.sleep(2000);
//        docobj.clickOnDropdown();
//        docobj.selectProjectFromDropDown("931-Medical-P");
//        docobj.openAnalyticsScreenOfADoc("inputDocs_Wipro POC_154 2090684801");
//        waitForloadSpinner();
//        docobj.clickOnChartData();
//        docobj.clickOnDiagnosisTab();
//        Thread.sleep(3000);
//        Assert.assertEquals(docobj.getTotalICDCountFromDiagnosisTab(), docobj.getTotalICDCount()
//                ,"Encounter Count does not match.");
//    }




    List<WebElement> documentTiles = null;
    @Story("story_id: Doc018 - Verify the Time taken by System")
    @Description("Verify the Time taken by System")
    @Test(priority = 18, groups = "smoke", description = "Verify the Time taken by System")
    public void Verify_Time_taken_by_System() throws Exception {
        softAssert = new SoftAssert();
        docobj=new DocumentPage(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        documentTiles = docobj.getListOfDocument();
        System.out.println(documentTiles.size());
        for (int i = 1; i <= documentTiles.size(); i++) {
            softAssert.assertTrue(DateTimeUtils.compareDates(docobj.getCreatedDateOfSearchedUserInGridView(),docobj.getUpdatedDateOfSearchedUserInGridView()
            ), "Updated Date ("+docobj.getUpdatedDateOfSearchedUserInGridView()+") is not greater than Created Date ("+docobj.getCreatedDateOfSearchedUserInGridView()+") for the user.");


        }
        softAssert.assertAll();
    }




    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: Doc019 - Verify_Working_Of_Patient_Demographics")
    @Description("Verify_Working_Of_Patient_Demographics")
    @Test(priority = 19, groups = "smoke", description = "Verify_Working_Of_Patient_Demographics")
    public void Verify_Working_Of_Patient_Demographics() throws Exception {

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
        docobj.clickOnPatientDempgraphics();
        Thread.sleep(1000);
     softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(text(),'Values')]")).getText(),"Values");
        softAssert.assertAll();


    }


//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: Doc020 - Verify_Working_Of_Patient_Demographics")
//    @Description("Verify_Working_Of_Patient_Demographics")
//    @Test(priority = 20, groups = "smoke", description = "Verify_Working_Of_Patient_Demographics")
//    public void Verify_Working_Of_Rejected_Document() throws Exception {
//
//        docobj = new DocumentPage(driver);
//        custom = new Custome_Wait(driver);
//        softAssert = new SoftAssert();
//        waitForloadSpinner();
//        docobj.clickOnDocumentTab();
//        waitForloadSpinner();
//        docobj.clickOnDropdown();
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
//        docobj.selectProject();
//        waitForloadSpinner();
//        docobj.clickOnRejectedDocument();
//        waitForloadSpinner();
//        softAssert.assertTrue(docobj.readydocname.isDisplayed());
//        softAssert.assertAll();
//        docobj.clickOnChartData();
//        Thread.sleep(1000);
//        docobj.clickOnPatientDempgraphics();
//        Thread.sleep(1000);
//        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(text(),'Values')]")).getText(),"Values");
//        softAssert.assertAll();
//
//
//    }
}