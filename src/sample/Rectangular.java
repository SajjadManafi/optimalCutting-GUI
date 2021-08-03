package sample;

import javafx.scene.shape.Rectangle;

public class Rectangular extends Rectangle implements Shape{

    private double area;

    public Rectangular(double width, double height) {
        super(width / Config.config.getCoefficient(), height / Config.config.getCoefficient());
        calculateArea();
        this.getStyleClass().add("rectangle");
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

    @Override
    public double getShapeWidth() {
        return this.getWidth();
    }

    @Override
    public double getShapeHeight() {
        return this.getHeight();
    }

    @Override
    public double getShapeX() {
        return this.getX();
    }

    @Override
    public double getShapeY() {
        return this.getY();
    }

    @Override
    public void setShapeWidth(double width) {
        this.setWidth(width);
    }

    @Override
    public void setShapeHeight(double height) {
        this.setHeight(height);
    }

    @Override
    public void setShapeX(double x) {
        this.setX(x);
    }

    @Override
    public void setShapeY(double y) {
        this.setY(y);
    }

}