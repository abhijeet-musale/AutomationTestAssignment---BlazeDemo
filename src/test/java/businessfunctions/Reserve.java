package businessfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.WaitHelper;

public class Reserve extends Base {

    private WaitHelper waitUtil;
    private int explicitTimeOut;

    @FindBy(xpath = "/descendant::h3")
    WebElement reservePageTitle;

    @FindBy(xpath = "/descendant::input[@type='submit'][3]")
    WebElement lowestPrice;

    public Reserve(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        waitUtil = new WaitHelper(driver);
        explicitTimeOut = waitUtil.getExplicitTimeout();
    }

    public void flyLowCostAirLine(){
        waitUtil.isElementVisible(lowestPrice, explicitTimeOut);
        lowestPrice.click();
    }

    public void verifyReservePageDisplayed(){
        waitUtil.isElementVisible(reservePageTitle, explicitTimeOut);
        reservePageTitle.isDisplayed();
    }

}
