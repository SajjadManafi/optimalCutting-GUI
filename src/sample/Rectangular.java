package sample;

import javafx.scene.shape.Rectangle;

public class Rectangular extends Rectangle implements Shape{

    private double area;

    public Rectangular(double width, double height) {
        super(width, height);
        calculateArea();
    }

    @Override
    public void calculateArea() {
        area = this.getHeight() * this.getWidth();
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getActualArea() {
        return area;
    }
}
