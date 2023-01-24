package Tests;

import Pages.TemplatePage;
import Utilities.ClickOnOutSide;
import Utilities.Custome_Wait;
import Utilities.DateTimeUtils;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TemplateTest extends BaseTest {
    TemplatePage TemplatePageObj;
    SoftAssert softAssert;
    Custome_Wait custom;

    ClickOnOutSide clickOnOutSide;

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
    @Story("story_id: T001  - Check Templates on user page ")
    @Description("verify_user_able_to_Check_Templates_on_user_page")
    @Test(priority = 1, groups = "smoke", description = "verify validation_type_as_name_on_Templates_on_user_page")
    public void verifySearchTemplatesOnUserPage() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplatesName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//td[contains(text(),' QA-Automation ')]")));
        TemplatePageObj.clickOnTemplatesName();
        //verify training of templates classification
        String expectedTrainingTemplates = driver.findElement(By.xpath("(//button[text()=' Complete '])[2]")).getText();
        String actualTrainingTemplates = driver.findElement(By.xpath("(//button[text()=' Complete '])[3]")).getText();
        softAssert.assertEquals(expectedTrainingTemplates, actualTrainingTemplates);
        TemplatePageObj.clickOnclassificationName();
        waitForloadSpinner();
        TemplatePageObj.clickOnToggleButton();
        TemplatePageObj.clickOnToggleButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//i[@class='fa fa-search-plus']")));
        TemplatePageObj.clickOnZoomInButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//i[@class='fa fa-search-minus']")));
        TemplatePageObj.clickOnZoomOutButton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' Cancel ')]")));
        TemplatePageObj.clickOnCancelButton();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T002  - Sort List Of Templates ")
    @Description("verify_user_able_to_sort_Templates")
    @Test(priority = 2, groups = "smoke", description = "verify_validation_type_as_name_to_sort_Templates")
    public void verifySortingListOfTemplates() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.getSortByTemplates.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("ascending");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Templates ')]")));
        TemplatePageObj.getSortByTemplates.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("descending");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Pages ')]")));
        TemplatePageObj.getSortbyPages.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("ascending");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Pages ')]")));
        TemplatePageObj.getSortbyPages.click();
        TemplatePageObj.sortingListOfTemplatesInOrder("descending");
        //verify the category sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Templates ')]")).getText(), "Templates");
        //verify the Datasets sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Projects ')]")).getText(), "Projects");
        //verify the Updated sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Training ')]")).getText(), "Training");
        //verify the created sort is enabled
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' Pages ')]")).getText(), "Pages");

        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T003  - check add new category on Upload Templates Button")
    @Description("verify_user_able_to_click_on_Upload_Templates ")
    @Test(priority = 3, groups = "smoke", description = "verify_validation_type_as_name_to_upload_new_telplates")
    public void verifyNewUploadTemplatesButton() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(3000);
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));

        TemplatePageObj.createNewTemplateName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'close')])[3]")));

        TemplatePageObj.clickOnCanceltemplatesButton();
        //verify upload_templates button
        softAssert.assertTrue(TemplatePageObj.uploadTemplatesButton.isDisplayed());
        //verify Create New Template
        softAssert.assertTrue(TemplatePageObj.validateCreateNewTemplate.isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T004  - Total Count Of Templatesin UserTab ")
    @Description("verify user able to check the total count on user tab")
    @Test(priority = 4, groups = "smoke", description = "verify_validation_type_as_check_total_count_on_usertab")
    public void verifyTheTotalCountOfTemplatesinUserTab() throws Exception {

        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnDropDown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[text()=' 200 ']")));
        TemplatePageObj.selectDropDownValue();
        Thread.sleep(5000);
        TemplatePageObj.userClickOnNextPageTab();
        //verify count of user in category on dataset page
        int expectedCountOfUserInTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]")).size();
        String actualCountOfUser = TemplatePageObj.getTotalUserCountOfItemPerPage();
        softAssert.assertEquals(expectedCountOfUserInTable, Integer.parseInt(actualCountOfUser));

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T005  - Verify Field Mapping functionality of Training Screen in Templates ")
    @Description("Verify Field Mapping functionlaity of Training Screen in Templates")
    @Test(priority = 5, groups = "smoke", description = "Verify_Field_Mapping_functionlaity_of_Training_Screen_in_Templates")
    public void verifyTrainingScreenFieldMapping() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        System.out.println(driver.manage().window().getSize());
//driver.manage().window().setSize(new Dimension(1552,840));
        String fieldName = "PatientName";
        String validationFieldName = "Name";
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QA1");
        TemplatePageObj.expandSearchedTemplateRow();
        TemplatePageObj.openPDFTrainingScreen();
        waitForloadSpinner();
        TemplatePageObj.enterFieldName(fieldName);
        TemplatePageObj.selectValidationColumn(validationFieldName);
        TemplatePageObj.cropAttributeValueInPDFDoc(210, 155);
        Thread.sleep(2000);
        TemplatePageObj.clickMapButton();
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "attributeName"), fieldName);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "validation"), validationFieldName);
        TemplatePageObj.removeMappingFromTable(1);
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 0);
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T006  - verifyMandtoryFieldIsWorking")
    @Description("verifyMandtoryFieldIsWorking")
    @Test(priority = 6, groups = "smoke", description = "verifyMandtoryFieldIsWorking")
    public void verifyMandtoryFieldIsWorking() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        System.out.println(driver.manage().window().getSize());
//driver.manage().window().setSize(new Dimension(1552,840));

        String fieldName = "PatientName";
        String validationFieldName = "Name";
        String fieldCityame = "CityName";
        String validationFieldCityame = "City";
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QA1");
        TemplatePageObj.expandSearchedTemplateRow();
        TemplatePageObj.openPDFTrainingScreen();
        waitForloadSpinner();
        TemplatePageObj.enterFieldName(fieldCityame);
        TemplatePageObj.selectValidationColumn(validationFieldCityame);

        TemplatePageObj.cropAttributeValueInPDFDoc(210, 155);
        Thread.sleep(2000);
        TemplatePageObj.clickMapButton();
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "attributeName"), fieldCityame);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "validation"), validationFieldCityame);
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        TemplatePageObj.clickOnMandtoryField();
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T007  - verifyMandtoryFieldIsWorking")
    @Description("verifyMandtoryFieldIsWorking")
    @Test(priority = 7, groups = "smoke", description = "verifyMandtoryFieldIsWorking")
    public void verifyWorkingOfCancelupdateandUpdate() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        System.out.println(driver.manage().window().getSize());
//driver.manage().window().setSize(new Dimension(1552,840));

        String fieldName = "PatientName";
        String validationFieldName = "Name";
        String fieldCityame = "CityName";
        String validationFieldCityame = "City";
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QA1");
        TemplatePageObj.expandSearchedTemplateRow();
        TemplatePageObj.openPDFTrainingScreen();
        waitForloadSpinner();
        TemplatePageObj.enterFieldName(fieldCityame);
        TemplatePageObj.selectValidationColumn(validationFieldCityame);

        TemplatePageObj.cropAttributeValueInPDFDoc(210, 155);
        Thread.sleep(2000);
        TemplatePageObj.clickMapButton();
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "attributeName"), fieldCityame);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "validation"), validationFieldCityame);
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        TemplatePageObj.clickOnMandtoryField();
        TemplatePageObj.clickOnUpdateButtonOfMandtoryField();
        TemplatePageObj.removeMappingFromTable(1);
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T008  - verifyMandtoryFieldIsWorking")
    @Description("verifyMandtoryFieldIsWorking")
    @Test(priority = 8, groups = "smoke", description = "verifyMandtoryFieldIsWorking")
    public void verifyWorkingOfCancel() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        System.out.println(driver.manage().window().getSize());
//driver.manage().window().setSize(new Dimension(1552,840));

        String fieldName = "PatientName";
        String validationFieldName = "Name";
        String fieldCityame = "CityName";
        String validationFieldCityame = "City";
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QA1");
        TemplatePageObj.expandSearchedTemplateRow();
        TemplatePageObj.openPDFTrainingScreen();
        waitForloadSpinner();
        TemplatePageObj.enterFieldName(fieldCityame);
        TemplatePageObj.selectValidationColumn(validationFieldCityame);

        TemplatePageObj.cropAttributeValueInPDFDoc(210, 155);
        Thread.sleep(2000);
        TemplatePageObj.clickMapButton();
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "attributeName"), fieldCityame);
        softAssert.assertEquals(TemplatePageObj.getDetailsFromMappingTable(1, "validation"), validationFieldCityame);
        //System.out.println(TemplatePageObj.getCountOfMappings());
        softAssert.assertEquals(TemplatePageObj.getCountOfMappings(), 1);
        TemplatePageObj.clickOnMandtoryField();
        TemplatePageObj.clickOnCancelUpdate();
        TemplatePageObj.removeMappingFromTable(1);
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T009  - Verify user is able to give template name(It should start with alphabet or digit) ")
    @Description("Verify user is able to give template name(It should start with alphabet or digit)")
    @Test(priority = 9, groups = "smoke", description = "Verify user is able to give template name(It should start with alphabet or digit)")
    public void verifyUserTemplateName() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(3000);
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));
        TemplatePageObj.GiveFieldName("@123");
        Thread.sleep(1000);
        clickOnOutSide.clickOutside();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[@role='alert']")).getText(), "Only alphabets,digits,parenthesis and hyphens are allowed while naming a template.");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T010  - Verify user is able to give template name(It should start with alphabet or digit) ")
    @Description("Verify user is able to give template name(It should start with alphabet or digit)")
    @Test(priority = 10, groups = "smoke", description = "Verify user is able to give template name(It should start with alphabet or digit)")
    public void verifyChooseFile() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(3000);
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));
        TemplatePageObj.GiveFieldName("QAtest");
        Thread.sleep(3000);
        //  clickOnOutSide.clickOutside();
        WebElement chooseFile = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        chooseFile.sendKeys("C:\\Users\\omkar\\Downloads\\Primary School Admission Template.jpg");
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@type='submit']")).getText(), "Create Template");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T011  - Verify the working of single Template")
    @Description("Verify the working of single Template")
    @Test(priority = 11, groups = "smoke", description = "Verify the working of single Template")
    public void verifyChooseFileSingleTemplate() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(3000);
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));
        TemplatePageObj.GiveFieldName("QAtest");
        Thread.sleep(3000);
        //  clickOnOutSide.clickOutside();
        WebElement chooseFile = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        chooseFile.sendKeys("C:\\Users\\omkar\\Downloads\\Primary School Admission Template.jpg");
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@type='submit']")).getText(), "Create Template");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T012  -Verify the working of Multiple page template")
    @Description("Verify the working of Multiple page template")
    @Test(priority = 12, groups = "smoke", description = "")
    public void verifyChooseFileMultipleTemplate() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(3000);
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));
        TemplatePageObj.GiveFieldName("QAtest");
        Thread.sleep(3000);
        //  clickOnOutSide.clickOutside();
        WebElement chooseFile = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        chooseFile.sendKeys("C:\\Users\\omkar\\Downloads\\jjpaf-application.pdf");
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@type='submit']")).getText(), "Create Template");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T013  -Verify that various template details are displayed")
    @Description("Verify that various template details are displayed")
    @Test(priority = 13, groups = "smoke", description = "Verify that various template details are displayed")
    public void verifyMultipleTemplateDetails() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(3000);
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")));
        TemplatePageObj.GiveFieldName("QAtesttest");
        Thread.sleep(3000);
        //  clickOnOutSide.clickOutside();
        WebElement chooseFile = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        chooseFile.sendKeys("C:\\Users\\omkar\\Downloads\\jjpaf-application.pdf");
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@type='submit']")).getText(), "Create Template");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//span[contains(text(),' Cancel ')]")).click();
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T014  -Verify the working of delete template button")
    @Description("Verify the working of delete template button")
    @Test(priority = 14, groups = "smoke", description = "Verify the working of delete template button")
    public void verifyDeleteBtn() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QAtestqa");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnDelete1stDoc();
        Thread.sleep(1000);
        //  TemplatePageObj.clickOnConfirmBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@color='accent'])[3]")).getText(), "Cancel");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T015  -Verify the dropdown for classification")
    @Description("Verify the dropdown for classification")
    @Test(priority = 15, groups = "smoke", description = "Verify the dropdown for classification")
    public void verifyClassificationDropDown() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QAtestqa");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnEditBtn();
        waitForloadSpinner();
        TemplatePageObj.clickOnClassificationDropDown();
        TemplatePageObj.clickOnApplicationFormOpn();
        softAssert.assertEquals(driver.findElement(By.xpath("(//Span[@class='mat-button-wrapper'])[12]")).getText(), "Complete Training");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T016  -Verify the  working of Map button without selecting field  ")
    @Description("Verify the  working of Map button without selecting field  ")
    @Test(priority = 16, groups = "smoke", description = "Verify the  working of Map button without selecting field  ")
    public void verifyMapBtn() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QAtestqa");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnEditBtn();
        waitForloadSpinner();
        TemplatePageObj.clickOnClassificationDropDown();
        TemplatePageObj.clickOnApplicationFormOpn();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//Span[@class='mat-button-wrapper'])[12]")).getText(), "Complete Training");
        TemplatePageObj.clickOnValidationDropDown();
        driver.findElement(By.xpath("//span[contains(text(),' Name ')]")).click();
        driver.findElement(By.xpath("//input[@formcontrolname='attributeName']")).sendKeys("test");
        TemplatePageObj.clickOnMapBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[@role='alert']")).getText(), " Please select the portion on image for which the field name and validations have been given. ");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T017  -Verify data Types values in Validations dropdown field should visible and editable ")
    @Description("Verify data Types values in Validations dropdown field should visible and editable ")
    @Test(priority = 17, groups = "smoke", description = "Verify data Types values in Validations dropdown field should visible and editable")
    public void verifyValidationBtn() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("testTemplate1");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnEditBtn();
        waitForloadSpinner();
        TemplatePageObj.clickOnClassificationDropDown();
        TemplatePageObj.clickOnApplicationFormOpn();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//Span[@class='mat-button-wrapper'])[12]")).getText(), "Cancel");
        TemplatePageObj.clickOnValidationDropDown();
        driver.findElement(By.xpath("//span[contains(text(),' Name ')]")).click();
        driver.findElement(By.xpath("//input[@formcontrolname='attributeName']")).sendKeys("test");
        TemplatePageObj.clickOnMapBtn();
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T018  -Verify the map attributes should present in the below table ")
    @Description("Verify the map attributes should present in the below table")
    @Test(priority = 18, groups = "smoke", description = "Verify the map attributes should present in the below table")
    public void verifyMapAttributes() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("testTemplate1");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnEditBtn();
        waitForloadSpinner();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[2]")).getText(), "Name");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[6]")).getText(), "Address");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[10]")).getText(), "Phone");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T019  -Verify save draft and complete training functionality ")
    @Description("Verify save draft and complete training functionality ")
    @Test(priority = 19, groups = "smoke", description = "Verify save draft and complete training functionality ")
    public void verifyCompleteTrainingFunctionality() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("testTemplate1");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnEditBtn();
        waitForloadSpinner();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[2]")).getText(), "Name");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[6]")).getText(), "Address");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[10]")).getText(), "Phone");
        driver.findElement(By.xpath("(//button[@color='primary'])[6]")).click();
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T020  -Verify save draft and complete training functionality ")
    @Description("Verify save draft and complete training functionality ")
    @Test(priority = 20, groups = "smoke", description = "Verify save draft and complete training functionality ")
    public void verifyDateTimeFormat() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        softAssert.assertTrue(DateTimeUtils.verifyDateFormat(TemplatePageObj.getCreatedSearchRoleInGridView()));
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T021  -Verify save draft and complete training functionality ")
    @Description("Verify save draft and complete training functionality ")
    @Test(priority = 21, groups = "smoke", description = "Verify save draft and complete training functionality ")
    public void verifyClassificationField() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("testTemplate1");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnEditBtn();
        waitForloadSpinner();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T022  -To verify the functionality of delete template page.")
    @Description("To verify the functionality of delete template page.")
    @Test(priority = 22, groups = "smoke", description = "To verify the functionality of delete template page.")
    public void verifyDeleteTemplaten() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        TemplatePageObj.searchTemplate("QAtestqa");
        Thread.sleep(3000);
        TemplatePageObj.clickOn1stOpn();
        Thread.sleep(2000);
        TemplatePageObj.clickOnDelete1stDoc();
        Thread.sleep(1000);
        //  TemplatePageObj.clickOnConfirmBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@color='accent'])[3]")).getText(), "Cancel");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: T008  - verify text on UI Template Page")
    @Description("Verify text present on UI Template Page")
    @Test(priority = 8, groups = "smoke", description = "verify text on UI Template Page")
    public void verifyUITextOnTemplatePage() throws Exception {
        softAssert = new SoftAssert();
        TemplatePageObj = new TemplatePage(driver);
        waitForloadSpinner();
        TemplatePageObj.clickOnTemplatesPage();
        waitForloadSpinner();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[contains(text(),'List of Templates')]")).getText(), "List of Templates");
        TemplatePageObj.getTheTextOfListOfTemplate();
        TemplatePageObj.searchTemplate("QA-Automation");
        TemplatePageObj.clickOnTemplateName();
        Thread.sleep(2000);
        TemplatePageObj.getTheTextOfListofTemplateName();
        softAssert.assertEquals(driver.findElement(By.xpath("//th[contains(@class,'mat-header-cell cdk-header-cell font-14px cdk-column-action')]")).getText(), "Action");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator ng-tns')]")).getText(), "Upload Template");
        TemplatePageObj.clickOnUploadTemplatesButton();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//input[@data-placeholder='Template Name']")).getText(), "Template Name *");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Create New Template')]")).getText(), "Create New Template");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mt-3 ng-tns')]")).getText(), "Create Template");
    }

}

