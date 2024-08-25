package io.orangetech.cars;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class CarRequest {
    private Long id;
    private String type;
    private String model;
    private String colour;
    private int year;


    public CarRequest(
            String type,
            String model,
            String colour,
            int year

    ){
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.year = year;

    }

    public CarRequest(){};

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
