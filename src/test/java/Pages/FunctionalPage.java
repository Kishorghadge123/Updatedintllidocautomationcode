package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class FunctionalPage {
    WebDriver driver;

    @FindBy(xpath = "(//div[contains(text(),'N')])[1]")
    public WebElement eicon;

    @FindBy(xpath = "//mat-icon[contains(text(),' keyboard_arrow_right ')]")
    public WebElement arrow;

    @FindBy(xpath = "//button[@id='profile-modal-button']")
    public WebElement theme;

    @FindBy(xpath = "(//button[@data-toggle=\"modal\"])[2]")
    public WebElement themeicon;


    @FindBy(xpath = "//span[contains(text(),' Apply ')]")
    public WebElement applybutton;

    @FindBy(xpath = "(//img[@class=\"img-responsive\"])[1]")
    public WebElement selecttheme;



    @FindBy(xpath = "(//mat-icon[contains(text(),'close')])[1]")
    public WebElement cancel;


    @FindBy(xpath = "//span[contains(text(),' Save')]")
    public  WebElement save;


    @FindBy(xpath ="//img[contains(@src,\"Analytics.svg\")]" )
            public WebElement anayticsbtn;

    @FindBy(xpath = "//img[contains(@src,\"Roles.svg\")]")
            public WebElement role;

    @FindBy(xpath = "//img[contains(@src,\"Users.svg\")]")
            public WebElement user;

    @FindBy(xpath = "//img[contains(@src,\"Datasets.svg\")]")
            public  WebElement dataset;

    @FindBy(xpath = "//img[contains(@src,\"Template.svg\")]")
            public WebElement template;

    @FindBy(xpath = "//img[contains(@src,\"Projects.svg\")]")
    public WebElement project;

@FindBy(xpath = "//img[contains(@src,\"Documents.svg\")]")
        public WebElement document;

@FindBy(xpath = "//img[contains(@src,\"Auditor.svg\")]")
        public WebElement audit;

@FindBy(xpath = "//img[contains(@src,\"Report.svg\")]")
        public WebElement report;


@FindBy(xpath = "//img[contains(@src,\"Analytics.svg\")]")
        public WebElement analytics;


    public FunctionalPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @Step("click on user")
    public void clickOnUserTab(){
        this.user.click();
    }

    @Step("click on role")
    public void clickOnRoleTab(){
        this.role.click();
    }

    @Step("click on template")
    public void clickOnTemplate(){
        this.template.click();
    }


    @Step("click on dataset")
    public void clickOnDatasetTab(){
        this.dataset.click();
    }



    @Step("click on project")
    public void clickOnProjectTab(){
        this.project.click();
    }


    @Step("click on document")
    public void clickOnDocumentTab(){
        this.document.click();
    }

    @Step("click on edit icon")
    public  void clickOnEdit(){
        this.eicon.click();
    }
    @Step("click on edit profile")
    public  void clickOnEditProfile(){
        this.theme.click();
    }

    @Step("click on theme")
    public void clickOnTheme(){
        this.themeicon.click();
    }
@Step("select theme")
public  void selectTheme(){
        this.selecttheme.click();
}

    @Step("click on apply button")
    public void clickOnApplyButton(){
        this.applybutton.click();
    }

@Step("click on arrow")
    public void clicOnArrow(){
        this.arrow.click();
    }


    @Step("click on cancel button")
    public void clickOnCancelButton(){
        this.cancel.click();
    }

    @Step("click on save button")
    public  void clickOnSaveButton(){
        this.save.click();
    }


    @Step("click on audit tab")
    public void clickOnAuditTab(){
        this.audit.click();
    }


    @Step("click on report tab")
    public void clickOnReportTab(){
        this.report.click();
    }


    @Step("click on Analytics tab")
    public void clickOnAnalyticsTab(){
        this.anayticsbtn.click();
    }





}
