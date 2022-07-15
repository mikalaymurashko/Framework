package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import static util.MethodWait.*;

public class EmailGenerationPage extends AbstractPage {

    private JavascriptExecutor executor = (JavascriptExecutor) driver;
    private static final By FRAME_LOCATOR = By.xpath("//iframe[@id='ifmail']");
    private static final By GENERATE_RANDOM_EMAIL_BUTTON = By.xpath("//b[contains (text(),'Случайный адрес электронной почты')]");
    private static final By RANDOM_EMAIL = By.xpath("//div[@id='egen']");
    private static final By OPEN_EMAIL_GENERATED = By.xpath("//button[@onclick='egengo();']");
    private static final By REFRESH_EMAIL_BOX = By.xpath("//button[@id='refresh']");
    private static final By ESTIMATED_COST_FROM_EMAIL_ = By.xpath("//td//h3[contains (text(),'USD')]");

    public EmailGenerationPage openEmailGenerationPage(String emailPage){
        driver.get(emailPage);
        logger.info("Email generation page opened successful");
        return this;
    }

    public EmailGenerationPage pressGenerateRandomEmailButton() {
        WebElement generateRandomEmailButton = waitPresenceOfElementLocated(driver,GENERATE_RANDOM_EMAIL_BUTTON);
        executor.executeScript("arguments[0].click()", generateRandomEmailButton);
        logger.info("Generate random email button pressed successful");
        return this;
    }

    public String copyEmail() {
        String email = waitPresenceOfElementLocated(driver,RANDOM_EMAIL).getText();
        logger.info(String.format("Random email generated and copied successful: %s",email));
        return email;
    }

    public CloudPricingCalculatorPage switchToCalculatorPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        logger.info("Web browser switched to calculator page successful");
        return new CloudPricingCalculatorPage(driver);
    }

    public EmailGenerationPage openEmail() {
        WebElement openEmailButton = waitPresenceOfElementLocated(driver,OPEN_EMAIL_GENERATED);
        executor.executeScript("arguments[0].click()", openEmailButton);
        logger.info("Email box opened successful");
        return this;
    }

    public EmailGenerationPage refreshEmailBox() {
        WebElement refreshEmailButton = waitPresenceOfElementLocated(driver,REFRESH_EMAIL_BOX);
        executor.executeScript("arguments[0].click()", refreshEmailButton);
        logger.info("Email box page refreshed successful");
        return this;
    }

    public String getEstimatedCostFromEmail() {
        waitPresenceOfElementLocated(driver,FRAME_LOCATOR);
        driver.switchTo().frame("ifmail");
        WebElement estimatedCostFromEmail = waitPresenceOfElementLocated(driver,ESTIMATED_COST_FROM_EMAIL_);
        logger.info(String.format("Cost from email successful extracted: %s", estimatedCostFromEmail.getText()));
        return estimatedCostFromEmail.getText();
    }

    public EmailGenerationPage(WebDriver driver) {
        super(driver);
    }
}
