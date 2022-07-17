package service;

import model.Calculator;

public class XpathGenerator {
    private Calculator calculator = CalculatorCreator.withCredentialsFromProperty();

    public String getXpathForOperatingSystemValue() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option", calculator.getOperatingSystem());
    }

    public String getXpathForProvisioningType() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option",
                calculator.getProvisionalType());
    }

    public String getXpathForMachineClass() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option",
                calculator.getMachineClass());
    }

    public String getXpathForMachineType() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option", calculator.getMachineType());
    }

    public String getXpathForGpuType() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option", calculator.getGpuType());
    }

    public String getXpathForNumberOfGpus() {
        return String.format("//*[contains(@ng-repeat,'listingCtrl.computeServer.gpuType') and @value='%s']", calculator.getNumberOfGPUs());
    }

    public String getXpathForLocalSSD() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option", calculator.getLocalSSD());
    }

    public String getXpathForDatacenterLocation() {
        return String.format("//div[contains(text(),'%s')]/parent::md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']",
                calculator.getDatacenterLocation());
    }

    public String getXpathForCommittedUsage() {
        return String.format("//div[@class='md-select-menu-container md-active md-clickable']/descendant::div[contains(text(),'%s')]/parent::md-option",
                calculator.getCommittedUsageTerm());
    }
}
