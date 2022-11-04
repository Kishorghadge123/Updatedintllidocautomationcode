package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locator
    @FindBy(xpath = "//label[text()='Email Id']//following::input[1]")
    public WebElement userName;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;
    @FindBy(xpath = "//span[@mattooltip='Logout']")
    public WebElement Logout;

    @FindBy(xpath = "//a[contains(text(),'Forgot Password?')]")
    public WebElement ForgetPwdButton;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement email;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    public WebElement Cancel;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    public WebElement Submit;

    @Step("EnterUsername")
    public void EnterUsername(String text) throws Exception {
        this.userName.sendKeys(text);
    }
    @Step("setPassword")
    public void setPassword(String pass) throws Exception {
        this.password.sendKeys(pass);
    }

    @Step("clickLoginButtonForValidInput")
    public void clickLoginButton() throws Exception {
        this.loginBtn.click();
    }
    @Step("")
    public void ClickOnForgotButton() {
        this.ForgetPwdButton.click();
    }
    @Step("ClickOnCancelButton")
    public void enterEmail(String EmailId) {
        this.email.sendKeys(EmailId);

    }

    @Step("Clickoncancel")
    public void clickOncancelButton(){
        this.Cancel.click();
    }


    @Step("ClickOnSumitButton")
    public void ClickOnSumitButton(String EmailId) {
        this.email.sendKeys(EmailId);

    }


    @Step("submitfunctinality")
    public void clickonsubmitbtn(){
        this.Submit.click();
    }

    @Step("ClickLogoutBtn")
    public void ClickLogoutBtn() throws Exception {
        try {
            wait = new WebDriverWait(driver, 5000L);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Please wait...'] ")))); // wait for loader to
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='Please wait...'] ")))); // wait for loader to disappear
            this.Logout.click();
        }catch (Exception e){
            System.out.println("Spinar Not Appear");
        }
    }
}

