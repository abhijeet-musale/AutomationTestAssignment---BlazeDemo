package businessfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.WaitHelper;

public class Purchase extends Base {
	private WaitHelper waitUtil;
    private int explicitTimeOut;

    @FindBy(xpath = "//descendant::h2")
    WebElement purchasePageTitle;

    @FindBy(name = "inputName")
    WebElement name;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "zipCode")
    WebElement zipCode;

    @FindBy(name = "cardType")
    WebElement cardType;

    @FindBy(name = "creditCardNumber")
    WebElement cardNumber;

    @FindBy(name = "creditCardMonth")
    WebElement month;

    @FindBy(name = "creditCardYear")
    WebElement year;

    @FindBy(name = "nameOnCard")
    WebElement cardName;

    @FindBy(name = "rememberMe")
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement purchaseFlight;

    public Purchase(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        waitUtil = new WaitHelper(driver);
        explicitTimeOut = waitUtil.getExplicitTimeout();
    }

    public void verifyPurchasePageDisplayed(){
        waitUtil.isElementVisible(purchasePageTitle, explicitTimeOut);
        purchasePageTitle.isDisplayed();
    }


    public void enterFlyerName(String value){
        waitUtil.isElementVisible(name, explicitTimeOut);
        name.clear();
        name.sendKeys(value);
    }

    public void enterFlyerAddress(String value){
        waitUtil.isElementVisible(address, explicitTimeOut);
        address.clear();
        address.sendKeys(value);
    }

    public void enterFlyerCity(String value){
        waitUtil.isElementVisible(city, explicitTimeOut);
        city.clear();
        city.sendKeys(value);
    }

    public void enterFlyerState(String value){
        waitUtil.isElementVisible(state, explicitTimeOut);
        state.clear();
        state.sendKeys(value);
    }

    public void enterFlyerZipCode(String value){
        waitUtil.isElementVisible(zipCode, explicitTimeOut);
        zipCode.clear();
        zipCode.sendKeys(value);
    }

    public void enterFlyerCardType(String value){
        waitUtil.isElementVisible(cardType, explicitTimeOut);
        waitUtil.selectByValue(cardType, value);
    }

    public void enterFlyerCardNumber(String value){
        waitUtil.isElementVisible(cardNumber, explicitTimeOut);
        cardNumber.clear();
        cardNumber.sendKeys(value);
    }

    public void enterFlyerCardMonth(String value){
        waitUtil.isElementVisible(month, explicitTimeOut);
        month.clear();
        month.sendKeys(value);
    }

    public void enterFlyerCardYear(String value){
        waitUtil.isElementVisible(year, explicitTimeOut);
        year.clear();
        year.sendKeys(value);
    }

    public void enterFlyerCardName(String value){
        waitUtil.isElementVisible(cardName, explicitTimeOut);
        cardName.clear();
        cardName.sendKeys(value);
    }

    public void enableRememberMeCheckBox(){
        waitUtil.isElementVisible(rememberMeCheckBox, explicitTimeOut);
        if(!rememberMeCheckBox.isSelected()) rememberMeCheckBox.click();
    }

    public void disableRememberMeCheckBox(){
        waitUtil.isElementVisible(rememberMeCheckBox, explicitTimeOut);
        if(rememberMeCheckBox.isSelected()) rememberMeCheckBox.click();
    }

    public void clickPurchaseFlights(){
        waitUtil.isElementVisible(purchaseFlight, explicitTimeOut);
        purchaseFlight.click();
    }
}
