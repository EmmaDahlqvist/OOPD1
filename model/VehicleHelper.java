package model;

import java.awt.*;

public class VehicleHelper{
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    protected VehicleHelper(int nrDoors, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected String getModelName() {
        return modelName;
    }


    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }


}
