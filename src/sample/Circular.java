package sample;

import javafx.scene.shape.Circle;

public class Circular extends Circle implements Shape{

    private double area;
    private double actualArea;

    public Circular(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
        calculateArea();
        this.getStyleClass().add("circle");
    }

    @Override
    public void calculateArea() {
        actualArea = Math.PI * (Math.pow(this.getRadius() , 2));
        area = Math.pow(this.getRadius() * 2 , 2);

    }
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getActualArea() {
        return actualArea;
    }
}
