package entity;

import java.io.Serializable;

public class Time implements Serializable {
    private String username;
    private Float checkIn;
    private Float getCheckout;

    public String getUsername() {
        return username;
    }

    public Time setUsername(String username) {
        this.username = username;
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
