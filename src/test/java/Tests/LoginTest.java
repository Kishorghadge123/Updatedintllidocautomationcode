package Tests;

import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.bson.codecs.SymbolCodec;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    WebDriverWait wait;
    SoftAssert softAssert;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: L001  - verification of test log in functinality")
    @Description("verification_test_log_in_functinality")
    @Test(priority = 1, groups = "smoke", description = "test_login_functinality", dataProvider = "LoginDataProvider")
    public void testloginfunctinality(String scenario, String username, String pwd) throws Exception {
        wait = new WebDriverWait(driver, 30);
        loginPage = new LoginPage(driver);
        loginPage.EnterUsername(username);
        loginPage.setPassword(pwd);
        loginPage.clickLoginButton();
        switch (scenario) {
            case "validLogin" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'mat-t')]")));
                Assert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/project-management");
                loginPage.ClickLogoutBtn();
            }
            case "Invalidlogin" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String Actualtext = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(Actualtext, "Please check the username or password.");
            }
            case "Invalidusername" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String ActualtextOfInvalidusername = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(ActualtextOfInvalidusername, "Please check the username or password.");
            }
            case "Invalidpassword" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String ActualtextOfInvalidpass = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(ActualtextOfInvalidpass, "Please check the username or password.");
            }
            case "WithoutPassword" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please Enter Valid Data ...!']")));
                String ActualtextOfWithoutPass = driver.findElement(By.xpath("//span[text()='Please Enter Valid Data ...!']")).getText();
                Assert.assertEquals(ActualtextOfWithoutPass, "Please Enter Valid Data ...!");
            }
            case "WithoutUsername" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please Enter Valid Data ...!']")));
                String ActualtextOfWithoutusername = driver.findElement(By.xpath("//span[text()='Please Enter Valid Data ...!']")).getText();
                Assert.assertEquals(ActualtextOfWithoutusername, "Please Enter Valid Data ...!");
            }


            case "validLoginsupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'mat-t')]")));
                Assert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/project-management");
                loginPage.ClickLogoutBtn();
            }
            case "Invalidloginsupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String Actualtext = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(Actualtext, "Please check the username or password.");
            }
            case "Invalidusernamesupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String ActualtextOfInvalidusername = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(ActualtextOfInvalidusername, "Please check the username or password.");
            }
            case "Invalidpasswordsupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String ActualtextOfInvalidpass = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(ActualtextOfInvalidpass, "Please check the username or password.");
            }
            case "WithoutPasswordsupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please Enter Valid Data ...!']")));
                String ActualtextOfWithoutPass = driver.findElement(By.xpath("//span[text()='Please Enter Valid Data ...!']")).getText();
                Assert.assertEquals(ActualtextOfWithoutPass, "Please Enter Valid Data ...!");
            }
            case "WithoutUsernamesupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please Enter Valid Data ...!']")));
                String ActualtextOfWithoutusername = driver.findElement(By.xpath("//span[text()='Please Enter Valid Data ...!']")).getText();
                Assert.assertEquals(ActualtextOfWithoutusername, "Please Enter Valid Data ...!");
            }
            case "validLoginOperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'mat-t')]")));
                Assert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/project-management");
                loginPage.ClickLogoutBtn();
            }
            case "InvalidloginOperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String Actualtext = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(Actualtext, "Please check the username or password.");
            }
            case "InvalidusernameOperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String ActualtextOfInvalidusername = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(ActualtextOfInvalidusername, "Please check the username or password.");
            }
            case "InvalidpasswordOperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please check the username or password.']")));
                String ActualtextOfInvalidpass = driver.findElement(By.xpath("//span[text()='Please check the username or password.']")).getText();
                Assert.assertEquals(ActualtextOfInvalidpass, "Please check the username or password.");
            }
            case "WithoutPasswordOperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please Enter Valid Data ...!']")));
                String ActualtextOfWithoutPass = driver.findElement(By.xpath("//span[text()='Please Enter Valid Data ...!']")).getText();
                Assert.assertEquals(ActualtextOfWithoutPass, "Please Enter Valid Data ...!");
            }
            case "WithoutUsernameOperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please Enter Valid Data ...!']")));
                String ActualtextOfWithoutusername = driver.findElement(By.xpath("//span[text()='Please Enter Valid Data ...!']")).getText();
                Assert.assertEquals(ActualtextOfWithoutusername, "Please Enter Valid Data ...!");
            }

            case "sameusernamepasswordforadmin" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Password cannot be email Id')]")));
                String ActualtextOfInvalidpass = driver.findElement(By.xpath("//span[contains(text(),'Password cannot be email Id')]")).getText();
                Assert.assertEquals(ActualtextOfInvalidpass, "Password cannot be email Id");
            }
            case "sameusernamepasswordforsupervisior" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Password cannot be email Id')]")));
                String ActualtextOfInvalidpass = driver.findElement(By.xpath("//span[contains(text(),'Password cannot be email Id')]")).getText();
                Assert.assertEquals(ActualtextOfInvalidpass, "Password cannot be email Id");
            }
            case "sameusernamepasswordforoperator" -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Password cannot be email Id')]")));
                String ActualtextOfInvalidpass = driver.findElement(By.xpath("//span[contains(text(),'Password cannot be email Id')]")).getText();
                Assert.assertEquals(ActualtextOfInvalidpass, "Password cannot be email Id");
            }
        }
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData() {
        return new Object[][]{
                {"validLogin", "di-admin@neutrinotechsystems.com", "Nts#admin@123"},
                {"Invalidlogin", "di-admin@neutrinotechsycfwstems.com", "s#admin@123"},
                {"Invalidusername", "di-admin@neutrinotechsycfwstems.com", "Nts#admin@123"},
                {"Invalidpassword", "di-admin@neutrinotechsystems.com", "s#admin@123"},
                {"WithoutPassword", "di-admin@neutrinotechsycfwstems.com", ""},
                {"WithoutUsername", "", "Nts#admin@123"},
                {"ValidLoginsupervisior","Supervisor@Test.com","Super@111"},
                {"Invalidloginsupervisior", "Supervisor11@Test.com", "a#Super@111"},
                {"Invalidusernamesupervisior", "Supervisor11@Test.com", "Super@111"},
                {"Invalidpasswordsupervisior", "Supervisor@Test.com", "a#Super@111"},
                {"WithoutPasswordsupervisior", "Supervisor@Test.com", ""},
                {"WithoutUsernamesupervisior", "", "Super@111"},
                {"ValidLoginOperator","Operator@Test.com","Operator@111"},
                {"InvalidloginOperator", "Operator@Test11.com", "a#Operator@111"},
                {"InvalidusernameOperator", "Operator11@Test.com", "Operator@111"},
                {"InvalidpasswordOperator", "Operator@Test.com", "a#Operator@111"},
                {"WithoutPasswordOperator", "Operator@Test.com", ""},
                {"WithoutUsernameOperator", "", "Operator@111"},
                {"sameusernamepasswordforadmin","di-admin@neutrinotechsystems.com","di-admin@neutrinotechsystems.com"},
                {"sameusernamepasswordforsupervisior","Supervisor@Test.com","Supervisor@Test.com"},
                {"sameusernamepasswordforoperator","Operator@Test.com","Operator@Test.com"},


        };
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: L002  - verification of title logo and login with blank details")
    @Description("verification_of_title_logo_and_login_with_blank_details")
    @Test(priority = 2, groups = "smoke", description = "verification_of_title_logo_and_login_with_blank_details")
    public void verification_of_title_ofLoginPage() throws Exception {
        String actualTitle = driver.getTitle();
        String expectedTitle = "IntelliDoc";
        assertEquals(expectedTitle, actualTitle, "TitleMismatched");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: L003  - verify that the user is able to Log off the application")
    @Description("verify_that_the_user_is_able_to_Log_off_the_application")
    @Test(priority = 3, groups = "smoke", description = "verify_that_the_user_is_able_to_Log_off_the_application")
    public void verification_TheLogOfApplication() throws Exception {
        WebElement i = driver.findElement(By.xpath("//img[contains(@class,'img-fluid login-logo')]"));
        Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
        //Verify logo Matched or not.
        if (p) {
            System.out.println("Logo Matched!");
        } else {
            System.out.println("Logo Unmatched!");
        }
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: For004 - verify click on cancel button on forgot password")
    @Description("verify user able to click_on_cancel_button_on_forgot_password")
    @Test(priority = 4, groups = "smoke", description = "verify click_on_cancel_button_on_forgot_password")
    public void VerifyForgotPasswerdButtonAndFunctionality() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnForgotButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card forgot-form']")).isDisplayed());
        loginPage.enterEmail("bagalpratiksha@gmail.com");
        loginPage.clickOncancelButton();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).isDisplayed());
        loginPage.ClickOnForgotButton();
        loginPage.ClickOnSumitButton("bagalpratiksha@gmail.com");
        loginPage.clickonsubmitbtn();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='User does not exist']")));
        String ActualText = driver.findElement(By.xpath("//span[text()='User does not exist']")).getText();
        Assert.assertEquals(ActualText, "User does not exist");
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: For005 - verify forgot password  email textfield functinality")
    @Description("verify forgot password  email textfield functinality")
    @Test(priority = 5, groups = "smoke", description = "verify forgot password  email textfield functinality")
    public void verify_forgot_password_email_textfield_functinality() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnForgotButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card forgot-form']")).isDisplayed());
        loginPage.enterEmail("bagalpratikshagmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),' *Please Check Email Id ')]")).getText(),"*Please Check Email Id");
    }
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: For006 - verify_forgot_password_Functinality_When_User_Is_Disable")
    @Description("verify_forgot_password_Functinality_When_User_Is_Disable")
    @Test(priority = 6, groups = "smoke", description = "verify_forgot_password_Functinality_When_User_Is_Disable")
    public void verify_forgot_password_Functinality_When_User_Is_Disable() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnForgotButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card forgot-form']")).isDisplayed());
        loginPage.enterEmail("bhagyashri.kalaskar@neutrinotechlabs.com");
        loginPage.clickonsubmitbtn();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'User is inactive. Please contact Administration')]")).getText(),"User is inactive. Please contact Administration");
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: For007 - verify click on cancel button on forgot password")
    @Description("verify user able to click_on_cancel_button_on_forgot_password")
    @Test(priority = 7, groups = "smoke", description = "verify click_on_cancel_button_on_forgot_password")
    public void VerifyForgotPasswerdWithEmail() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnForgotButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card forgot-form']")).isDisplayed());
        loginPage.enterEmail("pallavi.amrut@neutrinotechlabs.com");
        loginPage.clickonsubmitbtn();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: For008 - verify click on cancel button on forgot password")
    @Description("verify user able to click_on_cancel_button_on_forgot_password")
    @Test(priority = 8, groups = "smoke", description = "verify click_on_cancel_button_on_forgot_password")
    public void VerifyForgotPasswerdWithBlankEmail() throws Exception {
        loginPage = new LoginPage(driver);
        softAssert=new SoftAssert();
        loginPage.ClickOnForgotButton();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card forgot-form']")).isDisplayed());
        String color=driver.findElement(By.xpath("//button[@type=\"submit\"]")).getCssValue("background-color");
        softAssert.assertEquals(color,"rgba(158, 158, 158, 1)");
       if(driver.findElement(By.xpath("//button[@type=\"submit\"]")).getAttribute("disabled").equals("true")){
           System.out.println("Button is disable");
       }
       else {
           System.out.println("Button is enable");
       }
        softAssert.assertAll();

    }
}
