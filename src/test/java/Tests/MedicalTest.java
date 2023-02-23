package Tests;

import Pages.*;
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
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MedicalTest extends BaseTest {


    Project_Module project;
    ClickOnOutSide clickOnOutSide;
    DocumentPage docobj;
    MedicalPage medobj;
    SoftAssert softAssert;
    Custome_Wait custom;
    SortingLists sortingLists;
    Scroll_Page s;
    UserPage userPage;
    LoginPage loginobj;
    JavascriptExecutor js;

    @BeforeMethod
    public void setupmethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M001 - Verify Medical Project With Only PD option")
    @Description(" Verify Medical Project With Only PD option")
    @Test(priority = 1, groups = "smoke", description = "Verify Medical Project With Only PD option")
    public void  verify_Medical_Project_With_Only_PD_Option() throws Exception {
        docobj = new DocumentPage(driver);
        medobj=new MedicalPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
       Thread.sleep(2000);
        medobj.clickOnMedicalProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class=\"mat-tab-label-content\"]")).getText(),"Patient Demographics");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,\"mat-focus-indicator ml-\")]")).getText(),"Cancel");
        softAssert.assertAll();
    }



    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M002 -  verify_Save_Draft_Functionality")
    @Description("Verify Save Draft Functionality")
    @Test(priority = 2, groups = "smoke", description = " verify_Save_Draft_Functionality")
    public void  verify_Save_Draft_Functionality() throws Exception {
        docobj = new DocumentPage(driver);
        project=new Project_Module(driver);
        medobj=new MedicalPage(driver);
        softAssert = new SoftAssert();
        loginobj=new LoginPage(driver);
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("(//h4[@class=\"avg-time p-0\"])[1]")).getText(),"0");
        softAssert.assertAll();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        driver.navigate().refresh();
     waitForloadSpinner();
        docobj.clickOnSaveDraftButtonDropdown();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();
        Thread.sleep(1000);
        docobj.clickOnSaveDraft();







    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M003 - Verify Historical Dataset Toggle Button")
    @Description("Verify Historical Dataset Toggle Button")
    @Test(priority = 3, groups = "smoke", description = "Verify Historical Dataset Toggle Button")
    public void  verify_Medical_Project_WithEntityAndHistoricalDataset() throws Exception {
        docobj = new DocumentPage(driver);
        medobj=new MedicalPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project=new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnProjectPage();
        waitForloadSpinner();
        project.searchProject("QA-Automation-Medical-One-Option");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        Thread.sleep(2000);
       project.clickOnEditButton();
        waitForloadSpinner();
        project.historicalDatasetToggleButton();
        Thread.sleep(1000);
        project.historicalDatasetToggleButton();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-slide-toggle[@formcontrolname=\"isHistoricalDatasetEnabled\"]//preceding::mat-label[1]")).getText(),"Historical Dataset   ");
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        Thread.sleep(2000);
        medobj.clickOnMedicalProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class=\"mat-tab-label-content\"]")).getText(),"Patient Demographics");
        softAssert.assertAll();
    }

//    @Severity(SeverityLevel.NORMAL)
//    @Story("story_id: M006 - To Verify Add entity options")
//    @Description("To Verify Add entity options")
//    @Test(priority = 06, groups = "smoke", description = "To Verify Add entity options")
//    public void to_Verify_Target_Count() throws Exception {
//        softAssert = new SoftAssert();
//        s=new Scroll_Page(driver);
//        custom=new Custome_Wait(driver);
//        project = new Project_Module(driver);
//        waitForloadSpinner();
//        project.clickOnProjectPage();
//        waitForloadSpinner();
//        project.searchProject("QA-Automation Audit");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
//        Thread.sleep(2000);
//        project.clickOnEditButton();
//        waitForloadSpinner();
//        project.selectEntityLabel();
//        Thread.sleep(2000);
//        s.ScrollUpDown(driver.findElement(By.xpath("//span[contains(text(),'Target Channels')]")));
//       project.deletePd();
//       Thread.sleep(1000);
//       project.clickOnAddEntity();
//       Thread.sleep(1000);
//       project.selectFirstOption();
//        Thread.sleep(1000);
//        project.clickOnUpdate();
//
//    }



    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: M005 - to_Verify_Target_Count(")
    @Description("to_Verify_Target_Count(")
    @Test(priority = 5, groups = "smoke", description = "to_Verify_Target_Count(")
    public void to_Verify_Target_Count() throws Exception {
        softAssert = new SoftAssert();
        s = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        custom = new Custome_Wait(driver);
        userPage = new UserPage(driver);
        project = new Project_Module(driver);
        loginobj=new LoginPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver,driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("omoperator");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr/td[1]")).click();
      //  userPage.clickonActionBtton();
        waitForloadSpinner();
        userPage.enterTargetCount("10");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).clear();
        Thread.sleep(1000);
        userPage.enterTargetCount("50");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-30000)", "");
        Thread.sleep(3000);
        userPage.clickOnUpdateButton();
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("omoperator@gmail.com");
        loginobj.setPassword("Omkar@000");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("(//h4[@class=\"avg-time p-0\"])[1]")).getText(),"50");
        softAssert.assertAll();
        docobj.clickOnReadyDocument();





    }





    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M007 - verifyChartFlagsDropdown")
    @Description("verifyChartFlagsDropdown")
    @Test(priority = 7, groups = "smoke", description = "verifyChartFlagsDropdown")
    public void verifyChartFlagsDropdown() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        loginobj=new LoginPage(driver);
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartFlagsDropdown();
       Thread.sleep(1000);
       docobj.selectNonHccFlag();
        Thread.sleep(1000);
        docobj.clickOnSaveDraft();






    }




    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M008 - verifyMedicalDocumentFunctionality")
    @Description("verifyMedicalDocumentFunctionality")
    @Test(priority = 8, groups = "smoke", description = "verifyMedicalDocumentFunctionality")
    public void verifyMedicalDocumentFunctionality() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        loginobj = new LoginPage(driver);
        clickOnOutSide=new ClickOnOutSide(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22@");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();

        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[@mattooltipclass=\"primary-tooltip\"]")).getText(),"MedicalReady.pdf");
       docobj.clickOnSaveDraftButtonDropdown();
       softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).getText(),"Clarification");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).getText(),"Waiting for auditor");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).getText(),"To confirm provider name with others");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).getText(),"Bigger Chart");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[5]")).getText(),"None");
        clickOnOutSide.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnChartFlagsDropdown();
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).getText(),"Clear");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).getText(),"Non-HCC");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).getText(),"Invalid Record");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).getText(),"Patient name mismatch");
        softAssert.assertAll();

    }













    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M009 - verifySaveDraftFunctionality")
    @Description("verifySaveDraftFunctionality")
    @Test(priority = 9, groups = "smoke", description = "verifySaveDraftFunctionality")
    public void verifySaveDraftFunctionality() throws Exception {
        docobj = new DocumentPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        clickOnOutSide=new ClickOnOutSide(driver);
        loginobj=new LoginPage(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnSaveDraftButtonDropdown();
      Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();
        Thread.sleep(1000);
        docobj.clickOnSaveDraft();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M010 - verifySaveDraftFunctionalityWithEditingComment")
    @Description("verifySaveDraftFunctionalityWithEditingComment")
    @Test(priority = 10, groups = "smoke", description = "verifySaveDraftFunctionalityWithEditingComment")
    public void verifySaveDraftFunctionalityWithEditingComment() throws Exception {
        docobj = new DocumentPage(driver);
        medobj=new MedicalPage(driver);
        softAssert = new SoftAssert();
        s=new Scroll_Page(driver);
        custom = new Custome_Wait(driver);
        clickOnOutSide=new ClickOnOutSide(driver);
        loginobj=new LoginPage(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(3000);
        s.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        Thread.sleep(3000);
        docobj.clickOndiagnosis1();
        Thread.sleep(1000);
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
     //   Assert.assertEquals(driver.getCurrentUrl(), "https://www.avizva.com/");
        driver.close();
       // driver.switchTo().defaultContent();
        driver.switchTo().window(parentHandle);
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);
        medobj.clickHeaderDropdown1();
      //  Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'No HCC Codes ')]")).click();
        Thread.sleep(2000);
        s.ScrollUpDown(driver.findElement(By.xpath("//span[contains(text() ,' Save Draft')]")));
        Thread.sleep(2000);
        medobj.SaveDraftDropDown();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),' Bigger Chart ')]")).click();
        Thread.sleep(2000);
//        docobj.clickOnSaveDraftButtonDropdown();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();
//        Thread.sleep(1000);
        docobj.clickOnSaveDraft();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://alpha.neutrino-ai.com/#/home/documents");

    }





    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M011 - verifyDeleteEncounterFunctionality")
    @Description("verifyDeleteEncounterFunctionality")
    @Test(priority = 11, groups = "smoke", description = "verifyDeleteEncounterFunctionality")
    public void verifyDeleteEncounterFunctionality() throws Exception {
        docobj = new DocumentPage(driver);
        medobj = new MedicalPage(driver);
        softAssert = new SoftAssert();
        s = new Scroll_Page(driver);
        custom = new Custome_Wait(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        loginobj = new LoginPage(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("omoperator@gmail.com");
        loginobj.setPassword("Omkar@000");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //   Assert.assertEquals(driver.getCurrentUrl(), "https://www.avizva.com/");
        driver.close();
        // driver.switchTo().defaultContent();
        driver.switchTo().window(parentHandle);
        System.out.println(driver.getWindowHandle());
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        s.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOndiagnosis1();
        docobj.clickOnAddHccPlusBtn();
      docobj.eneterDiasesname("CUFF");
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
       docobj.clickOnHcc("111");
        docobj.clickOnHCCSaveBtn();
        Thread.sleep(2000);
        docobj.clickOnDeleteDiagnosisName();
//        docobj.clickOnAddHccPlusBtn();
//docobj.enterPageNumber("1");
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
//        docobj.selectHccDropdown();
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
//        docobj.selectComments();
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add ICD')]")));
//        docobj.clickOnAddIcdBtn();
//        Thread.sleep(2000);
//        docobj.enterIcdNo("l11");
//        Thread.sleep(1000);
//        docobj.selectDescriptionType();
//        Thread.sleep(1000);
//        docobj.clickOnHcc("111");
//        docobj.clickOnHCCSaveBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-expansion-panel-header[@role='button'])[1]")).getText(),"Chart Data");
    softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M012 - Verify_Working_Of_Diagnosis")
    @Description("Verify_Working_Of_Diagnosis")
    @Test(priority = 12, groups = "smoke", description = "Verify_Working_Of_Diagnosis")
    public void verify_Working_Of_Diagnosis() throws Exception {
        s = new Scroll_Page(driver);
        docobj = new DocumentPage(driver);
        medobj=new MedicalPage(driver);
        project=new Project_Module(driver);
        loginobj = new LoginPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        clickOnOutSide=new ClickOnOutSide(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("omoperator@gmail.com");
        loginobj.setPassword("Omkar@000");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnDropdown();
     //   custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' QA-Automation Medical ')]")));
        driver.findElement(By.xpath("(//button[@role='menuitem'])[1]")).click();
     //   docobj.selectProject();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
   //     softAssert.assertTrue(docobj.readydocname.isDisplayed());
        softAssert.assertAll();
        docobj.clickOnChartData();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),' Diagnosis ')]")));
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //   Assert.assertEquals(driver.getCurrentUrl(), "https://www.avizva.com/");
        driver.close();
        // driver.switchTo().defaultContent();
        driver.switchTo().window(parentHandle);
        System.out.println(driver.getWindowHandle());
        docobj.clickOnDiagnosisTab();
//        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[1]")));
        s.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOnAddDiagnosisTab();
        Thread.sleep(3000);
      //  docobj.clickOnSave();
      //  Thread.sleep(2000);
     //   docobj.enterNpiNo("122");
        docobj.enterDoctorName("Ramon smith");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'arrow_forward')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='mat-radio-container'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@class='mat-focus-indicator foregroundColor mat-mini-fab mat-button-base mat-accent'])[2]")).click();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(1000);
        docobj.clickOnSave();
        waitForloadSpinner();
        medobj.clickOnDiagnosisDos();
        Thread.sleep(1000);
        medobj.deleteEncounter();
        Thread.sleep(1000);
        medobj.clickOnDiagnosisDos();
        Thread.sleep(3000);
        medobj.clickOnEditEncounter();
        docobj.clickOnCancel();
        softAssert.assertTrue(docobj.adddiagnosisbtn.isDisplayed());
        softAssert.assertTrue(medobj.editencounter.isDisplayed());
        softAssert.assertTrue(medobj.deleteencounter.isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'I10')])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//mat-cell[contains(text(),'187')])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//mat-icon[contains(text(),' delete ')])[1]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("(//mat-icon[contains(text(),' create ')])[1]")).isDisplayed());
        medobj.headerDropdown();
        Thread.sleep(1000);
      List<WebElement> dropdownlist=driver.findElements(By.xpath("//span[@class=\"mat-option-text\"]"));
        softAssert.assertEquals(dropdownlist.get(0).getText(), "Assessment/Plan");
        softAssert.assertEquals(dropdownlist.get(1).getText(), "Problem List");
        softAssert.assertEquals(dropdownlist.get(2).getText(), "PMH");
        softAssert.assertEquals(dropdownlist.get(3).getText(), "HPI");
        softAssert.assertEquals(dropdownlist.get(4).getText(), "Medication");
        softAssert.assertEquals(dropdownlist.get(5).getText(), "Examination");
        softAssert.assertEquals(dropdownlist.get(6).getText(), "NA");
        clickOnOutSide.clickOutside();
        Thread.sleep(1000);
        docobj.clickOnHeaderDropdown();
        Thread.sleep(1000);
        List<WebElement> dropdownlistofcomment=driver.findElements(By.xpath("//span[@class=\"mat-option-text\"]"));
        softAssert.assertEquals(dropdownlistofcomment.get(0).getText(), "ADD");
        softAssert.assertEquals(dropdownlistofcomment.get(1).getText(), "No HCC codes");
        softAssert.assertEquals(dropdownlistofcomment.get(2).getText(), "No valid records found");
        softAssert.assertEquals(dropdownlistofcomment.get(3).getText(), "Dx listed but not Monitored/Evaluated/Assessed/Treated");
        softAssert.assertEquals(dropdownlistofcomment.get(4).getText(), "Patient name or Identifiers lacking");
        softAssert.assertEquals(dropdownlistofcomment.get(5).getText(), "Provider names or identifiers lacking");
        softAssert.assertEquals(dropdownlistofcomment.get(6).getText(), "Illegible Handwriting");

      //  softAssert.assertAll();


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M013 - Verify_Working_Of_Multiple_ICD_And_Delete")
    @Description(" Verify_Working_Of_Multiple_ICD_And_Delete")
    @Test(priority = 13, groups = "smoke", description = " Verify_Working_Of_Multiple_ICD_And_Delete")
    public void  verify_Working_Of_Multiple_ICD_And_Delete() throws Exception {
        docobj = new DocumentPage(driver);
        medobj = new MedicalPage(driver);
        softAssert = new SoftAssert();
        s = new Scroll_Page(driver);
        custom = new Custome_Wait(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        loginobj = new LoginPage(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        s.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOndiagnosis1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
      Thread.sleep(1000);
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")));
        docobj.enterPageNumber("1");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Add Comment')]")));
        docobj.selectHccDropdown();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),' No valid records found ')]")));
        docobj.selectComments();
        Thread.sleep(1000);
        medobj.selecticdHeaderDropdown();
        Thread.sleep(1000);
        medobj.clickonCommentDropdown();
        Thread.sleep(1000);
        docobj.clickOnAddIcdBtn();
        Thread.sleep(2000);
        docobj.enterIcdNo("l12");
        Thread.sleep(1000);
        docobj.selectDescriptionType();
        Thread.sleep(1000);
        docobj.clickOnHcc("111");
        docobj.clickOnHCCSaveBtn();
        Thread.sleep(1000);
        docobj.deleteDiagnosis();
        driver.navigate().refresh();


    }



    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: M014 - Verify_Working_Diagnosis_Without_Adding Comment")
    @Description("Verify_Working_Diagnosis_Without_Adding Comment")
    @Test(priority = 14, groups = "smoke", description = " Verify_Working_Diagnosis_Without_Adding Comment")
    public void  verify_Working_Diagnosis_Without_Adding_Comment() throws Exception {
        docobj = new DocumentPage(driver);
        medobj = new MedicalPage(driver);
        softAssert = new SoftAssert();
        s = new Scroll_Page(driver);
        custom = new Custome_Wait(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        loginobj = new LoginPage(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("pratikshaoperator@gmail.com");
        loginobj.setPassword("Pratiksha@22");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        docobj.clickOnDocumentTab();
        waitForloadSpinner();
        docobj.clickOnReadyDocument();
        waitForloadSpinner();
        docobj.clickOnChartData();
        Thread.sleep(1000);
        docobj.clickOnDiagnosisTab();
        Thread.sleep(2000);
        s.ScrollUpDown(driver.findElement(By.xpath("//div[contains(text(),'DOS End Date ')]")));
        docobj.clickOndiagnosis1();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),' add')])[2]")));
        docobj.clickOnAddHccPlusBtn();
        Thread.sleep(1000);
        docobj.clickOnAddIcdBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-error[contains(@id,\"mat-error-\")])[1]")).getText(),"Please enter a valid diagnosis.");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-error[contains(@id,\"mat-error-\")])[2]")).getText(),"Please enter a page number");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-error[contains(@id,\"mat-error-\")])[3]")).getText(),"Please enter a comment.");
        softAssert.assertAll();
    }




}
