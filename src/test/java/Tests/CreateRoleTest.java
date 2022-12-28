package Tests;

import Pages.*;
import Utilities.ClickOnOutSide;
import Utilities.Custome_Wait;
import Utilities.DateTimeUtils;
import Utilities.SortingLists;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

@Feature("test to create role")
public class CreateRoleTest extends BaseTest {
    CreateRolePage createRolePage;
    ClickOnOutSide clickOnOutSide;
    SoftAssert softAssert;
    Custome_Wait custom;
    SortingLists sortingLists;
    Project_Module project;
    DocumentPage documentPage;

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
    @Story("story_id: C001 - verify that user is able to create new role with permission")
    @Description("verify_that_user_is_able_to_create_new_role_with_permission")
    @Test(priority = 1, groups = "smoke", description = "verify_that_user_is_able_to_create_new_role_with_permission")
    public void verifyCreateNewRoleWithPermisson() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.clickCreateRoleBtn();
        waitForloadSpinner();
        createRolePage.EnterNewRoleName("Om_");
        createRolePage.activateButton();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Only alphabets,digits,parenthesis and hyphens are allowed.')]")).getText(), "Only alphabets,digits,parenthesis and hyphens are allowed.");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Add permission ')]")));
        createRolePage.addPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Role')]")));
        createRolePage.roleOption();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' View Role')]")));
        createRolePage.roleSubOpnBtn1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Update Role')]")));
        createRolePage.roleSubOpnBtn2();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Create Role')]")));
        createRolePage.roleSubOpnBtn3();
        clickOnOutSide.clickOutside();
        createRolePage.createButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Please enter a valid role name before creating.");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C002 - verify role with invalid data details and cancel")
    @Description("verify_role_with_invalid_data_details_and_cancel")
    @Test(priority = 2, groups = "smoke", description = "verify_role_with_invalid_data_details_and_cancel")
    public void verifyRolewithInvalidData() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.clickCreateRoleBtn();
        waitForloadSpinner();
        createRolePage.EnterNewRoleName("O");
        createRolePage.activateButton();
        createRolePage.activateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter at least 3 characters.')]")).getText(), "Please enter at least 3 characters.");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Add permission ')]")));
        createRolePage.addPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Role')]")));
        createRolePage.roleOption();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' View Role')]")));
        createRolePage.roleSubOpnBtn1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Update Role')]")));
        createRolePage.roleSubOpnBtn2();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Create Role')]")));
        createRolePage.roleSubOpnBtn3();
        clickOnOutSide.clickOutside();
        createRolePage.cancelButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C003 - verifyRolewithBlankData")
    @Description("verifyRolewithBlankData")
    @Test(priority = 3, groups = "smoke", description = "verifyRolewithBlankData")
    public void verifyRolewithBlankData() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.clickCreateRoleBtn();
        waitForloadSpinner();
        createRolePage.createButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),' Please enter some permission for the role to be created. ')]")).getText(), " Please enter some permission for the role to be created. ");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter the role name.')]")).getText(), "Please enter the role name.");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C004 -  Updating the role by adding new permission.")
    @Description("r Updating the role by adding new permission.")
    @Test(priority = 4, groups = "smoke", description = "r Updating the role by adding new permission.")
    public void Updating_role_by_adding_new_permission() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.cancelPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Add permission ')]")));
        createRolePage.addPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Role')]")));
        createRolePage.roleOption();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' View Role')]")));
        createRolePage.roleSubOpnBtn1();
        clickOnOutSide.clickOutside();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management");
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C005 - Serach created role")
    @Description("Serach created role")
    @Test(priority = 5, groups = "smoke", description = "Serach created role")
    public void serach_created_role() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management/edit-role/6352491b81a6482eb26c0dcb");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C006 - Delete All Permissions")
    @Description("Delete All Permissions")
    @Test(priority = 6, groups = "smoke", description = "Delete All Permissions")
    public void delete_All_Permissions() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        driver.findElement(By.xpath("//mat-icon[contains(text(),' list ')]")).click();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'cancel')])[1]")));
        createRolePage.cancelPermission1();
       Thread.sleep(500);
        createRolePage.cancelPermission1();
       Thread.sleep(500);
       createRolePage.clickOnUpdate();
       waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.addPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Role')]")));
        createRolePage.roleOption();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' View Role')]")));
        createRolePage.roleSubOpnBtn1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Update Role')]")));
        createRolePage.roleSubOpnBtn2();




    }


    @Story("story_id: C007 - Update role button when Active Role toggle button is enabled disable")
    @Description("Update role button when Active Role toggle button is enabled disable")
    @Test(priority = 7, groups = "smoke", description = "update role button when Active Role toggle button is enabled disable")
    public void update_role_toggle_button_enabled_disable() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.activateButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Update ')]")));
        createRolePage.clickOnUpdate();
        createRolePage.clickOnYes();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.activateButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Update ')]")));
        createRolePage.clickOnUpdate();
        waitForloadSpinner();
    }


    @Story("story_id: C008 - create role with existing name")
    @Description("create role with existing name")
    @Test(priority = 8, groups = "smoke", description = "create role with existing name")
    public void create_role_with_existing_name() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.clickCreateRoleBtn();
        waitForloadSpinner();
        createRolePage.entervalidRoleName(" QAdisable ");
        createRolePage.activateButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Add permission ')]")));
        createRolePage.addPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Role')]")));
        createRolePage.roleOption();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' View Role')]")));
        createRolePage.roleSubOpnBtn1();
        clickOnOutSide.clickOutside();
        createRolePage.createButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Role name QAdisable already exists, please enter a different role name.')]")).getText(), "Role name QAdisable already exists, please enter a different role name.");

    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: C009 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 9, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        createRolePage = new CreateRolePage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        driver.findElement(By.xpath("//mat-icon[contains(text(),' list ')]")).click();
        Thread.sleep(2000);
        createRolePage.clickOnTableArrowDropDown("Roles ");
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 1);
        Thread.sleep(1000);
        createRolePage.clickOnTableArrowDropDown("Roles ");
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 2);
        Thread.sleep(2000);
        createRolePage.clickOnTableArrowDropDown(" Permissions ");
        sortingLists.sortingListInOrder("descending ", 2);
        Thread.sleep(1000);
        createRolePage.clickOnTableArrowDropDown(" Permissions ");
        Thread.sleep(2000);
        createRolePage.clickOnTableArrowDropDown(" Updated Date ");
        Thread.sleep(2000);
        createRolePage.clickOnTableArrowDropDown(" Updated Date ");
        Thread.sleep(1000);
        createRolePage.clickOnTableArrowDropDown(" Created Date ");
        Thread.sleep(3000);
        createRolePage.clickOnTableArrowDropDown(" Created Date ");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: C010 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 10, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        createRolePage = new CreateRolePage(driver);

        //verify the text of user Button
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
driver.findElement(By.xpath("//mat-icon[contains(text(),' list ')]")).click();
Thread.sleep(2000);
        createRolePage.clickOnDropDown();
        Thread.sleep(1000);
        createRolePage.selectDropDownValue();
        createRolePage.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = createRolePage.getUserCountOfatomperPage();
        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C011 - verifyRolewithreleasebuttonfunctionality")
    @Description("verifyRolewithreleasebuttonfunctionality")
    @Test(priority = 11, groups = "smoke", description = "verifyRolewithreleasebuttonfunctionality")
    public void verifyRolewithreleasebuttonfunctionality() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.clickCreateRoleBtn();
        waitForloadSpinner();
        createRolePage.EnterNewRoleName("O");
        createRolePage.activateButton();
        createRolePage.activateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter at least 3 characters.')]")).getText(), "Please enter at least 3 characters.");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Add permission ')]")));
        createRolePage.addPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' Role')]")));
        createRolePage.roleOption1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Process Document ')]")));
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Audit Document ')]")).getText(), "Audit Document");
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Release Document ')]")).getText(), "Release Document");
        softAssert.assertAll();
    }

    @Story("story_id: C012 -verify role active status")
    @Description("verify_role_active_status")
    @Test(priority = 12, groups = "smoke", description = "verify_role_active_status", dataProvider = "roleTitles")
    public void verifyRoleActiveInactiveStatus(String roleTitle) throws Exception {
        createRolePage = new CreateRolePage(driver);
        waitForloadSpinner();
        createRolePage.clickOnRolesTab();
        waitForloadSpinner();
        /*String roleTitle = "QAdisable";
            //"Amit";*/
        createRolePage.clickOnRolesTab();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),' list ')]")).click();
        createRolePage.searchRole(roleTitle);
        boolean roleStatusInGrid = createRolePage.getRoleStatusInRoleGrid(roleTitle);
        createRolePage.goToRoleDetailsPageFromRoleGrid(roleTitle);
        waitForloadSpinner();
        Assert.assertEquals(roleStatusInGrid, createRolePage.getRoleStatusInRoleDetailsPage());
    }

    @DataProvider(name = "roleTitles")
    public Object[][] roleTitlesToValidate() {
        return new Object[][]{
                {"Amit"},
                {"QAdisable"},
                {"DemoSupervisor"},
                {"Testingrole"},
                {"QA_PE"},
                {"Auditor"},
                {"Regression Test"},
                {"Test"},
                {"bhagyaAuditor"},
                {"AutoAdmin2820"}
        };
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C013 - Serach created role")
    @Description("Serach created role")
    @Test(priority = 13, groups = "smoke", description = "Serach created role")
    public void cancelButtonOfUpdateButton() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.cancelButton();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C027 - Disable Role still user have permissions to edit the details")
    @Description("Disable Role still user have permissions to edit the details")
    @Test(priority = 14, groups = "smoke", description = "Disable Role still user have permissions to edit the details")
    public void disableRoleToEditDetails() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        project = new Project_Module(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser("omtest");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management/edit-role/638f35713a73893c53521af2");
        Thread.sleep(2000);
        createRolePage.addPermission();
        Thread.sleep(2000);
        createRolePage.searchRole("pro");
        Thread.sleep(3000);
        createRolePage.clickOnProjectOpn();
        Thread.sleep(1000);
        clickOnOutSide.clickOutside();
        Thread.sleep(2000);
        createRolePage.clickOnUpdate();
        waitForloadSpinner();
        project.clickOnProjectPage();
        waitForloadSpinner();
        project.searchCreatedProject("QA-AutoProject-SemiStructured2820im");
        waitForloadSpinner();
        // createRolePage.clickOnEditButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        project.clickOnRoleLabel();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(1000);
        project.clickOnaddUSerInRole();
        Thread.sleep(1000);
        project.searchUpdatedproject("omkar");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),' omkar.ranaware@neutrinotechlabs.com ')]")).click();
        clickOnOutSide.clickOutside();
       Thread.sleep(4000);
//       driver.findElement(By.xpath("(//span[contains(text(),'Cancel')])[2]//preceding::span[1]")).click();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C028 - Role tab when user enter permissions using search tab then already inserted permission is getting cleared")
    @Description("Role tab when user enter permissions using search tab then already inserted permission is getting cleared")
    @Test(priority = 15, groups = "smoke", description = "Role tab when user enter permissions using search tab then already inserted permission is getting cleared")
    public void searchPermissonInEdit() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management/edit-role/6352491b81a6482eb26c0dcb");
        Thread.sleep(2000);
        createRolePage.addPermission();
        Thread.sleep(2000);
        createRolePage.searchRole("ana");
        Thread.sleep(3000);
        createRolePage.analyticBtn();
        Thread.sleep(1000);
        createRolePage.clickOnViewAnalyticOpn();
        Thread.sleep(1000);
        clickOnOutSide.clickOutside();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Update ')]")));
        createRolePage.clickOnUpdate();

    }


    @Story("story_id: C42 -Handling 'Release' button via permissions")
    @Description("Handling 'Release' button via permissions")
    @Test(priority = 16, groups = "smoke", description = "Handling 'Release' button via permissions")
    public void handleReleaseButton() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        loginPage = new LoginPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        createRolePage.clickOnRolesTab();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),\" list \")]")).click();
        createRolePage.searchUser("omtest");
        createRolePage.clickOnEditButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management/edit-role/638f35713a73893c53521af2");
        Thread.sleep(2000);
        createRolePage.addPermission();
        Thread.sleep(2000);
    /*createRolePage.searchRole("Doc");
    Thread.sleep(1000);*/
        createRolePage.clickOnDocumentOpn();
        Thread.sleep(1000);
        createRolePage.clickOnReleaseDocumentopn();
        createRolePage.clickOnReleaseDocumentopn();
        Thread.sleep(1000);
        clickOnOutSide.clickOutside();
        Thread.sleep(2000);
        createRolePage.clickOnUpdate();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
        Thread.sleep(1000);

        waitForloadSpinner();
        loginPage.ClickLogoutBtn();
        waitForloadSpinner();
        loginPage.EnterUsername("omkar.ranaware@neutrinotechlabs.com");
        loginPage.setPassword("Omkar@0955");
        loginPage.clickLoginButton();
        waitForloadSpinner();
        documentPage.clickOnDocumentPage();
        waitForloadSpinner();
        documentPage.clickOnActionButton();
        waitForloadSpinner();
        softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text() ,' Save Draft')]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'Cancel')])[2]")).isDisplayed());
        softAssert.assertAll();


    }

    @Story("story_id: C16 - Change the name of the permission 'Update Processed Documents' to 'Audit Documents'")
    @Description("Change the name of the permission 'Update Processed Documents' to 'Audit Documents'")
    @Test(priority = 17, groups = "smoke", description = "Change the name of the permission 'Update Processed Documents' to 'Audit Documents'")
    public void updatePermisson() throws Exception {
        createRolePage = new CreateRolePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        createRolePage.clickOnRolesTab();
        waitForloadSpinner();
        createRolePage.searchUser("omtest");
        createRolePage.clickOnEditButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/role-management/edit-role/638f35713a73893c53521af2");
        Thread.sleep(2000);
        createRolePage.addPermission();
        Thread.sleep(3000);
        createRolePage.clickOnDocumentOpn();
        Thread.sleep(1000);
        createRolePage.clickOnProcessOpn();
        Thread.sleep(1000);
        createRolePage.clickOnAuditDocopn();
        clickOnOutSide.clickOutside();
        createRolePage.clickOnUpdate();


    }


    @Story("story_id: C017 -verify the format of the dates in users page")
    @Description("verify_the_format_of_the_dates_in_users_page")
    @Test(priority = 18, groups = "smoke", description = "verify_the_format_of_the_dates_in_users_page")
    public void verifyDateFormatInUsersPage() throws Exception {
        createRolePage=new CreateRolePage(driver);
       softAssert=new SoftAssert();
        waitForloadSpinner();
        createRolePage.clickOnRolesTab();
        waitForloadSpinner();
        driver.findElement(By.xpath("//mat-icon[contains(text(),' list ')]")).click();
        Thread.sleep(2000);
        String roleName="PratikshaQA me";

        createRolePage.clickOnSearchRole(roleName);
        Assert.assertTrue(DateTimeUtils.verifyDateFormat(createRolePage.getCreatedSearchRoleInGridView()));
   softAssert.assertAll();
    }

//List<WebElement> roleTiles=null;
//    @Story("story_id: C019 -verify user updated date greater than created date for all users")
//    @Description("verify_user_updated_date_greater_than_created_date")
//    @Test(priority = 19, groups = "smoke", description = "verify_user_updated_date_greater_than_created_date_for_all_users")
//    public void verifyUserUpdatedDateForAllUsers() throws Exception {
//        softAssert = new SoftAssert();
//
//        createRolePage = new CreateRolePage(driver);
//        waitForloadSpinner();
//        createRolePage.clickOnRolesTab();
//        waitForloadSpinner();
//        roleTiles=createRolePage.getListOfRoleTiles();
//        System.out.println(roleTiles.size());
//        for (int i = 1; i <= roleTiles.size(); i++) {
//            softAssert.assertTrue(DateTimeUtils.compareDates(createRolePage.getCreatedDateFromUserTile(i),createRolePage.getUpdatedDateFromUserTile(i))
//                    , "Updated Date ("+createRolePage.getUpdatedDateFromUserTile(i)+") is not greater than Created Date ("+createRolePage.getCreatedDateFromUserTile(i)+") for the user.");
//
//        }
//        softAssert.assertAll();
//    }



}