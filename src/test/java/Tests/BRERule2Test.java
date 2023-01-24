package Tests;

import Pages.BRERule2Page;
import Pages.DocumentPage;
import Pages.UserPage;
import Utilities.ClickOnOutSide;
import Utilities.Custome_Wait;
import Utilities.Scroll_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BRERule2Test extends BaseTest {

    BRERule2Page breRule2Page;
    Custome_Wait custom;
    SoftAssert softAssert;
    Scroll_Page scroll_page;
    ClickOnOutSide clickOnOutSide;
    UserPage userPage;
    DocumentPage documentPage;

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
    @Story("story_id: 001 - To verify navigate to the rule tab next to the project data tab by using di- admin credentials.")
    @Description("To verify navigate to the rule tab next to the project data tab by using di- admin credentials.")
    @Test(priority = 1, groups = "smoke", description = "To verify navigate to the rule tab next to the project data tab by using di- admin credentials.")
    public void verifyNextBtn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Matches Rule ')]")).isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 002 - To verify navigate to the rule tab by using operator's credentials.")
    @Description("To verify navigate to the rule tab by using operator's credentials.")
    @Test(priority = 2, groups = "smoke", description = "To verify navigate to the rule tab by using operator's credentials.")
    public void verifyLoginOperator() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("omkar.ranaware@neutrinotechlabs.com");
        loginPage.setPassword("Omkar@0955");
        loginPage.clickLoginButton();
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Rule-1')]")).getText(), "Rule-1");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 003 - To check project name is available at the top right corner.")
    @Description("To check project name is available at the top right corner.")
    @Test(priority = 3, groups = "smoke", description = ".")
    public void verifynameOfProject() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
//        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='ml-3 text-secondary mt-3 f-bold d-flex justify-content-end align-items-center ng-tns-c224-4 ng-star-inserted']")).getText(),"888-Medical");
        //       softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 004 - To check the three line menu logo is available ")
    @Description("To check the three line menu logo is available ")
    @Test(priority = 4, groups = "smoke", description = "To check the three line menu logo is available ")
    public void verify3linelogo() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[@style='cursor: pointer; font-size: 32px;']")).getText(), "menu");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 005 - To check the add rules button is available ")
    @Description("To check the add rules button is available ")
    @Test(priority = 5, groups = "smoke", description = "To check the add rules button is available ")
    public void verifyAddRoleBtn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@style='width: 100px; border-radius: 28px;']")).getText(), "Rules +");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 006 and Story_id: 7 - To verify three line menu logo is clickable and displayed proper data after clicking")
    @Description("To verify three line menu logo is clickable and displayed proper data after clicking")
    @Test(priority = 6, groups = "smoke", description = "To verify three line menu logo is clickable and displayed proper data after clicking")
    public void Verify3lineMenu() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnthreeLineLogoBtn();
        softAssert.assertEquals(driver.findElement(By.xpath("//h6[@class='d-flexb mt-1 bold align-items-center justify-content-center']")).getText(), "888-Medical");
        Thread.sleep(2000);
        breRule2Page.clickOnattributeDropDown();
        //structure
        breRule2Page.clickOnProjectPage();
        waitForloadSpinner();
        breRule2Page.searchCreatedProject("186 Structure Project");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnthreeLineLogoBtn();
        // softAssert.assertEquals(driver.findElement(By.xpath("//h6[@class='d-flexb mt-1 bold align-items-center justify-content-center']")).getText(),"888-Medical");
        Thread.sleep(1000);
        breRule2Page.clickOnattributeDropDown();
        //Semi-structure
        breRule2Page.clickOnProjectPage();
        waitForloadSpinner();
        breRule2Page.searchCreatedProject("QA-AutoProject-SemiStructured2820im");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(3000);
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnthreeLineLogoBtn();
        // softAssert.assertEquals(driver.findElement(By.xpath("//h6[@class='d-flexb mt-1 bold align-items-center justify-content-center']")).getText(),"888-Medical");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[contains(text(),'Attributes')])[3]")).click();
        //breRule2Page.clickOnattributeDropDown();
        //regression
        breRule2Page.clickOnProjectPage();
        waitForloadSpinner();
        breRule2Page.searchCreatedProject("Regression Testing 27");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnthreeLineLogoBtn();
        // softAssert.assertEquals(driver.findElement(By.xpath("//h6[@class='d-flexb mt-1 bold align-items-center justify-content-center']")).getText(),"888-Medical");
        Thread.sleep(1000);
        // breRule2Page.clickOnattributeDropDown();
        driver.findElement(By.xpath("(//mat-icon[contains(text(),' keyboard_arrow_down ')])[8]")).click();

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 08 - To verify the functionality of dataset dropdown button.")
    @Description("To verify the functionality of dataset dropdown button.")
    @Test(priority = 8, groups = "smoke", description = "To verify the functionality of dataset dropdown button.")
    public void VerifyDropDownDataSet() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickOnDataSetDropDown();
        breRule2Page.clickOnAddDataSetBtn();
        Thread.sleep(1000);
        breRule2Page.clickSearchDataset("QAAutomation");
        Thread.sleep(2000);
        breRule2Page.clickOnDatasetOpn();
        breRule2Page.clickOnSubdataSetOpn();
        // clickOnOutSide.clickOutside();
        breRule2Page.clickOndatanextBtn();
        ;
        Thread.sleep(1000);
        breRule2Page.clickOnthreeLineLogoBtn();
        breRule2Page.clickRuledataset();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@class='ml-2 mt-1 primary-font-color']")).getText(), "Datasets");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 09 - To verify working of varibles dropdown")
    @Description("To verify working of varibles dropdown")
    @Test(priority = 9, groups = "smoke", description = "To verify working of varibles dropdown")
    public void VerifyVariableOpn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickVariableDropDown();
        breRule2Page.clickAddvariableBtn();
        breRule2Page.enterVariableName("omtest");
        breRule2Page.selectValidationType();
        breRule2Page.selectAgeOpn();
        breRule2Page.enterVariableValue("10");
        breRule2Page.clickOnAddopn();
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnthreeLineLogoBtn();
        breRule2Page.clickOnRuleVariableOpn();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@class='ml-2 mt-1 primary-font-color']")).getText(), "Variables");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 10 - To verify the working of add rules (Rules +) button")
    @Description("To verify the working of add rules (Rules +) button")
    @Test(priority = 10, groups = "smoke", description = "To verify the working of add rules (Rules +) button")
    public void VerifyAddRulesOpn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnAddRules();
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='py-2 rulesetName'])[2]")).getText(), "Rule-2");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 11 - To verify the Clickability of  Rule-no (Rule-1)  Plus Button")
    @Description("To verify the Clickability of  Rule-no (Rule-1)  Plus Button")
    @Test(priority = 11, groups = "smoke", description = "To verify the Clickability of  Rule-no (Rule-1)  Plus Button")
    public void VerifyRuleOnOpn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnAddRules();
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='py-2 rulesetName'])[2]")).getText(), "Rule-2");
        breRule2Page.clickOnplusBtnRule();
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 12 - To verify the Clickability of  Rule-no (Rule-1)  Plus Button")
    @Description("To verify the Clickability of  Rule-no (Rule-1)  Plus Button")
    @Test(priority = 12, groups = "smoke", description = "To verify the Clickability of  Rule-no (Rule-1)  Plus Button")
    public void VerifyRuleDeleteOpn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        breRule2Page.clickOnAddRules();
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='py-2 rulesetName'])[2]")).getText(), "Rule-2");
        breRule2Page.clickOnDeleteRuleBtn();
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 13 - To verify user is able to click on 'Enter name of condition/ Action' textbox")
    @Description("To verify user is able to click on 'Enter name of condition/ Action' textbox")
    @Test(priority = 13, groups = "smoke", description = "To verify user is able to click on 'Enter name of condition/ Action' textbox")
    public void VerifyRuleActionConditionBtn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnplusBtnRule();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltipclass='primary-tooltip']")).getText(), " Create Condition or Action ");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 14 - To verify application behaviour when user enters all alphabets")
    @Description("To verify application behaviour when user enters all alphabets")
    @Test(priority = 14, groups = "smoke", description = "To verify application behaviour when user enters all alphabets")
    public void verifyUserEnterAllAplhabets() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnplusBtnRule();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltipclass='primary-tooltip']")).getText(), " Create Condition or Action ");
        breRule2Page.clickOnActionConditionTextBox("aqwer awer aswer asfg rtop asd asdf zxcv bnjklh");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnSaveCondition();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 15 - To verify application behaviour when user enters all Numbers")
    @Description("To verify application behaviour when user enters all Numbers")
    @Test(priority = 15, groups = "smoke", description = "To verify application behaviour when user enters all Numbers")
    public void verifyUserEnterDigits() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        waitForloadSpinner();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnplusBtnRule();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltipclass='primary-tooltip']")).getText(), "Create Condition or Action");
        Thread.sleep(1000);
        breRule2Page.clickOnActionConditionTextBox("1234567");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnSaveCondition();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(),"Please enter a valid condition in 1234567.");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 17 - To verify when user enters combination of alphabets, Numbers & \" - \".")
    @Description("To verify when user enters combination of alphabets, Numbers & \" - \".")
    @Test(priority = 17, groups = "smoke", description = "To verify when user enters combination of alphabets, Numbers & \" - \".")
    public void verifyUserEnterspcialCharacter() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnplusBtnRule();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltipclass='primary-tooltip']")).getText(), "Create Condition or Action");
        breRule2Page.clickOnActionConditionTextBox("@#$%");
        breRule2Page.clickAddCondition();
        // breRule2Page.clickOnSaveCondition();
        //  softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Please enter a valid condition in @#$%.')]")).isDisplayed());
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 18 - To verify the entered name of condition/ action is editable.")
    @Description("To verify the entered name of condition/ action is editable.")
    @Test(priority = 18, groups = "smoke", description = "To verify the entered name of condition/ action is editable.")
    public void verifyConditionNameEditable() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        waitForloadSpinner();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnConditionBox();
        breRule2Page.clickOnConditionEditBtn();
        Thread.sleep(1000);
        WebElement Abc = driver.findElement(By.xpath("(//span[contains(text(),'Matches Rule')])[1]"));
        String s = Keys.chord(Keys.BACK_SPACE.subSequence(1, 8));
        Abc.sendKeys(s);
        // sending DELETE key
        // Abc.sendKeys(Keys.DELETE);
        breRule2Page.clickEnterConditionName("omtest");
        Thread.sleep(1000);
        breRule2Page.clickOnSaveCondition();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltipclass='condition-tooltip']")).isDisplayed(), "omtest");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 19 - To verify the 'Add condition' and 'Add action' button is enable.")
    @Description("To verify the 'Add condition' and 'Add action' button is enable.")
    @Test(priority = 19, groups = "smoke", description = "To verify the 'Add condition' and 'Add action' button is enable .")
    public void verifyAddConditionAddActionEnable() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnplusBtnRule();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Add Action')]")).isDisplayed());

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 20 - To verify the 'Add condition' and 'Add action' button is enable.")
    @Description("To verify the 'Add condition' and 'Add action' button is enable.")
    @Test(priority = 20, groups = "smoke", description = "To verify the 'Add condition' and 'Add action' button is enable .")
    public void verifyAddConditionAddActionDisable() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("888-medical");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnplusBtnRule();
        String Color = driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).getCssValue("color");
        String Color1 = driver.findElement(By.xpath("//span[contains(text(),'Add Action')]")).getCssValue("color");
        System.out.println(Color);
        System.out.println(Color1);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 21 to 31 - To verify the condition rule cofiguration when project type is structured")
    @Description("To verify the condition rule cofiguration when project type is structured")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to click on conditions button ")
    public void verifyConditionRuleConfiguration() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        waitForloadSpinner();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnplusBtnRule();
        //  breRule2Page. clickOnplusBtnRule();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        // String Color = driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).getCssValue("color");
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.clickOnEnterValue("1234");
        breRule2Page.clickOnAndBtn();
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.clickOnAttributeOption1();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOperatorOption1();
        breRule2Page.clickOnEnterValue2("omtest");
        breRule2Page.clickOnORBtn();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-primary ng-untouched ng-pristine ng-valid mat-checkbox-checked']")).getText(),"Case Sensitive");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 33 - To verify the working of attached dataset in condition rule")
    @Description("To verify the working of attached dataset in condition rule")
    @Test(priority = 20, groups = "smoke", description = "To verify the working of attached dataset in condition rule ")
    public void verifyConditionRuleOfAttachedDataset() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnplusBtnRule();
        //  breRule2Page. clickOnplusBtnRule();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        // String Color = driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).getCssValue("color");
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnDatasetOperatorOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetOperator();
        breRule2Page.clickOnDatasetOption();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetHeaderDropDown();
        breRule2Page.clickOnDatasetHeaderOption();


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 34 to 38 -To verify the condition rule cofiguration when project type is Semi-structured Trade")
    @Description("To verify the condition rule cofiguration when project type is Semi-structured Trade")
    @Test(priority = 20, groups = "smoke", description = "To verify the condition rule cofiguration when project type is Semi-structured Trade ")
    public void verifyConditionRuleConfigurationforSemiStructureTrade() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        Thread.sleep(2000);
        breRule2Page.searchCreatedProject("QA-Automation Semi Structure");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        // String Color = driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).getCssValue("color");
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.clickOnEnterValue("1234");
        breRule2Page.clickOnAndBtn();
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.clickOnAttributeOption1();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOperatorOption1();
        breRule2Page.clickOnEnterValue2("omtest");
        breRule2Page.clickOnORBtn();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-primary ng-untouched ng-pristine ng-valid mat-checkbox-checked']")).getText(),"Case Sensitive");
        // softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 39 - To verify the document status for those projects in which rules are configured.")
    @Description("To verify the document status for those projects in which rules are configured.")
    @Test(priority = 20, groups = "smoke", description = "To verify the document status for those projects in Swhich rules are configured.")
    public void verifyConditionRuleOfAttachedDatasetForSemiStructured() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation Semi strcture");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnDatasetOperatorOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetOperator();
        breRule2Page.clickOnDatasetOption();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetHeaderDropDown();
        breRule2Page.clickOnDatasetHeaderOption();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 40 to 44 -To verify the condition rule cofiguration when project type is Semi-structured return")
    @Description("To verify the condition rule cofiguration when project type is Semi-structured return")
    @Test(priority = 20, groups = "smoke", description = "To verify the condition rule cofiguration when project type is Semi-structured return ")
    public void verifyConditionRuleConfigurationforSemiStructureReturn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation Semistrcture");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        // String Color = driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).getCssValue("color");
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.clickOnEnterValue("1234");
        breRule2Page.clickOnAndBtn();
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.clickOnAttributeOption1();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOperatorOption1();
        breRule2Page.clickOnEnterValue2("omtest");
        breRule2Page.clickOnORBtn();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-primary ng-untouched ng-pristine ng-valid mat-checkbox-checked']")).getText(),"Case Sensitive");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 45 - To verify the document status for those projects in which rules are configured (Return) .")
    @Description("To verify the document status for those projects in which rules are configured (Return) .")
    @Test(priority = 20, groups = "smoke", description = "To verify the document status for those projects in Swhich rules are configured(Return) .")
    public void verifyConditionRuleOfAttachedDatasetForSemiStructuredReturn() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation Semistrcture");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnDatasetOperatorOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetOperator();
        breRule2Page.clickOnDatasetOption();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetHeaderDropDown();
        breRule2Page.clickOnDatasetHeaderOption();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 46 to 50 -To verify the condition rule cofiguration when project type is  Freeform")
    @Description("To verify the condition rule cofiguration when project type is  Freeform")
    @Test(priority = 20, groups = "smoke", description = "To verify the condition rule cofiguration when project type is  Freeform")
    public void verifyConditionRuleConfigurationforFreeform() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation-FreeForm");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        // String Color = driver.findElement(By.xpath("//span[contains(text(),'Add Condition')]")).getCssValue("color");
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.clickOnEnterValue("1234");
        breRule2Page.clickOnAndBtn();
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.clickOnAttributeOption1();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOperatorOption1();
        breRule2Page.clickOnEnterValue2("omtest");
        breRule2Page.clickOnORBtn();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-primary ng-untouched ng-pristine ng-valid mat-checkbox-checked']")).getText(),"Case Sensitive");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 51 - To verify the document status for those projects in which rules are configured Freeform .")
    @Description("To verify the document status for those projects in which rules are configured Freeform.")
    @Test(priority = 20, groups = "smoke", description = "To verify the document status for those projects in Swhich rules are configured Freeform .")
    public void verifyConditionRuleOfAttachedDatasetForFreeForm() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation-FreeForm");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnDatasetOperatorOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetOperator();
        breRule2Page.clickOnDatasetOption();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetHeaderDropDown();
        breRule2Page.clickOnDatasetHeaderOption();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 52 to 57 -To verify the condition rule cofiguration when project type is  Freeform")
    @Description("To verify the condition rule cofiguration when project type is  Freeform")
    @Test(priority = 20, groups = "smoke", description = "To verify the condition rule cofiguration when project type is  Freeform")
    public void verifyConditionRuleConfigurationforMedical() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation-Medical-One-Option");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnEntityDropDown();
        breRule2Page.clickOnEntityOpn1();
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.clickOnEnterValue("1234");
        breRule2Page.clickOnAndBtn();
        JavascriptExecutor jsp1 = (JavascriptExecutor) driver;
        jsp1.executeScript("window.scrollBy(0,5000)", "");
        breRule2Page.clickOnEntityDropDown();
        breRule2Page.clickOnEntityOpn1();
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.clickOnAttributeOption1();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOperatorOption1();
        breRule2Page.clickOnEnterValue2("omtest");
        breRule2Page.clickOnORBtn();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-primary ng-untouched ng-pristine ng-valid mat-checkbox-checked']")).getText(),"Case Sensitive");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 58 - To verify the document status for those projects in which rules are configured Medical.")
    @Description("To verify the document status for those projects in which rules are configured Medical.")
    @Test(priority = 20, groups = "smoke", description = "To verify the document status for those projects in Swhich rules are configured Medical.")
    public void verifyConditionRuleOfAttachedDatasetForMedical() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation-Medical-One-Option");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnEntityDropDown();
        breRule2Page.clickOnEntityOpn1();
        breRule2Page.clickOnAttributeDropDown();
        Thread.sleep(1000);
        breRule2Page.selectAttributeOption();
        breRule2Page.clickOnOperatorDropDown();
        breRule2Page.clickOnDatasetOperatorOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetOperator();
        breRule2Page.clickOnDatasetOption();
        Thread.sleep(1000);
        breRule2Page.clickOnDatasetHeaderDropDown();
        breRule2Page.clickOnDatasetHeaderOption();
    }
 /*   @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 59 - To verify user is able to add any action after condition or without condition.")
    @Description("To verify user is able to add any action after condition or without condition.")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to add any action after condition or without condition.")
    public void verifyUserAbleToAddAction() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnplusBtnRule();
        //  breRule2Page. clickOnplusBtnRule();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickAddCondition();
      //  clickOnOutSide.clickOutside();
      //  driver.findElement(By.xpath("//body")).click();
        Thread.sleep(2000);
        breRule2Page.clickOnTrueBtn();
        driver.findElement(By.xpath("(//span[@class='filter_icon'])[1]")).click();
        Thread.sleep(1000);
       breRule2Page.clickOnFalseeBtn();

        Thread.sleep(1000);
        breRule2Page.clickOnActionConditionTextBox("test1");
        breRule2Page.clickAddCondition();
        breRule2Page.clickOnAttributeDropDown();
        breRule2Page.selectAttributeOption();
        Thread.sleep(1000);
        breRule2Page. clickOnOperatorDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.clickOnEnterValue("1234");
    }*/

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 60 - To verify the working of action type dropdown button for all types of projects")
    @Description("To verify the working of action type dropdown button for all types of projects")
    @Test(priority = 20, groups = "smoke", description = "To verify the working of action type dropdown button for all types of projects")
    public void verifyActionFunctionality() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickOnAddAction();
        Thread.sleep(1000);
        breRule2Page.clickOnActionTypeDropDown();
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-option[@role='option'])[1]")).getText(), "Set Variable");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-option[@role='option'])[2]")).getText(), "Set Attribute");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-option[@role='option'])[3]")).getText(), "Set BRE Status");
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-option[@role='option'])[4]")).getText(), "Set Document Status");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 61 - To verify user is able to configure the set variable action rule")
    @Description("To verify user is able to configure the set variable action rule")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to configure the set variable action rule")
    public void verifySetVariableActionRule() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        waitForloadSpinner();
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule1();
        breRule2Page.clickOnActionConditionTextBox("omtest");
        breRule2Page.clickOnAddAction();
        Thread.sleep(1000);
        breRule2Page.clickOnActionTypeDropDown();
        driver.findElement(By.xpath("(//span[contains(text(),'Set Variable')])[2]")).click();
        Thread.sleep(1000);
        breRule2Page.clickOnVariableDropDown();
        breRule2Page.clickOnVariablesOpn();
        softAssert.assertEquals(driver.findElement(By.xpath("(//input[@type='text'])[4]")).getText(), "0000");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 62 - To verify user is able to configure the set attribute action rule when data source is manually")
    @Description("To verify user is able to configure the set attribute action rule when data source is manually")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to configure the set attribute action rule when data source is manually")
    public void verifySetAttribute() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("SetAttribute contact");
        breRule2Page.clickOnAddAction();
        Thread.sleep(1000);
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.clickOnSetAttributes();
        // breRule2Page.clickOnVariableDropDown();
        Thread.sleep(1000);
        breRule2Page.clickOnSourceDropDown();
        breRule2Page.clickOnManuallyOpn();
        //   breRule2Page.clickOnSaveCondition();
        breRule2Page.clickOnAttributeDropDownOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnContactAttributeOpn();
        //  Thread.sleep(3000);
        breRule2Page.enterAttributeValue("1234567890");
        Thread.sleep(2000);
        breRule2Page.clickOnAttributeSubOpn();
        breRule2Page.clickOnStudentName();
        breRule2Page.clickOnOperatorSubDropDown();
        breRule2Page.clickOnOperatorOption();
        breRule2Page.enterAttributeSubValue("Omkar");
        breRule2Page.clickOnSaveCondition();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 63 - To verify user is able to configure the set attribute action rule when data source is dataset")
    @Description("To verify user is able to configure the set attribute action rule when data source is dataset")
    @Test(priority = 20, groups = "smoke", description = "")
    public void verifySetAttributeWithDataset() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("test DataSet");
        breRule2Page.clickOnAddAction();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='float-left mt-2']")).getText(), "Action");
        Thread.sleep(1000);
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.clickOnSetAttributes();
        breRule2Page.clickOnDatasetSourceDropDown();
        breRule2Page.clickOnsourceDataSetOpn();
        breRule2Page.clickOnDatasetAttributeDropDown();
        breRule2Page.clickOnDOBOpn();
        Thread.sleep(1000);
        breRule2Page.clickOnselectDataSetDropDown();
        breRule2Page.clickOnDataSetOpn();
        breRule2Page.clickOnFieldDropDow();
        breRule2Page.clickOnDOBOpn();
        breRule2Page.clickOnAttributeField();
        Thread.sleep(1000);
        breRule2Page.clickOnDOBOpn();
        breRule2Page.selectOperatorFiled();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//mat-option[@role='option'])[1]")).click();
        //   breRule2Page.clickVariableDropDown();
        breRule2Page.clickOnFieldOpn();
        breRule2Page.clickOnDOBOpn();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 64 - To verify user is able to configure the set BRE status action rule")
    @Description("To verify user is able to configure the set BRE status action rule")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to configure the set BRE status action rule")
    public void VerifyBREStatus() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("test BREStatus");
        breRule2Page.clickOnAddAction();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='float-left mt-2']")).getText(), "Action");
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.clickOnSetBREStatus();
        Thread.sleep(1000);
        breRule2Page.EnterBREValue("0000");
        breRule2Page.clickOnSaveCondition();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 65 - To verify user is able to configure the set document status action rule")
    @Description("To verify user is able to configure the set document status action rule")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to configure the set document status action rule")
    public void VerifySetDocumentStatus() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("test BREStatus");
        breRule2Page.clickOnAddAction();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='float-left mt-2']")).getText(), "Action");
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.clickOnDocumentStatus();
        Thread.sleep(1000);
        breRule2Page.clickOnDocumentAttribute();
        driver.findElement(By.xpath("(//span[contains(text(),' Document Status')])[2]")).click();
        breRule2Page.clickOnDocumentValueDropDown();
        breRule2Page.clickOnValueOption();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 66 to 69 - To verify user is able to select send email action type")
    @Description("To verify user is able to select send email action type")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to select send email action type")
    public void VerifyEmailStatus() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("test EmailStatus");
        breRule2Page.clickOnAddAction();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='float-left mt-2']")).getText(), "Action");
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.ClickOnSendEmailOpn();
        breRule2Page.EnterToEmail("omtest@gmail.com");
        breRule2Page.EnterCCEmail("test123@gmail.com");
        breRule2Page.EnterSubjectEmail("test123");
        breRule2Page.EnterComposeMail("composetest");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 70 - To verify user is able to configure the set document status action rule")
    @Description("To verify user is able to configure the set document status action rule")
    @Test(priority = 20, groups = "smoke", description = "To verify user is able to configure the set document status action rule")
    public void VerifyRepalceString() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("test StringReplace");
        breRule2Page.clickOnAddAction();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='float-left mt-2']")).getText(), "Action");
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.clickOnReplaceStringOpn();
        breRule2Page.clickOnAttributeStringDropDown();
        breRule2Page.clickOnEmailOpn();
        breRule2Page.clickOnReplaceStringOperator();
        breRule2Page.EnterReplaceName("omtest@gmail.com");
        breRule2Page.enterWithReplaceName("test@gmail.com");

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: 71 - To verify user is able to configure the replace string action rule with replace first operator in medical project")
    @Description("To verify user is able to configure the replace string action rule with replace first operator in medical project")
    @Test(priority = 20, groups = "smoke", description = "")
    public void VerifyRepalceStringEntity() throws Exception {
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        documentPage = new DocumentPage(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(1000);
        breRule2Page.clickOndatanextBtn();
        Thread.sleep(1000);
        breRule2Page.clickOnAddRules();
        // breRule2Page.clickOnRuleVisiblity();
        breRule2Page.clickOnPlusBtnRule2();
        breRule2Page.clickOnActionConditionTextBox("test StringReplace");
        breRule2Page.clickOnAddAction();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='float-left mt-2']")).getText(), "Action");
        breRule2Page.clickOnActionTypeDropDown();
        breRule2Page.clickOnReplaceStringOpn();
        breRule2Page.clickOnAttributeStringDropDown();
    }
}