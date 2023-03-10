package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DocumentPage {
    WebDriver driver = null;
    Actions action;
    SoftAssert softAssert;


    public DocumentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//img[contains(@src,'Documents.svg')]")
    public WebElement documentbtn;


    @FindBy(xpath = "//span[@class='mat-tooltip-trigger projectname']")
    public WebElement dropdown;

    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[1]")
    public WebElement chartflag;


    @FindBy(xpath = "//span[contains(text(),' Non-HCC ')]")
    public WebElement nonhccflag;


    @FindBy(xpath = "//span[contains(text(),' QA-AutoProject-SemiStructured2820qy ')]")
    public WebElement nodocumentproject;

    @FindBy(xpath = "//span[contains(text(),' QA-Automation Medical ')]")
    public WebElement selectproject;

    @FindBy(xpath = "//span[contains(text(),' QA-Automation BRE ')]")
    public WebElement selectrejectedocproject;

    @FindBy(xpath = "//span[contains(text(),' QA-AutoProject-SemiStructured2820im ')]")
    public WebElement selectsemiproject;


    @FindBy(how = How.XPATH, using = "//mat-cell[contains(@class,'mat-column-codes')]//span[contains(@class,'mat-select-min-line')]")
    List<WebElement> listOfICDColumnsInDiagnosisTab;


    @FindBy(xpath = "//span[contains(text(),' QA-Automation BRE ')]")
    public WebElement structproject;


    @FindBy(xpath = "//span[contains(text(),' 3.jpg ')]")
    public WebElement structpdf;

    @FindBy(xpath = "(//div[@style=\"transform: translateY(10px);\"])[1]")
    public WebElement size;

    @FindBy(xpath = "//span[contains(text(),' MedicalReady2.pdf ')]")
    public WebElement readydoc;


    @FindBy(xpath = "//button[@title=\"Find in Document\"]")
    public WebElement searchbox;


    @FindBy(xpath = "//input[@placeholder=\"Find in document???\"]")
    public WebElement textbox;


    @FindBy(xpath = "//div[contains(text(),'DOS End Date ')]")
    public WebElement diagnosisDOSEndDate;

    @FindBy(xpath = "//button[contains(@class,\"mat-focus-indicator mr-2 mat-stroked-button\")]")
    public WebElement cancelHCCButton;

    @FindBy(xpath = "//button[contains(@class,'mat-focus-indicator mr-2 mat-stroke')]")
    public WebElement cancelAddEncounterDetails;


    @FindBy(xpath = "//div[contains(text(),'Patient Demographics')]")
    public WebElement demography;

    @FindBy(xpath = "//mat-label[contains(text(),'MedicalReady2.pdf')]")
    public WebElement readydocname;

    @FindBy(xpath = "//mat-label[contains(text(),'Chart Data')]")
    public WebElement chartdata;

    @FindBy(xpath = "//mat-label[contains(text(),'Data')]")
    public WebElement data;

    @FindBy(xpath = "//div[contains(text(),' Diagnosis ')]")
    public WebElement diagnosistab;
    @FindBy(xpath = "(//mat-icon[contains(text(),' add')])[1]")
    public WebElement adddiagnosis;


    @FindBy(xpath = "(//div[contains(text(),'DOS End Date ')])[1]")
    public WebElement diagnosisname1;

    @FindBy(xpath = "//button[@class=\"mat-focus-indicator mat-raised-button mat-button-base mat-primary\"]")
    public WebElement save;

    @FindBy(xpath = "(//span[contains(text(), 'Tommy Love, Jr ')])[1]")
    public WebElement diagnosisname;


    @FindBy(xpath = "//span[contains(text(),'NPI No')]")
    public WebElement deletediag;


    @FindBy(xpath = "(//mat-icon[contains(text(),' add')])[2]")
    public WebElement adddiagnosisbtn;

    @FindBy(xpath = "(//input[@type=\"number\"])[3]")
    public WebElement hcctab;

    @FindBy(xpath = "//input[@name=\"NonHccDiagnosis\"]")
    public WebElement nonhccname;

    @FindBy(xpath = "//input[@name=\"NonHccPageRange\"]")
    public WebElement enetrpagerange;

    @FindBy(xpath = "//mat-select[@name=\"NonHccComment\"]")
    public WebElement selectNonHccDropdown;

    @FindBy(xpath = "//span[contains(text(),' No valid records found ')]")
    public WebElement selectcomment;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")
    public WebElement nonhccsave;

    @FindBy(xpath = "//input[contains(@class,'mat-autocomplete-trigger mat-chip-input mat-input-element')]")
    public WebElement pageno;

    @FindBy(xpath = "//input[@name=\"Diagnosis\"]")
    public WebElement diasesname;


    @FindBy(xpath = "//span[contains(text(),'Add Comment')]")
    public WebElement dropdownhcc;

    @FindBy(xpath = "(//mat-select[@name=\"comment\"])[1]")
    public WebElement commentheader;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
    WebElement selectProjectSearchBox;


    @FindBy(xpath = "//button[@class=\"mat-focus-indicator mat-raised-button mat-button-base mat-primary\"]")
    public WebElement savehcc;

    @FindBy(xpath = "//mat-icon[contains(text(),' delete ')]")
    public WebElement deletediagnosis;


    @FindBy(xpath = "//span[contains(text(),'Add ICD')]")
    public WebElement addicdbtn;

    @FindBy(how = How.XPATH, using = "//mat-tab-body[contains(@class,'mat-tab-body-active')]//mat-expansion-panel")
    List<WebElement> listOfEncountersInDiagnosisTab;


    @FindBy(xpath = "//mat-header-cell[contains(text(),' ICD ')]//following::input[1]")
    public WebElement icd;

    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[3]")
    public WebElement description;

    @FindBy(xpath = "(//span[@class=\"mat-option-text\"])[1]")
    public WebElement selectdescription;


    @FindBy(xpath = "//span[contains(text(),'E1100')]")
    public WebElement icdcode;

    @FindBy(xpath = "//span[contains(text(),' Type 2 diabetes mellitus with hyperosmolarity with coma')]")
    public WebElement selectdescription1;

    @FindBy(xpath = "//span[contains(text(),'Please fill all fields for the diagnosis.')]")
    public WebElement savehccerrmsg;


    @FindBy(xpath = "//span[contains(text(),' Cancel')]")
    public WebElement cancel;


    @FindBy(xpath = "//input[@formcontrolname=\"npiNo\"]")
    public WebElement npi;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter a valid diagnosis. ')]")
    public WebElement diagnosiserrmsg;


    @FindBy(xpath = "//button[@class=\"mat-focus-indicator btn-secondary white_bg mat-stroked-button mat-button-base docStatus-Ready\"]")
    public WebElement readyfilter;

    @FindBy(xpath = "//span[contains(text(),'Rejected ')]")
    public WebElement rejecteffilter;

    @FindBy(xpath = "//span[contains(text(),' Template  Form A1.jpg ')]")
    public WebElement rejecteddocument;

    @FindBy(xpath = "//span[contains(text(),'Processed ')]")
    public WebElement processedfilter;

    @FindBy(xpath = "//span[contains(text(),' arrival 1 page.PDF.pdf ')]")
    public WebElement processeddoc;


    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    public WebElement submit;
    public By documenttiles = By.xpath("//td[@class='mat-cell cdk-cell cdk-column-updated mat-column-updated ng-star-inserted']");


    @FindBy(xpath = "//span[contains(text() ,' Save Draft')]")
    public WebElement savedraft;


    @FindBy(xpath = "//input[@formcontrolname=\"physicianName\"]")
    public WebElement docname;


    @FindBy(xpath = "//mat-error[contains(text(),'Please enter the NPI number.')]")
    public WebElement npierromsg;

    @FindBy(xpath = "//mat-error[contains(text(),'Please enter the doctor???s name. ')]")
    public WebElement doctorerrmsg;

    @FindBy(xpath = "(//mat-error[@role='alert'])[3]")
    public WebElement startdateerrmsg;

    @FindBy(xpath = "//span[contains(text(),'Please fill all the entries before proceeding.')]")
    public WebElement saveerrmsg;


    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[2]")
    public WebElement savedraftdropdwon;


    @FindBy(xpath = "//img[contains(@src,'Documents.svg')]")
    public WebElement documentPage;
    @FindBy(xpath = "//i[@class='fa fa-chevron-circle-down ml-2']")
    public WebElement searchDropdown;
    @FindBy(xpath = "//span[contains(text(),' QA-Automation BRE ')]")
    public WebElement searchProjectName;
    @FindBy(xpath = "//mat-icon[contains(text(),' keyboard_arrow_down ')]")
    public WebElement keyboardArrayDown;
    @FindBy(xpath = "//span[contains(text(),' Filter ')]")
    public WebElement validateFilter;
    @FindBy(xpath = "//mat-label[contains(text(),'Document Name')]")
    public WebElement validateDocumnetName;
    @FindBy(xpath = "//mat-label[contains(text(),'Assignee')]")
    public WebElement validateAssignee;
    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[1]")
    public WebElement assigneeDropDown;
    @FindBy(xpath = "//span[contains(text(),' unassigned ')]")
    public WebElement unassignedCheckBox;
    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[2]")
    public WebElement statusDropDown;

    @FindBy(xpath = "//span[contains(text(),'Clear')]")
    public WebElement clearbtn;

    @FindBy(how = How.XPATH, using = "//div[text()=' Total Encounter Count : ']//input")
    WebElement totalEncounterCountValue;

    @FindBy(xpath = "//span[contains(text(),' Ready ')]")
    public WebElement readyCheckBox;
    @FindBy(xpath = "(//span[contains(text(),' Rejected ')])[2]")
    public WebElement rejectedCheckBox;
    @FindBy(xpath = "(//span[contains(text(),' Apply ')])[2]")
    public WebElement applyButton;
    @FindBy(xpath = "//span[contains(text(),' Processed ')]")
    public WebElement processedCheckBox;


    @FindBy(xpath = "//button[@class=\"mat-focus-indicator selected-project mat-menu-item\"]")
    public WebElement selectedProject;


    @FindBy(xpath = "//mat-icon[contains(text(),'visibility')]")
    public WebElement action1;

    @FindBy(xpath = "//button[@id=\"secondaryToolbarToggle\"]")
    public WebElement zoomoutdropdown;


    @FindBy(xpath = "//span[contains(text(),'Rotate Clockwise')]")
    public WebElement pagefit;


    public void clickOnDocumentPage() {
        this.documentPage.click();
    }

    public void clickOnSearchDropdown() {
        this.searchDropdown.click();
    }

    public void clickonsearchProjectName() {
        this.searchProjectName.click();
    }


    public void clickOnReadyOuterFilterBox() {
        this.readyfilter.click();
    }

    public void clickOnProcessedOuterFilterBox() {
        this.processedfilter.click();
    }

    public void clickOnProcessedDocument() {
        this.processeddoc.click();
    }

    public void clickOnRejectedOuterFilterBox() {
        this.rejecteffilter.click();
    }

    public void clickOnRejectedDocument() {
        this.rejecteddocument.click();
    }


    public void clickOnKeyboardArrayDown() {
        this.keyboardArrayDown.click();
    }

    public void clickOnAssigneeDropDown() {
        this.assigneeDropDown.click();
    }

    public void clickUnassignedCheckBox() {
        this.unassignedCheckBox.click();
    }

    public void clickOnStatusDropDown() {
        this.statusDropDown.click();
    }


    public void clickOnClearButton() {
        this.clearbtn.click();
    }

    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    public void clickOnReadyCheckBox() {
        this.readyCheckBox.click();
    }


    public void clickOnRejectedCheckBox() {
        this.rejectedCheckBox.click();
    }

    public int getTotalEncounterCount() {
        return Integer.parseInt(totalEncounterCountValue.getAttribute("value"));
    }


    public void selectProjectFromDropDown(String projectName) {
        selectProjectSearchBox.click();
        selectProjectSearchBox.sendKeys(projectName);

        /*Custome_Wait.waitVisibility
                (driver, driver.findElement(By.xpath("//span[contains(text(),' "+projectName+" ')]")));*/
        driver.findElement(By.xpath("//span[contains(text(),' " + projectName + " ')]")).click();
    }


    public void clickOnSelectedProject(){
        this.selectedProject.click();
    }

    public void clickOnApplyButton() {
        this.applyButton.click();
    }

    public void clickOnProcessedCheckBox() {
        this.processedCheckBox.click();
    }

    public void clickOnActionButton() {
        this.action1.click();
    }

    public void zoomOutFunctinality() {
        this.zoomoutdropdown.click();
    }

    public void clickOnPageFit() {
        this.pagefit.click();
    }

    public void verifyTotalCountOfAllDocInAnalyticsSection() throws InterruptedException {
        List<WebElement> allDocs = driver.findElements(By.xpath("//div[@class='bgcolor']//h4"));
        System.out.println(allDocs);
        int count = 0;
        for (int i = 1; i < allDocs.size(); i++) {
//                if(i==allDocs.size()-2 || i==allDocs.size()-3){
//                    continue;
//                }else {
            count = count + Integer.parseInt(allDocs.get(i).getText());
        }
        Thread.sleep(1000);
        Assert.assertEquals(allDocs.get(0).getText(), String.valueOf(count));
//            System.out.println("expected:" + allDocs.get(0).getText());
//            System.out.println("actual:" + String.valueOf(count));
    }

    public int getAllProjectsFromDropDown() {
        return driver.findElements(By.xpath("//button[@role='menuitem']")).size();
    }

    public void clickOnDocumentTab() {
        this.documentbtn.click();
    }


    //count senario
    @FindBy(xpath = "(//mat-select[@aria-haspopup='true'])[3]")
    public WebElement countDropDown;

    @FindBy(xpath = "(//span[@class=\"mat-option-text\"])[1]")
    public WebElement selectCount;

    @FindBy(xpath = "//button[@aria-label='Next page']")
    public WebElement nextPagetab;

    public void userClickOnNextpageTab() {
        boolean value1 = this.nextPagetab.isDisplayed();
        System.out.println(value1);
        for (int i = 0; i <= 2000; i++) {
            boolean value = this.nextPagetab.isEnabled();
            if (value) {
                this.nextPagetab.click();
            }
        }
    }

    public String getUserCountOfatomperPage() {
        return driver.findElement(By.xpath("//div[@class=\"mat-paginator-range-label\"]")).getText().split("of")[1].strip();
    }

    public void selectDropDownValue() {
        this.selectCount.click();
    }

    public void clickOnDropDown() {
        this.countDropDown.click();
    }


    public void clickOnTableArrowDropDown(String text) {
        driver.findElement(By.xpath("//div[text()='" + text + "']")).click();
    }

    public void clickOnDropdown() {
        this.dropdown.click();
    }

    public void clickOnChartFlagsDropdown() {
        this.chartflag.click();
    }

    public void clickOnSaveDraft() {
        this.savedraft.click();
    }

    public void selectNonHccFlag() {
        this.nonhccflag.click();
    }

    public void selectProjectWithNoDocument() {
        this.nodocumentproject.click();
    }

    public void openAnalyticsScreenOfADoc(String docName) {
        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),' " + docName + ".pdf ')]")));
        //.click().build().perform();
        driver.findElement(By.xpath("//span[contains(text(),' " + docName + ".pdf ')]")).click();
    }


    public void selectProject() {
        try {
            this.selectproject.click();
        } catch (StaleElementReferenceException sere) {
            System.out.println("Stale Element Reference Exception");
            sere.printStackTrace();
            PageFactory.initElements(driver, this);
            this.selectproject.click();

        }


    }

    public void clickOnRejectedDocumentProject() {
        this.selectrejectedocproject.click();
    }

    public void clickOnSemistructProjectt() {
        this.selectsemiproject.click();
    }


    public void selectStructureProject() {
        this.structproject.click();
    }

    @FindBy(how = How.XPATH, using = "//div[text()=' Total ICD Count : ']//input")
    WebElement totalICDCountValue;


    public void clickOnStructReadyDocument() {
        this.structpdf.click();
    }

    public void clickOnSize() {
        this.size.click();
    }

    public void clickOnReadyDocument() {
        this.readydoc.click();
    }

    public void clickOnserachBox() {
        this.searchbox.click();
    }

    public void enterTextInSerachBox(String str) {
        this.textbox.sendKeys(str);
    }

    public void clickOnPatientDempgraphics() {
        this.demography.click();
    }

    public void clickOnDiagnosisDOSEndDate() {
        this.diagnosisDOSEndDate.click();
    }

    public void clickOnCancelHCCButton() {
        this.cancelHCCButton.click();
    }

    public void clickOnCancelBtnAddEncounterDetails() {
        this.cancelAddEncounterDetails.click();
    }

    public void getTheTextOfListOfPatientDemographics() {
        List<WebElement> getTheTableHeaderText = driver.findElements(By.xpath("//mat-cell[contains(@class,\"mat-tooltip-trigger mat-cell cdk-cell cdk-column-attributeName\")]"));
        softAssert.assertEquals(getTheTableHeaderText.get(0).getText(), " Patient Name ");
        softAssert.assertEquals(getTheTableHeaderText.get(1).getText(), " Age ");
        softAssert.assertEquals(getTheTableHeaderText.get(2).getText(), " Birthdate ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " Gender ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " Phone ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " Address ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " Email Address ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " SSN ");
        softAssert.assertEquals(getTheTableHeaderText.get(3).getText(), " MRN ");
    }

    public void clickOnChartData() {
        this.chartdata.click();
    }

    public void clickOnData() {
        this.data.click();
    }

    public void clickOnDiagnosisTab() {
        this.diagnosistab.click();
    }


    public void clickOndiagnosis1() {
        this.diagnosisname1.click();

    }

    public void clickOnAddDiagnosisTab() {
        this.adddiagnosis.click();
    }

    public void clickOnAddDiagnosisName() {
        this.diagnosisname.click();
    }

    public void clickOnDeleteDiagnosisName() {
        this.deletediag.click();
    }

    public void clickOnAddHccPlusBtn() {
        this.adddiagnosisbtn.click();
    }

    public void clickOnHcc(String str) {
        this.hcctab.sendKeys(str);
    }

    public void enterNonHccname(String str) {
        this.nonhccname.sendKeys(str);
    }

    public void enterPageRangeNumber(String str) {
        this.enetrpagerange.sendKeys(str);
    }

    public void selectNonHccDropdown() {
        this.selectNonHccDropdown.click();
    }

    public void clickOnHCCSaveBtn() {
        this.savehcc.click();
    }


    public void clickonIcdCode() {
        this.icdcode.click();
    }

    public void deleteDiagnosis() {
        this.deletediagnosis.click();
    }

    public void clickOnAddIcdBtn() {
        this.addicdbtn.click();
    }

    public void enterIcdNo(String str) {
        this.icd.sendKeys(str);
    }

    public void selectDescription() {
        this.description.click();
    }

    public void selectDescriptionType() {
        this.selectdescription.click();
    }


    public void selectDescriptionType1() {
        this.selectdescription1.click();
    }

    public void enterPageNumber(String str) {
        this.pageno.sendKeys(str);
    }

    public void eneterDiasesname(String str) {
        this.diasesname.sendKeys(str);
    }

    public void selectHccDropdown() {
        this.dropdownhcc.click();
    }

    public void clickOnHeaderDropdown() {
        this.commentheader.click();
    }

    public void selectComments() {
        this.selectcomment.click();
    }

    public void clickOnNonhccSave() {
        this.nonhccsave.click();
    }


    public void clickOnSave() {
        this.save.click();
    }

    public void clickOnCancel() {
        this.cancel.click();
    }

    public void enterNpiNo(String str) {
        this.npi.sendKeys(str);
    }

    public void enterDoctorName(String str) {
        this.docname.sendKeys(str);
    }

    public void clickOnSubmitButton() {
        this.submit.click();
    }

    public void clickOnSaveDraftButtonDropdown() {
        this.savedraftdropdwon.click();
    }

    public List<WebElement> getListOfDocument() {
        List<WebElement> documentlist = null;
        try {
            documentlist = driver.findElements(documenttiles);
        } catch (StaleElementReferenceException sere) {
            System.out.println("Stale Element Reference Exception");
            sere.printStackTrace();
            PageFactory.initElements(driver, this);
            documentlist = driver.findElements(documenttiles);
        }
        return documentlist;
    }


    public String getCreatedDateOfSearchedUserInGridView() {
        return driver.findElement(By.cssSelector("td.mat-column-received")).getText();//.split(" ")[1];
    }

    public String getUpdatedDateOfSearchedUserInGridView() {
        return driver.findElement(By.cssSelector("td.mat-column-updated")).getText();//.split(" ")[1];
    }


    public void selectProjectFromDropDown(int index) {
        driver.findElement(By.xpath("(//button[@role='menuitem']//span)[" + index + "]")).click();
    }

    public int getTotalICDCount() {
        return Integer.parseInt(totalICDCountValue.getAttribute("value"));
    }

    public int getTotalEncounterCountFromDiagnosisTab() {
        /*if(NoDataDefaultMessageDiagnosisTab.isDisplayed()){
            //System.out.println(NoEncountersDefaultMessage.getText());
            return 0;
        }
        else*/
        return listOfEncountersInDiagnosisTab.size();
    }

    public int getTotalICDCountFromDiagnosisTab() {
        int count = 0;
        //int k = 0;
        /*if(NoDataDefaultMessageDiagnosisTab.isDisplayed()){
            //System.out.println(NoEncountersDefaultMessage.getText());
            return 0;
        }*/

        if (listOfICDColumnsInDiagnosisTab.size() == 0) {
            System.out.println("No Diagnosis.");
        } else {
            for (int i = 0; i < listOfICDColumnsInDiagnosisTab.size(); i++) {
                /*if (listOfICDValuesInDiagnosisTab.get(i).getAttribute("style").contains("visibility: hidden")) {
                    System.out.println("<mat-row>- style attribute: "+listOfICDValuesInDiagnosisTab.get(i).getAttribute("style"));
                    System.out.println("Checking If condition: "+listOfICDValuesInDiagnosisTab.get(i).getAttribute("style").contains("visibility: hidden"));
                    continue;
                }*/
                WebElement icdColumnElement = driver.findElement(By.xpath
                        ("(//mat-cell[contains(@class,'mat-column-codes')]//span[contains(@class,'mat-select-min-line')])[" + (i + 1) + "]"));
                //String jsGetInnerText = "return argument[0].innerText";
                String ICDValues = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent", icdColumnElement);

                //.getAttribute("value");
                //.getText();
                //("(//mat-tab-body[contains(@class,'mat-tab-body-active')]//mat-row)["+(i+1)+"]//mat-cell[contains(@class,'mat-column-codes')]//span[contains(@class,'mat-select-min-line')]"))
                //listOfICDValuesInDiagnosisTab.get(i).findElement(ICDValuesInADiagnosisRecord).getText();

                System.out.println("ICD Column on UI: " + ICDValues);
                    /*String[] list = ICDValues.split(", ");
                    System.out.println(list.length);*/

                List<String> listOfICDValues = List.of(ICDValues.split(", "));
                System.out.println(listOfICDValues.size());
                System.out.println(listOfICDValues.get(0));
                count += listOfICDValues.size();
                //k++;
            }
        }
        //System.out.println("Total Diagnosis records: "+k);
        return count;
    }


}