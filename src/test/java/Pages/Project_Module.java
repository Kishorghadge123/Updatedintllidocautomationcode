package Pages;
import java.util.List;
import java.util.Random;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;;import javax.security.auth.x500.X500Principal;

public class Project_Module {

    WebDriver driver = null;
    @FindBy(xpath = "//img[contains(@src,'Projects.svg')]")
    WebElement projectbtn;


    @FindBy(xpath = "(//mat-icon[contains(text(),'list')])[1]")
    WebElement listview;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchbar;

    @FindBy(xpath = "")
    public WebElement searchedproject;

    @FindBy(xpath = "//span[text()=' Create Project ']")
    public WebElement createbtnproject;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter the project name.')]")
    public WebElement projectnamerrmsg;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter the lead name.')]")
    public WebElement leaderrormsg;

    @FindBy(xpath = "(//mat-error[contains(text(),'Please enter the date in MM/DD/YYYY format.')])[1]")
    public WebElement startdateerrmsg;

    @FindBy(xpath = "(//mat-error[contains(text(),'Please enter the date in MM/DD/YYYY format.')])[2]")
    public WebElement enddateerrmsg;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter the Document Structure name.')]")
    public WebElement documentstructureerrmsg;

    @FindBy(xpath = "//span[contains(text(),'Please add the attributes before creating the project.')]")
    public WebElement projectcreateerrmsg;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter a processing engine. ')]")
    public WebElement processengineerrmsg;


    @FindBy(xpath = "//span[contains(text(),'Role(s) cannot be empty')]")
    public WebElement rolecreateerrmsg;

    @FindBy(xpath = "//span[contains(text(),'Please add the template before creating the project.')]")
    public WebElement templatecreateerrmsg;


    @FindBy(xpath = "(//button[contains(@class,'mat-focus-indicator ml')])[2]")
    public WebElement createbtn;

    @FindBy(xpath = "(//button[contains(@class,'mat-focus-indicator ml')])[3]")
    public WebElement cancelbtn;

    @FindBy(xpath = "//span[text()=' Update']")
    public WebElement updatebtn;


    @FindBy(xpath = "//span[contains(text(),'Please associate a role with \"Audit Document\" permission before updating  the project.')]")
    public WebElement disableerrmsg;

    @FindBy(xpath = "//span[contains(text(),' Update ')]")
    public WebElement updatebtn1;

    @FindBy(xpath = "(//span[contains(text(),' Next')])")
    public WebElement nextbtn;

    @FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
    public WebElement projectcancelbtn;

    @FindBy(xpath = "//mat-select[@formcontrolname='lead']")
    public WebElement leaddropdown;

    @FindBy(xpath = "//span[contains(text(),' pratiksha.bagal@neutrinotechlabs.com ')]")
    public WebElement selectlead;

    @FindBy(xpath = "//mat-select[@formcontrolname='documentStructure']")
    public WebElement docstructure;


    @FindBy(xpath = "//mat-select[@formcontrolname=\"processingEngine\"]")
    public WebElement processengindropdown;

    @FindBy(xpath = "//span[contains(text(),' NN High ')]")
    public WebElement selectenigine;

    @FindBy(xpath = "//span[contains(text(),' Structured ')]")
    public WebElement selectpeoject;

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    public WebElement searchpreviouslead;

    @FindBy(xpath = "(//span[contains(text(),'pratiksha.bagal@neutrinotechlabs.com')])[1]")
    public WebElement selectpreviouslead;

    @FindBy(xpath = "(//label[@class='mat-slide-toggle-label'])[1]")
    public WebElement statustogglebtn;

    @FindBy(xpath = "(//label[@class='mat-slide-toggle-label'])[2]")
    public WebElement documentautoassignmentogglebtn;

    @FindBy(xpath = "(//label[@class='mat-slide-toggle-label'])[3]")
    public WebElement auditenabletogglebtn;

    @FindBy(xpath = "(//label[@class='mat-slide-toggle-label'])[4]")
    public WebElement StraightThroughProcesstogglebtn;

    @FindBy(xpath = "(//label[@class='mat-slide-toggle-label'])[5]")
    public WebElement sendmailtogglebtn;

    @FindBy(xpath = "//span[contains(text(),'Attributes')]")
    public WebElement attributelabel;

    @FindBy(xpath = "//mat-header-cell[contains(text(),' Field Name ')]")
    public  WebElement fieldname;

    @FindBy(xpath = "//mat-icon[contains(text(),'create')]")
    public WebElement searchedproject1;


    @FindBy(xpath = "//span[contains(text(),' Add Fields ')]")
    public WebElement addfieldbtn;

    @FindBy(xpath = "//button[contains(text(),'Age')]")
    public WebElement addattribute;

    @FindBy(xpath = "(//mat-icon[contains(text(),'delete')])[4]")
    public WebElement deleteattribute;

    @FindBy(xpath = "//span[contains(text(),' Add Template ')]")
    public WebElement addtemplatebtn;

    @FindBy(xpath = "//button[contains(text(),'QA-Automation')]")
    public WebElement template;

    @FindBy(xpath = "//span[contains(text(),'Templates')]")
    public WebElement templatelabel;

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    public WebElement SearchRole;

    @FindBy(xpath = "//span[contains(text(),'Roles')]")
    public WebElement rolelabel;


    @FindBy(xpath = "//span[contains(text(), 'Add Role ')]")
    public WebElement addrole;

    @FindBy(xpath = "(//button[contains(text(),'PratikshaQA')])[1]")
    public WebElement selectrole;

    @FindBy(xpath = "//mat-slide-toggle[@class='mat-slide-toggle mat-primary ng-untouched ng-pristine ng-valid mat-checked']")
    public WebElement disablerole;


    @FindBy(xpath = "(//mat-icon[contains(text(),'add_circle_outline')])[2]")
    public WebElement clickonroleplusbutton;

    @FindBy(xpath = "//span[contains(text(),'Datasets')]")
    public WebElement datasetlabel;

    @FindBy(xpath = "//div[contains(text(),' Roles ')]")
    public WebElement roletab;

    @FindBy(xpath = "//h5[contains(text(),' Please Add Template ...')]")
    public WebElement templatemsg;

    @FindBy(xpath = "//span[contains(text(),'Role cannot have empty users')]")
    public WebElement usercreaterrmsg;


    @FindBy(xpath = "//span[contains(text(),' pratiksha.bagal@neutrinotechlabs.com ')]")
    public WebElement user;



    @FindBy(xpath = "//span[contains(text(),' Document Ingestion Channels ')]")
    public WebElement documentlabel;

    @FindBy(xpath = "//span[contains(text(),'GCP Bucket (Default)')]")
    public WebElement selectchanneldropdown;

    @FindBy(xpath = "//span[contains(text(),' GCP Bucket (Default) ')]")
    public WebElement channel;

    @FindBy(xpath = "//span[contains(text(),' Add Dataset ')]")
    public WebElement adddatasetbtn;

    @FindBy(xpath = "//h5[contains(text(),' Please Add Dataset ...')]")
    public WebElement datasetmsg;

    @FindBy(xpath = "//button[contains(text(),'PratikshaQA')]")
    public WebElement clickdataset;

    @FindBy(xpath = "//button[contains(text(),' QA-Automation ')]")
    public WebElement selectdataset;

    @FindBy(xpath = "(//button[@class='mat-focus-indicator foregroundColor mat-mini-fab mat-button-base mat-accent'])[5]")
    public WebElement deletedataset;

    @FindBy(xpath = "(//span[contains(text(),'Next')])[2]")
    public WebElement nextbtn1;

    @FindBy(xpath = "//span[contains(text(),' Variables')]")
    public WebElement variablelabel;

    @FindBy(xpath = "//h5[contains(text(),' Please Add Variables ...')]")
    public WebElement variablemsg;

    @FindBy(xpath = "//span[contains(text(),' Add Variable ')]")
    public WebElement addvariable;

    @FindBy(xpath = "//mat-hint[contains(text(),'Only alphabets digits and - are allowed')]")
    public WebElement namemsg;

    @FindBy(xpath = "//span[contains(text(),'Add Condition')]")
    public WebElement conditionbtn;

//    @FindBy(xpath = "")

    @FindBy(xpath = "//input[@id=\"variableName\"]")
    public WebElement enetrvariablename;

    @FindBy(xpath = "//input[@id=\"variableName\"]//following::span[2]")
    public WebElement validationtypelabel;

    @FindBy(xpath = "//span[contains(text(),'Address ')]")
    public WebElement selectvalidationtype;

    @FindBy(xpath = "//span[contains(text(),' Rules ')]")
    public WebElement rulemsg;

    @FindBy(xpath = "(//span[contains(text(),'Back')])[2]")
    public WebElement backbtn;

    @FindBy(xpath = "//input[@id=\"VariableValue\"]")
    public WebElement adddefaultvalue;

    @FindBy(xpath = "//input[@placeholder=\"Enter name of Condition / Action\"]")
    public WebElement entername;

    @FindBy(xpath = "//span[contains(text(),'Add Condition')]")
    public WebElement actionbtn;

    @FindBy(xpath = "//span[contains(text(),' F ')]")
    public WebElement truebox1;

    @FindBy(xpath = "//span[contains(text(),' + ')]")
    public WebElement rulebtn;

    @FindBy(xpath = "//mat-icon[contains(text(),'add_circle_outline ')]")
    public WebElement ruleplusbtn;

    @FindBy(xpath = "(//span[contains(text(),'Add')])[6]")
    public WebElement addbtn;

    @FindBy(xpath = "//input[@placeholder=\"Enter name of Condition / Action\"]")
    public WebElement enterconditionname;

    @FindBy(xpath = "//button[@class='mat-focus-indicator ml-2 mat-stroked-button mat-button-base mat-accent']")
    public WebElement datasetcancel;

    @FindBy(xpath = "(//mat-icon[contains(text(),'delete')])[4]")
    public WebElement deletevariable;


    @FindBy(xpath = "(//mat-card[@data-toggle=\"modal\"])[1]")
    public  WebElement rulemodel;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[10]")
    public  WebElement attributedropdown;

    @FindBy(xpath = "//span[contains(text(),'Attribute / Variable')]")
    public WebElement attributedropdown1;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
    public  WebElement selectattribute;

    @FindBy(xpath = "//mat-select[@placeholder=\" Operator\"]")
    public WebElement operatordropdown;

    @FindBy(xpath = "//input[@placeholder=\"value\"]")
    public WebElement entervalue;


    @FindBy(xpath = "(//span[contains(text(),' contains ')])[1]")
    public WebElement selectoperator;

    @FindBy(xpath = "//span[contains(text(),' T ')]")
    public WebElement truebox;

    @FindBy(xpath = "//span[contains(text(),'Save ')]")
    public WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Add Action')]")
    public WebElement action;

    @FindBy(xpath = "//span[contains(text(),'Set Variable')]")
    public WebElement selectatrributedropdown;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
    public WebElement selectattribute1;

    @FindBy(xpath = "//span[contains(text(),'Set Variable')]//following::span[3]")
    public WebElement variabledropdown;

    @FindBy(xpath = "//span[contains(text(),' Adreess ')]")
    public WebElement selectvariable;

    @FindBy(xpath = "(//input[@type=\"text\"])[4]")
    public WebElement entervariable;

    @FindBy(xpath = "//input[@formcontrolname=\"project\"]")
    public WebElement enterprojectname;

    @FindBy(xpath = "//h5[contains(text(),' Please add Target Channels.')]")
    public WebElement targetchannelmsg;
    @FindBy(xpath = "//button[@class='mat-focus-indicator font-17 mat-mini-fab mat-button-base']")
    public WebElement grid_icon;
    public void clickonGridIcon() {
        this.grid_icon.click();
    }
    @FindBy(xpath = "//div[@id='mat-select-value-1']")
    public WebElement countDropDown;
    @FindBy(xpath = "//span[contains(text(),' 200 ')]")
    public WebElement selectCount;

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
    public void selectDropDownValue(){
        this.selectCount.click();
    }
    public void clickOnDropDown(){
        this.countDropDown.click();
    }
    public void clickOnTableArrowDropDown(String text) {
        driver.findElement(By.xpath("//div[text()='" + text + "']")).click();
    }

    public  void  clickOnProjectPage(){
        this.projectbtn.click();
    }

    public void clickOnRoleLabel(){
        this.rolelabel.click();
    }

    public  void  clickOnSearchRole(String text){
        this.SearchRole.sendKeys(text);
    }

    public Project_Module(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   public void clickOnSearchedProject(){
        this.searchedproject1.click();
   }


    public void searchCreatedProject(String str) throws Exception {
        this.listview.click();
        Thread.sleep(2000);
        this.searchbar.sendKeys(str);
        Thread.sleep(1000);
        this.searchedproject1.click();
    }

    public void searchUpdatedproject(String str) throws Exception {
        this.searchbar.sendKeys(str);
        this.searchedproject.click();

    }


    public void  clickOnList(){
        this.listview.click();
    }

    public void clickOnCreateProjectButton(){
        this.createbtnproject.click();
    }

    public  void  clickOnCreateButton(){
        this.createbtn.click();
    }

    public void clickOnCancelButton(){
        this.projectcancelbtn.click();
    }
    public void verifyProjectIsUpdated(String str) throws Exception {

        this.leaddropdown.click();
        Thread.sleep(1000);
        this.selectlead.click();
        Thread.sleep(1000);

    }

    public void selectDateRange(String year, String month, String date, String selectCalender) {
        driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[" + selectCalender + "]")).click();
        driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//div[@class='mat-calendar-arrow']")).click();
        List<WebElement> allyears = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement years : allyears) {
            if (years.getText().equals(year)) {
                years.click();
                break;
            }
        }
        List<WebElement> allmonth = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement months : allmonth) {
            if (months.getText().equals(month)) {
                months.click();
                break;
            }
        }
        List<WebElement> alldays = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement days : alldays) {
            if (days.getText().equals(date)) {
                days.click();
                break;
            }
        }
    }
    public void clickstatustogglebutton(){
        this.statustogglebtn.click();
    }

    public void clickondocumentautoassignmentogglebtn(){
        this.documentautoassignmentogglebtn.click();
    }
    public void clickauditenabletogglebtn(){
        this.auditenabletogglebtn.click();
    }
    public  void clickStraightThroughProcesstogglebtn(){
        this.StraightThroughProcesstogglebtn.click();
    }


    public void clickattributelabel(){
        this.attributelabel.click();
    }
    public void clickaddfieldbtn(){
        this.addfieldbtn.click();
    }

    public void clickaddattribute(){
        this.addattribute.click();
    }
    public void clickdeleteattribute(){
        this.deleteattribute.click();
    }
    public  void  clickonrolelabel(){
        this.rolelabel.click();
    }
    public void clickOnTemplateLabel(){
        this.templatelabel.click();
    }

    public void  clickAddTemplateButton(){
        this.addtemplatebtn.click();
    }

    public void selectTemplate(){
        this.template.click();
    }

    public void clickonnextbutton(){
        this.nextbtn.click();
    }
    public void clickondatasetlabel(){
        this.datasetlabel.click();
    }
    public void clickonadddatasetbtn(){
        this.adddatasetbtn.click();
    }
    public void clickondataset(){
        this.clickdataset.click();
    }
    public  void selectdataset(){
        this.selectdataset.click();
    }
    public void deletedataset(){
        this.deletedataset.click();
    }

    public void clickonvariablelabel(){
        this.variablelabel.click();
    }
    //public void clickvalidationtypelabel1(){
//        this.variablelabel1.click();
//}
    public void enterVariableName(String str){
        this.enetrvariablename.sendKeys(str);
    }
    public void clickvalidationtypelabel(){
        this.validationtypelabel.click();
    }
    public void selectvalidationtype(){
        this.selectvalidationtype.click();
    }
    public void addvariable() throws Exception {
        this.addvariable.click();
    }

    public  void enetrdefaultvalue(String str){
        this.adddefaultvalue.sendKeys(str);
    }


    public void canceldataset() throws InterruptedException {
        Thread.sleep(1000);
        this.datasetcancel.click();
    }
    public void clickoncreaterolebutton(){
        this.rulebtn.click();
    }

    public void clickaddrule(){
        this.ruleplusbtn.click();
    }

    public void enterName(String str){
        this.entername.sendKeys(str);
    }

    public void clickOnTrureBox1(){
        this.truebox1.click();
    }
    public void clickOnCondition(){
        this.actionbtn.click();
    }
    public void  clickOnAction(){

    }

    public void clickOnNextButton(){
        this.nextbtn1.click();
    }

    public  void  clickOnAttributDropdown(){
        this.attributedropdown.click();
    }

    public  void  clickOnAttributDropdown1(){
        this.attributedropdown1.click();
    }

    public  void clickOnRuleModel(){
        this.rulemodel.click();
    }
    public void selectatrribute(){
        this.selectattribute.click();
    }

    public void selectoperatodropdown(){
        this.operatordropdown.click();
    }

    public  void selectoperator(){
        this.selectoperator.click();
    }
    public  void  clickOnTrureBox(){
        this.truebox.click();
    }
    public void clickonSaveButton(){
        this.save.click();
    }

    public void clickOnAddAction(){
        this.action.click();
    }

    public void selectatrributedropdown(){
        this.selectatrributedropdown.click();
    }
    public void selectattribute1(){
        this.selectattribute1.click();
    }


    public  void variabledropdown(){
        this.variabledropdown.click();
    }

    public void selectvariable(){
        this.selectvariable.click();
    }

    public void entervariablevalue(){
        this.entervariable.click();
    }
    public void enterValue(String str){
        this.entervalue.sendKeys(str);
    }

    public  void clickOnUpdate(){
        this.updatebtn.click();
    }

    public void clickUpdate1(){
        this.updatebtn1.click();
    }
    @Step("ClickOnTemplateNameNew")
    public void ClickOnTemplateNameNew(String text) {
        Random r = new Random();
        char first_c = (char) (r.nextInt(26) + 'a');
        char second_c = (char) (r.nextInt(26) + 'a');
        this.enterprojectname.sendKeys(text + first_c + second_c);
        this.enterprojectname.click();

    }

    public void ClickOnLeadBtn() throws Exception
    {
        this.leaddropdown.click();

    }
    public void selectLead(){
        this.selectlead.click();
    }
    public void selectDocumentStructure(){
        this.docstructure.click();
    }
    public  void selectprocessengindropdown(){
        this.processengindropdown.click();
    }
    public  void selectprocessingengine(){
        this.selectenigine.click();
    }
    public void selectProjectType(){
        this.selectpeoject.click();
    }
    public  void clickOnAddRoleButton(){
        this.addrole.click();
    }
    public void selectRole(){
        this.selectrole.click();
    }

    public void disableRole(){
        this.disablerole.click();
    }
    public void clickonroleplusbutton(){
        this.clickonroleplusbutton.click();
    }

    public  void  selectUser(){
        this.user.click();
    }

    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
    public void clickOnDocumentlabel(){
        this.documentlabel.click();
    }

    public  void selectchanneldropdown(){
        this.selectchanneldropdown.click();
    }
    public  void  selectchannel(){
        this.channel.click();
    }

    public  void clickOnRuleBtn(){
        this.rulemsg.click();
    }


}