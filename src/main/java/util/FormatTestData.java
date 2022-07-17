package util;

import model.Calculator;
import service.CalculatorCreator;

public class FormatTestData {
    private static final Calculator calculator = CalculatorCreator.withCredentialsFromProperty();

    public static String getDatacenterLocationString() {
        return "Region: " + calculator.getDatacenterLocation();
    }
    public static String getCommitmentTermString(){
        return "Commitment term: " + calculator.getCommittedUsageTerm();
    }
    public static String getMachineClassString() {
        return "Provisioning model: " + calculator.getProvisionalType();
    }
    public static String getMachineTypeString() {
        return "Instance type: " + calculator.getMachineType() +
                "\nCommitted Use Discount applied";
    }
    public static String getLocalSSDString() {
        return "Local SSD: " + calculator.getLocalSSD() +
                " GiB\nCommitted Use Discount applied";
    }
    public static String getTotalCostString(){
        return "Total Estimated Cost: "+calculator.getTotalCost()+" per 1 month";
    }
}
