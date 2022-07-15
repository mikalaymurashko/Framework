package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;
    protected Logger logger;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        logger = LogManager.getRootLogger();
    }
}
