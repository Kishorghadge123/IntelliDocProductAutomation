package Tests;

import Pages.Project_Module;
import Utilities.ClickOnOutSide;
import Utilities.Custome_Wait;
import Utilities.Scroll_Page;
import Utilities.SortingLists;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FreeFormTest extends BaseTest {

    Project_Module project;
    SoftAssert softAssert;
    Custome_Wait custom;
    SortingLists sortingLists;
    ClickOnOutSide clickOnOutSide;
    Scroll_Page scrollPage;

    @BeforeMethod
    public void setMethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F001 -Verify the working of Project creation of freeform ")
    @Description("Verify the working of Project creation of freeform ")
    @Test(priority = 1, groups = "smoke", description = "Verify the working of Project creation of freeform ")
    public void Verify_freeFrom_project_Creation() throws Exception {

        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.selectDocumentStructure();
        driver.findElement(By.xpath("//span[contains(text(),' Free-Form ')]")).click();
        Thread.sleep(1000);
        project.clickauditenabletogglebtn();
        Thread.sleep(1000);
        project.clickStraightThroughProcesstogglebtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='col-lg-6 pr-0 d-flex align-items-center ng-tns-c224-4']")).getText(),"Document Score (0-100)");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F002 & F003 -verify the working of field name with its validation type")
    @Description("verify the working of field name with its validation type ")
    @Test(priority = 2, groups = "smoke", description = "verify the working of field name with its validation type ")
    public void Verify_Working_Field() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("omtest");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(2000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(1000);
       project.clickFreeForm();
      //  driver.findElement(By.xpath("//span[contains(text(),' Free-Form ')]")).click();
        Thread.sleep(1000);
        project.clickauditenabletogglebtn();
        Thread.sleep(1000);
        project.clickStraightThroughProcesstogglebtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='col-lg-6 pr-0 d-flex align-items-center ng-tns-c224-4']")).getText(),"Document Score (0-100)");
        Thread.sleep(1000);
        project.clickauditenabletogglebtn();
        Thread.sleep(1000);
        project.clickStraightThroughProcesstogglebtn();
      //  softAssert.assertAll();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        project.clickaddfieldbtn();
        project.clickaddattribute();
        Thread.sleep(1000);
        project.clickaddfieldbtn();
        Thread.sleep(1000);
        project.selectEmailField();
        Thread.sleep(1000);
        project.clickaddfieldbtn();
        project.selectGender();
        Thread.sleep(1000);
        project.clickaddfieldbtn();
        project.selectNameField();
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[2]")).getText(),"Age");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[6]")).getText(),"Email");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-cell[@role='gridcell'])[10]")).getText(),"Characters");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F004 - Verify the working of free form when document straight through process if on")
    @Description("Verify the working of free form when document straight through process if on")
    @Test(priority = 4, groups = "smoke", description = "Verify the working of free form when document straight through process if on ")
    public void Verify_straight_through_process() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("omtest");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(2000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(1000);
        project.clickFreeForm();
        //  driver.findElement(By.xpath("//span[contains(text(),' Free-Form ')]")).click();
        Thread.sleep(1000);
        project.clickauditenabletogglebtn();
        Thread.sleep(1000);
        project.clickStraightThroughProcesstogglebtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='col-lg-6 pr-0 d-flex align-items-center ng-tns-c224-4']")).getText(), "Document Score (0-100)");
        Thread.sleep(1000);
       project.EnterDocumentScore(100);
       softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: F005 - Verify the working of free form when document straight through process if off")
    @Description("Verify the working of free form when document straight through process if 0ff")
    @Test(priority = 5, groups = "smoke", description = "Verify the working of free form when document straight through process if 0ff ")
    public void Verify_straight_through_process_off() throws Exception {
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        project = new Project_Module(driver);
        scrollPage = new Scroll_Page(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("omtest");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(2000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(1000);
        project.clickFreeForm();
        Thread.sleep(1000);
        project.clickauditenabletogglebtn();
        Thread.sleep(1000);
        project.clickstatustogglebutton();
        project.clickStraightThroughProcesstogglebtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='col-lg-6 pr-0 d-flex align-items-center ng-tns-c224-4']")).getText(), "Document Score (0-100)");
        Thread.sleep(1000);
        project.EnterDocumentScore(100);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        project.clickaddfieldbtn();
        project.clickaddattribute();
        Thread.sleep(1000);
        project.clickaddfieldbtn();
        Thread.sleep(1000);
        project.selectEmailField();
        Thread.sleep(1000);
        project.clickaddfieldbtn();
        project.selectGender();
        Thread.sleep(1000);
        project.clickaddfieldbtn();
        project.selectNameField();
        project.clickonrolelabel();
        Thread.sleep(2000);
        project.clickOnAddRoleButton();
        driver.findElement(By.xpath("//button[contains(text(),'Auditor')]")).click();
        // project.selectRole();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//mat-icon[contains(text(),'add_circle_outline')])[2]")).click();
        driver.findElement(By.xpath("//span[contains(text(),' omkar.ranaware@neutrinotechlabs.com ')]")).click();
        Thread.sleep(2000);
        clickOnOutSide.clickOutside();
        scrollPage.ScrollUpDown(driver.findElement(By.xpath("//mat-label[contains(text(),'End Date ')]")));
        project.clickStraightThroughProcesstogglebtn();
        project.clickOnCreateButton();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[@class='primary-font-color']")).getText(),"List of Projects");
        softAssert.assertAll();
    }
}
