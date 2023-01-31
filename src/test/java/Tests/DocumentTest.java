package Tests;

import Pages.DocumentPage;
import Pages.LoginPage;
import Pages.Project_Module;
import Utilities.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.List;

public class DocumentTest extends BaseTest {
    DocumentPage docobj;
    SoftAssert softAssert;
    Custome_Wait custom;
    SortingLists sortingLists;
    Scroll_Page scrollPage;

    @BeforeMethod
    public void setupmethod() throws Exception {
        setup();
        loginApplication();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc01 - verify_Data_Extracted_From_Document")
    @Description("verify_Data_Extracted_From_Document")
    @Test(priority = 1, groups = "smoke", description = "verify_Data_Extracted_From_Document")
    public void verify_Data_Extracted_From_Document() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnSize();
        Thread.sleep(3000);
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,\"mat-focus-indicator ml-\")]")).getText(), "Cancel");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'MedicalReady.pdf')]")).getText(), "MedicalReady.pdf");

        softAssert.assertAll();
        docobj.clickOnChartData();
        Thread.sleep(1000);


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc02 - Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    @Description("Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    @Test(priority = 2, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details")
    public void verify_Working_Of_Diagnosis_Without_Adding_Encounter_Details() throws Exception {
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnSave();
        Thread.sleep(2000);
        softAssert.assertTrue(docobj.npierromsg.isDisplayed());
        softAssert.assertTrue(docobj.doctorerrmsg.isDisplayed());
        softAssert.assertTrue(docobj.startdateerrmsg.isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc03 - Verify_Working_Of_Diagnosis_Without_Adding_Date_Encounter_Details(")
    @Description("Verify_Working_Of_Diagnosis_Without_Adding_Date_Encounter_Details(")
    @Test(priority = 3, groups = "smoke", description = "Verify_Working_Of_Diagnosis_Without_Adding_Date_Encounter_Details(")
    public void verify_Working_Of_Diagnosis_Without_Adding_Date_Encounter_Details() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnSave();
        Thread.sleep(2000);
        docobj.enterNpiNo("122");
        docobj.enterDoctorName("Sinha");
        docobj.clickOnSave();
        softAssert.assertTrue(docobj.startdateerrmsg.isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc04 - edit_Encounter_Details")
    @Description("edit_Encounter_Details")
    @Test(priority = 4, groups = "smoke", description = "edit_Encounter_Details")
    public void edit_Encounter_Details() throws Exception {
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        scrollPage = new Scroll_Page(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));

        docobj.clickOnDiagnosisTab();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
        docobj.clickOnSave();
        Thread.sleep(2000);
        docobj.enterNpiNo("122");
        docobj.enterDoctorName("Sinha");
        docobj.clickOnCancel();
        Thread.sleep(2000);
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc05 - Without_Adding_HCC_Details")
    @Description("Without_Adding_HCC_Details")
    @Test(priority = 5, groups = "smoke", description = "Without_Adding_HCC_Details")
    public void without_Adding_HCC_Details() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        Thread.sleep(3000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));

        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class=\"mat-simple-snackbar ng-star-inserted\"]")).getText(), "Please fill all the entries before saving.");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc06 - Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Description("Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    @Test(priority = 6, groups = "smoke", description = "Verify_Without_Adding_DiagnosisName_In_HCC_Details")
    public void verify_Without_Adding_DiagnosisName_In_HCC_Details() throws Exception {
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        docobj.clickOnHCCSaveBtn();


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc07 - add_HCC_Details")
    @Description("add_HCC_Details")
    @Test(priority = 7, groups = "smoke", description = "add_HCC_Details")
    public void add_HCC_Details() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@name=\"Diagnosis\"]")));
        docobj.eneterDiasesname("CUFF");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));
        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("e11");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(), 'Type 2 diabetes mellitus with hyperosmolarity with coma')]")));
        docobj.selectDescriptionType();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();
        Thread.sleep(1000);
        docobj.clickonIcdCode();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@class=\"mat-option-text\"]")).getText(), "E1100");
        softAssert.assertAll();


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc08 - Delete_HCC_Details")
    @Description("Delete_HCC_Details")
    @Test(priority = 8, groups = "smoke", description = "Delete_HCC_Details")
    public void delete_HCC_Details() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOndiagnosis1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));

        docobj.clickOnAddHccPlusBtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@name=\"Diagnosis\"]")));
        docobj.eneterDiasesname("CUFF");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));

        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("l11");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(), 'Acquired keratosis follicularis')]")));
        docobj.selectDescriptionType();
        Thread.sleep(2000);
        docobj.clickOnHcc("111");
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();
        Thread.sleep(2000);
        docobj.deleteDiagnosis();
        Thread.sleep(1000);


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc09  - verify that user able to Check Document ")
    @Description("verify_that_user_able_to_Check_Document")
    @Test(priority = 9, groups = "smoke", description = "verify_that_user_able_to_Check_Document")
    public void verifyDocumentOnUserPage() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentPage();
        waitForloadSpinner();
        docobj.clickOnSearchDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation BRE ')]")));
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        docobj.clickOnKeyboardArrayDown();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[@class=\"mat-icon notranslate material-icons mat-icon-no-color primary-font-color\"]//following::mat-label[1]")).getText(), "Document Name");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[@class=\"mat-icon notranslate material-icons mat-icon-no-color primary-font-color\"]//following::mat-label[2]")).getText(), "Assignee");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[@class=\"mat-icon notranslate material-icons mat-icon-no-color primary-font-color\"]//following::mat-label[3]")).getText(), "Status");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[@class=\"mat-icon notranslate material-icons mat-icon-no-color primary-font-color\"]//following::mat-label[4]")).getText(), "Received Date");

        Thread.sleep(2000);
        docobj.clickOnAssigneeDropDown();
        Thread.sleep(1000);
        docobj.clickUnassignedCheckBox();
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnStatusDropDown();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-option[@class=\"mat-option mat-focus-indicator mat-option-multiple mat-selected mat-active\"]")).getText(), "Ready");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-option[@class=\"mat-option mat-focus-indicator mat-option-multiple\"])[1]")).getText(), "Rejected");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-option[@class=\"mat-option mat-focus-indicator mat-option-multiple\"])[2]")).getText(), "Processed");
        docobj.clickOnRejectedCheckBox();
        Thread.sleep(1000);
        docobj.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnApplyButton();
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc011 - edit_Diagnosis_Details")
    @Description("edit_Diagnosis_Details")
    @Test(priority = 11, groups = "smoke", description = "edit_Diagnosis_Details")
    public void edit_Diagnosis_Details() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisName();
        Thread.sleep(2000);
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc012 - verifyActionButtonWorking")
    @Description("verifyActionButtonWorking")
    @Test(priority = 12, groups = "smoke", description = "verifyActionButtonWorking")
    public void verifyActionButtonWorking() throws Exception {

        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnActionButton();
        waitForloadSpinner();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: Doc014 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 14, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        docobj = new DocumentPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnTableArrowDropDown(" Documents ");
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 1);
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Documents ");
        Thread.sleep(2000);
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(2000);
        sortingLists.sortingListInOrder("ascending", 2);
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Assignee ");
        Thread.sleep(2000);
        sortingLists.sortingListInOrder("descending ", 2);
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Assignee ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Status ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Status ']")).isEnabled());
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Status ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Size ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Size ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Received ");
        Thread.sleep(2000);
        docobj.clickOnTableArrowDropDown(" Received ");
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[8]")).getText(), "Action");
        softAssert.assertEquals(driver.findElement(By.xpath("(//th[@role=\"columnheader\"])[4]")).getText(), "Type");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: Doc015 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 15, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        scrollPage = new Scroll_Page(driver);
        softAssert = new SoftAssert();
        docobj = new DocumentPage(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
   /* docobj.clickonGridIcon();
    Thread.sleep(5000);*/
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,15000)", "");
        Thread.sleep(3000);
//        docobj.clickOnDropdown();
        docobj.clickOnDropDown();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).getText(), "10");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).getText(), "20");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).getText(), "50");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).getText(), "100");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[5]")).getText(), "200");
        Thread.sleep(1000);
        docobj.selectDropDownValue();
        Thread.sleep(1000);

        int documentcount = driver.findElements(By.xpath("//td[@class=\"mat-tooltip-trigger mat-cell cdk-cell cdk-column-document mat-column-document ng-star-inserted\"]")).size();
        softAssert.assertEquals(documentcount, 10);
        Thread.sleep(2000);
        docobj.userClickOnNextpageTab();
        softAssert.assertAll();
//        Assert.assertEquals(exepectedCountOfUserInTable, Integer.parseInt(ActualCountOfUser));
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc016 - Verify_the_Encounter_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    @Description("Verify_the_Encounter_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    @Test(priority = 16, groups = "smoke", description = "Verify_the_Encounter_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    public void verifyEncounterCountInPDFAnalytics() throws Exception {
        docobj = new DocumentPage(driver);
        //softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        Thread.sleep(2000);
        docobj.clickOnDropdown();
        docobj.selectProjectFromDropDown("888-Medical");
        docobj.openAnalyticsScreenOfADoc("B");
        waitForloadSpinner();
        docobj.clickOnChartData();
        docobj.clickOnDiagnosisTab();
        System.out.println("Number of Encounters in Diagnosis tab: " + docobj.getTotalEncounterCountFromDiagnosisTab());
        System.out.println("Total Encounter Count: " + docobj.getTotalEncounterCount());
        Assert.assertEquals(docobj.getTotalEncounterCountFromDiagnosisTab(), docobj.getTotalEncounterCount()
                , "Encounter Count does not match.");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc017 - Verify_the_ICD_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    @Description("Verify_the_ICD_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    @Test(priority = 17, groups = "smoke", description = "Verify_the_ICD_Count_matches_the_Number_of_Encounters_in_Diagnosis_Tab_in_Chart_Data")
    public void verifyICDCountInPDFAnalytics() throws Exception {
        docobj = new DocumentPage(driver);
        //softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        Thread.sleep(2000);
        docobj.clickOnDropdown();
        docobj.selectProjectFromDropDown("931-Medical-P");
        docobj.openAnalyticsScreenOfADoc("inputDocs_Wipro POC_154 2090684801");
        waitForloadSpinner();
        docobj.clickOnChartData();
        docobj.clickOnDiagnosisTab();
        Thread.sleep(3000);
        Assert.assertEquals(docobj.getTotalICDCountFromDiagnosisTab(), docobj.getTotalICDCount()
                , "Encounter Count does not match.");
    }


    List<WebElement> documentTiles = null;

    @Story("Test Case Id: Doc018 - Verify the Time taken by System")
    @Description("Verify the Time taken by System")
    @Test(priority = 18, groups = "smoke", description = "Verify the Time taken by System")
    public void Verify_Time_taken_by_System() throws Exception {
        softAssert = new SoftAssert();
        docobj = new DocumentPage(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        documentTiles = docobj.getListOfDocument();
        System.out.println(documentTiles.size());
        for (int i = 1; i <= documentTiles.size(); i++) {
            softAssert.assertTrue(DateTimeUtils.compareDates(docobj.getCreatedDateOfSearchedUserInGridView(), docobj.getUpdatedDateOfSearchedUserInGridView()
            ), "Updated Date (" + docobj.getUpdatedDateOfSearchedUserInGridView() + ") is not greater than Created Date (" + docobj.getCreatedDateOfSearchedUserInGridView() + ") for the user.");


        }
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc019 - Verify_Working_Of_Patient_Demographics")
    @Description("Verify_Working_Of_Patient_Demographics")
    @Test(priority = 19, groups = "smoke", description = "Verify_Working_Of_Patient_Demographics")
    public void verify_Working_Of_Patient_Demographics() throws Exception {

        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnPatientDempgraphics();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(text(),'Values')]")).getText(), "Values");
        softAssert.assertAll();


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc020 - Verify_Working_Of_Rejected_Document")
    @Description("Verify_Working_Of_Rejected_Document")
    @Test(priority = 20, groups = "smoke", description = "Verify_Working_Of_Rejected_Document")
    public void verify_Working_Of_Rejected_Document() throws Exception {

        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.clickOnRejectedDocumentProject();
        waitForloadSpinner();
        docobj.clickOnRejectedOuterFilterBox();
        Thread.sleep(1000);
        docobj.clickOnRejectedDocument();


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc21 - verify_Ui_labels")
    @Description("verify_Ui_labels")
    @Test(priority = 21, groups = "smoke", description = "verify_Ui_labels")
    public void verify_Ui_labels() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[@class=\"mat-icon notranslate material-icons primary-font-color mat-icon-no-color\"]//following::span[1]")).getText(), "Analytics");
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[contains(@class,\"mat-sort-header-content ng-tns\")])[1]")).getText(), "Documents");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox\"])[1]")).getText(), "Documents");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox\"])[2]")).getText(), "Processed");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox\"])[3]")).getText(), "Ready to process");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox\"])[4]")).getText(), "Rejected");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox avg\"])[1]")).getText(), "Validation Count");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox avg\"])[2]")).getText(), "Validation Time");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"infobox avg\"])[4]")).getText(), "Unassigned");
        softAssert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"bgcolor avg align_center\"])//following::span[5]")).getText(), "Filter");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base docStatus-Ready\"]")).getText(), "Ready");
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base\"])[1]")).getText(), "Rejected");
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base\"])[2]")).getText(), "Processed");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc022  - verifyReadyDocumentStatus")
    @Description("verifyReadyDocumentStatus.")
    @Test(priority = 22, groups = "smoke", description = "verifyReadyDocumentStatus.")
    public void verifyReadyDocumentStatus() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentPage();
        waitForloadSpinner();
        docobj.clickOnSearchDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation BRE ')]")));
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        List<WebElement> count = driver.findElements(By.xpath("//td[@class=\"mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted\"]"));
        for (WebElement doccount : count) {
            String totalready = doccount.getText();
            softAssert.assertEquals(driver.findElement(By.xpath("//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base docStatus-Ready\"]")).getText(), totalready);
            String readycolor = driver.findElement(By.xpath("//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base docStatus-Ready\"]")).getCssValue("color");
            String readybackcolor = driver.findElement(By.xpath("//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base docStatus-Ready\"]")).getCssValue("background-color");
            softAssert.assertEquals(readycolor, "rgba(79, 191, 249, 1)");
            softAssert.assertEquals(readybackcolor, "rgba(225, 245, 255, 1)");
            softAssert.assertAll();
        }
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc023  - verifyProcessedDocumentStatus")
    @Description("verifyProcessedDocumentStatus.")
    @Test(priority = 23, groups = "smoke", description = "verifyProcessedDocumentStatus.")
    public void verifyProcessedDocumentStatus() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentPage();
        waitForloadSpinner();
        docobj.clickOnSearchDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation BRE ')]")));
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        docobj.clickOnReadyOuterFilterBox();
        Thread.sleep(1000);
        docobj.clickOnProcessedOuterFilterBox();
        Thread.sleep(1000);
        docobj.clickOnReadyOuterFilterBox();
        Thread.sleep(1000);

        List<WebElement> count = driver.findElements(By.xpath("//td[@class=\"mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted\"]"));
        for (WebElement doccount : count) {
            String totalproceesed = doccount.getText();
            System.out.println(totalproceesed);
            softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Processed ')]")).getText(), totalproceesed);
            String proceesedcolor = driver.findElement(By.xpath("//span[contains(text(),'Processed ')]")).getCssValue("color");
            String proceesedbackcolor = driver.findElement(By.xpath("//span[contains(text(),'Processed ')]")).getCssValue("background-color");
            softAssert.assertEquals(proceesedcolor, "rgba(50, 205, 48, 1)");
            softAssert.assertEquals(proceesedbackcolor, "rgba(0, 0, 0, 0)");
            softAssert.assertAll();

        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc024  - verifyRejecteedDocumentStatus")
    @Description("verifyRejecteedDocumentStatus.")
    @Test(priority = 24, groups = "smoke", description = "verifyRejecteedDocumentStatus.")
    public void verifyRejecteedDocumentStatus() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentPage();
        waitForloadSpinner();
        docobj.clickOnSearchDropdown();
        Thread.sleep(1000);
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        docobj.clickOnRejectedOuterFilterBox();
        Thread.sleep(1000);
        docobj.clickOnReadyOuterFilterBox();
        Thread.sleep(2000);
        List<WebElement> count = driver.findElements(By.xpath("//td[@class=\"mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted\"]"));
        for (WebElement doccount : count) {
            String totalrejected = doccount.getText();
            softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Rejected ')]")).getText(), totalrejected);
            String rejectcolor = driver.findElement(By.xpath("//span[contains(text(),'Rejected ')]")).getCssValue("color");
            String rejectbackgroundcolor = driver.findElement(By.xpath("//span[contains(text(),'Rejected ')]")).getCssValue("background-color");
            System.out.println(rejectcolor);
            System.out.println(rejectbackgroundcolor);
            softAssert.assertEquals(rejectcolor, "rgba(209, 36, 36, 1)");
            softAssert.assertEquals(rejectbackgroundcolor, "rgba(0, 0, 0, 0)");
            softAssert.assertAll();
        }
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc025 - Verify the details with no documents.")
    @Description("Verify the details with no documents.")
    @Test(priority = 25, groups = "smoke", description = "Verify the details with no documents.")
    public void verifyDetailsWithNoDocuments() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Audit ')]")));
        docobj.selectProjectWithNoDocument();
        waitForloadSpinner();
        softAssert.assertTrue(driver.findElement(By.xpath("//img[@src=\"./assets/images/No content.png\"]")).isDisplayed());
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc026 - verifySearchButtonOfDocument")
    @Description("verifySearchButtonOfDocument")
    @Test(priority = 26, groups = "smoke", description = "verifySearchButtonOfDocument")
    public void verifySearchButtonOfDocument() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnserachBox();
        Thread.sleep(1000);
        docobj.enterTextInSerachBox("26");
        //NEED TO ADD ASSERTION
        softAssert.assertAll();


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc027 - Verify_Without_Adding_Comment_In_HCC_Details")
    @Description("Verify_Without_Adding_Comment_In_HCC_Details")
    @Test(priority = 27, groups = "smoke", description = "Verify_Without_Adding_Comment_In_HCC_Details")
    public void verify_Without_Adding_Comment_In_HCC_Details() throws Exception {
        docobj = new DocumentPage(driver);
        scrollPage = new Scroll_Page(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));

        docobj.clickOndiagnosis1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class=\"mat-simple-snackbar ng-star-inserted\"]")).getText(), "Please fill all the entries before saving.");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc028 - valid ICD Code")
    @Description("valid ICD Code")
    @Test(priority = 28, groups = "smoke", description = "valid ICD Code")
    public void verifyvalidIcdCode() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@name=\"Diagnosis\"]")));
        docobj.eneterDiasesname("CUFF");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));
        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("l11");
        Thread.sleep(1000);
        docobj.selectDescriptionType();
        Thread.sleep(1000);
        docobj.clickOnHCCSaveBtn();


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc029 - verifyChartFlagsDropdown")
    @Description("verifyChartFlagsDropdown")
    @Test(priority = 29, groups = "smoke", description = "verifyChartFlagsDropdown")
    public void verifyChartFlagsDropdown() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartFlagsDropdown();
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).getText(), "Clear");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).getText(), "Non-HCC");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).getText(), "Invalid Record");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).getText(), "Patient name mismatch");
        softAssert.assertAll();


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: Doc030 - Invalid ICD Code")
    @Description("Invalid ICD Code")
    @Test(priority = 30, groups = "smoke", description = "Invalid ICD Code")
    public void verifyInvalidIcdCode() throws Exception {
        scrollPage = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisName();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@name=\"Diagnosis\"]")));
        docobj.eneterDiasesname("CUFF");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));
        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("ll11");
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class=\"mat-simple-snackbar ng-star-inserted\"]")).getText(), "Please enter a valid ICD for which HCC is available.");
        softAssert.assertAll();

    }

    @Test(priority = 33)
    public void manual_intervention_structured_ready_document() throws Exception {
        // upload doc to QA-AutoProject-Structured folder in GCP:
        String document = RandomStringUtils.randomAlphabetic(1);
        UploadObject.uploadObject(ReadProps.readAttr("project_id"), ReadProps.readAttr("bucket_name"), "inputDocs/QA-Automation Structure/Pfizer" + document + ".jpg", System.getProperty("user.dir") + "\\src\\test\\resources\\structready");

        docobj = new DocumentPage(driver);
        Robot r = new Robot();
        docobj.clickOnDocumentTab();
        Thread.sleep(10000);
        docobj.clickOnDropdown();
        Thread.sleep(2000);
        docobj.selectProject();
        Thread.sleep(2000);
        System.out.println(document);

    }


    @Story("story_id: U021 -Verify text on UI Document Page.")
    @Description("Verify text present on UI Document Page.")
    @Test(priority = 21, groups = "smoke", description = "Verify text on UI Document Page")
    public void verifyUITextOnDocumentPage() throws Exception {
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        scrollPage = new Scroll_Page(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Classification')]")).getText(), "Classification");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Chart level flags')]")).getText(), "Chart level flags");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Save Drafts')]")).getText(), "Save Drafts");
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnPatientDempgraphics();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(text(),' Attributes ')]")).getText(), "Attributes");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(text(),'Values')]")).getText(), "Values");
        docobj.getTheTextOfListOfPatientDemographics();
        docobj.clickOnDiagnosisTab();
        Thread.sleep(1000);
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnDiagnosisDOSEndDate();
        Thread.sleep(1000);
        docobj.clickOnAddDiagnosisTab();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'NPI Number')]")).getText(), "NPI Number");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Doctor Name')]")).getText(), "Doctor Name");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'DOS Start Date')]")).getText(), "DOS Start Date");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'DOS End Date')]")).getText(), "DOS End Date");
        docobj.clickOnCancelBtnAddEncounterDetails();
        Thread.sleep(1000);
        docobj.clickOnAddHccPlusBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(@class,\"mat-header-cell cdk-header-cell font-14px bgcolor cdk-column-icd\")]")).getText(), "ICD");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(@class,\"mat-header-cell cdk-header-cell font-14px bgcolor cdk-column-description\")]")).getText(), "Description");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(@class,\"mat-header-cell cdk-header-cell font-14px bgcolor cdk-column-hcc \")]")).getText(), "HCC");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-header-cell[contains(@class,\"mat-header-cell cdk-header-cell font-14px bgcolor cdk-column-action mat-column-action ng-star\")]")).getText(), "Action");
        Thread.sleep(2000);
        docobj.clickOnCancelHCCButton();
        softAssert.assertAll();
    }


}