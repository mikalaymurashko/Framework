package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ComparePriceTest extends CommonConditions{
    private String costFromEmail;

    @BeforeClass(description = "Algorithm of methods")
    public void getCostFromEmail() throws InterruptedException {
        emailPage = cloudPricingCalculatorPage.pressEmailEstimateButton()
                .openNewTab()
                .openEmailGenerationPage("https://yopmail.com/")
                .pressGenerateRandomEmailButton();
        String email = emailPage.copyEmail();
        emailPage.switchToCalculatorPage()
                .pasteEmail(email)
                .sendEmail()
                .switchToEmailPage();
        Thread.sleep(3000);
       costFromEmail= emailPage.openEmail()
                .refreshEmailBox()
                .getEstimatedCostFromEmail();
    }

    @Test(description = "Total price comparison from website and email")
    public void priceOnCloudGooglePageEqualEmailedPrice() {
        Assert.assertEquals(costFromGoogleCloudPricingPage,costFromEmail,"Total cost is not equal");
    }
}
