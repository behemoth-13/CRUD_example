package by.training.controller;

import by.training.model.Car;

import javax.servlet.http.HttpServletRequest;

class CarValidator {
    private static CarValidator instance = new CarValidator();

    private CarValidator(){}

    static CarValidator getInstance() {
        return instance;
    }

    Car getValidCar(HttpServletRequest request) {
        Car car = null;
        String model = request.getParameter("model").trim();
        String maxSpeed = request.getParameter("maxSpeed").trim();
        String consumption = request.getParameter("cons").trim();
        String volTank = request.getParameter("volTank").trim();
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
            float cons = Float.parseFloat(consumption);
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
        if (errors.isEmpty()) {
            car = new Car();
            car.setModel(model);
            car.setMaxSpeed(Integer.parseInt(maxSpeed));
            car.setConsumptionPer100Km(Float.parseFloat(consumption));
            car.setVolTank(Integer.parseInt(volTank));
        } else {
            request.setAttribute("errors", errors);
        }
        return car;
    }

    int getValidId(HttpServletRequest request) {
        String strId = request.getParameter("id");
        int volume;
        try {
            volume = Integer.parseInt(strId);
        } catch (NumberFormatException e) {
            request.setAttribute("errors", "Please try again");
            volume = -1;
        }
        return volume;
    }
}
