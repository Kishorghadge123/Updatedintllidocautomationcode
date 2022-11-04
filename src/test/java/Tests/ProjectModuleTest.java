package Tests;


import Pages.CreateRolePage;
import Pages.Project_Module;
import Utilities.Custome_Wait;
import Utilities.SortingLists;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ProjectModuleTest extends BaseTest {
    Project_Module project;
    SoftAssert softAssert;
    Custome_Wait custom;
    CreateRolePage createRolePage;
    SortingLists sortingLists;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//
//    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 001 - Search Created Project")
    @Description("verify_user_able_to_Search_Created_Project")
    @Test(priority = 1, groups = "smoke", description = "verify_user_able_to_Search_Created_Project")
    public void Search_Created_Project() throws Exception {

        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation-FreeForm ");

    }

//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: 002 - Update Created Project")
//    @Description("verify_user_able_to_Update_Created_Project")
//    @Test(priority = 2, groups = "smoke", description = "verify_user_able_to_Update_Created_Project")
//    public void Update_Created_Project() throws Exception {
//        softAssert = new SoftAssert();
//        custom=new Custome_Wait(driver);
//        project = new Project_Module(driver);
//        waitForloadSpinner();
//        project.clickOnCreateProjectButton();
//        waitForloadSpinner();
//        project.verifyProjectIsUpdated("pratiksha.bagal@neutrinotechlabs.com");
//        project.selectDateRange("2022", "OCT", "20", "1");
//        project.selectDateRange("2022", "OCT", "23", "2");
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[1]")));
//        project.clickstatustogglebutton();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[2]")));
//        project.clickondocumentautoassignmentogglebtn();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[3]")));
//        project.clickauditenabletogglebtn();
//        Thread.sleep(1000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,80000)", "");
//        Thread.sleep(3000);
//        project.clickonrolelabel();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//span[contains(text(),' Next')])")));
//        project.clickonnextbutton();
//        waitForloadSpinner();
//        project.clickondatasetlabel();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Add Dataset ')]")));
//        project.clickonadddatasetbtn();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[contains(text(),'PratikshaQA')]")));
//        project.clickondataset();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[contains(text(),' QA-Automation ')]")));
//        project.selectdataset();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//button[@class='mat-focus-indicator foregroundColor mat-mini-fab mat-button-base mat-accent'])[5]")));
//        project.deletedataset();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Variables')]")));
//        project.clickonvariablelabel();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Add Variable ')]")));
//        project.addvariable();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@id=\"variableName\"]")));
//        project.enterVariableName("Address");
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@id=\"variableName\"]//following::span[2]")));
//        project.clickvalidationtypelabel();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),'Address ')]")));
//        project.selectvalidationtype();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[@class='mat-focus-indicator ml-2 mat-stroked-button mat-button-base mat-accent']")));
//        project.canceldataset();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//span[contains(text(),'Next')])[2]")));
//        project.clickOnNextButton();
//      waitForloadSpinner();
//        project.clickOnRuleModel();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//mat-select[@role='combobox'])[10]")));
//        project.clickOnAttributDropdown();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]")));
//        project.selectatrribute();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//mat-select[@placeholder=\" Operator\"]")));
//        project.selectoperatodropdown();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("(//span[contains(text(),' contains ')])[1]")));
//        project.selectoperator();
//        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),' Update ')]")));
//        project.clickUpdate1();
//       waitForloadSpinner();
//        softAssert.assertAll();
//    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 003 - Create Project With Blank Data")
    @Description("verify_user_able_to_Create_Project_With_Blank_Data")
    @Test(priority = 3, groups = "smoke", description = "verify_user_able_to_Create_Project_With_Blank_Data")
    public void Create_Project_With_Blank_Data() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.projectnamerrmsg.isDisplayed());
        softAssert.assertTrue(project.leaderrormsg.isDisplayed());
        softAssert.assertTrue(project.startdateerrmsg.isDisplayed());
        softAssert.assertTrue(project.enddateerrmsg.isDisplayed());
        softAssert.assertTrue(project.documentstructureerrmsg.isDisplayed());
        Thread.sleep(3000);
        project.clickOnCreateButton();
        softAssert.assertTrue(project.projectcreateerrmsg.isDisplayed());
        project.clickOnCancelButton();
        waitForloadSpinner();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004 - Create Project Without Selecting Processing Engine and Templates")
    @Description("verify_that_user_able_to_Create_Project_Without_Selecting_Processing_Engine_and_Templates")
    @Test(priority = 4, groups = "smoke", description = "verify_that_user_able_to_Create_Project_Without_Selecting_Processing_Engine_and_Templates")
    public void Create_Project_Without_Selecting_Processing_Engine_And_Template() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.processengineerrmsg.isDisplayed());
        softAssert.assertTrue(project.templatecreateerrmsg.isDisplayed());
        project.clickOnCancelButton();
        waitForloadSpinner();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 005 - Create Project Without Role and user")
    @Description("verify_that_user_able_to_Create_Project_without_Role_and_user")
    @Test(priority = 5, groups = "smoke", description = "verify_that_user_able_to_Create_Project_without_Role_and_user")
    public void Create_Project_Without_Without_Role_And_User() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.selectprocessengindropdown();
        project.selectprocessingengine();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        softAssert.assertTrue(project.templatemsg.isDisplayed());
        project.clickAddTemplateButton();
        Thread.sleep(2000);
        project.selectTemplate();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.rolecreateerrmsg.isDisplayed());
        project.clickOnCancelButton();
        waitForloadSpinner();
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 006 - Create Project Without  and user")
    @Description("verify_that_user_able_to_Create_Project_without_and_user")
    @Test(priority = 6, groups = "smoke", description = "verify_that_user_able_to_Create_Project_without_and_user")
    public void Create_Project_Without_User() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.selectprocessengindropdown();
        project.selectprocessingengine();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        softAssert.assertTrue(project.templatemsg.isDisplayed());
        project.clickAddTemplateButton();
        Thread.sleep(2000);
        project.selectTemplate();
        project.clickonrolelabel();
        project.clickOnAddRoleButton();
        project.selectRole();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.usercreaterrmsg.isDisplayed());

    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 007 - Create Project Without  and user")
    @Description("verify_that_user_able_to_Create_Project_without_and_user")
    @Test(priority = 7, groups = "smoke", description = "verify_that_user_able_to_Create_Project_without_and_user")
    public void Create_Project_Without_When_User_is_disable() throws Exception {
        softAssert = new SoftAssert();
        custom=new Custome_Wait(driver);
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        custom.waitVisibility(driver,driver.findElement(By.xpath("//span[contains(text(),'Roles')]")));
        project.clickonrolelabel();
     custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'add_circle_outline')])[2]")));
     project.clickonroleplusbutton();
     softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'PratikshaQA role is Disabled')]")).getText(),"PratikshaQA role is Disabled");
    }

    @Story("story_id: 008 - verify that all disabled roles are not displayed in add role& lead list while creating a project by platform admin")
    @Description("verify_that_all_disabled_roles_are_not_displayed_in_add_role&lead_list_while_creating_project_by_platform_admin")
    @Test(priority = 8, groups = "smoke", description = "verify_that_all_disabled_roles_are_not_displayed_in_add_role&lead_list_while_creating_project_by_platform_admin")
    public void verifyDisabledRoles() throws Exception {
        createRolePage = new CreateRolePage(driver);
        softAssert=new SoftAssert();
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchRoleInRolePage("QAdisable");
        Thread.sleep(2000);
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.clickOnUpdateButton();
        Thread.sleep(1000);
        createRolePage.clickOnYes();
       waitForloadSpinner();
        project =new Project_Module(driver);
        project.clickOnProjectPage();
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.clickOnRoleLabel();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        project.clickOnAddRoleButton();
        Thread.sleep(2000);
        project.clickOnSearchRole("QAdisable");
        String text= driver.findElement(By.xpath("//div[contains(text(),' No Records Found ! ')]")).getText();
        System.out.println(text);
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' No Records Found ! ')]")).getText(), " No Records Found ! ");


    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 009 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 9, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        project.clickonGridIcon();
        Thread.sleep(5000);
        project.clickOnTableArrowDropDown(" Projects ");
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 1);
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Projects ");
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 2);
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown("Document Structure ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()='Document Structure ']")).isEnabled());
        sortingLists.sortingListInOrder("descending ", 2);
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown("Document Structure ");
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Lead ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Lead ']")).isEnabled());
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Lead ");
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(1000);
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(1000);
   /* project.clickOnTableArrowDropDown(" Created ");
    softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Created ']")).isEnabled());
    project.clickOnTableArrowDropDown(" Created ");*/
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 010 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 10, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        project = new Project_Module(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        project.clickonGridIcon();
        Thread.sleep(5000);
        project.clickOnDropDown();
        project.selectDropDownValue();
        project.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = project.getUserCountOfatomperPage();
//        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }

}
