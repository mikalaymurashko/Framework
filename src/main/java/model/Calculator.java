package model;

import java.util.Objects;

public class Calculator {
    private String numberOfInstances;
    private String operatingSystem;
    private String provisionalType;
    private String machineClass;
    private String machineType;
    private String gpuType;
    private String numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsageTerm;
    private String totalCost;

    public Calculator(String numberOfInstances, String operatingSystem, String provisionalType, String machineClass,
                      String machineType, String gpuType, String numberOfGPUs, String localSSD,
                      String datacenterLocation, String committedUsageTerm, String totalCost) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.provisionalType = provisionalType;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsageTerm = committedUsageTerm;
        this.totalCost = totalCost;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisionalType() {
        return provisionalType;
    }

    public void setProvisionalType(String provisionalType) {
        this.provisionalType = provisionalType;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsageTerm() {
        return committedUsageTerm;
    }

    public void setCommittedUsageTerm(String committedUsageTerm) {
        this.committedUsageTerm = committedUsageTerm;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return numberOfInstances.equals(that.numberOfInstances)
                && operatingSystem.equals(that.operatingSystem)
                && provisionalType.equals(that.provisionalType)
                && machineClass.equals(that.machineClass)
                && machineType.equals(that.machineType)
                && gpuType.equals(that.gpuType)
                && numberOfGPUs.equals(that.numberOfGPUs)
                && localSSD.equals(that.localSSD)
                && datacenterLocation.equals(that.datacenterLocation)
                && committedUsageTerm.equals(that.committedUsageTerm)
                && totalCost.equals(that.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, provisionalType, machineClass, machineType,
                gpuType, numberOfGPUs, localSSD, datacenterLocation, committedUsageTerm, totalCost);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", provisionalType='" + provisionalType + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsageTerm='" + committedUsageTerm + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
}
