package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class AuditPage {
    WebDriver driver;
    SoftAssert softAssert;

    public AuditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),' Filter ')]")
    WebElement filterMatIcon;

    @FindBy(xpath = "//img[contains(@src,'Audit')]")
    WebElement auditTab;

    @FindBy(xpath = "//span[contains(@class,'mat-tooltip-trigger projectname')]")
    WebElement selectProjectDropDown;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement searchProject;

    @FindBy(xpath = "(//div[contains(@class,'mat-tooltip-trigger ng-star-inserted')]//button[contains(@role,'menuitem')])[1]")
    WebElement clickOnproject;

    @FindBy(xpath = "(//span[contains(text(),' Pending ')])[2]")
    WebElement selectStatusPending;

    @FindBy(xpath = "(//span[contains(text(),' Audited ')])[2]")
    WebElement selectStatusAudited;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')])[2]")
    WebElement clickStatusDropDownArrow;

    @FindBy(xpath = "(//button[contains(@class,'mat-focus-indicator mat-flat-button mat-button-base mat-primary')]//span[contains(text(),'Apply')])[2]")
    WebElement clickOnApplyFilter;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//input[contains(@type,'text')])[2]")
    WebElement documentName;

    @FindBy(xpath = "(//table/tbody/tr/td[8])[1]")
    WebElement ActionButtoninTable;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//input[contains(@aria-label,'Choose one option')])[1]")
    WebElement classificationTab;

    @FindBy(xpath = "//div[contains(@role,'listbox')]")
    WebElement selectChatsDropDown;

    @FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')]//div[contains(@class,'mat-select-arrow ng-tns')])[1]")
    WebElement chatLevelFlagDropDown;

    @FindBy(xpath = "//span[contains(@class,'mat-expansion-indicator ng-tns-c')]")
    WebElement chatCardDropDown;

    @FindBy(xpath = "(//mat-option[contains(@class,'mat-option mat-focus-indicator mat-option-multiple mat-active')])[1]")
    WebElement clickInCheckBoxOnAssignee;
    @FindBy(xpath = "//mat-row[contains(@role,'row')]//mat-cell[text()=' SSN ']")
    public WebElement ssn;
//    @FindBy(xpath = "//input[@id='mat-input-6']")

    @FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')]//div[contains(@class,'mat-select-arrow ng-tns-c')])[1]")
    WebElement assigneeDropDown;
    @FindBy(xpath = "//span[contains(text(),'Clear')]")
    WebElement clearButton;

    public void clickOnassigneeDropDown() {
        this.assigneeDropDown.click();
    }

    public void clickOnauditTab() {
        this.auditTab.click();
    }

    @FindBy(xpath = "(//mat-select[@aria-haspopup='true'])[3]")
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

    public void selectDropDownValue() {
        this.selectCount.click();
    }

    public void clickOnDropDown() {
        this.countDropDown.click();
    }


    public void clickOnTableArrowDropDown(String text) {
        driver.findElement(By.xpath("//div[text()='" + text + "']")).click();
    }

    public void ClickOnDropDownsInAuditPage(int index) {
        driver.findElement(By.xpath("(//span[contains(@class,'mat-content ng-tns-c')]//mat-panel-title[contains(@class,'mat-expansion-panel-header-title justify-content-start ng-tns-c')])[" + index + "]")).click();
    }

    public String verifyTheTotalCountOfAuditedAndAuditPendingDoc(int index) {
        return driver.findElement(By.xpath("(//div[contains(@class,'mat-exp')]//div[contains(@class,'bgcolor')]//h4)[" + index + "]")).getText();
    }

    public void selectProject() throws InterruptedException {
        this.selectProjectDropDown.click();
        Thread.sleep(2000);
        this.searchProject.clear();
        this.searchProject.sendKeys("888-Medical");
        Thread.sleep(1000);
        this.clickOnproject.click();
    }

    public void verifySortsortingofTableData(int index) {
        driver.findElement(By.xpath("(//table/thead/tr/th)[" + index + "]")).click();
    }

    public void clickOnPendingStatus() {
        this.selectStatusPending.click();
    }

    public void clickOnAuditedStatus() {
        this.selectStatusAudited.click();
    }

    public void clickStatusDropDownArrow() {
        this.clickStatusDropDownArrow.click();
    }

    public void clickOnApplyFilter() {
        this.clickOnApplyFilter.click();
    }

    public void enterDocName(String docName) {
        this.documentName.sendKeys(docName);
    }

    public void clickOnActionButtoninTable() {
        this.ActionButtoninTable.click();
    }

    public void clickOnClassificationTab() {
        this.classificationTab.click();
    }

    public void SelectChatsDropDown() {
        this.selectChatsDropDown.click();
    }

    public void SelectChatLevelFlags(int index) {
        driver.findElement(By.xpath("(//span[contains(@class,'mat-option-text')])[" + index + "]")).click();
    }

    public void SelectChatLevelFlagsDropDown() {
        this.chatLevelFlagDropDown.click();
    }

    public void clickOnChatCardDropDown() {
        this.chatCardDropDown.click();
    }

    public void verifyPetientDetails() {
        driver.findElement(By.xpath("//mat-row[contains(@role,'row')]//mat-cell[text()=' SSN ']"));
    }

    public void clickOnClearButton() {
        this.clearButton.click();
    }

    public void clickInCheckBoxOnAssignees() {
        this.clickInCheckBoxOnAssignee.click();
    }


    public void getTheTextOfListOfFilterOnAuditPage() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//div[contains(@class,'col-sm')]//following::mat-label"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Document Name");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Auditor");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Status");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), "Updated Date");
    }

    public void getTheTextOfListOfAuditTable() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//div[contains(@class,\"mat-sort-header-content ng-tns\")]"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Documents");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Auditor");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Status");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), "Type");
        softAssert.assertEquals(getTheTableHeaderText.get(4).getText(), "Size");
        softAssert.assertEquals(getTheTableHeaderText.get(5).getText(), "Updated");
        softAssert.assertEquals(getTheTableHeaderText.get(6).getText(), "Received");
    }

    public void getTheTextOfListOfButtonOnAuditPage() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//button[contains(@class,'mat-focus-indicator btn-secondary white_bg mat-stroked')]"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Pending");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Audited");
    }

    public void clickOnFilterMatIcon() {
        this.filterMatIcon.click();
    }

    public void getTheTextOfListOfAuditPage() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//span[@class='infobox']"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Total");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Audited");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Audit Pending");
    }

    @FindBy(xpath = "//span[contains(text(),' Analytics ')]")
    public WebElement analyticsDropDown;

    public void clickOnAnalyticsDropDown(){
        this.analyticsDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Filter ')]")
    public WebElement filterDropDown;

    public void clickOnFilterDropDown(){
        this.filterDropDown.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[1]")
    public WebElement filterAuditorDropDown;

    public void clickOnAuditorDropDown(){
        this.filterAuditorDropDown.click();
    }

   @FindBy(xpath = "//tr[1]//td[1]")
    public WebElement firstDoc;

    public void ClickOn1stDoc(){
        this.firstDoc.click();
    }
}