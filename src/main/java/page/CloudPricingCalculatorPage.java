package page;

import model.Calculator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.CalculatorCreator;
import service.XpathGenerator;
import java.util.ArrayList;
import static util.MethodWait.*;

import static java.lang.String.format;

public class CloudPricingCalculatorPage extends AbstractPage {

    private JavascriptExecutor executor = (JavascriptExecutor) driver;
    private Calculator calculator = CalculatorCreator.withCredentialsFromProperty();
    private XpathGenerator xpathGenerator = new XpathGenerator();
    private static final By FRAME_LOCATOR = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private static final By COMPUTER_ENGINE_BUTTON_LOCATOR = By.xpath("//md-tab-item/*[@title='Compute Engine']");
    private static final By NUMBER_OF_INSTANCE_INPUT_LOCATOR = By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']");
    private static final By SELECT_OS_LOCATOR = By.xpath("//*[@ng-model='listingCtrl.computeServer.os']/md-select-value");
    private static final By PROVISIONING_DROPDOWN_LOCATOR = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.class')]/md-select-value");
    private static final By SERIES_DROPDOWN_LOCATOR = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.series')]/md-select-value");
    private static final By MACHINE_TYPE_DROPDOWN_LOCATOR = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.instance')]/md-select-value");
    private static final By ADD_GPUS_BUTTON = By.xpath("//md-input-container//md-checkbox[@aria-label='Add GPUs']");
    private static final By GPU_TYPE_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.gpuType')]/md-select-value");
    private static final By NUMBER_OF_GPUS_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.gpuCount')]/md-select-value");
    private static final By LOCAL_SSD_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.ssd')]/md-select-value");
    private static final By DATACENTER_LOCATION_DROPDOWN = By.xpath("//*[@ng-model='listingCtrl.computeServer.location']//md-select-value");
    private static final By COMMITTED_USAGE_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.cud')]/md-select-value");
    private static final By ADD_TO_ESTIMATE_BUTTON = By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']");
    private static final By EMAIL_BUTTON = By.xpath("//button[@title='Email Estimate']");
    private static final By EMAIL_AREA = By.xpath("//input[@ng-model='emailQuote.user.email']");
    private static final By SEND_EMAIL_BUTTON = By.xpath("//button[@aria-label='Send Email']");
    private static final By PROVISIONING_MODEL_AREA = By.xpath("//div[contains(text(),'Provisioning model')]");
    private static final By INSTANCE_TYPE_AREA = By.xpath("//div[contains(text(),'Instance type:')]");
    private static final By REGION_AREA = By.xpath("//md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Region:')]");
    private static final By SSD_AREA = By.xpath("//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex'][contains(text(),'Local SSD:')]");
    private static final By TERM_AREA = By.xpath("//div[@class='md-list-item-text ng-binding'][contains(text(),'Commitment term:')]");
    private static final By TOTAL_COST_AREA = By.xpath("//b[@class='ng-binding'][contains(text(),'Total Estimated Cost:')]");

    public CloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingCalculatorPage switchToComputerEngine() {
        waitPresenceOfElementLocated(driver,FRAME_LOCATOR);
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitElementToBeClickable(driver,COMPUTER_ENGINE_BUTTON_LOCATOR).click();
        logger.info("Switching to computer engine was successful");
        return this;
    }

    public CloudPricingCalculatorPage inputNumberOfInstancesValue() {
        waitElementToBeClickable(driver,NUMBER_OF_INSTANCE_INPUT_LOCATOR).sendKeys(calculator.getNumberOfInstances());
        logger.info(String.format("Number of instances was inputted successful: %s",calculator.getNumberOfInstances()));
        return this;
    }

    public CloudPricingCalculatorPage selectOSValue() {
        waitElementToBeClickable(driver,SELECT_OS_LOCATOR).click();
        By osValueLocator = By.xpath(xpathGenerator.getXpathForOperatingSystemValue());
        WebElement osValue = waitElementToBeClickable(driver,osValueLocator);
        executor.executeScript("arguments[0].click()", osValue);
        logger.info(String.format("Setting of operating system was successful: %s",calculator.getOperatingSystem()));
        return this;
    }

    public CloudPricingCalculatorPage selectProvisioningValue() {
        waitElementToBeClickable(driver,PROVISIONING_DROPDOWN_LOCATOR).click();
        By provisionalTypeLocator = By.xpath(format(xpathGenerator.getXpathForProvisioningType()));
        WebElement provisionalType = waitPresenceOfElementLocated(driver,provisionalTypeLocator);
        executor.executeScript("arguments[0].click()", provisionalType);
        logger.info(String.format("Setting of provisioning model was successful: %s",calculator.getProvisionalType()));
        return this;
    }

    public CloudPricingCalculatorPage selectSeriesValue() {
        WebElement seriesDropDown = waitPresenceOfElementLocated(driver,SERIES_DROPDOWN_LOCATOR);
        executor.executeScript("arguments[0].click()", seriesDropDown);
        By seriesValueLocator = By.xpath(format(xpathGenerator.getXpathForMachineClass()));
        WebElement seriesValue = waitPresenceOfElementLocated(driver,seriesValueLocator);
        executor.executeScript("arguments[0].click()", seriesValue);
        logger.info(String.format("Setting of series was successful: %s",calculator.getMachineClass()));
        return this;
    }

    public CloudPricingCalculatorPage selectMachineTypeValue() {
        WebElement machineTypeDropdown = waitPresenceOfElementLocated(driver,MACHINE_TYPE_DROPDOWN_LOCATOR);
        executor.executeScript("arguments[0].click()", machineTypeDropdown);
        By machineTypeValueLocator = By.xpath(format(xpathGenerator.getXpathForMachineType()));
        WebElement machineTypeValue = waitPresenceOfElementLocated(driver,machineTypeValueLocator);
        executor.executeScript("arguments[0].click()", machineTypeValue);
        logger.info(String.format("Setting of machine type was successful: %s",calculator.getMachineType()));
        return this;
    }

    public CloudPricingCalculatorPage addGPUs() {
        WebElement addGPUsButton = waitPresenceOfElementLocated(driver,ADD_GPUS_BUTTON);
        executor.executeScript("arguments[0].click()", addGPUsButton);
        WebElement GPUTypeDropdown = waitElementToBeClickable(driver,GPU_TYPE_DROPDOWN);
        executor.executeScript("arguments[0].click()", GPUTypeDropdown);
        By GPUTypeValueLocator = By.xpath(xpathGenerator.getXpathForGpuType());
        WebElement GPUTypeValue = waitElementToBeClickable(driver,GPUTypeValueLocator);
        executor.executeScript("arguments[0].click()", GPUTypeValue);
        logger.info(String.format("Setting of GPU type was successful: %s",calculator.getGpuType()));
        WebElement numberOfGPUsDropdown = waitElementToBeClickable(driver,NUMBER_OF_GPUS_DROPDOWN);
        executor.executeScript("arguments[0].click()", numberOfGPUsDropdown);
        By numberOfGPUValueLocator = By.xpath(xpathGenerator.getXpathForNumberOfGpus());
        WebElement numberOfGPUValue = waitPresenceOfElementLocated(driver,numberOfGPUValueLocator);
        executor.executeScript("arguments[0].click()", numberOfGPUValue);
        logger.info(String.format("Setting number of GPUs was successful: %s",calculator.getNumberOfGPUs()));
        return this;
    }

    public CloudPricingCalculatorPage selectSSDValue() {
        WebElement localSSDDropdown = waitElementToBeClickable(driver,LOCAL_SSD_DROPDOWN);
        executor.executeScript("arguments[0].click()", localSSDDropdown);
        By localSSDValueLocator = By.xpath(xpathGenerator.getXpathForLocalSSD());
        WebElement localSSDValue = waitPresenceOfElementLocated(driver,localSSDValueLocator);
        executor.executeScript("arguments[0].click()", localSSDValue);
        logger.info(String.format("Setting number and value of local SSDs was successful: %s",calculator.getLocalSSD()));
        return this;
    }

    public CloudPricingCalculatorPage selectDatacenterLocation() {
        WebElement datacenterDropDown = waitPresenceOfElementLocated(driver,DATACENTER_LOCATION_DROPDOWN);
        executor.executeScript("arguments[0].click()", datacenterDropDown);
        By datacenterLocationValueLocator = By.xpath(xpathGenerator.getXpathForDatacenterLocation());
        WebElement datacenterLocationValue = waitElementToBeClickable(driver,datacenterLocationValueLocator);
        executor.executeScript("arguments[0].click()", datacenterLocationValue);
        logger.info(String.format("Setting location of datacenter was successful: %s",calculator.getDatacenterLocation()));
        return this;
    }

    public CloudPricingCalculatorPage selectCommittedUsage() {
        WebElement committedUsageDropdown = waitPresenceOfElementLocated(driver,COMMITTED_USAGE_DROPDOWN);
        executor.executeScript("arguments[0].click()", committedUsageDropdown);
        By committedUsageValueLocator = By.xpath(xpathGenerator.getXpathForCommittedUsage());
        WebElement committedUsageValue = waitPresenceOfElementLocated(driver,committedUsageValueLocator);
        executor.executeScript("arguments[0].click()", committedUsageValue);
        logger.info(String.format("Setting committed usage term was successful: %s",calculator.getCommittedUsageTerm()));
        return this;
    }

    public CloudPricingCalculatorPage pressAddToEstimateButton() {
        WebElement addToEstimateButton = waitPresenceOfElementLocated(driver,ADD_TO_ESTIMATE_BUTTON);
        executor.executeScript("arguments[0].click()", addToEstimateButton);
        logger.info("Estimate button pressed successful");
        return this;
    }

    public String getCostFromCloudPricingPage() {
        String cost = waitPresenceOfElementLocated(driver,TOTAL_COST_AREA).getText();
        String format = cost.replace("Total Estimated Cost: ","");
        String formattedCostFromCloudPricingPage = format.replace(" per 1 month","");
        logger.info(String.format("Cost from cloud pricing page successful extracted: %s", formattedCostFromCloudPricingPage));
        return formattedCostFromCloudPricingPage;
    }

    public CloudPricingCalculatorPage pressEmailEstimateButton() {
        WebElement pressEmailButton = waitPresenceOfElementLocated(driver,EMAIL_BUTTON);
        executor.executeScript("arguments[0].click()", pressEmailButton);
        logger.info("Send email button pressed successful");
        return this;
    }

    public CloudPricingCalculatorPage pasteEmail(String email) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        WebElement enterEmail = waitPresenceOfElementLocated(driver,EMAIL_AREA);
        executor.executeScript("arguments[0].click()", enterEmail);
        enterEmail.sendKeys(email);
        logger.info(String.format("Email adress copied successful: %s", email));
        return this;
    }

    public CloudPricingCalculatorPage sendEmail() {
        WebElement pressSendEmailButton = waitPresenceOfElementLocated(driver,SEND_EMAIL_BUTTON);
        executor.executeScript("arguments[0].click()", pressSendEmailButton);
        logger.info("Send email button pressed successful");
        return this;
    }

    public EmailGenerationPage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("New tab opened successful");
        return new EmailGenerationPage(driver);
    }

    public EmailGenerationPage switchToEmailPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("Web browser switched to email page successful");
        return new EmailGenerationPage(driver);
    }

    public String getProvisioningModel() {
        return waitPresenceOfElementLocated(driver, PROVISIONING_MODEL_AREA).getText();
    }

    public String getInstanceType() {
        return waitPresenceOfElementLocated(driver,INSTANCE_TYPE_AREA).getText();
    }

    public String getRegion() {
        return waitPresenceOfElementLocated(driver,REGION_AREA).getText();
    }

    public String getLocalSSDValue() {
        return waitPresenceOfElementLocated(driver,SSD_AREA).getText();
    }

    public String getTermAreaValue() {
        return waitPresenceOfElementLocated(driver,TERM_AREA).getText();
    }
}