package businessfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.WaitHelper;

public class Home extends Base {

    private WaitHelper waitUtil;
    private int explicitTimeOut;

    @FindBy(xpath = "//div[@class='jumbotron']//h1[contains(text(),'Welcome')]")
    WebElement welcomeTitle;

    @FindBy(name = "fromPort")
    WebElement departureDropDown;

    @FindBy(name = "toPort")
    WebElement destinationDropDown;

    @FindBy(xpath = "//input[@value='Find Flights']")
    WebElement findFlightsButton;

    public Home(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        waitUtil = new WaitHelper(driver);
        explicitTimeOut = waitUtil.getExplicitTimeout();
    }


    public void selectDepartureCity(String value){
        waitUtil.selectByValue(departureDropDown, value);
    }

    public void selectDesitinationCity(String value){
        waitUtil.selectByValue(destinationDropDown, value);
    }

    public void findFlights(){
        waitUtil.isElementVisible(findFlightsButton, explicitTimeOut);
        findFlightsButton.click();
    }


}

