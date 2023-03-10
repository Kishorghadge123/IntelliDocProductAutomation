package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;

public class ReportPage {
    WebDriver driver;
    SoftAssert softAssert;

    public ReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'mat-tooltip-trigger projectname')]")
    WebElement selectProjectDropDown;
    @FindBy(xpath = "//div[@class='mat-list-item-content']/img[contains(@src,'Report')]")
    WebElement reportTab;

    @FindBy(xpath = "//span[contains(text(),' Filter ')]")
    WebElement filterMatIcon;
    @FindBy(xpath = "//span[@class=\"mat-button-wrapper\"]/i")
    WebElement projectDrowpdown;
    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement searchProject;
    @FindBy(xpath = "//button[contains(@class,'mat-focus-indicator font')]")
    WebElement reportDownloadbutton;
    @FindBy(xpath = "(//div[contains(@class,'mat-tooltip-trigger ng-star-inserted')]//button[contains(@role,'menuitem')])[1]")
    WebElement clickOnproject;

    @FindBy(xpath = "(//div[contains(@class,'mat-select-trigger ng-tns-c')]//div[contains(@class,'mat-select-arrow ng-tns-c')])[3]")
    WebElement clickOnDropDownStatus;

    @FindBy(xpath = "(//mat-accordion[contains(@class,'mat-accordion example-headers-align mt-2')]//mat-expansion-panel-header//span//mat-panel-title//mat-icon)[2]")
    WebElement FilterDropDownArrow;
    @FindBy(xpath = "(//button[contains(@class,'mat-focus-indicator mat-flat-button mat-button-base mat-primary')]//span[contains(text(),'Apply')])[2]")
    WebElement clickOnApplyFilter;
    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c')]//input[contains(@type,'text')])[2]")
    WebElement documentName;

    @FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns-c')]//div[contains(@class,'mat-select-arrow ng-tns-c')])[1]")
    WebElement assigneeDropDown;

    @FindBy(xpath = "(//mat-option[contains(@class,'mat-option mat-focus-indicator mat-option-multiple mat-active')])[1]")
    WebElement clickInCheckBoxOnAssignee;


    @FindBy(xpath = "(//span[contains(text(),'Audited')])[2]")
    WebElement adropdown;

    @FindBy(xpath = "(//span[contains(text(),' Pending ')])[2]")
    WebElement auditor;

    @FindBy(xpath = "//span[contains(text(),'Clear')]")
    WebElement clearButton;


    @FindBy(xpath = "(//*[local-name()='text'])[1]")
    public WebElement totalpercentage;

    @FindBy(xpath = "(//*[local-name()='text'])[2]")
    public WebElement readypercentage;

    @FindBy(xpath = "(//*[local-name()='text'])[3]")
    public WebElement processedpercentage;

    @FindBy(xpath = "(//*[local-name()='text'])[4]")
    public WebElement rejectedpercentage;


    //span[contains(text(),'Clear')]
    public void clickOnReportTab() {
        this.reportTab.click();
    }


    public void clickOnFilterMatIcon() {
        this.filterMatIcon.click();
    }

    public void getTheTextOfListOfReportsPage() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//span[@class='infobox']"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Total");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Ready");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Processed");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), "Rejected");
    }

    public void getTheTextOfListOfFilterOnReportsPage() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//div[contains(@class,'col-sm')]//following::mat-label"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Document Name");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Auditor");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Status");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), "Received Date");
        softAssert.assertEquals(getTheTableHeaderText.get(4).getText(), "Updated Date");
    }

    public void getTheTextOfListOfReportsTable() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//div[contains(@class,\"mat-sort-header-content ng-tns\")]"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Documents");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Assignee ");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Status ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " Updated Date ");
        softAssert.assertEquals(getTheTableHeaderText.get(4).getText(), " Received Date ");
    }

    public void getTheTextOfListOfButtonOnReportsPage() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//button[contains(@class,'mat-focus-indicator btn-secondary white_bg mat-stroked')]"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), " Ready ");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), " Processed ");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), " Rejected ");
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

    public void getTotalPercentage() throws Exception {
        softAssert = new SoftAssert();
        softAssert.assertEquals(Integer.parseInt((totalpercentage).getText().split("%")[0]), Double.parseDouble((readypercentage).getText().split("%")[0] + Double.parseDouble((processedpercentage).getText().split("%")[0] + Double.parseDouble((rejectedpercentage).getText().split("%")[0]))));
        softAssert.assertAll();

    }

    public void clickOnProjectDropdown() {
        this.projectDrowpdown.click();
    }

    public void selectProjectFromDropDown() {
        driver.findElement(By.xpath("(//span[contains(text(),' 10 Oct - Dataset Creation ')])[2]")).click();
    }

    public int getAllProjectsFromDropDown() {
        return driver.findElements(By.xpath("//button[@role='menuitem']")).size();
    }

    public void verifyTotalCountOfAllDocInAnalyticsSection() {
        List<WebElement> allDocs = driver.findElements(By.xpath("//div[@class='bgcolor']//h4"));
        System.out.println(allDocs);
        int count = 0;
        for (int i = 1; i < allDocs.size(); i++) {
//            if (i == allDocs.size() - 2 || i == allDocs.size() - 3) {
//                continue;
//            } else {
            count = count + Integer.parseInt(allDocs.get(i).getText());
        }

        Assert.assertEquals(allDocs.get(0).getText(), String.valueOf(count));
        System.out.println("expected:" + allDocs.get(0).getText());
        System.out.println("actual:" + String.valueOf(count));
    }


    public void verifyUserableDownloadreport() {
        this.reportDownloadbutton.click();
    }

    public boolean isFileDownloaded(String fileName) {
        File dir = new File("C:\\Users\\kishor_ghadge");
        System.out.println(dir);
        File[] dir_contents = dir.listFiles();
        if (dir_contents != null) {
            for (File dir_content : dir_contents) {
                if (dir_content.getName().equals(fileName))
                    return true;
            }
        }
        return false;
    }

    public void deleteReportFile(String fileName) {
        File dir = new File("C:\\Users\\kishor_ghadge");
        File[] dir_contents = dir.listFiles();
        if (dir_contents != null)
            for (File dir_content : dir_contents) {
                if (dir_content.getName().equals(fileName))
                    dir_content.delete();
            }
    }

    public void ClickOnDropDownsInReportTab() {
        driver.findElement(By.xpath("(//mat-icon[contains(text(),' keyboard_arrow_down ')])[1]")).click();
    }

    public void selectProject() throws InterruptedException {
        this.selectProjectDropDown.click();
        Thread.sleep(2000);
        this.searchProject.clear();
        this.searchProject.sendKeys("888-Medical");
        this.clickOnproject.click();
    }


    public String getCreatedDateOfSearchedUserInGridView() {
        return driver.findElement(By.cssSelector("td.mat-column-updated")).getText();//.split(" ")[1];
    }

    public String getUpdatedDateOfSearchedUserInGridView() {
        return driver.findElement(By.cssSelector("td.mat-column-received")).getText();//.split(" ")[1];
    }

    public void clickOnStatusDropDown() throws InterruptedException {

        this.clickOnDropDownStatus.click();
    }

    public void clickOnFilterDropDownArrow() throws InterruptedException {
        this.FilterDropDownArrow.click();
        Thread.sleep(2000);
    }

    public void clickOnApplyFilter() {
        this.clickOnApplyFilter.click();
    }

    public void SelectStatusInReportTab(int index) {
        driver.findElement(By.xpath("(//div//span[@class='mat-option-text'])[" + index + "]")).click();
    }

    public void EnterDocumentName(String documentName) {
        this.documentName.clear();
        this.documentName.sendKeys(documentName);
    }

    public void clickOnassigneeDropDown() {
        this.assigneeDropDown.click();
    }

    public void clickInCheckBoxOnAssignees() {
        this.clickInCheckBoxOnAssignee.click();
    }

    public void clickOnClearButton() {
        this.clearButton.click();
    }

    public void verifySortsortingofTableData(int index) {
        driver.findElement(By.xpath("(//table/thead/tr/th)[" + index + "]")).click();
    }

    public void clickOnAuditorDropdown() {
        this.adropdown.click();
    }

    public void selectAuditor() {
        this.auditor.click();
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
}