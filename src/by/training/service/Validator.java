package by.training.service;

public class Validator {
    private static Validator instance = new Validator();

    private Validator(){}

    public static Validator getInstance() {
        return instance;
    }

    public String validate(String model, String maxSpeed, String consumptionPer100Km, String volTank){
        String errors = "";
        if (model.length() < 1 || model.length() > 32) {
            errors += "Length of model must be greater than 0 symbol and less than 33.\n";
        }
        try {
            int speed = Integer.parseInt(maxSpeed);
            if (speed < 0 || speed > 1000) {
                errors += "Speed can't be negative or greater than 1000 km/h.\n";
            }
        } catch (NumberFormatException e) {
            errors += "Speed is not a number.\n";
        }
        try {
            float cons = Float.parseFloat(consumptionPer100Km);
            if (cons < 0 || cons > 200) {
                errors += "Consumption can't be negative or greater than 200 l/100 km.\n";
            }
        } catch (NumberFormatException e) {
            errors += "Consumption is not a number.\n";
        }
        try {
            int volume = Integer.parseInt(volTank);
            if (volume < 0 || volume > 1000) {
                errors += "Volume of tank can't be negative or greater than 1000 l.\n";
            }
        } catch (NumberFormatException e) {
            errors += "Volume of tank is not a number.\n";
        }
        return errors;
    }
}
