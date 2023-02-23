package Tests;

import Pages.*;
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
import org.testng.util.Strings;

import java.util.List;


public class UserTest extends BaseTest {
    UserPage userPage;
    SoftAssert softAssert;
    SortingLists sortingLists;
    Custome_Wait custom;
    ClickOnOutSide clickOnOutSide;
    Scroll_Page scrollPage;
    Project_Module projectModule;
    ReportPage reportPage;
    DocumentPage docobj;
    FunctionalPage functional;

    LoginPage loginobj;
    MedicalPage medobj;


    @BeforeMethod
    public void setmethod() throws Exception {
        setup();
        loginApplication();
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U001 -Search project name on user page")
    @Description(" verify_that_user_able_to_Search_project_name_on_user_page")
    @Test(priority = 1, groups = "smoke", description = "verify_that_user_able_to_Search_project_name_on_user_page")
    public void verifyProjectnameShouldBeSearchOnUserPage() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("QA Automation Project");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']")).isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U002 -verify User Able To Click On Cancel Button")
    @Description(" verify_user_able_to_click_on_cancel_button")
    @Test(priority = 2, groups = "smoke", description = "verify_user_able_to_click_on_cancel_button")
    public void verifyUserAbleToClickOnCancelButton() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("QA Automation Project");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();
       /* userPage.clickonActionBtton();
        waitForloadSpinner();*/
        userPage.clickonCancelButtonOfEditUser();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed());
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U003 -Create New User and Verify All Text Of Create User")
    @Description(" verify_user_able_to_create_new_user_with_blank_data_and_verify_all_text_of_create_user")
    @Test(priority = 3, groups = "smoke", description = "verify_user_able_to_create_new_user_with_blank_data_and_verify_all_text_of_create_user")
    public void verifyUserableToCreatNewUserAndVerifyAllTextOfCreatUser() throws Exception {
        softAssert = new SoftAssert();
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Please enter all the details before submitting.')]")).getText(), "Please enter all the details before submitting.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid user name.')]")).getText(), "Please enter a valid user name.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(), "Please enter a valid email id.");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U004 -Click On Active Role Toggle Button In UserTab")
    @Description("verify_user_able_to_click_on_active_role_toggle_button_in_user_tab")
    @Test(priority = 4, groups = "smoke", description = "verify_user_able_to_click_on_active_role_toggle_button_in_user_tab")
    public void verifyWorkingOfToggleButton() throws Exception {
        userPage = new UserPage(driver);
        custom = new Custome_Wait(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();

        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");


    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U005 -The Total Count Of User in UserTab")
    @Description("verify_the_total_Count_Of_user_in_UserTab")
    @Test(priority = 5, groups = "smoke", description = "verify_the_total_Count_Of_user_in_UserTab")
    public void verifyTheTotalCountOfUserinUserTab() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[@class='mat-paginator-page-size-label']//following::div[6]")));
        userPage.clickOnDropDown();
        userPage.selectDropDownValue();
        waitForloadSpinner();
        userPage.userClickOnNextpageTab();
        waitForloadSpinner();
        userPage.userClickOnNextpageTab();
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[@class='primary-font-color']")).getText(),"List of Users");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U006 -All DropDown Arrow In Table")
    @Description("verify_all_dropDown_arrow_in_table")
    @Test(priority = 6, groups = "smoke", description = "verify_all_dropDown_arrow_in_table")
    public void verifyAllDropDownArrowInTable() throws Exception {
        softAssert = new SoftAssert();
        userPage = new UserPage(driver);
        custom = new Custome_Wait(driver);
        sortingLists = new SortingLists(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//div[contains(text(),'Name')]")));
        userPage.clickOnTableArrowDropDown("Name ");
        sortingLists.sortingListInOrder("ascending", 1);
        userPage.clickOnTableArrowDropDown("Name ");
        sortingLists.sortingListInOrder("descending", 1);
        Thread.sleep(1000);
        sortingLists.sortingListInOrder("ascending", 2);
        userPage.clickOnTableArrowDropDown(" Email ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Email ']")).isEnabled());
        sortingLists.sortingListInOrder("descending ", 2);
        userPage.clickOnTableArrowDropDown(" Email ");
        userPage.clickOnTableArrowDropDown(" Assigned Projects ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Assigned Projects ']")).isEnabled());
        userPage.clickOnTableArrowDropDown(" Assigned Projects ");
        userPage.clickOnTableArrowDropDown(" Updated ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Updated ']")).isEnabled());
        userPage.clickOnTableArrowDropDown(" Updated ");
        userPage.clickOnTableArrowDropDown(" Created ");
        softAssert.assertTrue(driver.findElement(By.xpath("//div[text()=' Created ']")).isEnabled());
        userPage.clickOnTableArrowDropDown(" Created ");
        softAssert.assertAll();
    }

//    @Severity(SeverityLevel.CRITICAL)
//    @Story("story_id: U007 -To Add Or Delete Role")
//    @Description("verify_user_able_to_add_or_delete_role")
//    @Test(priority = 7, groups = "smoke", description = "verify_user_able_to_add_or_delete_role")
//    public void verifyUserAbleToAddOrDeletRole() throws Exception {
//        userPage = new UserPage(driver);
//        softAssert = new SoftAssert();
//        custom = new Custome_Wait(driver);
//        //verify the text of user Button
//        waitForloadSpinner();
//        userPage.userclickOnUserTab();
//        waitForloadSpinner();
//        userPage.clickonGridIcon();
//        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@placeholder='Search']")));
//
//        userPage.searchProjectInUserPage("QA Automation Project");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
//        waitForloadSpinner();
//        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
//        waitForloadSpinner();
//       /* userPage.clickonActionBtton();
//        waitForloadSpinner();*/
//        System.out.println((driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]")).getText()));
//        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/user-management");
//        softAssert.assertAll();
//    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U008 -verifyUserAbleToUpdateProjectNameandPassword")
    @Description("verifyUserAbleToUpdateProjectNameandPassword")
    @Test(priority = 8, groups = "smoke", description = "verifyUserAbleToUpdateProjectNameandPassword")
    public void verifyUserAbleToUpdateProjectNameandPassword() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        Thread.sleep(3000);
        userPage.searchProjectInUserPage("QA Automation Project");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();
       /* Thread.sleep(2000);
        userPage.clickonActionBtton();*/
        waitForloadSpinner();
        userPage.updateUsername();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")));
        userPage.updatePassword();
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.clickOnUpdateButton();
        waitForloadSpinner();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/user-management");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U009 -VerifyUserWithblankUserAndPassword")
    @Description("VerifyUserWithblankUserAndPassword")
    @Test(priority = 9, groups = "smoke", description = "VerifyUserWithblankUserAndPassword")
    public void VerifyUpdateUserWithblankUserAndPassword() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        Thread.sleep(3000);
        userPage.searchProjectInUserPage("QA Automation Project");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();
//        userPage.clickonActionBtton();
//        waitForloadSpinner();
        userPage.blankUsername();
        userPage.blankPassword();
        userPage.clickOnUpdateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid user name.')]")).getText(), "Please enter a valid user name.");
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Please enter a user name before updating the user.");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U010 -VerifyUserIsAbleToUpdateUserWithInvalidUsernameAndPassword")
    @Description("VerifyUserIsAbleToUpdateUserWithInvalidUsernameAndPassword")
    @Test(priority = 10, groups = "smoke", description = "VerifyUserIsAbleToUpdateUserWithInvalidUsernameAndPassword")
    public void VerifyUserIsAbleToUpdateUserWithInvalidUsernameAndPassword() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("Pratiksha");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();
        /*userPage.clickonActionBtton();
        waitForloadSpinner();*/
        userPage.enetrInvalidUsername("Noah1234");
        userPage.enterInvalidPassword("Qwerty");
        userPage.clickOnUpdateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only characters.')]")).getText(), "Please enter only characters.");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U011 -VerifyUserWithblankUserAndPassword")
    @Description("VerifyUserWithblankUserAndPassword")
    @Test(priority = 11, groups = "smoke", description = "VerifyUserWithblankUserAndPassword")
    public void VerifyUserIsAbleToCreateUserWithInvalidEmailAndName() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidName("1111");
        userPage.enterInvalidEmail("dfghjkl");
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only characters.')]")).getText(), "Please enter only characters.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(), "Please enter a valid email id.");
        softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")).getText(), "Please enter a valid user name before creating the user.");
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U012 -create user with exiting name")
    @Description("create user with exiting name")
    @Test(priority = 12, groups = "smoke", description = "create user with exiting name")
    public void create_user_with_exiting_name() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidName("demo");
        userPage.enterInvalidEmail("abc@gmail.com");
        userPage.setActiveUserToggleButton("on");
        userPage.clickOnCreateButton();
        Thread.sleep(2000);
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'A user already exists with a mail ID- abc@gmail.com')]")).getText(), "A user already exists with a mail ID- abc@gmail.com");
        softAssert.assertAll();

    }


    List<WebElement> userTiles = null;

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U013 -verify details on user tiles")
    @Description("verify_details_on_user_tiles")
    @Test(priority = 13, groups = "smoke", description = "verify_details_on_user_tiles")
    public void verifyTileDetailsForAllUsers() throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();

        userTiles = userPage.getListOfUserTiles();
        System.out.println(userTiles.size());
        /*for (WebElement ele : userTiles){
            try{
                userPage.verifyUserTileDetails(ele);
            }catch(StaleElementReferenceException sere){
                System.out.println("Stale Element Reference Exception");
                sere.printStackTrace();
                PageFactory.initElements(driver,UserPage.class);
                userPage.verifyUserTileDetails(ele);
            }
        }*/
        for (int i = 1; i <= userTiles.size(); i++) {
            if (i > 5) break;
            userPage.verifyUserTileDetails(i);
        }
    }

    @Story("story_id: U014 -verify user active status")
    @Description("verify_user_active_status")
    @Test(priority = 14, groups = "smoke", description = "verify_user_active_status", dataProvider = "userEmailIds")
    public void verifyUserActiveInactiveStatus(String userEmailId) throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
       userPage.clickonGridIcon();
        userPage.searchUserInGridView(userEmailId);
        waitForloadSpinner();
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
      //  waitForloadSpinner();
        boolean userStatusInGrid = userPage.getUserStatusInUserGrid(userEmailId);
        userPage.goToUserDetailsPageFromUserGrid(userEmailId);
        waitForloadSpinner();
        Assert.assertEquals(userStatusInGrid, userPage.getUserStatusInUserDetailsPage());
    }

    @DataProvider(name = "userEmailIds")
    public Object[][] userEmailIdsToValidate() {
        return new Object[][]{ {"test@gmail.com"}, {"wehomog846@migonom.com"}, {"nts-auditor@yopmail.com"}, {"demo@gmail.com"}, {"regression@gmail.com"}, {"neutrinotech123@gmail.com"}, {"207adminuseremail@test.com"}, {"bagalpratiksha1999@gmail.com"}, {"poxiti1250@iunicus.com"}};
    }

    @Story("story_id: U015 -login_with_another_user")
    @Description("login_with_another_user")
    @Test(priority = 15, groups = "smoke", description = "login_with_another_user")
    public void login_with_another_user() throws Exception {
        userPage = new UserPage(driver);
        loginPage = new LoginPage(driver);
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("Supervisor@Test.com");
        loginPage.setPassword("Super@1111");
        loginPage.clickLoginButton();


    }

    @Story("story_id: U015 -login_with_another_user")
    @Description("login_with_another_user")
    @Test(priority = 15, groups = "smoke", description = "login_with_another_user")
    public void check_User_Is_Inactive() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("amar.gaikwad@neutrinotechlabs.com");
        loginPage.setPassword("Amar@12345");
        loginPage.clickLoginButton();


    }

    @Story("story_id: U016 -verify the format of the dates in users page")
    @Description("verify_the_format_of_the_dates_in_users_page")
    @Test(priority = 16, groups = "smoke", description = "verify_the_format_of_the_dates_in_users_page")
    public void verifyDateFormatInUsersPage() throws Exception {
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        String userEmailId = "michael223@gmail.com";
        userPage.clickonGridIcon();
        userPage.searchUserInGridView(userEmailId);
        Assert.assertTrue(DateTimeUtils.verifyDateFormat(userPage.getCreatedDateOfSearchedUserInGridView()), "Date is not in correct format.");
    }

    @Story("story_id: U017 -verify user updated date greater than created date for all users")
    @Description("verify_user_updated_date_greater_than_created_date")
    @Test(priority = 17, groups = "smoke", description = "verify_user_updated_date_greater_than_created_date_for_all_users")
    public void verifyUserUpdatedDateForAllUsers() throws Exception {
        softAssert = new SoftAssert();
        userPage = new UserPage(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userTiles = userPage.getListOfUserTiles();
        System.out.println(userTiles.size());
        for (int i = 1; i <= userTiles.size(); i++) {
            softAssert.assertTrue(DateTimeUtils.compareDates(userPage.getCreatedDateFromUserTile(i), userPage.getUpdatedDateFromUserTile(i)), "Updated Date (" + userPage.getUpdatedDateFromUserTile(i) + ") is not greater than Created Date (" + userPage.getCreatedDateFromUserTile(i) + ") for the user.");

        }
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U018 -VerifyEmailField")
    @Description("VerifyEmailField")
    @Test(priority = 18, groups = "smoke", description = "VerifyUserWithblankUserAndPassword")
    public void VerifyEmailField() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        custom = new Custome_Wait(driver);
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        custom.waitVisibility(driver, driver.findElement(By.xpath("//input[@placeholder='Search']")));
        userPage.searchProjectInUserPage("QA Automation Project");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();
       /* userPage.clickonActionBtton();
        waitForloadSpinner();*/
        if (driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]")).isEnabled()) {
            System.out.println("Editable");
        } else {
            System.out.println("Not Editable");
        }
        softAssert.assertAll();
    }


    @Story("story_id: U019 -Verify the inactive user logo and active user logo.")
    @Description("Verify the inactive user logo and active user logo.")
    @Test(priority = 19, groups = "smoke", description = "Verify the inactive user logo and active user logo")
    public void verifyActiveInactiveUserColour() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickonGridIcon();
        userPage.searchProjectInUserPage("user@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
       /* driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        Thread.sleep(3000);*/
        String colorGrey = driver.findElement(By.xpath("(//mat-icon[contains(text(),'person')])[1]")).getCssValue("Color");
        System.out.println(colorGrey);
        softAssert.assertEquals(driver.findElement(By.xpath("(//mat-icon[contains(text(),'person')])[1]")).getCssValue("Color"), "rgb(232, 112, 51)");
        driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
        Thread.sleep(1000);
        userPage.searchProjectInUserPage("om.r@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
      /*  driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();*/
        String colorOrg = driver.findElement(By.xpath("//mat-icon[contains(text(),'person')]")).getCssValue("color");
        System.out.println(colorOrg);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-icon[contains(text(),'person')]")).getCssValue("Color"), "rgba(108, 117, 125, 1)");
//        softAssert.assertAll();
    }

    @Story("story_id:  U020 -Verify the validation of Name text box. {Invalid Value(enter Special Character)}")
    @Description("Verify the validation of Name text box. {Invalid Value(enter Special Character)}")
    @Test(priority = 20, groups = "smoke", description = "Verify the validation of Name text box. {Invalid Value(enter Special Character)}")
    public void verifyUsernameForNewUser() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        Thread.sleep(2000);
        userPage.enterInvalidName("!@#$%%");
        userPage.enterInvalidEmail("abc");
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only characters.')]")).getText(), "Please enter only characters.");
        softAssert.assertAll();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 021 -To verify Assignee name")
    @Description("To verify Assignee name")
    @Test(priority = 21, groups = "smoke", description = "To verify Assignee name")
    public void verifyAssigneeName() throws Exception {
        scrollPage = new Scroll_Page(driver);
        reportPage = new ReportPage(driver);
        sortingLists = new SortingLists(driver);
        projectModule = new Project_Module(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        reportPage.clickOnReportTab();
        waitForloadSpinner();
        reportPage.selectProject();
        Thread.sleep(1000);
        reportPage.clickOnFilterDropDownArrow();
        Thread.sleep(1000);
        reportPage.clickOnassigneeDropDown();
        String reportName = driver.findElement(By.xpath("//span[contains(text(),' omkar.ranaware@neutrinotechlabs.com ')]")).getText();
        Thread.sleep(1000);
        clickOnOutSide.clickOutside();
        projectModule.clickOnProjectPage();
        waitForloadSpinner();
        projectModule.searchCreatedProject("888-medical");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
        waitForloadSpinner();
        driver.findElement(By.xpath("//tr[1]/td[2]")).click();
        waitForloadSpinner();
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(1000);
        projectModule.clickOnRoleLabel();
        JavascriptExecutor jsp1 = (JavascriptExecutor) driver;
        jsp.executeScript("window.scrollBy(0,5000)", "");
        String ProjectName = driver.findElement(By.xpath("(//mat-chip[contains(text(),'omkar.ranaware@neutrinotechlabs.com')])[1]")).getText();
        if (reportName.equals(ProjectName)) {
            System.out.println("Same Operator");
        } else {
            System.out.println("Different Operator");
        }
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U022 -To verify Enables users")
    @Description("To verify Enables users")
    @Test(priority = 22, groups = "smoke", description = "To verify Enables users")
    public void verifyEnablesUsers() throws Exception {
        scrollPage = new Scroll_Page(driver);
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        clickOnOutSide = new ClickOnOutSide(driver);
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        List<WebElement> enablesusers = driver.findElements(By.xpath("//mat-icon[@class=\"mat-icon notranslate primary-font-color card-person-icon material-icons mat-icon-no-color\"]"));
        for (WebElement enable : enablesusers) {
            String enablecolor = enable.getCssValue("color");
            softAssert.assertEquals(enablecolor, "rgba(232, 112, 51, 1)");

            softAssert.assertAll();
        }

    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U022 -VerifyUserWithInvalidName")
    @Description("VerifyUserWithInvalidName")
    @Test(priority = 22, groups = "smoke", description = "VerifyUserWithInvalidName")
    public void verifyUserWithInvalidName() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidName("@#$%^&*");
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter only characters.')]")).getText(), "Please enter only characters.");
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(), "Please enter a valid email id.");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U023 -VerifyUserWithInvalidEmail")
    @Description("VerifyUserWithInvalidEmail")
    @Test(priority = 23, groups = "smoke", description = "VerifyUserWithInvalidEmail")
    public void verifyUserWithInvalidEmail() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidEmail("manisha.vish#gmail.com");
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(), "Please enter a valid email id.");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U024 -VerifyUserWithInvalidEmailWithSpecialSymbols")
    @Description("VerifyUserWithInvalidEmailWithSpecialSymbols")
    @Test(priority = 24, groups = "smoke", description = "VerifyUserWithInvalidEmailWithSpecialSymbols")
    public void verifyUserWithInvalidEmailWithSpecialSymbols() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidEmail("!#$%^&*@gmail.com");
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.clickOnCreateButton();
        softAssert.assertEquals(driver.findElement(By.xpath("//mat-error[contains(text(),'Please enter a valid email id.')]")).getText(), "Please enter a valid email id.");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: U025 -VerifyUserCreationCancelButton")
    @Description("VerifyUserCreationCancelButton")
    @Test(priority = 25, groups = "smoke", description = "VerifyUserCreationCancelButton")
    public void verifyUserCreationCancelButton() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        //verify the text of user Button
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.enterInvalidName("pratiksha");
        userPage.enterInvalidEmail("pratikshabagal@gmail.com");
        userPage.setActiveUserToggleButton("on");
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        userPage.clickOCancelButton();
        waitForloadSpinner();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://alpha.neutrino-ai.com/#/home/user-management");
        softAssert.assertAll();
    }


    @Story("story_id: U026-login_with_another_user_Verify_Cancel_Button")
    @Description("login_with_another_user")
    @Test(priority = 26, groups = "smoke", description = "login_with_another_user")
    public void login_With_Another_User_Verify_Cancel_Button() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("amar.gaikwad@neutrinotechlabs.com");
        loginPage.setPassword("Amar@12345");
        loginPage.clickLoginButton();


    }


/*    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case Id: U027 - verifyUserWithNoProject")
    @Description("verifyUserWithNoProject")
    @Test(priority = 27, groups = "smoke", description = "verifyUserWithNoProject")
    public void verifyUserWithNoProject() throws Exception {
        docobj = new DocumentPage(driver);
        medobj = new MedicalPage(driver);
        projectModule = new Project_Module(driver);
        softAssert = new SoftAssert();
        scrollPage = new Scroll_Page(driver);
        custom = new Custome_Wait(driver);
        clickOnOutSide = new ClickOnOutSide(driver);
        loginobj = new LoginPage(driver);
        waitForloadSpinner();
        loginobj.ClickLogoutBtn();
        waitForloadSpinner();
        loginobj.EnterUsername("report1@gmail.com");
        loginobj.setPassword("Nts@1234");
        loginobj.clickLoginButton();
        waitForloadSpinner();
        projectModule.clickOnProjectPage();
        waitForloadSpinner();
        softAssert.assertTrue(driver.findElement(By.xpath("//img[@src=\"./assets/images/No content.png\"]")).isDisplayed());
    }*/


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: U0028 - Verify user is able to change Profile picture ")
    @Description("Verify user is able to change Profile picture ")
    @Test(priority = 28, groups = "smoke", description = "Verify user is able to change Profile picture ")
    public void verifyUserIsAbleToChangeProfilePicture() throws Exception {

        userPage = new UserPage(driver);
        functional = new FunctionalPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.clickOnProfileIcon();
        Thread.sleep(1000);
        functional.clickOnEditProfile();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='fileInput']")).click();
        Thread.sleep(2000);
//        Runtime.getRuntime().exec("C:\\Users\\bagal\\OneDrive\\Documents\\autoit-v3\\install\\SciTe\\profilepic.exe");
//        Assert.assertTrue(Strings.isNotNullAndNotEmpty(driver.findElement(By.xpath("//label[@for='fileInput']/img")).getAttribute("src")));
//        System.out.println(driver.findElement(By.xpath("//label[@for='fileInput']/img")).getAttribute("src"));
        functional.clickOnSaveButton();
        waitForloadSpinner();
        userPage.clickOnProfileIcon();
        Thread.sleep(1000);
        functional.clickOnEditProfile();
        Thread.sleep(2000);
        functional.clickOnRemoveButton();
        Thread.sleep(1000);
        functional.clickOnSaveButton();
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C029 - Verify operator is able to create user ")
    @Description("Verify operator is able to create user ")
    @Test(priority = 29, groups = "smoke", description = "Verify operator is able to create user")
    public void verifyOperatorAbleToCreateUser() throws Exception {
        userPage = new UserPage(driver);
        functional = new FunctionalPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("omkar.ranaware@neutrinotechlabs.com");
        loginPage.setPassword("Omkar@0955");
        loginPage.clickLoginButton();
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: C030 - Verify operator is able to update user ")
    @Description("Verify operator is able to update user ")
    @Test(priority = 30, groups = "smoke", description = "Verify operator is able to update user")
    public void verifyOperatorAbleToUpdateUser() throws Exception {
        userPage = new UserPage(driver);
        functional = new FunctionalPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("omkar.ranaware@neutrinotechlabs.com");
        loginPage.setPassword("Omkar@0955");
        loginPage.clickLoginButton();
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.searchProjectInUserPage("superDemo");
        Thread.sleep(2000);
        userPage.clickonActionBtton();
waitForloadSpinner();
        driver.findElement(userPage.userName).clear();
        Thread.sleep(1000);
        userPage.EnterNewUserName("supaedemo");
        Thread.sleep(1000);
        userPage.clickOnUpdateButton();


    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: U022 - verify that user is able to create new role ")
    @Description("verify that user is able to create new role")
    @Test(priority = 22, groups = "smoke", description = "verify that user is able to create new role")
    public void verifyCreateNewUser() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        userPage.clickOnCreateUserButton();
        waitForloadSpinner();
        userPage.EnterNewUserName("qatest");
        userPage.EnterNewUserEmail("qatest@gmail.com");
        Thread.sleep(1000);
        userPage.setActiveUserToggleButton("on");
        userPage.setOtpVerificationToggleButton("on");
        Thread.sleep(1000);
        userPage.clickOnCreateButton();
       waitForloadSpinner();

    }


    @Story("story_id: U021 -Verify text on UI User Page.")
    @Description("Verify text present on UI User Page.")
    @Test(priority = 21, groups = "smoke", description = "Verify text on UI User Page")
    public void verifyUITextOnUserPage() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.userclickOnUserTab();
        waitForloadSpinner();
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[@class='primary-font-color']")).getText(), "List of Users");
        Thread.sleep(3000);
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator font-17 float-right ')]")).getText(), "Create User");
        userPage.clickonGridIcon();
        userPage.getTheTextOfListOfUsers();
        softAssert.assertEquals(driver.findElement(By.xpath("//th[contains(@class,'mat-header-cell cdk-header-cell font-14px cdk-column')]")).getText(), "Action");
        userPage.searchUserInGridView("QAAutomation");
        Thread.sleep(2000);
        userPage.clickOnUsersName();
        userPage.getTheTextOfEditUser();
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator float-right button')]")).getText(), "Update");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator float-right ml')]")).getText(), "Cancel");
        Thread.sleep(2000);
        userPage.clickonCancelButtonOfEditUser();
        Thread.sleep(2000);
        userPage.clickOnCreateUserButton();
        Thread.sleep(3000);
        softAssert.assertEquals(driver.findElement(By.xpath("//strong[@class='primary-font-color']")).getText(), "Create User");
        userPage.getTheTextOfListOfCreateUsers();
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@class='mat-focus-indicator float-right ml-2 button-cls mat-stroked-button mat-button-base mat-accent']")).getText(), "Cancel");
        softAssert.assertEquals(driver.findElement(By.xpath("//button[@class='mat-focus-indicator float-right button-cls mat-raised-button mat-button-base mat-primary']")).getText(), "Create");
        softAssert.assertAll();
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: U0029 - verifyUserIsAbleToChangeProfilePictureWithPngFormat ")
    @Description("verifyUserIsAbleToChangeProfilePictureWithPngFormat ")
    @Test(priority = 29, groups = "smoke", description = "verifyUserIsAbleToChangeProfilePictureWithPngFormat")
    public void verifyUserIsAbleToChangeProfilePictureWithPngFormat() throws Exception {

        userPage = new UserPage(driver);
        functional = new FunctionalPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.clickOnProfileIcon();
        Thread.sleep(1000);
        functional.clickOnEditProfile();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='fileInput']")).click();
        Thread.sleep(2000);
//        Runtime.getRuntime().exec("C:\\Users\\bagal\\OneDrive\\Documents\\autoit-v3\\install\\SciTe\\profilepicpng.exe");
//        Assert.assertTrue(Strings.isNotNullAndNotEmpty(driver.findElement(By.xpath("//label[@for='fileInput']/img")).getAttribute("src")));
//        System.out.println(driver.findElement(By.xpath("//label[@for='fileInput']/img")).getAttribute("src"));
        functional.clickOnSaveButton();
        waitForloadSpinner();
        userPage.clickOnProfileIcon();
        Thread.sleep(1000);
        functional.clickOnEditProfile();
        Thread.sleep(2000);
     //   functional.clickOnRemoveButton();
        Thread.sleep(1000);
        functional.clickOnSaveButton();
        softAssert.assertAll();

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story_id: U0030 - verifyUserIsAbleToChangeProfilePictureWithPngFormat ")
    @Description("verifyUserIsAbleToChangeProfilePictureWithPngFormat ")
    @Test(priority = 30, groups = "smoke", description = "verifyUserIsAbleToChangeProfilePictureWithPngFormat")
    public void verifyUserIsAbleToChangeProfilePictureWithHigherResolution() throws Exception {

        userPage = new UserPage(driver);
        functional = new FunctionalPage(driver);
        softAssert = new SoftAssert();
        waitForloadSpinner();
        userPage.clickOnProfileIcon();
        Thread.sleep(1000);
        functional.clickOnEditProfile();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='fileInput']")).click();
        Thread.sleep(2000);
     //   Runtime.getRuntime().exec("C:\\Users\\bagal\\OneDrive\\Documents\\autoit-v3\\install\\SciTe\\higherresolution.exe");
//       softAssert.assertEquals(driver.findElement(By.xpath("//simple-snack-bar[@class=\"mat-simple-snackbar ng-star-inserted\"]")).getText(),"Please upload an image with the resolution less than 400*400.");
    }



    @Story("story_id: U015 -login_with_another_user")
    @Description("login_with_another_user")
    @Test(priority = 15, groups = "smoke", description = "login_with_another_user")
    public void verifyOperatorIsableToUpdateOrCreateUser() throws Exception {
        userPage = new UserPage(driver);
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        waitForloadSpinner();
        userPage.clickOnLogoutButton();
        waitForloadSpinner();
        loginPage.EnterUsername("Supervisor@Test.com");
        loginPage.setPassword("Super@1111");
        loginPage.clickLoginButton();
        waitForloadSpinner();
        userPage.userclickOnUserTab();


    }

}




