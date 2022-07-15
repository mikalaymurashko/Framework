package test;

import driver.DriverSingleton;
import org.testng.annotations.Listeners;
import page.CloudGoogleHomepage;
import page.CloudPricingCalculatorPage;
import page.EmailGenerationPage;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected CloudPricingCalculatorPage cloudPricingCalculatorPage;
    protected EmailGenerationPage emailPage;
    protected String costFromGoogleCloudPricingPage;

    @BeforeClass(description = "Setup browser")
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @BeforeClass(description = "Algorithm of methods")
    public void getCalculatorResult() {
        CloudGoogleHomepage cloudGoogleHomepage = new CloudGoogleHomepage(driver);
        cloudPricingCalculatorPage = cloudGoogleHomepage.openPage()
                .searchElement("google cloud platform pricing calculator")
                .proceedToCalculatorPage()
                .switchToComputerEngine()
                .inputNumberOfInstancesValue()
                .selectOSValue()
                .selectProvisioningValue()
                .selectSeriesValue()
                .selectMachineTypeValue()
                .addGPUs()
                .selectSSDValue()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .pressAddToEstimateButton();
        costFromGoogleCloudPricingPage = cloudPricingCalculatorPage.getCostFromCloudPricingPage();
    }

//    @AfterClass(description = "Browser closing", alwaysRun = true)
//    public void browserClose() {
//        DriverSingleton.closeDriver();
//    }
}
