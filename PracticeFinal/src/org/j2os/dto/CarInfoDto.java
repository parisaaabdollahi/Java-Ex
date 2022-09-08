package org.j2os.dto;

public class CarInfoDto {
    private String code;
    private long totalEntry;
    private long totalCost;

    public String getCode() {
        return code;
    }

    public CarInfoDto setCode(String code) {
        this.code = code;
        return this;
    }

    public long getTotalEntry() {
        return totalEntry;
    }

    public CarInfoDto setTotalEntry(long totalEntry) {
        this.totalEntry = totalEntry;
        return this;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public CarInfoDto setTotalCost(long totalCost) {
        this.totalCost = totalCost;
        return this;
    }
}
