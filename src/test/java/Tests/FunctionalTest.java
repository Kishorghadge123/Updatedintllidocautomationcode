package Tests;
import Pages.FunctionalPage;
import Utilities.Custome_Wait;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FunctionalTest extends BaseTest {
    FunctionalPage functional;
    Custome_Wait custom;
    SoftAssert softassert;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F001  - Check user button is working ")
    @Description("Check user button is working")
    @Test(priority = 1, groups = "smoke", description = " Check user button is working")
    public void verifyUserButtonIsWorking() throws Exception {
functional=new FunctionalPage(driver);
softassert=new SoftAssert();
waitForloadSpinner();
functional.clickOnUserTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Users.svg\")]")).getText(),"Users");
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F002  - Check Role button is working ")
    @Description("Check Role button is working ")
    @Test(priority = 2, groups = "smoke", description = " Check Role button is working ")
    public void Check_Role_button_is_working () throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnRoleTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Roles.svg\")]")).getText(),"Roles");



    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F003  - Check Dataset button is working ")
    @Description("Check Dataset button is working")
    @Test(priority = 3, groups = "smoke", description = " Check Dataset button is working")
    public void verifyDatasetButtonIsWorking() throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnDatasetTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Datasets.svg\")]")).getText(),"Datasets");



    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F004  - Check Template button is working ")
    @Description("Check Template button is working")
    @Test(priority = 4, groups = "smoke", description = " Check Template button is working")
    public void verifyTempalteButtonIsWorking() throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnTemplate();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Template.svg\")]")).getText(),"Template");



    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F005  - Check Project button is working ")
    @Description("Check Project button is working")
    @Test(priority = 5, groups = "smoke", description = " Check Project button is working")
    public void verifyProjectButtonIsWorking() throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnProjectTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Projects.svg\")]")).getText(),"Projects");



    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F006  - Check Document button is working ")
    @Description("Check Document button is working")
    @Test(priority = 6, groups = "smoke", description = " Check user button is working")
    public void verifyDocumentButtonIsWorking() throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnDocumentTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Documents.svg\")]")).getText(),"Documents");



    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F007  - Check Audit button is working ")
    @Description("Check Audit button is working")
    @Test(priority = 7, groups = "smoke", description = " Check user button is working")
    public void verifyAuditButtonIsWorking() throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnAuditTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Auditor.svg\")]")).getText(),"Auditor");



    }




    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F008  - Check Report button is working ")
    @Description("Check Report button is working")
    @Test(priority = 8, groups = "smoke", description = " Check Report button is working")
    public void verifyReportButtonIsWorking() throws Exception {
        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnReportTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Report.svg\")]")).getText(),"Report");



    }




    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F009  - Check Analytics button is working ")
    @Description("Check Analytics button is working")
    @Test(priority = 9, groups = "smoke", description = " Check Analytics button is working")
    public void verifyAnalyticsButtonIsWorking() throws Exception {

        functional=new FunctionalPage(driver);
        softassert=new SoftAssert();
        waitForloadSpinner();
        functional.clickOnAnalyticsTab();
        softassert.assertEquals(driver.findElement(By.xpath("//img[contains(@src,\"Analytics.svg\")]")).getText(),"Analytics");



    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F010  - Check edit functionality is working ")
    @Description("Check edit functionality is working")
    @Test(priority = 10, groups = "smoke", description = " Check edit functionality is working")
    public void CheckEditFunctionality() throws Exception {

        functional = new FunctionalPage(driver);
        softassert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        functional.clickOnEdit();
        softassert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),' NTS Platform Admin ')]")).getText(),"NTS Platform Admin");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[@id='profile-modal-button']")));
        functional.clickOnEditProfile();
        softassert.assertEquals(driver.findElement(By.xpath("//h6[contains(text(),'Please upload PNG or JPEG with resolution less than 400*400 and size less than 1 MB.')]")).getText(), "Please upload PNG or JPEG with resolution less than 400*400 and size less than 1 MB.");
       functional.clickOnCancelButton();
    }








    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F011  - Check save button is working ")
    @Description("Check save button is working")
    @Test(priority = 11, groups = "smoke", description = " Check save button is working")
    public void verifySaveFunctionality() throws Exception {

        functional = new FunctionalPage(driver);
        softassert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        functional.clickOnEdit();
        softassert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),' NTS Platform Admin ')]")).getText(),"NTS Platform Admin");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[@id='profile-modal-button']")));
        functional.clickOnEditProfile();
        softassert.assertEquals(driver.findElement(By.xpath("//h6[contains(text(),'Please upload PNG or JPEG with resolution less than 400*400 and size less than 1 MB.')]")).getText(), "Please upload PNG or JPEG with resolution less than 400*400 and size less than 1 MB.");
        functional.clickOnSaveButton();
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F012  - Check edit theme is working ")
    @Description("Check edit themeAnalytics button is working")
    @Test(priority = 12, groups = "smoke", description = " Check edit theme is working")
    public void verifyEditTheme() throws Exception {

        functional = new FunctionalPage(driver);
        softassert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        functional.clickOnEdit();
        softassert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),' NTS Platform Admin ')]")).getText(),"NTS Platform Admin");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Theme ')]")));
       functional.clickOnTheme();
       waitForloadSpinner();
       functional.selectTheme();
       Thread.sleep(1000);
       functional.clickOnApplyButton();

    }



    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F013  - verifyHomePageArrow")
    @Description("verifyHomePageArrow")
    @Test(priority = 13, groups = "smoke", description = "verifyHomePageArrow")
    public void verifyHomePageArrow() throws Exception {

        functional = new FunctionalPage(driver);
        softassert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        functional.clicOnArrow();
    }


}
