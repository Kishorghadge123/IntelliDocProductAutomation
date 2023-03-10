package Tests;

import Pages.LoginPage;
import Utilities.InitTestData;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    WebDriverWait wait;

    Properties testdata;
    NgWebDriver ngWebDriver;
    public WebDriver driver;
    LoginPage loginPage;
    InitTestData initTestData;
    public void setup() throws Exception {
        loginPage = new LoginPage(driver);
        initTestData = new InitTestData("alpha");
        testdata = initTestData.testdata;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(testdata.getProperty("url"));
    }
    public void loginApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.EnterUsername(testdata.getProperty("user"));
        loginPage.setPassword(testdata.getProperty("password"));
        loginPage.clickLoginButton();
        waitForloadSpinner();
    }
    public void waitForloadSpinner() throws Exception {
        try {
            wait = new WebDriverWait(driver, 11L);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Please wait...'] ")))); // wait for loader to
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='Please wait...'] ")))); // wait for loader to disappear
        } catch (Exception e) {
            System.out.println("Spinar Not Appear");
        }
    }
}