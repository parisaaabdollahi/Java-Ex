package org.j2os.entity;

public class CarInfo {
    private long id;
    private String model;
    private String code;
    private int indoor;
    private int outdoor;
    private long cost;

    public long getId() {
        return id;
    }

    public CarInfo setId(long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarInfo setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CarInfo setCode(String code) {
        this.code = code;
        return this;
    }

    public int getIndoor() {
        return indoor;
    }

    public CarInfo setIndoor(int indoor) {
        this.indoor = indoor;
        return this;
    }

    public int getOutdoor() {
        return outdoor;
    }

    public CarInfo setOutdoor(int outdoor) {
        this.outdoor = outdoor;
        return this;
    }

    public long getCost() {
        return cost;
    }

    public CarInfo setCost(long cost) {
        this.cost = cost;
        return this;
    }

    public CarInfo(String model, String code, int indoor, int outdoor) {
        this.model = model;
        this.code = code;
        this.indoor = indoor;
        this.outdoor = outdoor;
    }

    public CarInfo(String model, String code, int indoor, int outdoor, long cost) {
        this.model = model;
        this.code = code;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.cost = cost;
    }

    public CarInfo(long id, String model, String code, int indoor, int outdoor, long cost) {
        this.id = id;
        this.model = model;
        this.code = code;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.cost = cost;
    }

    public CarInfo() {
    }



}
