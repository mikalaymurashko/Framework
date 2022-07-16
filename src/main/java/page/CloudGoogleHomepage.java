package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static util.MethodWait.*;

public class CloudGoogleHomepage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//div[@class='devsite-searchbox']");
    private static final By SEARCH_FORM_LOCATOR = By.xpath("//input[@placeholder='Search']");

    public CloudGoogleHomepage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomepage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Home page Google Cloud was opened");
        return this;
    }

    public SearchResultPage searchElement(String searchQuery) {
        waitPresenceOfElementLocated(driver, SEARCH_BUTTON_LOCATOR).click();
        WebElement searchFrom = waitPresenceOfElementLocated(driver, SEARCH_FORM_LOCATOR);
        searchFrom.sendKeys(searchQuery);
        searchFrom.sendKeys(Keys.ENTER);
        logger.info(String.format("Search for cloud pricing calculator with search query: %s",searchQuery));
        return new SearchResultPage(driver);
    }
}
