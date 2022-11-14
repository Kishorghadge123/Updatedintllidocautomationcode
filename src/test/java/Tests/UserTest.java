package Tests;

import Pages.LoginPage;
import Pages.UserPage;
import Utilities.Custome_Wait;
import Utilities.DateTimeUtils;
import Utilities.SortingLists;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserTest extends BaseTest {
    UserPage userPage;
    SoftAssert softAssert;
    SortingLists sortingLists;
    Custome_Wait custom;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

@AfterMethod
public void teardown(){
        driver.quit();
}

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 001 -Search project name on user page")
    @Description(" verify_that_user_able_to_Search_project_name_on_user_page")
    @Test(priority = 1, groups = "smoke", description = "verify_that_user_able_to_Search_project_name_on_user_page")
    public void verifyProjectnameShouldBeSearchOnUserPage() throws Exception {
        userPage = new UserPage(driver);
        softAssert=new SoftAssert();
        custom=new Custome_Wait(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
       custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("QA Automation Project");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']")).isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 002 -verify User Able To Click On Cancel Button")
    @Description(" verify_user_able_to_click_on_cancel_button")
    @Test(priority = 2, groups = "smoke", description = "verify_user_able_to_click_on_cancel_button")
    public void verifyUserAbleToClickOnCancelButton() throws Exception {
        userPage = new UserPage(driver);
        softAssert=new SoftAssert();
        custom=new Custome_Wait(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("QA Automation Project");
        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator outline-none foregroundColor mat-mini-fab mat-button-base mat-accent ng-star-inserted')]")));
        userPage.clickonActionBtton();
        waitForloadSpinner();
        userPage.clickonCancelButtonOfEditUser();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 003 -Create New User and Verify All Text Of Create User")
    @Description(" verify_user_able_to_create_new_user_with_blank_data_and_verify_all_text_of_create_user")
    @Test(priority = 3, groups = "smoke", description = "verify_user_able_to_create_new_user_with_blank_data_and_verify_all_text_of_create_user")
    public void verifyUserableToCreatNewUserAndVerifyAllTextOfCreatUser() throws Exception {
        softAssert = new SoftAssert();
        userPage = new UserPage(driver);
        softAssert=new SoftAssert();
        custom=new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter all the details before submitting.')]")).getText(), "Please enter all the details before submitting.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid user name.')]")).getText(), "Please enter a valid user name.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(), "Please enter a valid email id.");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 004 -Click On Active Role Toggle Button In UserTab")
    @Description("verify_user_able_to_click_on_active_role_toggle_button_in_user_tab")
    @Test(priority = 4, groups = "smoke", description = "verify_user_able_to_click_on_active_role_toggle_button_in_user_tab")
    public void verifyWorkingOfToggleButton() throws Exception {
        userPage = new UserPage(driver);
        custom=new Custome_Wait(driver);
        softAssert=new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();

        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");


    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 005 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 5, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        userPage = new UserPage(driver);
        softAssert=new SoftAssert();
        custom=new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//div[@class='mat-paginator-page-size-label']//following::div[6]")));

        userPage.clickOnDropDown();
        userPage.selectDropDownValue();
        userPage.userClickOnNextpageTab();
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = userPage.getUserCountOfatomperPage();
        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 006 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 6, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        userPage = new UserPage(driver);
        custom=new Custome_Wait(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//div[contains(text(),'Name')]")));
        userPage.clickOnTableArrowDropDown("Name ");
        sortingLists.sortingListInOrder("ascending", 1);
        userPage.clickOnTableArrowDropDown("Name ");
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 2);
        userPage.clickOnTableArrowDropDown(" Email ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Email ']")).isEnabled());
        sortingLists.sortingListInOrder("descending ", 2);
        userPage.clickOnTableArrowDropDown(" Email ");
        userPage.clickOnTableArrowDropDown(" Assigned Projects ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Assigned Projects ']")).isEnabled());
        userPage.clickOnTableArrowDropDown(" Assigned Projects ");
        userPage.clickOnTableArrowDropDown(" Updated ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        userPage.clickOnTableArrowDropDown(" Updated ");
        userPage.clickOnTableArrowDropDown(" Created ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Created ']")).isEnabled());
        userPage.clickOnTableArrowDropDown(" Created ");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 007 -To Add Or Delete Role")
    @Description("verify_user_able_to_add_or_delete_role")
    @Test(priority = 7, groups = "smoke", description = "verify_user_able_to_add_or_delete_role")
    public void verifyUserAbleToAddOrDeletRole() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom=new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));

        userPage.searchProjectInUserPage("QA Automation Project");
        userPage.clickonActionBtton();
        waitForloadSpinner();
        userPage.clickOCancelButton();
        waitForloadSpinner();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/user-management");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 008 -verifyUserAbleToUpdateProjectNameandPassword")
    @Description("verifyUserAbleToUpdateProjectNameandPassword")
    @Test(priority = 8, groups = "smoke", description = "verifyUserAbleToUpdateProjectNameandPassword")

    public void verifyUserAbleToUpdateProjectNameandPassword() throws Exception {
        userPage = new UserPage(driver);
        softAssert=new SoftAssert();
        custom=new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));

        userPage.searchProjectInUserPage("QA Automation Project");
        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator outline-none foregroundColor mat-mini-fab mat-button-base mat-accent ng-star-inserted')]")));

        userPage.clickonActionBtton();
        waitForloadSpinner();
        userPage.updateUsername();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")));
        userPage.updatePassword();
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.clickOnUpdateButton();
        waitForloadSpinner();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/user-management");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 009 -VerifyUserWithblankUserAndPassword")
    @Description("VerifyUserWithblankUserAndPassword")
    @Test(priority = 9, groups = "smoke", description = "VerifyUserWithblankUserAndPassword")
    public void VerifyUpdateUserWithblankUserAndPassword() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom=new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("QA Automation Project");
        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator outline-none foregroundColor mat-mini-fab mat-button-base mat-accent ng-star-inserted')]")));
        userPage.clickonActionBtton();
        waitForloadSpinner();
        userPage.blankUsername();
        userPage.blankPassword();
        userPage.clickOnUpdateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid user name.')]")).getText(), "Please enter a valid user name.");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter all the details before submitting.')]")).getText(), "Please enter all the details before submitting.");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 010 -VerifyUserWithblankUserAndPassword")
    @Description("VerifyUserWithblankUserAndPassword")
    @Test(priority = 10, groups = "smoke", description = "VerifyUserWithblankUserAndPassword")
    public void VerifyUserIsAbleToUpdateUserWithInvalidUsernameAndPassword() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom=new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
       custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("Pratiksha");
        custom.waitVisibility(driver,driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator outline-none foregroundColor mat-mini-fab mat-button-base mat-accent ng-star-inserted')]")));
        userPage.clickonActionBtton();
        waitForloadSpinner();
        userPage.enetrInvalidUsername("111");
        userPage.enterInvalidPassword("12");
        userPage.clickOnUpdateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only characters.')]")).getText(), "Please enter only characters.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'A password should contain an uppercase and lowercase characters. and in between 8 to 12  ')]")).getText(), "A password should contain an uppercase and lowercase characters. and in between 8 to 12");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter all the details before submitting.')]")).getText(), "Please enter all the details before submitting.");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 011 -VerifyUserWithblankUserAndPassword")
    @Description("VerifyUserWithblankUserAndPassword")
    @Test(priority = 11, groups = "smoke", description = "VerifyUserWithblankUserAndPassword")
    public void VerifyUserIsAbleToCreateUserWithInvalidEmailAndName() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidName("1111");
        userPage.enterInvalidEmail("dfghjkl");
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only characters.')]")).getText(),"Please enter only characters.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(),"Please enter a valid email id.");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter all the details before submitting.')]")).getText(), "Please enter all the details before submitting.");
        softAssert.assertAll();

    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 012 -create user with exiting name")
    @Description("create user with exiting name")
    @Test(priority = 12, groups = "smoke", description = "create user with exiting name")
    public void create_user_with_exiting_name() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidName("demo");
        userPage.enterInvalidEmail("abc@gmail.com");
        userPage.setActiveUserToggleButton("on");
        userPage.clickOnCreateButton();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'A user already exists with a mail ID- abc@gmail.com')]")).getText(),"A user already exists with a mail ID- abc@gmail.com");
        softAssert.assertAll();

    }



    List<WebElement> userTiles = null;
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 009 -verify details on user tiles")
    @Description("verify_details_on_user_tiles")
    @Test(priority = 9, groups = "smoke", description = "verify_details_on_user_tiles")
    public void verifyTileDetailsForAllUsers() throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();

        userTiles = userPage.getListOfUserTiles();
        System.out.println(userTiles.size());
        /*for (WebElement ele : userTiles){
            try{
                userPage.verifyUserTileDetails(ele);
            }catch(StaleElementReferenceException sere){
                System.out.println("Stale Element Reference Exception");
                sere.printStackTrace();
                PageFactory.initElements(driver,UserPage.class);
                userPage.verifyUserTileDetails(ele);
            }
        }*/
        for(int i = 1; i <= userTiles.size(); i++){
            if(i>5)
                break;
            userPage.verifyUserTileDetails(i);
        }
    }

    @Story("story_id: 010 -verify user active status")
    @Description("verify_user_active_status")
    @Test(priority = 10, groups = "smoke", description = "verify_user_active_status", dataProvider = "userEmailIds")
    public void verifyUserActiveInactiveStatus(String userEmailId) throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        userPage.searchUserInGridView(userEmailId);
        boolean userStatusInGrid = userPage.getUserStatusInUserGrid(userEmailId);
        userPage.goToUserDetailsPageFromUserGrid(userEmailId);
        waitForloadSpinner();
        Assert.assertEquals(userStatusInGrid,userPage.getUserStatusInUserDetailsPage());
    }

    @DataProvider(name="userEmailIds")
    public Object[][] userEmailIdsToValidate(){
        return new Object[][]{
                {"jyoti@yopmail.com"},
                {"test@gmail.com"},
                {"wehomog846@migonom.com"},
                {"nts-auditor@yopmail.com"},
                {"demo@gmail.com"},
                {"regression@gmail.com"},
                {"neutrinotech123@gmail.com"},
                {"207adminuseremail@test.com"},
                {"bagalpratiksha1999@gmail.com"},
                {"poxiti1250@iunicus.com"}
        };
    }

    @Story("story_id: 011 -login_with_another_user")
    @Description("login_with_another_user")
    @Test(priority = 11, groups = "smoke", description = "login_with_another_user")
    public void login_with_another_user() throws Exception {
        userPage=new UserPage(driver);
        loginPage = new LoginPage(driver);
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("Supervisor@Test.com");
        loginPage.setPassword("Super@1111");
        loginPage.clickLoginButton();

    }
    @Story("story_id: 012 -verify user updated date greater than created date")
    @Description("verify_user_updated_date_greater_than_created_date")
    @Test(priority = 12, groups = "smoke", description = "verify_user_updated_date_greater_than_created_date")
    public void verifyUserUpdatedDate() throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        String userEmailId = "michael223@gmail.com";
        //"pradnyaauditor@gmail.com";*/
        userPage.clickonGridIcon();
        userPage.searchUserInGridView(userEmailId);
        //softAssert = new SoftAssert();
        System.out.println("Created Date: "+ userPage.getCreatedDateOfSearchedUserInGridView()+"  |  Updated Date: "+userPage.getUpdatedDateOfSearchedUserInGridView());
        Assert.assertTrue(DateTimeUtils.compareDates
                        (userPage.getCreatedDateOfSearchedUserInGridView(),userPage.getUpdatedDateOfSearchedUserInGridView())
                , "Updated Date is not greater than Created Date for the user.");
    }

    @Story("story_id: 013 -verify the format of the dates in users page")
    @Description("verify_the_format_of_the_dates_in_users_page")
    @Test(priority = 13, groups = "smoke", description = "verify_the_format_of_the_dates_in_users_page")
    public void verifyDateFormatInUsersPage() throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        String userEmailId = "michael223@gmail.com";
        userPage.clickonGridIcon();
        userPage.searchUserInGridView(userEmailId);
        Assert.assertTrue(DateTimeUtils.verifyDateFormat(userPage.getCreatedDateOfSearchedUserInGridView())
                , "Date is not in correct format.");
    }

    @Story("story_id: 014 -verify user updated date greater than created date for all users")
    @Description("verify_user_updated_date_greater_than_created_date")
    @Test(priority = 14, groups = "smoke", description = "verify_user_updated_date_greater_than_created_date_for_all_users")
    public void verifyUserUpdatedDateForAllUsers() throws Exception {
        softAssert = new SoftAssert();
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userTiles = userPage.getListOfUserTiles();
        System.out.println(userTiles.size());
        for (int i = 1; i <= userTiles.size(); i++) {
            softAssert.assertTrue(DateTimeUtils.compareDates(userPage.getCreatedDateFromUserTile(i),userPage.getUpdatedDateFromUserTile(i))
                    , "Updated Date ("+userPage.getUpdatedDateFromUserTile(i)+") is not greater than Created Date ("+userPage.getCreatedDateFromUserTile(i)+") for the user.");

        }
        softAssert.assertAll();
    }

}






