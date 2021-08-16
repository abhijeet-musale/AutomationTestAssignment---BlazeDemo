package businessfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class Confirmation extends Base {

	private WaitHelper waitUtil;
	private int explicitTimeOut;

	public Confirmation(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		waitUtil = new WaitHelper(driver);
		explicitTimeOut = waitUtil.getExplicitTimeout();
	}

	@FindBy(xpath = "/descendant::h1")
	WebElement confirmationPageTitle;


	public boolean verifyConfirmationPageDisplayed(){

		waitUtil.isElementVisible(confirmationPageTitle, explicitTimeOut);
		return confirmationPageTitle.isDisplayed();
	}
}
