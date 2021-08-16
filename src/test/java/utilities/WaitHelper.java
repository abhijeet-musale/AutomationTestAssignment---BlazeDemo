package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public int getExplicitTimeout() {
        return 20;
    }

    public int getImplicitTimeout() {
        return 20;
    }

    public int getPollTime() {
        return 10;
    }

    public Boolean isElementVisible(WebElement element, final long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (ElementNotVisibleException e) {
        
        }
        return false;
    }

    public Boolean isElementsListVisible(List<WebElement> elements, final long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;
        } catch (ElementNotVisibleException e) {
                }
        return false;
    }
    
    public void selectByValue(WebElement dropDownWebElement, String value) {
        Select select = new Select(dropDownWebElement);
        select.selectByValue(value);
    }
    
    public void setSleepTimeOut(final long sleepWait) {
        try {
            Thread.sleep(sleepWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep(Integer timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException ignored) {
        }
    }

    public void setImplicitTimeOut(final long implicitWait) {
        try {
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


}
