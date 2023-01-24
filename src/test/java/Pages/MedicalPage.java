package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalPage {
    WebDriver driver;


    @FindBy(xpath = "(//span[contains(text(), 'Add Header')])[1]")
    public WebElement commentdropdown;


    @FindBy(xpath = "//span[@class=\"mat-select-placeholder mat-select-min-line ng-tns-c163-54 ng-star-inserted\"]")
    public WebElement commentdropdown1;

    @FindBy(xpath = "(//span[@class=\"mat-option-text\"])[1]")
    public WebElement selectheader;


    @FindBy(xpath = "(//mat-select[@placeholder=\"Add Header\"])[3]")
    public WebElement selecticdheaderdropdown;

    @FindBy(xpath = "(//mat-select[@placeholder=\"Add Header\"])[1]")
    public WebElement headerDropdown;


    @FindBy(xpath = "(//div[contains(text(),'DOS End Date ')])[1]")
    public WebElement dos;


    @FindBy(xpath = "(//mat-icon[contains(text(),' create')])[1]")
    public WebElement editencounter;


    @FindBy(xpath = "//span[contains(text(),' QA-Automation-Medical-One-Option ')]")
    public WebElement mproject;

    @FindBy(xpath = "//span[contains(text(),' QA-Automation-Medical-One-Option ')]")
    public WebElement mreadydocumentproject;

    @FindBy(xpath = "(//button[contains(@class,\"mat-focus-indicator outline-none foregroundColor headerButtons ml-\")])[2]")
    public WebElement deleteencounter;


    public MedicalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void deleteEncounter() {
        this.deleteencounter.click();
    }


    public void selecticdHeaderDropdown() {
        this.selecticdheaderdropdown.click();
    }

    public void headerDropdown() {
        this.headerDropdown.click();
    }


    public void selectProjectMedical() {
        this.mproject.click();
    }

    public void clickOnMedicalProject() {
        this.mreadydocumentproject.click();
    }

    public void clickCommentDropdown() {
        this.commentdropdown.click();
    }

    public void clickHeaderDropdown() {
        this.selectheader.click();
    }

    public void clickHeaderDropdown1() {
        this.commentdropdown1.click();
    }

    public void clickOnDiagnosisDos() {
        this.dos.click();
    }


    public void clickOnEditEncounter() {
        this.editencounter.click();
    }

    public void clickonCommentDropdown() {
        this.selectheader.click();
    }

}
