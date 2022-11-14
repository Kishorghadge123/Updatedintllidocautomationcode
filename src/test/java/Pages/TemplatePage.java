package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;
public class TemplatePage {
    WebDriver driver = null;
    Actions action;

    public TemplatePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='List of Templates']")
    public WebElement validateListofTemplates;

    @FindBy(xpath = "(//div[@class='mat-list-item-content'])[3]")
    public WebElement templatesPage;

    @FindBy(xpath = "//input[@data-placeholder='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//mat-icon[contains(text(),'search')]")
    public WebElement searchIcon;

    @FindBy(xpath ="//td[contains(text(),' QA-Automation ')]")
    public WebElement templateName;

    @FindBy(xpath = "//td[contains(text(),' Patient Information ')]")
    public WebElement classificationName;

    @FindBy(xpath = "//div[contains(text(),' Templates ')]")
    public WebElement getSortByTemplates;

    @FindBy(xpath = "//div[contains(text(),' Pages ')]")
    public WebElement getSortbyPages;

    @FindBy(xpath = "//div[@class='mat-slide-toggle-thumb']")
    public WebElement toggleButton;

    @FindBy(xpath = "//i[@class='fa fa-search-plus']")
    public WebElement zoomInButton;

    @FindBy(xpath = "//i[@class='fa fa-search-minus']")
    public WebElement zoomOutButton;


    @FindBy(how = How.XPATH,using="//mat-icon[text()=' chevron_right ']")
    public WebElement expandSearchedTemplateRowIcon;

    @FindBy(how= How.XPATH, using = "//mat-icon[text()='subdirectory_arrow_right']")
    public WebElement openPDFTrainingScreenIcon;

    @FindBy(how=How.CSS, using="img.navbar-brand-minimized")
    public WebElement companyLogoIcon;

    @FindBy(how= How.XPATH, using= "//input[@formcontrolname='attributeName']")
    public WebElement fieldNameTextBox;

    @FindBy(how=How.CSS, using= "div.mat-select-trigger")
    public WebElement validationDropDown;

    @FindBy(how=How.XPATH,using="//span[text()='Map']")
    public WebElement mapButton;


    @FindBy(xpath = "//span[@class=\"mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin\"]")
    public WebElement mattribute;


    @FindBy(xpath = "(//span[contains(text(),'Update')])[1]")
    public WebElement update;



    @FindBy(xpath = "//span[contains(text(),' Cancel ')]")
    public WebElement cancelbutton;

    @FindBy(xpath = "//span[contains(text(),'Upload Template')]")
    public WebElement uploadTemplatesButton;

    @FindBy(xpath = "//span[contains(text(),'Create New Template')]")
    public WebElement validateCreateNewTemplate;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter a valid template name.')]")
    public WebElement validateErrorMessage;

    @FindBy(xpath = "//input[@data-placeholder='Template Name']")
    public WebElement createNewTemplate;

    @FindBy(xpath = "(//mat-icon[contains(text(),'close')])[3]")
    public WebElement cancelCreatenewTemplatesNames;

    @FindBy(xpath = "//button[@aria-label='Next page']")
    public WebElement nextPageTab;

    @FindBy(xpath = "//div[@class='mat-paginator-page-size-label']//following::div[6]")
    public WebElement itemsPerPageDropDown;

    @FindBy(xpath = "//span[text()=' 200 ']")
    public WebElement itemPerPageCount;

    public void clickOnTemplatesPage(){
        this.templatesPage.click();
    }
    public void searchTemplatesName(){
        this.searchBox.sendKeys("QA-Automation");
    }
    public void clickOnToggleButton(){
        this.toggleButton.click();
    }
    public void clickOnZoomInButton(){
        this.zoomInButton.click();
    }
    public void clickOnZoomOutButton(){
        this.zoomOutButton.click();
    }

    public void clickOnTemplatesName(){
        this.templateName.click();
    }
    public void clickOnclassificationName(){
        this.classificationName.click();
    }
    public void clickOnCancelButton(){
        this.cancelbutton.click();
    }


    public void searchTemplate(String templateName){
        this.searchBox.sendKeys(templateName);
    }

    public void expandSearchedTemplateRow(){
        expandSearchedTemplateRowIcon.click();
    }

    public void openPDFTrainingScreen(){
        openPDFTrainingScreenIcon.click();
    }

    public void cropAttributeValueInPDFDoc(int offsetX, int offsetY){
        action = new Actions(driver);
        action.moveToElement(companyLogoIcon, offsetX, offsetY);
        action.clickAndHold().moveByOffset(40, 20).release().build().perform();

    }

    public void enterFieldName(String fieldName){
        fieldNameTextBox.sendKeys(fieldName);
    }
    public void selectValidationColumn(String colName){
        validationDropDown.click();
        driver.findElement(By.xpath("//mat-option/span[text()=' "+colName+" ']")).click();
    }




    public void clickMapButton(){
        mapButton.click();
    }


    public  void  clickOnMandtoryField(){
        this.mattribute.click();
    }

    public  void clickOnUpdateButtonOfMandtoryField(){
        this.update.click();
    }

    public int getCountOfMappings(){
        return driver.findElements(By.xpath("//mat-table/mat-row")).size();
    }

    public String getDetailsFromMappingTable(int rowIndex, String headerName){
        return driver.findElement(By.xpath("(//mat-table/mat-row)["+rowIndex+"]"))
                .findElement(By.cssSelector("mat-cell[class*='"+headerName+"']")).getText().trim();
    }

    public void removeMappingFromTable(int rowIndex){
        driver.findElement(By.xpath("(//mat-table/mat-row)["+rowIndex+"]"))
                .findElement(By.cssSelector("mat-cell[class*=action]>button")).click();
    }

    public void clickOnUploadTemplatesButton(){
        this.uploadTemplatesButton.click();
    }
    public void createNewTemplateName(){
        this.createNewTemplate.sendKeys("QA Automation");
    }
    public void clickOnCanceltemplatesButton(){
        this.cancelCreatenewTemplatesNames.click();
    }

    public void userClickOnNextPageTab() throws InterruptedException {
        Thread.sleep(5000);
        boolean value1 = this.nextPageTab.isDisplayed();
        System.out.println(value1);
        for (int i = 0; i <= 500; i++) {
            boolean value = this.nextPageTab.isEnabled();
            if (value) {
                this.nextPageTab.click();
            }
        }
    }
    public String getTotalUserCountOfItemPerPage() {
        return driver.findElement(By.xpath("//div[@class=\"mat-paginator-range-label\"]")).getText().split("of")[1].strip();
    }

    public void clickOnDropDown() {
        this.itemsPerPageDropDown.click();
    }

    public void selectDropDownValue() {
        this.itemPerPageCount.click();
    }

    public void sortingListOfTemplatesInOrder(String order) throws InterruptedException {
        boolean sorted = true;
        List<WebElement> listofuser = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        if (order.equalsIgnoreCase("ascending")) {
            for (int i = 0; i < listofuser.size() - 1; i++) {
                if (listofuser.get(i).getText().toUpperCase().compareTo(listofuser.get(i + 1).getText().toUpperCase()) > 0) {
                    sorted = false;
                    break;
                }
            }
        }
        if (order.equalsIgnoreCase("descending")) {
            for (int i = 0; i < listofuser.size() - 1; i++) {
                if (listofuser.get(i).getText().toUpperCase().compareTo(listofuser.get(i + 1).getText().toUpperCase()) < 0) {
                    sorted = false;
                    break;
                }
            }
            if (sorted = true) {
                System.out.println("It is sorted list");
            } else {
                System.out.println("It is not sorted list");
            }
            Assert.assertTrue(sorted);

        }

    }
}

