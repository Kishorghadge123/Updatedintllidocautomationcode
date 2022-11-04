package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;

public class DatasetPage {
    WebDriver driver = null;

    public DatasetPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='mat-list-item-content'])[4]")
    public WebElement dataSets;

    @FindBy(xpath = "//mat-icon[contains(text(),'add_circle_outline')]")
    public WebElement datasetnew;

    @FindBy(xpath = "//input[@formcontrolname=\"newDatasetName\"]")
    public WebElement datasetname;


    @FindBy(xpath = "//input[@data-placeholder='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//mat-icon[contains(text(),'search')]")
    public WebElement searchBar;

    @FindBy(xpath = "//td[contains(text(),'QA Automation')]")
    public WebElement clickonCategory;

    @FindBy(xpath = "//td[contains(text(),'QA Automation')]/following::div[contains(text(),'Datasets')]")
    public WebElement validateDatasetsName;

    @FindBy(xpath = "(//div[contains(@class,'mat-slide-toggle-thumb')])[1]")
    public WebElement togglebutton;

    @FindBy(xpath = "(//span[@class='mat-button-wrapper']/mat-icon[text()='visibility'])[1]")
    public WebElement visibilityButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchBox1;

    @FindBy(xpath = "//div[text()=' Patient name ']")
    public WebElement validatePatientName;

    @FindBy(xpath = "//mat-icon[contains(text(),'search')]")
    public WebElement searchBar1;
    @FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
    public WebElement cancelDataset;

    @FindBy(xpath = "//span[text()='Add Category']")
    public WebElement addCategory;
    @FindBy(xpath = "//input[@formcontrolname='newCategoryName']")
    public WebElement createNewCategory;
    @FindBy(xpath = "//span[text()='Create New Dataset Category']")
    public WebElement validateCreateNewDatasetCategory;
    @FindBy(xpath = "//span[text()='Create Category']")
    public WebElement validateCreateCategory;

    @FindBy(xpath = "//button[@id=\"category-close-modal\"]")
    public WebElement cancelCreateNewDatasetCategory;

    @FindBy(xpath = "//div[contains(text(),' Category ')]")
    public WebElement getSortByCategory;

    @FindBy(xpath = "//div[contains(text(),' Datasets ')]")
    public WebElement getSortByDatasets;

    @FindBy(xpath = "//div[contains(text(),' Updated ')]")
    public WebElement getSortByUpdated;

    @FindBy(xpath = "//div[contains(text(),' Created ')]")
    public WebElement getSortByCreated;

    @FindBy(xpath = "//span[contains(text(),'Action')]//following::span[1]")
    public WebElement actionButton;

    @FindBy(xpath = "(//span[contains(text(),'Create New Dataset')])[2]")
    public WebElement createNewDataset;

    @FindBy(xpath = "//input[@formcontrolname='newDatasetName']")
    public WebElement createDataSetName;

    //@FindBy(xpath = "//input[@accept='.csv']")
    // @FindBy(xpath = "//div[contains(@class,'row selectFile ng-tns-')]//div[contains(@class,'col-md-12 fileUpload ng-tns-')]")
    @FindBy(xpath = "//div[contains(@class,'fileUpload')]/child::input")
    public WebElement clickOnChooseFile;

    @FindBy(xpath = "(//span[@class='mat-button-wrapper']/mat-icon[text()='close'])[3]")
    public WebElement cancelNewDataset;

    @FindBy(xpath = "//div[contains(text(),'100,000 entries. ')]")
    public WebElement validateCSVformatText;

    @FindBy(xpath = "//div[@class='mat-paginator-page-size-label']//following::div[6]")
    public WebElement itemsPerPageDropDown;

    @FindBy(xpath = "//span[text()=' 200 ']")
    public WebElement itemPerPageCount;

    @FindBy(xpath = "//button[@aria-label='Next page']")
    public WebElement nextPageTab;

    public void clickONDatasetPage() {
        this.dataSets.click();
    }
    public void clickOnNewDataset(){
        this.datasetnew.click();
    }

    public void enterDatasetName(String str){
        this.datasetname.sendKeys(str);
    }

    public void sendCategoryName() {
        this.searchBox.sendKeys("QA Automation");
    }

    public void clickOnSearchBarIcon() {
        this.searchBar.click();
    }

    public void clickOnCategoryName() {
        this.clickonCategory.click();
    }

    public void clickOnTogglebutton() {
        this.togglebutton.click();
    }

    public void clickOnVisibilityButton() {
        this.visibilityButton.click();
    }

    public void searchPatientName() {
        this.searchBox1.sendKeys("Jennifer");
    }

    public void clickOnserchBarIcon1() {
        this.searchBar1.click();
    }

    public void clickOnCancelDatasets() {
        this.cancelDataset.click();
    }

    public void clickOnAddCategory() {
        this.addCategory.click();
    }

    public void sendCreateNewCategoryName() {
        this.createNewCategory.sendKeys("QAAutomation");
    }
    public void sendCreateNewCategoryNameBlank() {
        this.createNewCategory.sendKeys("");
    }
    public void enterNewCategoryName(String str) {
        this.createNewCategory.sendKeys(str);
    }

    public void validateCreateCategoryName() {
        this.validateCreateCategory.click();
    }

    public void clickOnCancelCreateNewDatasetCategory() {
        this.cancelCreateNewDatasetCategory.click();
    }

    public void clickOnActionButton() {
        this.actionButton.click();
    }

    public void createDatasetFileName() {
        this.createDataSetName.sendKeys("DataFile");
    }

    public void clickOnChooseCSVFile() {
//        this.clickOnChooseFile.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", this.clickOnChooseFile);
//        executor.executeScript("arguments[0].click();", this.clickOnChooseFile);
    }

    public void clickOnCancelNewDataset() {
        this.cancelNewDataset.click();

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
}
