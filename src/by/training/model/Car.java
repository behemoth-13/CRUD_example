package by.training.model;

public class Car {
    private int id;
    private String model;
    private int maxSpeed;
    private float consumptionPer100Km;
    private int volTank;

    public Car() {
    }

    public Car(String model, int maxSpeed, float consumptionPer100Km, int volTank) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.consumptionPer100Km = consumptionPer100Km;
        this.volTank = volTank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getConsumptionPer100Km() {
        return consumptionPer100Km;
    }

    public void setConsumptionPer100Km(float consumptionPer100Km) {
        this.consumptionPer100Km = consumptionPer100Km;
    }

    public int getVolTank() {
        return volTank;
    }

    public void setVolTank(int volTank) {
        this.volTank = volTank;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", consumptionPer100Km=" + consumptionPer100Km +
                ", volTank=" + volTank +
                '}';
    }
}
