package Tests;

import Pages.DocumentPage;
import Pages.StructurePage;
import Utilities.Custome_Wait;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StructureTest extends BaseTest {

    StructurePage struct;
    SoftAssert softAssert;
    DocumentPage docobj;
    Custome_Wait custom;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        Thread.sleep(2000);
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: S001 - Revamp Side Bar")
    @Description("Revamp Side Bar")
    @Test(priority = 1, groups = "smoke", description = "Revamp Side Bar")
    public void Revamp_Side_Bar() throws Exception {
        struct = new StructurePage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        struct.clickOnIcon();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),' Users ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),'Roles')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),' Templates ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),' Datasets ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),' Projects ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),' Documents ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),'Audit ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),'Reports ')]")).isDisplayed();
        driver.findElement(By.xpath("//span[contains(text(),' Analytics ')]")).isDisplayed();
        // softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: S002 - verify_Data_Extracted_From_Document")
    @Description("verify_Data_Extracted_From_Document")
    @Test(priority = 2, groups = "smoke", description = "verify_Data_Extracted_From_Document")
    public void verify_Data_Extracted_From_Document() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation BRE ')]")));
        docobj.selectStructureProject();
        waitForloadSpinner();
        docobj.clickOnStructReadyDocument();
        waitForloadSpinner();


    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: S003 -Check Zoom In and Out")
    @Description("Check Zoom In and Out")
    @Test(priority = 3, groups = "smoke", description = "Check Zoom In and Out")
    public void verifyTheZoomInOutButton() throws Exception {
        struct = new StructurePage(driver);
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();

        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        struct.clickOnDocument();
        waitForloadSpinner();
        struct.clickOnRotateLeft();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[@id=\"rotate_right\"]")));
        struct.clickOnRotateRight();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[@mattooltip=\"Zoom In\"]")));
        struct.clickOnZoomIn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[@mattooltip=\"Zoom Out\"]")));
        struct.clickOnZoomOut();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: S004 -Verify the document page for Structured type project.")
    @Description("Verify the document page for Structured type project.")
    @Test(priority = 4, groups = "smoke", description = "Verify the document page for Structured type project.")
    public void verifyDocumentpageStructuredprojectforReadydocument() throws Exception {
        struct = new StructurePage(driver);
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        Thread.sleep(2000);
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        struct.clickOnDocument();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[@mattooltipclass=\"primary-tooltip\"]")).getText(), "13.jpg");
        softAssert.assertEquals(driver.findElement(By.xpath("//input[@mattooltipclass=\"primary-tooltip\"]")).getText(), "Application Form");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(@class,\"float-right text-center font-\")]")).getText(), "Ready");
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-undo\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-repeat\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-search-minus\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-search-plus\"]")).isDisplayed());
        docobj.clickOnData();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[1]")).getText(), "Attributes");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[2]")).getText(), "Value");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[3]")).getText(), "Action");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-label[contains(@class,'ng-tns')])[7]")).getText(), "Data");
        softAssert.assertAll();


    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: S005 -Verify the processed document page for Structured type project.")
    @Description("Verify the  processed document page for Structured type project.")
    @Test(priority = 5, groups = "smoke", description = "Verify the processed document page for Structured type project.")
    public void verifyDocumentpageStructuredprojectforProcesseddocument() throws Exception {
        struct = new StructurePage(driver);
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        Thread.sleep(2000);
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        docobj.clickOnProcessedOuterFilterBox();
        Thread.sleep(1000);
        docobj.clickOnProcessedDocument();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[@mattooltipclass=\"primary-tooltip\"]")).getText(), "QA-DemoDocument_inputDocs_structureaudit_newdocument for attribute checking 1.png");
        Thread.sleep(1000);
//        softAssert.assertEquals(driver.findElement(By.xpath("(//input[@role=\"combobox\"])[1]")).getText(),"Patient Information");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(@class,\"float-right text-center font-\")]")).getText(), "Processed");
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-undo\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-repeat\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-search-minus\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-search-plus\"]")).isDisplayed());
        docobj.clickOnData();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[1]")).getText(), "Attributes");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[2]")).getText(), "Value");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[3]")).getText(), "Action");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-label[contains(@class,'ng-tns')])[7]")).getText(), "Data");
        softAssert.assertAll();


    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case Id: S006 -Verify the processed document page for Structured type project.")
    @Description("Verify the  processed document page for Structured type project.")
    @Test(priority = 6, groups = "smoke", description = "Verify the processed document page for Structured type project.")
    public void verifyWorkingOfProcessedDocument() throws Exception {
        struct = new StructurePage(driver);
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        Thread.sleep(2000);
        docobj.clickonsearchProjectName();
        waitForloadSpinner();
        docobj.clickOnProcessedOuterFilterBox();
        Thread.sleep(1000);
        docobj.clickOnRejectedDocument();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[@mattooltipclass=\"primary-tooltip\"]")).getText(), "Template Form A1.jpg");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(@class,\"float-right text-center font-\")]")).getText(), "Rejected");
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-undo\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-repeat\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-search-minus\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-search-plus\"]")).isDisplayed());
        docobj.clickOnData();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[1]")).getText(), "Attributes");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[2]")).getText(), "Value");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-header-cell[@role=\"columnheader\"])[3]")).getText(), "Action");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-label[contains(@class,'ng-tns')])[5]")).getText(), "Data");
        softAssert.assertAll();


    }
}





