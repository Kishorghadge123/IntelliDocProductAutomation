package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class DatasetPage {
    WebDriver driver = null;
    SoftAssert softAssert;


    public DatasetPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//td[contains(text(),' QAAutomation ')]")
    public WebElement dataSetName;

    @FindBy(xpath = "//img[contains(@src,\"Datasets.svg\")]")
    public WebElement dataSets;

    @FindBy(xpath = "//mat-icon[contains(text(),'add_circle_outline')]")
    public WebElement datasetnew;

    @FindBy(xpath = "//input[@formcontrolname=\"newDatasetName\"]")
    public WebElement datasetname;


    @FindBy(xpath = "//input[@data-placeholder='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//mat-icon[contains(text(),'search')]")
    public WebElement searchBar;

    @FindBy(xpath = "//td[contains(text(),'QAAutomation')]")
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


    @FindBy(xpath = "(//mat-icon[contains(text(),'add_circle_outline')])[1]")
    public WebElement newcategory;


    By createNewCategory = By.xpath("//input[@formcontrolname='newCategoryName']");

    @FindBy(xpath = "//span[contains(text(),'Create Dataset')]")
    public WebElement createdataset;

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


    public By createDataSetName = By.xpath("//input[@formcontrolname='newDatasetName']");

    @FindBy(xpath = "//input[@formcontrolname='newDatasetName']")
    public WebElement createDataSetName1;


    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[2]")
    public WebElement selectfirstvalidationtypefirst;


    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[3]")
    public WebElement selectfirstvalidationtypesecond;

    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[4]")
    public WebElement selectfirstvalidationtypethird;


    @FindBy(xpath = "//span[contains(text(),' Date ')]")
    public WebElement selectdatedata;

    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[5]")
    public WebElement dateformat;

    @FindBy(xpath = "(//span[@class=\"mat-option-text\"])[1]")
    public WebElement valtype;


    @FindBy(xpath = "//span[contains(text(),' Name ')]")
    public WebElement valtype1;

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

    public void clickOnNewDataset() {
        this.datasetnew.click();
    }

    public void enterDatasetName(String str) {
        this.datasetname.sendKeys(str);
    }

    public void sendCategoryName() {
        this.searchBox.sendKeys("QAAutomation");
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
        this.searchBox1.sendKeys("1");
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

    public void clickOnNewlyCreatedCategory() {
        this.newcategory.click();
    }


    public void clickOnDatasetName() {
        this.dataSetName.click();
    }

    public void getTheTextOfListOfDataSet() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//div[contains(@class,'mat-sort-header-content ng-tns')]"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), "Category");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), "Datasets");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), "Updated");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), "Created");
    }

    public void getTheTextOfListofDataSetCategoryName() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//div[contains(@class,'mat-sort-header-content ng-tns')]"));
        softAssert.assertEquals(getTheTableHeaderText.get(4).getText(), "Datasets");
        softAssert.assertEquals(getTheTableHeaderText.get(5).getText(), "Projects");
        softAssert.assertEquals(getTheTableHeaderText.get(6).getText(), "File Name");
        softAssert.assertEquals(getTheTableHeaderText.get(7).getText(), "Created");
    }

    public void sendCreateNewCategoryName(String text) {
        driver.findElement(createNewCategory).sendKeys(text);
    }


    public void enterCategoryName(String text) {

        Random r = new Random();
        char first_c = (char) (r.nextInt(26) + 'a');    // char second_c = (char) (r.nextInt(26) + 'a');
        driver.findElement(createNewCategory).sendKeys(text + first_c);

    }

    public void sendCreateNewCategoryNameBlank() {
        driver.findElement(createNewCategory).sendKeys("");
    }

    public void enterNewCategoryName(String str) {
        driver.findElement(createNewCategory).sendKeys(str);
    }

    public void validateCreateCategoryName() {
        this.validateCreateCategory.click();
    }


    public void clickOnCreateDataset() {
        this.createdataset.click();
    }


    public void clickOnActionButton() {
        this.actionButton.click();
    }

    public void clickOnValiadationFirstDropdown() {
        this.selectfirstvalidationtypefirst.click();
    }

    public void clickOnValiadationSecondDropdown() {
        this.selectfirstvalidationtypesecond.click();
    }

    public void clickOnValiadationThreeDropdown() {
        this.selectfirstvalidationtypethird.click();
    }

    public void selectDateValidationType() {
        this.selectdatedata.click();
    }

    public void showDataFormat() {
        this.dateformat.click();
    }

    public void selectValType1() {


        try {
            this.valtype1.click();
        } catch (StaleElementReferenceException sere) {
            System.out.println("Stale Element Reference Exception");
            sere.printStackTrace();
            PageFactory.initElements(driver, this);
            this.valtype1.click();

        }
    }


    public void createDatasetFileName(String text) {


        Random r = new Random();
        char first_c = (char) (r.nextInt(26) + 'a');    // char second_c = (char) (r.nextInt(26) + 'a');
        driver.findElement(createDataSetName).sendKeys(text + first_c);
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
