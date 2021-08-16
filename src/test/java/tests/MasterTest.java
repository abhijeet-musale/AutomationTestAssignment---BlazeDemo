package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class MasterTest {

    public static WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public void launchBrowser(String browserName){
        try {            
        	if(browserName.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browserName.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
        }catch (WebDriverException e){
            System.out.println(e.getMessage());
        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
