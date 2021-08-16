package businessfunctions;

import org.openqa.selenium.WebDriver;

public abstract class Base {

    public WebDriver driver;
    
    public Base(WebDriver driver){
        this.driver = driver;
    }
}

