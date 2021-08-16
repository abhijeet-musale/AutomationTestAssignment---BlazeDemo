package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {

    private WebDriver driver;

    public Driver(WebDriver driver){
        this.driver = driver;
    }

    public void navigatePage(String url) {
        driver.get(url);
    }}
