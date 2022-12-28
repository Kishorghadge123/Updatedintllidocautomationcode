package Pages;

import Utilities.Custome_Wait;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CreateRolePage {

    public WebDriver driver;
//TC 6.1 element locators

    public CreateRolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By rolebtn = By.xpath("//img[contains(@src,'Roles.svg')]");
    public By validname=By.xpath("//input[@formcontrolname=\"role\"]");
    public By CreateRoleBtn = By.xpath("//span[contains(text(),' Create Role ')]");
    public By RoleName = By.xpath("//input[@formcontrolname='role']");
    public By AddPermission = By.xpath("//span[contains(text(),' Add permission ')]");
    public By RoleOption = By.xpath("//button[contains(text(),' Role')]");
    public By RoleOption1=By.xpath("//button[@role=\"menuitem\"][2]");
    @FindBy(how= How.XPATH, using = "//div[@class='mat-list-item-content']/img[contains(@src,'Roles')]")
    WebElement rolesTab;
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchButton;
    public By RoleSubOpn1 = By.xpath("//div[contains(text(),' View Role')]");
    public By RoleSubOpn2 = By.xpath("//div[contains(text(),' Update Role')]");
    public By update=By.xpath("//span[contains(text(),' Update ')]");
    public By RoleSubOpn3 = By.xpath("//div[contains(text(),' Create Role')]");
    public By ActiveRole = By.xpath("//mat-slide-toggle[@formcontrolname=\"status\"]");
    public By CreateBtn = By.xpath("(//span[contains(@class,'mat-button-wrapper')])[8]");
    public By cancelPermission=By.xpath("//mat-icon[contains(text(),'cancel')]");
    public By CancelBtn = By.xpath("(//span[contains(text(),'Cancel')])[2]");
    public  By search=By.xpath("//input[@placeholder=\"Search\"]");
    public By edit=By.xpath("//mat-icon[contains(text(),'create')]");
    public By deletepermission=By.xpath("(//span[contains(text(),'Cancel')])[2]");
    public By yes=By.xpath("//span[contains(text(),'Yes')]");

@FindBy(xpath = "//input[@placeholder=\"Search\"]")
public WebElement SearchRole;

public By roleLocator=By.xpath("//tr[@class=\"mat-row cdk-row ng-star-inserted\"]");


    @FindBy(xpath = "//span[contains(text(), 'Add Role ')]")
    public WebElement addrole;
    @FindBy(xpath = "//span[text()=' Create Project ']")
    public WebElement createbtnproject;


    @FindBy(xpath = "//img[contains(@src,'Projects.svg')]")
    public WebElement projectbtn;

@FindBy(xpath = "(//mat-icon[contains(text(),'cancel')])[1]")
public WebElement cancelpermission1;

    @FindBy(xpath = "(//mat-icon[contains(text(),'cancel')])[2]")
    public WebElement cancelpermission2;


    @FindBy(xpath = "(//mat-icon[contains(text(),'add_circle_outline')])[4]")
    public WebElement addUSerInRole;
    public void clickOnaddUSerInRole(){
        this.addUSerInRole.click();
    }


    @FindBy(xpath = "//mat-error[contains(text(),'Only alphabets,digits,parenthesis and hyphens are allowed.')]")
    public WebElement roleNameError;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter at least 3 characters.')]")
    public WebElement roleNameLmt;


    @FindBy(how= How.XPATH, using= "//mat-slide-toggle[@formcontrolname='status']//input")
    public WebElement activeRoleToggleOnRoleDetails;


    @FindBy(xpath = "//span[contains(text(),'Roles')]")
    public WebElement rolelabel;
    @FindBy(xpath = "//span[contains(text(),' Create ')]")
    public WebElement createRoleBtn;
    @FindBy(xpath = "//span[contains(text(),'Role name 111 already exists, please enter a different role name.')]")
    public WebElement SameUserError;
    @FindBy(xpath = "//button[contains(text(),' Project ')]")
    public WebElement projectOpn;
    @FindBy(xpath = "//div[contains(text(),' Process Document ')]")
    public WebElement processDocOpn;
    public void clickOnProcessOpn(){
        this.processDocOpn.click();
    }
    @FindBy(xpath = "//div[contains(text(),' Audit Document ')]")
    public WebElement auditDocOpn;
    public void clickOnAuditDocopn(){
        this.auditDocOpn.click();
    }


    public void clickOnProjectOpn(){
        this.projectOpn.click();
    }

    @FindBy(xpath = "//button[contains(text(),' Analytics ')]")
    public WebElement analyticpermisson;
    public void analyticBtn() {
        this.analyticpermisson.click();
    }


    @FindBy(xpath = "//div[contains(text(),' View Analytics ')]")
    public WebElement viewAnalyticOpn;
    @FindBy(xpath = "//button[contains(text(),' Document ')]")
    public WebElement DocumentOpn;
    public void clickOnDocumentOpn(){
        this.DocumentOpn.click();
    }

    @FindBy(xpath = "//div[contains(text(),' Release Document ')]")
    public WebElement releaseDocumentOpn;
    public void clickOnReleaseDocumentopn(){
        this.releaseDocumentOpn.click();
    }
    public void clickOnViewAnalyticOpn() {
        this.viewAnalyticOpn.click();
    }


    @FindBy(xpath = "//button[@aria-label='Next page']")
    public WebElement nextPagetab;
    public void userClickOnNextpageTab() {
        boolean value1 = this.nextPagetab.isDisplayed();
        System.out.println(value1);
        for (int i = 0; i <= 2000; i++) {
            boolean value = this.nextPagetab.isEnabled();
            if (value) {
                this.nextPagetab.click();
            }
        }
    }
    public String getUserCountOfatomperPage() {
        return driver.findElement(By.xpath("//div[@class=\"mat-paginator-range-label\"]")).getText().split("of")[1].strip();
    }
    public  void  clickOnProjectPage(){
        this.projectbtn.click();
    }

    public void clickOnRoleLabel(){
        this.rolelabel.click();
    }

    public  void  clickOnSearchRole(String text){
//        this.SearchRole.click();
        this.SearchRole.sendKeys(text);
    }

    public String getCreatedSearchRoleInGridView(){
      return  driver.findElement(By.cssSelector("td.mat-column-created")).getText();//.split(" ")[1];

    }

    public void clickOnCreateProjectButton(){
        this.createbtnproject.click();
    }
    public  void clickOnAddRoleButton(){

        this.addrole.click();
    }
    @FindBy(xpath = "//div[@id='mat-select-value-1']")
    public WebElement countDropDown;
    @FindBy(xpath = "//span[contains(text(),' 200 ')]")
    public WebElement selectCount;

    @Step("Click on role button")
    public void clickRoleBtn() {
        driver.findElement(rolebtn).click();
    }

    public void selectDropDownValue(){
        this.selectCount.click();
    }
    public void clickOnDropDown(){
        this.countDropDown.click();
    }

    public void clickOnTableArrowDropDown(String text) {
        driver.findElement(By.xpath("//div[text()='" + text + "']")).click();
    }

    @Step("Click on Create button")
    public void clickCreateRoleBtn() {
        driver.findElement(CreateRoleBtn).click();
    }

    @Step("enter role name")
    public void  entervalidRoleName(String str){
        driver.findElement(validname).sendKeys(str);
    }


    @Step("enter New Role Name")
    public void EnterNewRoleName(String roleName) throws Exception {
        Random r = new Random();
        char first_c = (char) (r.nextInt(26) + 'a');
        // char second_c = (char) (r.nextInt(26) + 'a');
        driver.findElement(RoleName).sendKeys(roleName + first_c);
        Thread.sleep(3000);
    }


    public void addPermission() {
        driver.findElement(AddPermission).click();
    }


    public void cancelPermission2(){
        this.cancelpermission2.click() ;}


    public void cancelPermission1(){
       this.cancelpermission1.click() ;}

    @Step("click On AddPermission Role Button")
    public void roleOption() {
        driver.findElement(RoleOption).click();
    }


    @Step("click On AddPermission document Button")
    public void roleOption1() {
        driver.findElement(RoleOption1).click();
    }

    public boolean getRoleStatusInRoleGrid(String RoleTitle){
        String roleIconColor = driver.findElement(By.xpath("//span[text()=' "+RoleTitle+" ']/preceding-sibling::i")).getCssValue("color");
        //.getAttribute("class");
        System.out.println(Color.fromString(roleIconColor).asHex());
        boolean isActive=false;

        if(Color.fromString(roleIconColor).asHex().equalsIgnoreCase("#e87033"))
            isActive = true;

        return isActive;
    }

    public void clickOnRolesTab() throws Exception {
        rolesTab.click();

        //Thread.sleep(3000);
    }
    public String getCreatedDateFromUserTile(int index){
        return driver.findElement(By.xpath("//div[contains(text(),' Created Date ')]//following::td[3]["+index+"]")).getText();
    }

    public String getUpdatedDateFromUserTile(int index) {
        return driver.findElement(By.xpath("//div[contains(text(),' Updated Date ')]//following::td[3]["+index+"]")).getText();
    }



    public List<WebElement> getListOfRoleTiles(){
    List<WebElement> roleTiles=null;
    try {
        roleTiles = driver.findElements(roleLocator);
    }catch(StaleElementReferenceException sere){
        System.out.println("Stale Element Reference Exception");
        sere.printStackTrace();
        PageFactory.initElements(driver, this);
       roleTiles=driver.findElements(roleLocator);
    }
    return roleTiles;
}

    public void searchRole(String searchText) throws InterruptedException {
        searchButton.sendKeys(searchText+ Keys.RETURN);
        Thread.sleep(2000);
    }

    public void goToRoleDetailsPageFromRoleGrid(String RoleTitle){
        driver.findElement(By.xpath("//span[text()=' "+RoleTitle+" ']/preceding-sibling::i")).click();
    }

    public boolean getRoleStatusInRoleDetailsPage(){
        Custome_Wait c=new Custome_Wait(driver);
        c.waitUpToelementClickable(driver, activeRoleToggleOnRoleDetails);
        //System.out.println(activeRoleToggleOnProjectDetails.getAttribute("aria-checked"));
        System.out.println(Boolean.valueOf(activeRoleToggleOnRoleDetails.getAttribute("aria-checked")));
        return Boolean.valueOf(activeRoleToggleOnRoleDetails.getAttribute("aria-checked"));
    }

    @Step("click On AddPermission Sub-role Button")
    public void roleSubOpnBtn1() {
        driver.findElement(RoleSubOpn1).click();
    }

    @Step("click On AddPermission Sub-role Button")
    public void roleSubOpnBtn2() {
        driver.findElement(RoleSubOpn2).click();
    }

    @Step("click on update button")
    public void clickOnUpdate(){
        driver.findElement(update).click();
    }

    @Step("click On Addpermission sub-role Button")
    public void roleSubOpnBtn3() {
        driver.findElement(RoleSubOpn3).click();
    }

    @Step("cancel permission")
    public void cancelPermission(){
        driver.findElement(cancelPermission).click();
    }

    @Step("click On Activate button")
    public void activateButton() {
        driver.findElement(ActiveRole).click();
    }

    @Step("click On Serach button")
    public void searchRoleInRolePage(String text) throws Exception {
        driver.findElement(search).sendKeys(text);
        driver.findElement(search).click();



    }
    @Step("click On Update button")
    public void clickOnUpdateButton() throws Exception {

        driver.findElement(update).click();
    }

    @Step("click On create button")
    public void createButton() {
        driver.findElement(CreateBtn).click();
    }

    @Step("search role")
    public void searchUser(String str){
        driver.findElement(search).sendKeys(str);
    }

    @Step("click on edit role")
    public void clickOnEditButton(){
        driver.findElement(edit).click();
    }


    @Step("click on yes")
    public void clickOnYes(){
        driver.findElement(yes).click();
    }

    @Step("cancel permissions")
    public void clickOnCancelPermission(){
        driver.findElement(deletepermission).click();
    }

    @Step("Click on cancel")
    public void cancelButton() {
        driver.findElement(CancelBtn).click();
    }

//    public void clickOutside() {
//        Actions action = new Actions(driver);
//        action.moveByOffset(0, 0).click().build().perform();
//    }
}
