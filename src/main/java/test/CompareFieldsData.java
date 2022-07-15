package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.FormatTestData;

public class CompareFieldsData extends CommonConditions{

    @Test(description = "Provisioning model check")
    public void provisioningModelTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getProvisioningModel(), FormatTestData.getMachineClassString());
    }

    @Test(description = "Instance type check")
    public void instanceTypeTest() {
        Assert.assertTrue(cloudPricingCalculatorPage.getInstanceType().contains(FormatTestData.getMachineTypeString()));
    }

    @Test(description = "Region check")
    public void regionTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getRegion(), FormatTestData.getDatacenterLocationString());
    }

    @Test(description = "Local SSD check")
    public void localSSDTest() {
        Assert.assertTrue(cloudPricingCalculatorPage.getLocalSSDValue().contains(FormatTestData.getLocalSSDString()));
    }

    @Test(description = "Commitment term check")
    public void commitmentTermTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getTermAreaValue(), FormatTestData.getCommitmentTermString());
    }
}
