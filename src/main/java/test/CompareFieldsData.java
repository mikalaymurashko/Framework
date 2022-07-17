package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.FormatTestData;

import static java.lang.String.format;

public class CompareFieldsData extends CommonConditions{

    @Test(description = "Provisioning model check")
    public void provisioningModelTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getProvisioningModel(), FormatTestData.getMachineClassString(),
                format("Wrong provisioning model: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getProvisioningModel(), FormatTestData.getMachineClassString()));
    }

    @Test(description = "Instance type check")
    public void instanceTypeTest() {
        Assert.assertTrue(cloudPricingCalculatorPage.getInstanceType().contains(FormatTestData.getMachineTypeString()),
                format("Wrong instance type value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getInstanceType(), FormatTestData.getMachineTypeString()));
    }

    @Test(description = "Region check")
    public void regionTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getRegion(), FormatTestData.getDatacenterLocationString(),
                format("Wrong region value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getRegion(), FormatTestData.getDatacenterLocationString()));
    }

    @Test(description = "Local SSD check")
    public void localSSDTest() {
        Assert.assertTrue(cloudPricingCalculatorPage.getLocalSSDValue().contains(FormatTestData.getLocalSSDString()),
                format("Wrong local SSD value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getLocalSSDValue(), FormatTestData.getLocalSSDString()));
    }

    @Test(description = "Commitment term check")
    public void commitmentTermTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getTermAreaValue(), FormatTestData.getCommitmentTermString(),
                format("Wrong commitment term value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getTermAreaValue(), FormatTestData.getCommitmentTermString()));
    }
    @Test(description = "Total cost check")
    public void totalCostTest() {
        Assert.assertEquals(cloudPricingCalculatorPage.getTotalCost(), FormatTestData.getTotalCostString(),
                format("Wrong total cost value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getTotalCost(), FormatTestData.getTotalCostString()));
    }
}
