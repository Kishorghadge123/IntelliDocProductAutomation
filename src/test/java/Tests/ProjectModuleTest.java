package Tests;


import Pages.BRERule2Page;
import Pages.CreateRolePage;
import Pages.Project_Module;
import Pages.UserPage;
import Utilities.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProjectModuleTest extends BaseTest {
    Project_Module project;
    SoftAssert softAssert;
    Custome_Wait custom;
    CreateRolePage createRolePage;
    SortingLists sortingLists;
    Scroll_Page s;
    ClickOnOutSide clickOnOutSide;
    UserPage userPage;
    BRERule2Page breRule2Page;

    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P001 - Search Created Project")
    @Description("verify_user_able_to_Search_Created_Project")
    @Test(priority = 1, groups = "smoke", description = "verify_user_able_to_Search_Created_Project")
    public void Search_Created_Project() throws Exception {

        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation-FreeForm ");

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P002 - Search Created Project On Grid View")
    @Description("verify_user_able_to_Search_Created_Project_On_Grid_View")
    @Test(priority = 2, groups = "smoke", description = "Search Created Project On Grid View\"")
    public void Search_Created_Project_On_Grid_View() throws Exception {

        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.searchCreatedProjectOnGridView("QA-Automation Semistrcture ");

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P003 - Create Project With Blank Data")
    @Description("verify_user_able_to_Create_Project_With_Blank_Data")
    @Test(priority = 3, groups = "smoke", description = "verify_user_able_to_Create_Project_With_Blank_Data")
    public void Create_Project_With_Blank_Data() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.projectnamerrmsg.isDisplayed());
        softAssert.assertTrue(project.leaderrormsg.isDisplayed());
        softAssert.assertTrue(project.startdateerrmsg.isDisplayed());
        softAssert.assertTrue(project.enddateerrmsg.isDisplayed());
        softAssert.assertTrue(project.documentstructureerrmsg.isDisplayed());
        Thread.sleep(3000);
        project.clickOnCreateButton();
        softAssert.assertTrue(project.projectcreateerrmsg.isDisplayed());
        project.clickOnCancelButton();
        waitForloadSpinner();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P004 - Create Project Without Selecting Processing Engine and Templates")
    @Description("verify_that_user_able_to_Create_Project_Without_Selecting_Processing_Engine_and_Templates")
    @Test(priority = 4, groups = "smoke", description = "verify_that_user_able_to_Create_Project_Without_Selecting_Processing_Engine_and_Templates")
    public void Create_Project_Without_Selecting_Processing_Engine_And_Template() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.processengineerrmsg.isDisplayed());
        softAssert.assertTrue(project.templatecreateerrmsg.isDisplayed());
        project.clickOnCancelButton();
        waitForloadSpinner();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P005 - Create Project Without Role and user")
    @Description("verify_that_user_able_to_Create_Project_without_Role_and_user")
    @Test(priority = 5, groups = "smoke", description = "verify_that_user_able_to_Create_Project_without_Role_and_user")
    public void Create_Project_Without_Without_Role_And_User() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.selectprocessengindropdown();
        project.selectprocessingengine();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        softAssert.assertTrue(project.templatemsg.isDisplayed());
        project.clickAddTemplateButton();
        Thread.sleep(2000);
        project.selectTemplate();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.rolecreateerrmsg.isDisplayed());
        project.clickOnCancelButton();
        waitForloadSpinner();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P006 - Create Project Without  and user")
    @Description("verify_that_user_able_to_Create_Project_without_and_user")
    @Test(priority = 6, groups = "smoke", description = "verify_that_user_able_to_Create_Project_without_and_user")
    public void Create_Project_Without_User() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.selectprocessengindropdown();
        project.selectprocessingengine();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        softAssert.assertTrue(project.templatemsg.isDisplayed());
        project.clickAddTemplateButton();
        Thread.sleep(2000);
        project.selectTemplate();
        Thread.sleep(1000);
        project.clickonrolelabel();
        project.clickOnAddRoleButton();
        project.selectRole();
        project.clickOnCreateButton();
        softAssert.assertTrue(project.usercreaterrmsg.isDisplayed());

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P007 - Create Project Without  and user")
    @Description("verify_that_user_able_to_Create_Project_without_and_user")
    @Test(priority = 7, groups = "smoke", description = "verify_that_user_able_to_Create_Project_without_and_user")
    public void Create_Project_Without_When_User_is_disable() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Roles')]")));
        project.clickonrolelabel();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'add_circle_outline')])[2]")));
        project.clickonroleplusbutton();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'PratikshaQA role is Disabled')]")).getText(), "PratikshaQA role is Disabled");
    }

    @Story("story_id: P008 - verify that all disabled roles are not displayed in add role& lead list while creating a project by platform admin")
    @Description("verify_that_all_disabled_roles_are_not_displayed_in_add_role&lead_list_while_creating_project_by_platform_admin")
    @Test(priority = 8, groups = "smoke", description = "verify_that_all_disabled_roles_are_not_displayed_in_add_role&lead_list_while_creating_project_by_platform_admin")
    public void verifyDisabledRoles() throws Exception {
        createRolePage = new CreateRolePage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        createRolePage.clickRoleBtn();
        waitForloadSpinner();
        createRolePage.searchRoleInRolePage("QAdisable");
        Thread.sleep(2000);
        createRolePage.clickOnEditButton();
        waitForloadSpinner();
        createRolePage.clickOnUpdateButton();
        Thread.sleep(1000);

        project = new Project_Module(driver);
        project.clickOnProjectPage();
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.clickOnRoleLabel();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        project.clickOnAddRoleButton();
        Thread.sleep(2000);
        project.clickOnSearchRole("QAdisable");
        String text = driver.findElement(By.xpath("//div[contains(text(),' No Records Found ! ')]")).getText();
        System.out.println(text);
        softAssert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' No Records Found ! ')]")).getText(), " No Records Found ! ");


    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: P009 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 9, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        project.clickonGridIcon();
        Thread.sleep(5000);
        project.clickOnTableArrowDropDown(" Projects ");
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 1);
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Projects ");
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 2);
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown("Document Structure ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()='Document Structure ']")).isEnabled());
        sortingLists.sortingListInOrder("descending ", 2);
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown("Document Structure ");
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Lead ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Lead ']")).isEnabled());
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Lead ");
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(1000);
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        Thread.sleep(1000);
        project.clickOnTableArrowDropDown(" Updated ");
        Thread.sleep(1000);
   /* project.clickOnTableArrowDropDown(" Created ");
    softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Created ']")).isEnabled());
    project.clickOnTableArrowDropDown(" Created ");*/
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P016 - Project Updation by platform admin ")
    @Description("Verify the working of platform admin for Update Project button when role and user status is disabled")
    @Test(priority = 16, groups = "smoke", description = "Verify the working of platform admin for Update Project button when role and user status is disabled")
    public void Project_update_by_platform_admin() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation structure");
        waitForloadSpinner();
        project.clickauditenabletogglebtn();
        project.clickStraightThroughProcesstogglebtn();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        project.clickonrolelabel();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,50000)", "");
        project.clickOnaddUSerInRole();
        driver.findElement(By.xpath("//span[contains(text(),' omkar.ranaware@neutrinotechlabs.com ')]")).click();
        Thread.sleep(2000);
        clickOnOutSide.clickOutside();
        driver.findElement(By.xpath("(//mat-icon[@class='mat-icon notranslate mat-chip-remove mat-chip-trailing-icon position material-icons mat-icon-no-color'])[4]")).click();
        project.clickOnUpdate();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//h5[@class='mt-1']")).getText(), "List of Projects");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: P010 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 10, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        project = new Project_Module(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        project.clickonGridIcon();
        Thread.sleep(5000);
        project.clickOnDropDown();
        project.selectDropDownValue();
        project.userClickOnNextpageTab();

    }

    @Story("story_id: P011 -verify role active status")
    @Description("verify_role_active_status")
    @Test(priority = 11, groups = "smoke", description = "verify_role_active_status", dataProvider = "projectNames")
    public void verifyProjectActiveInactiveStatus(String projectTitle) throws Exception {
        project = new Project_Module(driver);
        waitForloadSpinner();
        //waitForloadSpinner();
        /*String projectTitle = "1163-Prada";
        //"M-1168";*/
        project.clickOnGridIcon();
        project.searchProject(projectTitle);
        boolean projectStatusInGrid = project.getProjectStatusInProjectGrid(projectTitle);
        project.goToProjectDetailsPageFromProjectGrid(projectTitle);
        waitForloadSpinner();
        Assert.assertEquals(projectStatusInGrid, project.getProjectStatusInProjectDetailsPage());
        project.clickOnCancelButton();
    }

    @DataProvider(name = "projectNames")
    public Object[][] projectNamesToValidate() {
        return new Object[][]{
                {"M-1168"},
                {"1135-Struct"},
                {"1163-Prada"},
                {"Testing"},
                {"R-25-Regression (return semi struct)"},
                {"931-Medical-P Aft Deployment"},
                {"958-Historical dataset"},
                {"dev test structure"},
                {"QA-AutoDisable2821jo"},
                {"dfgh"}
        };
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P012 - Update Created Project")
    @Description("verify_user_able_to_Update_Created_Project")
    @Test(priority = 12, groups = "smoke", description = "verify_user_able_to_Update_Created_Project")
    public void Update_Created_Project() throws Exception {
        softAssert = new SoftAssert();
        s = new Scroll_Page(driver);
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.verifyProjectIsUpdated("pratiksha.bagal@neutrinotechlabs.com");
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[1]")));
        project.clickstatustogglebutton();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[2]")));
        project.clickondocumentautoassignmentogglebtn();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[3]")));
        project.clickauditenabletogglebtn();
        Thread.sleep(1000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectMedicalProjectType();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'Please Add Entity ...')]")).getText(), "Please Add Entity ...");
        Thread.sleep(3000);
        s.ScrollUpDown(driver.findElement(By.xpath("(//span[contains(text(),' Add Entity ')])[1]")));
        project.clickOnAddEntity();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' PatientDemographics')]")));
        project.selectFirstOption();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//span[contains(text(),' Add Entity ')])[1]")));
        project.clickOnAddEntity();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//button[contains(text(),' HCCConditions')]")));
        project.selectSecondOption();
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id:P013- Verify that while creating a project user should not able to add a user when the role is disabled for the project")
    @Description("Verify that while creating a project user should not able to add a user when the role is disabled for the project")
    @Test(priority = 13, groups = "smoke", description = "Verify that while creating a project user should not able to add a user when the role is disabled for the project")
    public void Create_Project_With_disable_user() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.selectprocessengindropdown();
        project.selectprocessingengine();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        softAssert.assertTrue(project.templatemsg.isDisplayed());
        project.clickAddTemplateButton();
        Thread.sleep(2000);
        project.selectTemplate();
        project.clickonrolelabel();
        project.clickOnAddRoleButton();
        driver.findElement(By.xpath("(//button[contains(text(),'Operator')])[1]")).click();
        Thread.sleep(1000);
        project.disableRole();
        driver.findElement(By.xpath("(//mat-icon[contains(text(),'add_circle_outline')])[2]")).click();
        project.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Operator role is Disabled");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P014 -Verify that while creating project role should not have an empty user")
    @Description("Verify that while creating project role should not have an empty user")
    @Test(priority = 14, groups = "smoke", description = "Verify that while creating project role should not have an empty user")
    public void Create_Project_With_empty_user() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(2000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        project.selectProjectType();
        project.selectprocessengindropdown();
        project.selectprocessingengine();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        softAssert.assertTrue(project.templatemsg.isDisplayed());
        project.clickAddTemplateButton();
        Thread.sleep(2000);
        project.selectTemplate();
        project.clickonrolelabel();
        project.clickOnAddRoleButton();
        driver.findElement(By.xpath("(//button[contains(text(),'Operator')])[1]")).click();
        // project.selectRole();
        project.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Role cannot have empty users");
        softAssert.assertAll();
    }

    @Story("story_id: U021 -Verify text on UI Project Module.")
    @Description("Verify text present on UI Project Module.")
    @Test(priority = 21, groups = "smoke", description = "Verify text on UI Project Module")
    public void verifyUITextOnProjectModule() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[@class=\"primary-font-color\"]")).getText(), "List of Projects");
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.getTheTextOfListOfProjectModule();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Status')]")).getText(), "Status   ");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Document Auto-Assignment')]")).getText(), "Document Auto-Assignment   ");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Audit Enabled')]")).getText(), "Audit Enabled   ");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Send Mail')]")).getText(), "Send Mail   ");
        Thread.sleep(2000);
        project.clickOnRoleLabel();
        project.getTheTextOfListOfProjectModuleRoles();
        softAssert.assertEquals(driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-menu-trigger mat-raised-button')])[1]")).getText(), "Add Role add_circle_outline");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Document Ingestion Channels')]")).getText(), "Document Ingestion Channels");
        project.getTheButtonTextOfList();
        Thread.sleep(2000);
        project.selectDocumentStructure();
        project.selectProjectType();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),' Processing Engine ')]")).getText(), "Processing Engine *");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Straight Through Process')]")).getText(), "Straight Through Process   ");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Document Score')]")).getText(), "Document Score (0-100)");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[text()='Templates']")).getText(), "Templates");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        project.selectProjectTypeSemiStructured();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Attributes')]")).getText(), "Attributes");
        project.getTheTextOfListAttributesProjectModule();
        project.getTheTextOfListAttributesFieldName();
        Thread.sleep(2000);
        project.selectDocumentStructure();
        project.selectProjectTypeFreeForm();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Attributes')]")).getText(), "Attributes");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-button-base mat-primary ng-star-ins')]")).getText(), "Add Fields add_circle_outline");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        project.selectMedicalProjectType();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-label[contains(text(),'Historical Dataset')]")).getText(), "Historical Dataset   ");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[text()='Entity']")).getText(), "Entity");
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),' Add Entity ')]")).getText(), " Add Entity ");    //(//button[contains(@class,'mat-focus-indicator mat-menu-trigger mat-raised-button')]/span)[1]    softAssert.assertAll();} 


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P015 -Verify the working of platform admin for Update Project button when role and user status is enabled")
    @Description("Verify the working of platform admin for Update Project button when role and user status is enabled")
    @Test(priority = 15, groups = "smoke", description = "Verify the working of platform admin for Update Project button when role and user status is enabled")
    public void Update_Project_Without_When_User_is_disable() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);

        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation BRE");
        waitForloadSpinner();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        custom.waitVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Roles')]")));
        project.clickonrolelabel();
        custom.waitVisibility(driver, driver.findElement(By.xpath("(//mat-icon[contains(text(),'add_circle_outline')])[2]")));
        project.clickonroleplusbutton();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "PratikshaQA role is Disabled");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P017 - Project name is visible in the user after disabling the role or deleting the user from project creation page.")
    @Description("Project name is visible in the user after disabling the role or deleting the user from project creation page.")
    @Test(priority = 17, groups = "smoke", description = "Project name is visible in the user after disabling the role or deleting the user from project creation page.")
    public void check_project_name_in_user() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        userPage = new UserPage(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automationym");
        waitForloadSpinner();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        project.clickonrolelabel();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,50000)", "");
        driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb-container'])[8]")).click();
        Thread.sleep(2000);
        project.clickOnUpdate();
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.searchProjectInUserPage("omtest");
        Thread.sleep(2000);
        userPage.clickonActionBtton();
        waitForloadSpinner();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,50000)", "");
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='col-md-7 d-flex align-items-center']")).getText(), " Projects ");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P018 - Verify push Target channel.")
    @Description(" Verify push Target channel.")
    @Test(priority = 18, groups = "smoke", description = " Verify push Target channel.")
    public void Verify_push_Target_channel() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation structure");
        waitForloadSpinner();
        project.clickauditenabletogglebtn();
        project.clickStraightThroughProcesstogglebtn();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        project.clickOnTargetChannel();
        Thread.sleep(1000);
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,50000)", "");
        project.clickOnCreateTargetChannel();
        project.clickOnChannelTypeDropDown();
        project.clickOnPOSTServer();
        project.enterChannelName("test");
        Thread.sleep(1000);
        project.enterEndPoint("https://neo.neutrino-ai.com:8443/target/target-system");
        Thread.sleep(1000);
        project.enterSecretKey("intellidocsSecretKey");
        Thread.sleep(1000);
        project.clickOnTestConnection();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Connection established successfully...!");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P019 -Verify Test connection failed while testing POST target channel.")
    @Description("Verify Test connection failed while testing POST target channel.")
    @Test(priority = 19, groups = "smoke", description = "Verify Test connection failed while testing POST target channel.")
    public void Verify_Test_connection_fail() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        Assert.assertTrue(project.createbtnproject.isDisplayed());
        project.searchCreatedProject("QA-Automation structure");
        waitForloadSpinner();
        project.clickauditenabletogglebtn();
        project.clickStraightThroughProcesstogglebtn();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)", "");
        Thread.sleep(3000);
        project.clickOnTargetChannel();
        Thread.sleep(1000);
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,50000)", "");
        project.clickOnCreateTargetChannel();
        project.clickOnChannelTypeDropDown();
        project.clickOnPOSTServer();
        project.enterChannelName("test");
        Thread.sleep(1000);
        project.enterEndPoint("https://neo.neutrino-ai.com:8443/target/target-system");
        Thread.sleep(1000);
        project.enterSecretKey("intellidocsSecretKe");
        Thread.sleep(1000);
        project.clickOnTestConnection();
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Test Connection failed");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P020 -To verify that user should not be shown the 'Straight through processing' option, it should be shown only when I select the document type")
    @Description("To verify that user should not be shown the 'Straight through processing' option, it should be shown only when I select the document type")
    @Test(priority = 20, groups = "smoke", description = "To verify that user should not be shown the 'Straight through processing' option, it should be shown only when I select the document type")
    public void Verify_Straight_through_process_btn() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(2000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        driver.findElement(By.xpath("//span[contains(text(),'Structured')]")).click();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltip='If enabled, the documents will not require any manual intervention if the threshold score matches.']")).getText(), "Straight Through Process   ");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P021 - After adding variables in data section in project configuration tab and clicking of 'add' button, pop-up window should get close.")
    @Description("After adding variables in data section in project configuration tab and clicking of 'add' button, pop-up window should get close.")
    @Test(priority = 21, groups = "smoke", description = "After adding variables in data section in project configuration tab and clicking of 'add' button, pop-up window should get close.")
    public void Verify_Variable_pop_up() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        breRule2Page = new BRERule2Page(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        breRule2Page.clickOnProjectPage();
        breRule2Page.searchCreatedProject("QA-Automation structure");
        waitForloadSpinner();
        breRule2Page.clickonnextbutton();
        Thread.sleep(2000);
        breRule2Page.clickVariableDropDown();
        breRule2Page.clickAddvariableBtn();
        breRule2Page.enterVariableName("omtest");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-select[@id='validationType']")).click();
        breRule2Page.selectAgeOpn();
        breRule2Page.enterVariableValue("10");
        breRule2Page.clickOnAddopn();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@class='ml-1 text-secondary']")).getText(), "QA-Automation Structure");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P022 - Verify the \"Grid View\" button and user available in list view.")
    @Description("Verify the \"Grid View\" button and user available in list view.")
    @Test(priority = 22, groups = "smoke", description = "Verify the \"Grid View\" button and user available in list view.")
    public void verifyActiveProject() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        List<WebElement> activeusers = driver.findElements(By.xpath("//mat-icon[@class=\"mat-icon notranslate docStIconPos material-icons mat-icon-no-color\"]"));
        for (WebElement colorcode : activeusers) {
            System.out.println(colorcode.getCssValue("color"));

        }


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P022 -When there is no use of the 'processing engine', the field should not be visible, for example in case of 'Free form' and 'Medical charts'")
    @Description("When there is no use of the 'processing engine', the field should not be visible, for example in case of 'Free form' and 'Medical charts'")
    @Test(priority = 22, groups = "smoke", description = "When there is no use of the 'processing engine', the field should not be visible, for example in case of 'Free form' and 'Medical charts'")
    public void Verify_Processing_Engine() throws Exception {
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnCreateProjectButton();
        waitForloadSpinner();
        project.ClickOnTemplateNameNew("QA-Automation");
        project.ClickOnLeadBtn();
        project.selectLead();
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "20", "1");
        Thread.sleep(1000);
        project.selectDateRange("2022", "OCT", "23", "2");
        Thread.sleep(2000);
        project.selectDocumentStructure();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Structured')]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltip='If enabled, the documents will not require any manual intervention if the threshold score matches.']")).getText(), "Straight Through Process   ");
        project.selectDocumentStructure();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Medical Chart')]")).click();
        //   softAssert.assertEquals(driver.findElement(By.xpath("//span[@mattooltip='If enabled, the documents will not require any manual intervention if the threshold score matches.']")).getText(), "Straight Through Process   ");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: P022 - Verify the \"List View\" button and user available in list view.")
    @Description("Verify the \"List View\" button and user available in list view.")
    @Test(priority = 22, groups = "smoke", description = "Verify the \"List View\" button and user available in list view.")
    public void verify_activeDiactiveProject() throws Exception {
        softAssert = new SoftAssert();
        project = new Project_Module(driver);
        waitForloadSpinner();
        project.clickOnList();
        Thread.sleep(2000);
        List<WebElement> activedeactiveusers = driver.findElements(By.xpath("//i[@class=\"fa fa-briefcase primary-font-color mr-2\"]"));
        for (WebElement colorcode : activedeactiveusers) {
            System.out.println(colorcode.getCssValue("color"));

        }


    }


}