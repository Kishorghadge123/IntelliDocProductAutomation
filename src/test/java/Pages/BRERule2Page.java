package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BRERule2Page {

    WebDriver driver;

    public BRERule2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[contains(@src,'Projects.svg')]")
    WebElement projectbtn;

    public void clickOnProjectPage() {
        this.projectbtn.click();
    }

    @FindBy(xpath = "(//mat-icon[contains(text(),'list')])[1]")
    WebElement listview;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchbar;
    @FindBy(xpath = "//mat-icon[contains(text(),'create')]")
    public WebElement searchedproject1;

    public void searchCreatedProject(String str) throws Exception {
        this.listview.click();
        Thread.sleep(2000);
        this.searchbar.sendKeys(str);
        Thread.sleep(1000);
        this.searchedproject1.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Next')]")
    public WebElement nextbtn;

    public void clickonnextbutton() {
        this.nextbtn.click();
    }

    @FindBy(xpath = "(//span[contains(text(),'Next')])[2]")
    public WebElement dataNextBtn;

    public void clickOndatanextBtn() {
        this.dataNextBtn.click();
    }

    @FindBy(xpath = "//mat-icon[contains(text(),'menu')]")
    public WebElement threeLineLogoBtn;

    public void clickOnthreeLineLogoBtn() {
        this.threeLineLogoBtn.click();
    }

    @FindBy(xpath = "(//mat-icon[contains(text(),' keyboard_arrow_down ')])[9]")
    public WebElement attributeDropDown;

    public void clickOnattributeDropDown() {
        this.attributeDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Datasets')]")
    public WebElement dataSetDropDown;

    public void clickOnDataSetDropDown() {
        this.dataSetDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Add Dataset ')]")
    public WebElement addDataSetBtn;

    public void clickOnAddDataSetBtn() {
        this.addDataSetBtn.click();
    }

    @FindBy(xpath = "(//button[@role='menuitem'])[1]")
    public WebElement selectDataSetOpn;

    public void clickOnDatasetOpn() {
        this.selectDataSetOpn.click();
    }

    @FindBy(xpath = "(//button[@role='menuitem'])[2]")
    public WebElement selectSubdatasetOpn;

    public void clickOnSubdataSetOpn() {
        this.selectSubdatasetOpn.click();
    }

    @FindBy(xpath = "(//span[contains(text(),'Datasets')])[2]")
    public WebElement selectRuleDataset;

    public void clickRuledataset() {
        this.selectRuleDataset.click();
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchDatasetOpn;

    public void clickSearchDataset(String str) {
        this.searchDatasetOpn.sendKeys(str);
    }

    @FindBy(xpath = "//span[contains(text(),' Variables')]")
    public WebElement variableDropDown;

    public void clickVariableDropDown() {
        this.variableDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Add Variable ')]")
    public WebElement addVariableBtn;

    public void clickAddvariableBtn() {
        this.addVariableBtn.click();
    }

    @FindBy(xpath = "//input[@id='variableName']")
    public WebElement variableName;

    public void enterVariableName(String str) {
        this.variableName.sendKeys(str);
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[7]")
    public WebElement validationType;

    public void selectValidationType() {
        this.validationType.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Age ')]")
    public WebElement selectAge;

    public void selectAgeOpn() {
        this.selectAge.click();
    }

    @FindBy(xpath = "//input[@id='VariableValue']")
    public WebElement VariableValue;

    public void enterVariableValue(String str) {
        this.VariableValue.sendKeys(str);
    }

    @FindBy(xpath = "(//span[contains(text(),'Add')])[5]")
    public WebElement addOpn;

    public void clickOnAddopn() {
        this.addOpn.click();
    }

    @FindBy(xpath = "(//span[contains(text(),'Variables')])[2]")
    public WebElement ruleVariableOpn;

    public void clickOnRuleVariableOpn() {
        this.ruleVariableOpn.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Rules ')]")
    public WebElement addRules;

    public void clickOnAddRules() {
        this.addRules.click();
    }

    @FindBy(xpath = "(//mat-icon[contains(text(),' add_circle_outline ')])[2]")
    public WebElement plusBtnRule;

    public void clickOnplusBtnRule() {
        this.plusBtnRule.click();
    }

    @FindBy(xpath = "(//span[@class='rulesetVisibilityIcon px-3 bgcolor2'])[2]")
    public WebElement deleteRoleBtn;

    public void clickOnDeleteRuleBtn() {
        this.deleteRoleBtn.click();
    }

    @FindBy(xpath = "//mat-icon[contains(text(),'visibility')]")
    public WebElement ruleVisiblity;

    public void clickOnRuleVisiblity() {
        this.ruleVisiblity.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Matches Rule ')]")
    public WebElement matchRuleBox;

    public void clickOnMatchRuleBox() {
        this.matchRuleBox.click();
    }

    @FindBy(xpath = "//input[@data-placeholder='value']")
    public WebElement valueofCondition;

    public void enterValueOfCondition(String str) {
        this.valueofCondition.sendKeys(str);
    }

    @FindBy(xpath = "//span[contains(text(),' F ')]")
    public WebElement matchRuleF;

    public void clickOnRuleF() {
        this.matchRuleF.click();
    }

    @FindBy(xpath = "//input[@data-placeholder='Enter name of Condition / Action']")
    public WebElement actionCondtionTextbox;

    public void clickOnActionConditionTextBox(String str) {
        this.actionCondtionTextbox.sendKeys(str);
    }

    @FindBy(xpath = "//span[contains(text(),'Add Condition')]")
    public WebElement addCondition;


    public void clickAddCondition() {
        this.addCondition.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Add Action')]")
    public WebElement addAction;

    public void clickOnAddAction() {
        this.addAction.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Save ')]")
    public WebElement saveCondition;

    public void clickOnSaveCondition() {
        this.saveCondition.click();
    }

    @FindBy(xpath = "//div[@class='opacity7 font-12 conditionCardHeading']")
    public WebElement conditionBox;

    public void clickOnConditionBox() {
        this.conditionBox.click();
    }

    @FindBy(xpath = "//mat-icon[contains(text(),'edit')]")
    public WebElement conditionEditBtn;

    public void clickOnConditionEditBtn() {
        this.conditionEditBtn.click();
    }

    @FindBy(xpath = "//div[@class='py-1 d-flex align-items-center']")
    public WebElement enterConditionName;

    public void clickEnterConditionName(String str) {
        // this.enterConditionName.clear();
        this.enterConditionName.sendKeys(str);
    }

    @FindBy(xpath = "(//span[contains(text(),'Matches Rule')])[1]")
    public WebElement clearConditionBox;

    public void clearConditionBox() {
        this.clearConditionBox.clear();
    }

    @FindBy(xpath = "//span[contains(text(),'Attribute / Variable')]")
    public WebElement attributeDropDowns;

    public void clickOnAttributeDropDown() {
        this.attributeDropDowns.click();
    }

    @FindBy(xpath = "(//mat-option[@role='option'])[2]")
    public WebElement attributeOption;

    public void selectAttributeOption() {
        this.attributeOption.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Operator')]")
    public WebElement operatorDropDown;

    public void clickOnOperatorDropDown() {
        this.operatorDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' == ')]")
    public WebElement operatorOption;

    public void clickOnOperatorOption() {
        this.operatorOption.click();
    }

    @FindBy(xpath = "//input[@data-placeholder='value']")
    public WebElement enterValue;

    public void clickOnEnterValue(String str) {
        this.enterValue.sendKeys(str);
    }

    @FindBy(xpath = "//span[contains(text(),'AND')]")
    public WebElement ANDBtn;

    public void clickOnAndBtn() {
        this.ANDBtn.click();
    }

    @FindBy(xpath = "(//mat-option[@role='option'])[2]")
    public WebElement attributeOption1;

    public void clickOnAttributeOption1() {
        this.attributeOption1.click();
    }

    @FindBy(xpath = "//span[contains(text(),' $regex ')]")
    public WebElement operatoroption1;

    public void clickOperatorOption1() {
        this.operatoroption1.click();
    }

    @FindBy(xpath = "//span[contains(text(),'OR')]")
    public WebElement ORBtn;

    public void clickOnORBtn() {
        this.ORBtn.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Exists In ')]")
    public WebElement DatasetOperatorOpn;

    public void clickOnDatasetOperatorOpn() {
        this.DatasetOperatorOpn.click();
    }

    @FindBy(xpath = "//span[contains(text(),'dataset')]")
    public WebElement datasetDropDown;

    public void clickOnDatasetOperator() {
        this.datasetDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' omtest - OmDoc ')]")
    public WebElement datasetOption;

    public void clickOnDatasetOption() {
        this.datasetOption.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Dataset Header')]")
    public WebElement datasetHeaderDropDown;

    public void clickOnDatasetHeaderDropDown() {
        this.datasetHeaderDropDown.click();
    }

    @FindBy(xpath = "(//mat-option[@role='option'])[2]")
    public WebElement selectDatasetHeaderOption;

    public void clickOnDatasetHeaderOption() {
        this.selectDatasetHeaderOption.click();

    }

    @FindBy(xpath = "//mat-icon[contains(text(),' add_circle_outline ')]")
    public WebElement plusBtnRule1;

    public void clickOnPlusBtnRule1() {
        this.plusBtnRule1.click();
    }

    @FindBy(xpath = "(//input[@data-placeholder='value'])[2]")
    public WebElement enterValue2;

    public void clickOnEnterValue2(String Str) {
        this.enterValue2.sendKeys(Str);
    }

    //+button for freeform
    @FindBy(xpath = "(//mat-icon[contains(text(),' add_circle_outline ')])[2]")
    public WebElement PlusBtnRule2;

    public void clickOnPlusBtnRule2() {
        this.PlusBtnRule2.click();
    }

    @FindBy(xpath = "(//span[contains(text(),'Entity')])[3]")
    public WebElement entityDropDown;

    public void clickOnEntityDropDown() {
        this.entityDropDown.click();
    }

    @FindBy(xpath = "(//mat-option[@role='option'])[2]")
    public WebElement entityOpn1;

    public void clickOnEntityOpn1() {
        this.entityOpn1.click();
    }

    @FindBy(xpath = "(//span[@class='filter_icon'])[1]")
    public WebElement trueBtn;

    @FindBy(xpath = "(//span[contains(text(),'omtest ')])[1]//following::button[17]")
    public WebElement falseblck;

    public void clickOnTrueBtn() {
        this.trueBtn.click();
    }

    public void clickOnFalseeBtn() {
        this.falseblck.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Set Variable')]")
    public WebElement ActionTypeDropDown;

    public void clickOnActionTypeDropDown() {
        this.ActionTypeDropDown.click();
    }

    @FindBy(xpath = "//div[@id='mat-select-value-29']")
    public WebElement variablesDropDown;

    public void clickOnVariableDropDown() {
        this.variablesDropDown.click();
    }

    @FindBy(xpath = "(//mat-option[@role='option'])[1]")
    public WebElement variablesOpn;

    public void clickOnVariablesOpn() {
        this.variablesOpn.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Set Attribute ')]")
    public WebElement setAttributes;

    public void clickOnSetAttributes() {
        this.setAttributes.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[16]")
    public WebElement sourceDropDown;

    public void clickOnSourceDropDown() {
        this.sourceDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' Manually ')]")
    public WebElement selectManuallyOpn;

    public void clickOnManuallyOpn() {
        this.selectManuallyOpn.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[17]")
    public WebElement attributesDropDown;

    public void clickOnAttributeDropDownOpn() {
        this.attributesDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),'ContactNo')]")
    public WebElement selectContactNoAttribute;

    public void clickOnContactAttributeOpn() {
        this.selectContactNoAttribute.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement attributeValue;

    public void enterAttributeValue(String str) {
        this.attributeValue.sendKeys(str);
    }

    @FindBy(xpath = "//span[contains(text(),' Update ')]")
    public WebElement updateBtn;

    public void clickOnUpdateBtn() {
        this.updateBtn.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[18]")
    public WebElement attributeSubOpn;

    public void clickOnAttributeSubOpn() {
        this.attributeSubOpn.click();
    }

    @FindBy(xpath = "//span[contains(text(),' StudentName ')]")
    public WebElement selectStudentName;

    public void clickOnStudentName() {
        this.selectStudentName.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[19]")
    public WebElement operatorSubDropDown;

    public void clickOnOperatorSubDropDown() {
        this.operatorSubDropDown.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement attributeSubValue;

    public void enterAttributeSubValue(String str) {
        this.attributeValue.sendKeys(str);
    }

    //This xpath goes to Document Module page
    @FindBy(xpath = "//mat-label[contains(text(),'Data')]")
    public WebElement dataDropDown;

    public void clickOnDataDropDown() {
        this.dataDropDown.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement studentNametextbox;

    public void enterStudentName(String str) {
        this.studentNametextbox.sendKeys(str);
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[17]")
    public WebElement sourceDataSet;

    public void clickOnDatasetSourceDropDown() {
        this.sourceDataSet.click();

    }

    @FindBy(xpath = "(//span[contains(text(),' Dataset ')])[2]")
    public WebElement sourceDatasetOpn;

    public void clickOnsourceDataSetOpn() {
        this.sourceDatasetOpn.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[18]")
    public WebElement DatasetAttributeDropDown;

    public void clickOnDatasetAttributeDropDown() {
        this.DatasetAttributeDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' DOB ')]")
    public WebElement selectDOBOpn;

    public void clickOnDOBOpn() {
        this.selectDOBOpn.click();
    }

    @FindBy(xpath = "(//mat-form-field[@appearance='outline'])[21]")
    public WebElement selectDataSetDropDown;

    public void clickOnselectDataSetDropDown() {
        this.selectDataSetDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),' QAAutomation - Data1  ')]")
    public WebElement selectDataSet;

    public void clickOnDataSetOpn() {
        this.selectDataSet.click();
    }

    @FindBy(xpath = "(//mat-form-field[@appearance='outline'])[22]")
    public WebElement selectFieldDropDown;

    public void clickOnFieldDropDow() {
        this.selectFieldDropDown.click();
    }
    // We Have to select DOB DropDown

    @FindBy(xpath = "(//span[contains(text(),'Attribute')])[4]")
    public WebElement selectAttributeField;

    public void clickOnAttributeField() {
        this.selectAttributeField.click();
    }
    // Have to select DOB DropDown

    @FindBy(xpath = "(//mat-form-field[@appearance='outline'])[24]")
    public WebElement OperatorField;

    public void selectOperatorFiled() {
        this.OperatorField.click();
    }
    //We have to select Variable OPn as Operator Opn

    @FindBy(xpath = "(//mat-form-field[@appearance='outline'])[25]")
    public WebElement FieldOpn;

    public void clickOnFieldOpn() {
        this.FieldOpn.click();
    }
    //  select DOB DropDown

    @FindBy(xpath = "//span[contains(text(),'Set BRE Status')]")
    public WebElement setBREStatus;

    public void clickOnSetBREStatus() {
        this.setBREStatus.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement inputBREValue;

    public void EnterBREValue(String Str) {
        this.inputBREValue.sendKeys(Str);
    }

    @FindBy(xpath = "//span[contains(text(),'Set Document Status')]")
    public WebElement setDocumentStatus;

    public void clickOnDocumentStatus() {
        this.setDocumentStatus.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[16]")
    public WebElement setdocumentAttribute;

    public void clickOnDocumentAttribute() {
        this.setdocumentAttribute.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[17]")
    public WebElement DocumentValueDropDown;

    public void clickOnDocumentValueDropDown() {
        this.DocumentValueDropDown.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Rejected')]")
    public WebElement valueOption;

    public void clickOnValueOption() {
        this.valueOption.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Send Email')]")
    public WebElement SendEmailOpn;

    public void ClickOnSendEmailOpn() {
        this.SendEmailOpn.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement emailTo;

    public void EnterToEmail(String Str) {
        this.emailTo.sendKeys(Str);
    }

    @FindBy(xpath = "(//input[@role='combobox'])[2]")
    public WebElement emailCC;

    public void EnterCCEmail(String Str1) {
        this.emailTo.sendKeys(Str1);
    }

    @FindBy(xpath = "//input[@class='mat-input-element mat-form-field-autofill-control ng-tns-c97-82 ng-untouched ng-pristine ng-valid cdk-text-field-autofill-monitored']")
    public WebElement emailSubject;

    public void EnterSubjectEmail(String Str2) {
        this.emailTo.sendKeys(Str2);
    }

    @FindBy(xpath = "//input[@class='mat-input-element mat-form-field-autofill-control ng-tns-c97-83 ng-pristine ng-valid cdk-text-field-autofill-monitored ng-touched']")
    public WebElement emailCompose;

    public void EnterComposeMail(String Str3) {
        this.emailTo.sendKeys(Str3);
    }

    @FindBy(xpath = "//span[contains(text(),'Replace String')]")
    public WebElement replaceString;

    public void clickOnReplaceStringOpn() {
        this.replaceString.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[16]")
    public WebElement attributeReplaceString;

    public void clickOnAttributeStringDropDown() {
        this.attributeReplaceString.click();
    }

    @FindBy(xpath = "//span[contains(text(),'email')]")
    public WebElement EmailOpn;

    public void clickOnEmailOpn() {
        this.EmailOpn.click();
    }

    @FindBy(xpath = "(//mat-select[@role='combobox'])[17]")
    public WebElement ReplaceStringOperator;

    public void clickOnReplaceStringOperator() {
        this.ReplaceStringOperator.click();
    }

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement replaceName;

    public void EnterReplaceName(String Str5) {
        this.replaceName.sendKeys(Str5);
    }

    @FindBy(xpath = "(//input[@type='text'])[5]")
    public WebElement withName;

    public void enterWithReplaceName(String Str6) {
        this.withName.sendKeys(Str6);
    }
}

