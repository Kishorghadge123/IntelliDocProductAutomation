package Tests;

import Pages.DatasetPage;
import Utilities.ClickOnOutSide;
import Utilities.Custome_Wait;
import Utilities.SortingLists;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

@Feature("Data Set Test")
//@Listeners(Utilities.TestListeners.class)
public class DataSetTest extends BaseTest {
    DatasetPage DatasetPageObj;
    SoftAssert softAssert;
    SortingLists sortingLists;
    Custome_Wait custom;
    ClickOnOutSide clickoutside;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

   @AfterMethod
    public void tearDown() {

        driver.quit();
   }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D001  - verify that user is able to Check search Datasets on user page ")
    @Description("verify_that_user_is_able_to_Check_Datasets_on_user_page")
    @Test(priority = 1, groups = "smoke", description = "verify_that_user_is_able_to_Check_Datasets_on_user_page")
    public void verifySearchDatasetsOnUserPage() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        clickoutside = new ClickOnOutSide(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.sendCategoryName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//td[contains(text(),'QAAutomation')]")));
        DatasetPageObj.clickOnSearchBarIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//td[contains(text(),'QAAutomation')]")));
        DatasetPageObj.clickOnCategoryName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//div[contains(@class,'mat-slide-toggle-thumb')])[1]")));
        DatasetPageObj.clickOnTogglebutton();
        Thread.sleep(2000);
        DatasetPageObj.clickOnVisibilityButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@placeholder='Search']")));
        DatasetPageObj.searchPatientName();
        Thread.sleep(3000);
        DatasetPageObj.clickOnserchBarIcon1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//span[contains(text(),'Cancel')])[2]")));
        Thread.sleep(3000);
        DatasetPageObj.clickOnCancelDatasets();

        //verify the search box is display
        softAssert.assertTrue(DatasetPageObj.clickonCategory.isDisplayed());
        //verify the count of Datasets File
//        int exepectedCountOfFileInTable = driver.findElements(By.xpath("//td[contains(text(),'QA Automation')]/following::table/tbody/tr")).size();
//        String ActualCountOfFile = driver.findElement(By.xpath("(//table/tbody/tr/td[2])[1]")).getText();
//        softAssert.assertEquals(exepectedCountOfFileInTable, Integer.parseInt(ActualCountOfFile));

        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D002  - verify that user is able to add new category on dataset page")
    @Description("verify_that_user_is_able_to_add_new_category_on_dataset_page ")
    @Test(priority = 2, groups = "smoke", description = "verify_that_user_is_able_to_add_new_category_on_dataset_page")
    public void verifyAddNewCategory() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.clickOnAddCategory();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newCategoryName']")));
        DatasetPageObj.sendCreateNewCategoryName("QAAutomation");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[text()='Create Category']")));
        DatasetPageObj.validateCreateCategoryName();
        Thread.sleep(2000);


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D003  - verify that user is able to Sort List Of Datasets ")
    @Description("verify_that_user_is_able_to_Sort_List_Of_Datasets")
    @Test(priority = 3, groups = "smoke", description = "verify_that_user_is_able_to_Sort_List_Of_Datasets")
    public void verifySortingListOfDatasets() throws Exception {
        softAssert = new SoftAssert();
        sortingLists = new SortingLists(driver);
        DatasetPageObj = new DatasetPage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.getSortByCategory.click();
        sortingLists.sortingListInOrder("ascending", 1);
        Thread.sleep(1000);
        DatasetPageObj.getSortByCategory.click();
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("descending", 1);
        //verify the category sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Category ')]")).getText(), "Category");
        //verify the Datasets sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Datasets ')]")).getText(), "Datasets");
        //verify the Updated sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Updated ')]")).getText(), "Updated");
        //verify the created sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Created ')]")).getText(), "Created");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D004  - verify that user is able to click on Action Button ")
    @Description("verify_that_user_is_able_to_click_on_Action_Button")
    @Test(priority = 4, groups = "smoke", description = "verify_that_user_is_able_to_click_on_Action_Button")
    public void verifyActionButton() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        DatasetPageObj = new DatasetPage(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.clickOnActionButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newDatasetName']")));
        DatasetPageObj.createDatasetFileName("DataFile");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(@class,'fileUpload')]/child::input")));
        DatasetPageObj.clickOnChooseCSVFile();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//span[@class='mat-button-wrapper']/mat-icon[text()='close'])[3]")));
        DatasetPageObj.clickOnCancelNewDataset();
        //verify that create new dataset
        softAssert.assertEquals(DatasetPageObj.createNewDataset.getText(), "Create New Dataset");
        //verify text on action button CSV format with maximum 100,000 entries.
        softAssert.assertEquals(DatasetPageObj.validateCSVformatText.getText(), "Please select CSV format with maximum 100,000 entries.");
//        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D005  - verify that user is able to Count total Users in UserTab ")
    @Description("verify_that_user_is_able_to_Count_total_Users_in_UserTab")
    @Test(priority = 5, groups = "smoke", description = "verify_that_user_is_able_to_Count_total_Users_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        DatasetPageObj.clickOnDropDown();
        DatasetPageObj.selectDropDownValue();
        Thread.sleep(5000);
        DatasetPageObj.userClickOnNextPageTab();
        //verify count of user in category on dataset page
        int exepectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String ActualCountOfUser = DatasetPageObj.getTotalUserCountOfItemPerPage();
        softAssert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D006  - verify create category button disable when there is no categoryname")
    @Description("verify create category button disable when there is no categoryname ")
    @Test(priority = 6, groups = "smoke", description = "verify create category button disable when there is no categoryname")
    public void verify_create_category_button_disable_when_thereis_no_categoryname() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.clickOnAddCategory();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newCategoryName']")));
        DatasetPageObj.sendCreateNewCategoryNameBlank();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[text()='Create Category']")));
        DatasetPageObj.validateCreateCategoryName();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/datasets");


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D008  - verify validation of category name field")
    @Description("verify validation of category name field ")
    @Test(priority = 8, groups = "smoke", description = "verify validation of category name field")
    public void verify_validation_of_category_name_field() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        custom = new Custome_Wait(driver);
        clickoutside = new ClickOnOutSide(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.clickOnAddCategory();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newCategoryName']")));
        DatasetPageObj.enterNewCategoryName("3@@");
        DatasetPageObj.validateCreateCategoryName();
        // clickoutside.clickOutside();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only alphabets or digits.')]")).getText(), "Please enter only alphabets or digits.");
        Thread.sleep(2000);
        // softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D009  - verify validation of dataset name field")
    @Description("verify validation of dataset name field")
    @Test(priority = 9, groups = "smoke", description = "verify validation of dataset name field\"")
    public void verify_validation_of_dataset_name_field() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        clickoutside = new ClickOnOutSide(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.sendCategoryName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//td[contains(text(),'QAAutomation')]")));
        DatasetPageObj.clickOnSearchBarIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//mat-icon[contains(text(),'add_circle_outline')]")));
        DatasetPageObj.clickOnNewDataset();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname=\"newDatasetName\"]")));
        DatasetPageObj.enterDatasetName("3@@");
        clickoutside.clickOutside();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only alphabets or digits.')]")).getText(), "Please enter only alphabets or digits.");
        //   softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D010  -verify text on UI Dataset Page")
    @Description("verify text on UI Dataset Page")
    @Test(priority = 10, groups = "smoke", description = "verify text on UI Dataset Page")
    public void verifyUITextOnDatasetPage() throws Exception {
        softAssert = new SoftAssert();
        DatasetPageObj = new DatasetPage(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        Thread.sleep(3000);
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[contains(text(),'List of Datasets')]")).getText(), "List of Datasets");
        DatasetPageObj.getTheTextOfListOfDataSet();
        softAssert.assertEquals(driver.findElement(By.xpath("//th[contains(@class,'mat-header-cell cdk-header-cell font-14px cdk')]")).getText(), "Action");
        DatasetPageObj.searchPatientName();
        Thread.sleep(2000);
        DatasetPageObj.clickOnDatasetName();
        DatasetPageObj.getTheTextOfListofDataSetCategoryName();
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[contains(@class,'mat-header-cell cdk-header-cell font-14px cdk-column-action mat-column')])[2]")).getText(), "Action");
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator ng-tns')]")).getText(), "Add Category");
        DatasetPageObj.clickOnAddCategory();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//span[text()='Create New Dataset Category']")).getText(), "Create New Dataset Category");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mt-3 ng-tns')]")).getText(), "Create Category");
        softAssert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='newCategoryName']")).getText(), "Category Name");
    }


    ///create Category(utility)

//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: D011  - verify that user is able to add new category on dataset page")
//    @Description("verify_that_user_is_able_to_add_new_category_on_dataset_page ")
//    @Test(priority = 11, groups = "smoke", description = "verify_that_user_is_able_to_add_new_category_on_dataset_page")
//    public void verifyCreateNewCategory() throws Exception {
//        softAssert = new SoftAssert();
//        DatasetPageObj = new DatasetPage(driver);
//        custom = new Custome_Wait(driver);
//        waitForloadSpinner();
//        DatasetPageObj.clickONDatasetPage();
//        waitForloadSpinner();
//        DatasetPageObj.clickOnAddCategory();
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newCategoryName']")));
//        DatasetPageObj.enterCategoryName("QA");
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[text()='Create Category']")));
//        DatasetPageObj.validateCreateCategoryName();
//        waitForloadSpinner();
//        DatasetPageObj.clickOnNewlyCreatedCategory();
//    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D020  - To verify When user add special characters in Dataset name then error message should display")
    @Description("To verify When user add special characters in Dataset name then error message should display")
    @Test(priority = 20, groups = "smoke", description = "To verify When user add special characters in Dataset name then error message should display")
    public void verifyDatasetNameValidation() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
         clickoutside=new ClickOnOutSide(driver);
        DatasetPageObj = new DatasetPage(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.clickOnActionButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newDatasetName']")));
        DatasetPageObj.createDatasetFileName("#@@@@@");
        Thread.sleep(2000);
        Actions act=new Actions(driver);
        act.moveToElement(DatasetPageObj.createDataSetName1,18,12).click().build().perform();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[@role=\"alert\"]")).getText(),"Please enter only alphabets or digits.");
        WebElement chooseFile = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        chooseFile.sendKeys("C:\\Users\\bagal\\OneDrive\\Documents\\dataset.csv");
        Thread.sleep(2000);
    softAssert.assertAll();
}





    ///for upload csv and category (utility)
    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: D022  - To verify When user add special characters in Dataset name then error message should display")
    @Description("To verify When user add special characters in Dataset name then error message should display")
    @Test(priority = 22, groups = "smoke", description = "To verify When user add special characters in Dataset name then error message should display")
    public void verifyDatasetIsCreated() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        clickoutside=new ClickOnOutSide(driver);
        DatasetPageObj = new DatasetPage(driver);
        waitForloadSpinner();
        DatasetPageObj.clickONDatasetPage();
        waitForloadSpinner();
        DatasetPageObj.clickOnActionButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname='newDatasetName']")));
        DatasetPageObj.createDatasetFileName("QA");
        Thread.sleep(2000);
        WebElement chooseFile = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        chooseFile.sendKeys("C:\\Users\\bagal\\OneDrive\\Documents\\dataset.csv");
        Thread.sleep(2000);
        DatasetPageObj.clickOnValiadationFirstDropdown();
        DatasetPageObj.selectValType1();
        DatasetPageObj.clickOnValiadationSecondDropdown();
        DatasetPageObj.selectValType1();
        DatasetPageObj.clickOnValiadationThreeDropdown();
        DatasetPageObj.selectDateValidationType();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-20000)", "");
        Thread.sleep(2000);
        DatasetPageObj.showDataFormat();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).getText(),"mm/dd/yyyy");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).getText(),"dd/mm/yyyy");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).getText(),"mm-dd-yyyy");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).getText(),"dd-mm-yyyy");
        softAssert.assertAll();



    }





    }




