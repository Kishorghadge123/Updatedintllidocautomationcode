package Tests;
import Pages.TemplatePage;
import Utilities.Custome_Wait;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
public class TemplateTest extends BaseTest{
    TemplatePage TemplatePageObj;
    SoftAssert softAssert;
    Custome_Wait custom;
    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 001  - Check Templates on user page ")
    @Description("verify_user_able_to_Check_Templates_on_user_page")
    @Test(priority = 1, groups = "smoke", description = "verify validation_type_as_name_on_Templates_on_user_page")
    public void verifySearchTemplatesOnUserPage() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom=new Custome_Wait(driver);
       waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
         waitForloadSpinner();
        TemplatePageObj.searchTemplatesName();
      custom.waitVisibility(driver,driver.findElement(By.xpath("//td[contains(text(),' QA-Automation ')]")));
        TemplatePageObj.clickOnTemplatesName();
        //verify training of templates classification
        String expectedTrainingTemplates = driver.findElement(By.xpath("(//button[text()=' Complete '])[2]")).getText();
        String actualTrainingTemplates = driver.findElement(By.xpath("(//button[text()=' Complete '])[3]")).getText();
        softAssert.assertEquals(expectedTrainingTemplates,actualTrainingTemplates);
        TemplatePageObj.clickOnclassificationName();
        waitForloadSpinner();
        TemplatePageObj.clickOnToggleButton();
        TemplatePageObj.clickOnToggleButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//i[@class='fa fa-search-plus']")));
        TemplatePageObj.clickOnZoomInButton();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//i[@class='fa fa-search-minus']")));
        TemplatePageObj.clickOnZoomOutButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Cancel ')]")));
        TemplatePageObj.clickOnCancelButton();

    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 002  - Sort List Of Templates ")
    @Description("verify_user_able_to_sort_Templates")
    @Test(priority = 2, groups = "smoke", description = "verify_validation_type_as_name_to_sort_Templates")
    public void verifySortingListOfTemplates() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom=new Custome_Wait(driver);
       waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.getSortByTemplates.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("ascending");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Templates ')]")));
        TemplatePageObj.getSortByTemplates.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("descending");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Pages ')]")));
        TemplatePageObj.getSortbyPages.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("ascending");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Pages ')]")));
        TemplatePageObj.getSortbyPages.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("descending");
        //verify the category sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Templates ')]")).getText(), "Templates");
        //verify the Datasets sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Projects ')]")).getText(), "Projects");
        //verify the Updated sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Training ')]")).getText(), "Training");
        //verify the created sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Pages ')]")).getText(), "Pages");

        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 003  - check add new category on Upload Templates Button")
    @Description("verify_user_able_to_click_on_Upload_Templates ")
    @Test(priority = 3, groups = "smoke", description = "verify_validation_type_as_name_to_upload_new_telplates")
    public void verifyNewUploadTemplatesButton() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom=new Custome_Wait(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
       waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));

        TemplatePageObj.createNewTemplateName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'close')])[3]")));

        TemplatePageObj.clickOnCanceltemplatesButton();
        //verify upload_templates button
        softAssert.assertTrue(TemplatePageObj.uploadTemplatesButton.isDisplayed());
        //verify Create New Template
        softAssert.assertTrue(TemplatePageObj.validateCreateNewTemplate.isDisplayed());
//      //verify error message on create new templates
//      softAssert.assertTrue(TemplatePageObj.validateErrorMessage.isDisplayed());

        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004  - Total Count Of Templatesin UserTab ")
    @Description("verify user able to check the total count on user tab")
    @Test(priority = 4, groups = "smoke", description = "verify_validation_type_as_check_total_count_on_usertab")
    public void verifyTheTotalCountOfTemplatesinUserTab() throws Exception {

        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom=new Custome_Wait(driver);
       waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnDropDown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[text()=' 200 ']")));
        TemplatePageObj.selectDropDownValue();
        Thread.sleep(5000);
        TemplatePageObj.userClickOnNextPageTab();
        //verify count of user in category on dataset page
        int expectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String actualCountOfUser = TemplatePageObj.getTotalUserCountOfItemPerPage();
        softAssert.assertEquals(expectedCountOfUserInTable,Integer.parseInt(actualCountOfUser));

    }
}
