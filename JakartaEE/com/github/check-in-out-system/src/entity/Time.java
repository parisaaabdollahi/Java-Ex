package entity;

import java.io.Serializable;

public class Time implements Serializable {
    private String employeeCode;
    private Float checkIn;
    private Float getCheckout;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public Time setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public Float getCheckIn() {
        return checkIn;
    }

    public Time setCheckIn(Float checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public Float getGetCheckout() {
        return getCheckout;
    }

    public Time setGetCheckout(Float getCheckout) {
        this.getCheckout = getCheckout;
        return this;
    }
}
