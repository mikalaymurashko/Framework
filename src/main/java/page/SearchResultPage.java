package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static util.MethodWait.*;

public class SearchResultPage extends AbstractPage {

    private By calculatorLinkLocator = By.xpath("//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CloudPricingCalculatorPage proceedToCalculatorPage(){
        waitPresenceOfElementLocated(driver,calculatorLinkLocator).click();
        logger.info("Cloud pricing calculator page was opened successful");
        return new CloudPricingCalculatorPage(driver);
    }
}
