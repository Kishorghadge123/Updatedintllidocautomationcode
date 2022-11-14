package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StructurePage {
    WebDriver driver;

    @FindBy(xpath = "//img[contains(@src,\"projectLogoN.png\")]")
    public WebElement nicon;
    @FindBy(xpath ="//span[contains(text(),'13.jpg')]")
    public WebElement SelectDocument;
    @FindBy(xpath = "//button[@id=\"rotate_left\"]")
    public WebElement rotateleft;


    @FindBy(xpath = "//span[contains(text(),'Release')]")
    public  WebElement releasebtn;


    @FindBy(xpath = "//button[@mattooltip=\"Zoom Out\"]")
    public WebElement zoomOut;


    @FindBy(xpath = "//button[@id=\"rotate_right\"]")
    public WebElement rotateright;


    @FindBy(xpath = "//button[@mattooltip=\"Zoom In\"]")
    public WebElement zoomIn;

    public void clickOnDocument(){
        this.SelectDocument.click();
    }


    @Step("click on release button")
    public  void  clickOnRealeseButton(){
        this.releasebtn.click();
    }


    public void clickOnRotateLeft(){
        this.rotateleft.click();
        this.rotateleft.click();
    }


    public void clickOnRotateRight(){
        this.rotateright.click();
        this.rotateright.click();
    }


    public void clickOnZoomOut(){
        this.zoomOut.click();
        this.zoomOut.click();
    }


    public void clickOnZoomIn(){
        this.zoomIn.click();
        this.zoomIn.click();
    }













    @Step("Click On Icon")
    public void clickOnIcon(){
        this.nicon.click();
    }

















    public StructurePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }




}
