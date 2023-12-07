package model;

import model.Engine;
import model.Movable;

import java.awt.*;

public interface Vehicle extends Movable, Engine {

    void setX(double x);

    void setY(double y);

    int getNrDoors();

    Color getColor();

    void setColor(Color clr);

    String getModelName();
}
