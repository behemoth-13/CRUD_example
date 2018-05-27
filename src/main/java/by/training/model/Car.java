package by.training.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn( name = "owner_id" )
    private Owner owner;

    private String model;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "consumption")
    private float consumptionPer100Km;

    @Column(name = "volume_tank")
    private int volTank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
