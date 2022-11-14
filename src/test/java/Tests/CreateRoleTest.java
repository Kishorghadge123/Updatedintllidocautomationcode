package Tests;

import Pages.CreateRolePage;
import Utilities.ClickOnOutSide;
import Utilities.Custome_Wait;
import Utilities.SortingLists;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

@Feature("test to create role")
public class CreateRoleTest extends BaseTest {
    CreateRolePage createRolePage;
    ClickOnOutSide clickOnOutSide;
    SoftAssert softAssert;
    Custome_Wait custom;
    SortingLists sortingLists;

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
    @Story("story_id: 001 - verify that user is able to create new role with permission")
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
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter the role name to be created.')]")).getText(), "Please enter the role name to be created.");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 002 - verify role with invalid data details and cancel")
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
    @Story("story_id: 003 - verifyRolewithBlankData")
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
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),' Please add some permissions for the role created. ')]")).getText(), " Please add some permissions for the role created. ");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter the role name to be created.')]")).getText(), "Please enter the role name to be created.");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004 -  Updating the role by adding new permission.")
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
    @Story("story_id: 005 - Serach created role")
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
    @Story("story_id: 006 - Delete All Permissions")
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
        createRolePage.searchUser(" QA_AUTOMATION ");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'create')]")));
        createRolePage.clickOnEditButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'cancel')])[1]")));
        createRolePage.clickOnCancelPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'cancel')])[1]")));
        createRolePage.clickOnCancelPermission();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Update ')]")));
        createRolePage.clickOnUpdate();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),' Please add some permissions for the role created. ')]")).getText(), " Please add some permissions for the role created. ");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter the role name to be created.')]")).getText(), "Please enter the role name to be created.");
    }


    @Story("story_id: 007 - Update role button when Active Role toggle button is enabled disable")
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


    @Story("story_id: 008 - create role with existing name")
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
    @Story("story_id: 009 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 9, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        custom=new Custome_Wait(driver);
        createRolePage = new CreateRolePage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
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
        createRolePage.clickOnTableArrowDropDown(" Updated ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        Thread.sleep(3000);
        createRolePage.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(1000);
        createRolePage.clickOnTableArrowDropDown(" Created ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Created ']")).isEnabled());
        Thread.sleep(3000);
        createRolePage.clickOnTableArrowDropDown(" Created ");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 010 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 10, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        createRolePage = new CreateRolePage(driver);

        //verify the text of user Button
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
       waitForloadSpinner();
   //* createRolePage.clickonGridIcon();
    Thread.sleep(2000);//*
        createRolePage.clickOnDropDown();
        Thread.sleep(1000);
        createRolePage.selectDropDownValue();
        createRolePage.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = createRolePage.getUserCountOfatomperPage();
        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 011 - verifyRolewithreleasebuttonfunctionality")
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
       softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Audit Document ')]")).getText(),"Audit Document");
      softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Release Document ')]")).getText(),"Release Document");
        softAssert.assertAll();
    }
    @Story("story_id: 001 -verify role active status")
    @Description("verify_role_active_status")
    @Test(priority = 1, groups = "smoke", description = "verify_role_active_status", dataProvider = "roleTitles")
    public void verifyRoleActiveInactiveStatus(String roleTitle) throws Exception {
        createRolePage = new CreateRolePage(driver);
        waitForloadSpinner();
        createRolePage.clickOnRolesTab();
        waitForloadSpinner();
        /*String roleTitle = "QAdisable";
            //"Amit";*/
        createRolePage.clickOnRolesTab();
        createRolePage.searchRole(roleTitle);
        boolean roleStatusInGrid = createRolePage.getRoleStatusInRoleGrid(roleTitle);
        createRolePage.goToRoleDetailsPageFromRoleGrid(roleTitle);
        waitForloadSpinner();
        Assert.assertEquals(roleStatusInGrid,createRolePage.getRoleStatusInRoleDetailsPage());
    }

    @DataProvider(name="roleTitles")
    public Object[][] roleTitlesToValidate(){
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
}


