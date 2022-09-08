package j2os.org.domain;

public class Car {
    private long id;
    private String model;
    private String code;
    private  int inDoor;
    private int outDoor;
    private Long cost;

    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Car setCode(String code) {
        this.code = code;
        return this;
    }

    public int getInDoor() {
        return inDoor;
    }

    public Car setInDoor(int inDoor) {
        this.inDoor = inDoor;
        return this;
    }

    public int getOutDoor() {
        return outDoor;
    }

    public Car setOutDoor(int outDoor) {
        this.outDoor = outDoor;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public Car setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
