package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circular extends Circle implements Shape{
    private Node fit = null;
    private double area;
    private double actualArea;

    public Circular(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius / Config.config.getCoefficient());
        calculateArea();
//        this.getStyleClass().add("circle");
//        this.setStroke(Color.DARKBLUE);
        this.setFill(Color.color(Math.random(), Math.random(), Math.random()));
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

    @Override
    public double getShapeWidth() {
        return this.getRadius()*2;
    }

    @Override
    public double getShapeHeight() {
        return this.getRadius()*2;
    }

    @Override
    public double getShapeX() {
        return this.getCenterX() - this.getRadius();
    }

    @Override
    public double getShapeY() {
        return this.getCenterY() - this.getRadius();
    }

    @Override
    public void setShapeWidth(double width) {
        this.setRadius(width/2);
    }

    @Override
    public void setShapeHeight(double height) {
        this.setRadius(height/2);
    }

    @Override
    public void setShapeX(double x) {
        this.setCenterX(x + this.getRadius());
    }

    @Override
    public void setShapeY(double y) {
        this.setCenterY(y + this.getRadius());
    }

    @Override
    public void setFit(Node node) {
        this.fit = node;
    }

    @Override
    public Node getFit() {
        return fit;
    }
}
