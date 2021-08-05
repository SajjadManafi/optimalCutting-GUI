package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangular extends Rectangle implements Shape{
    private Node fit = null;
    private double area;
    private double wid;
    private double hei;

    public Rectangular(double width, double height) {
        super(width / Config.config.getCoefficient(), height / Config.config.getCoefficient());
        calculateArea();
        this.wid = width;
        this.hei = height;
//        this.getStyleClass().add("rectangle");
//        this.setStroke(Color.ORANGERED);
        this.setFill(Color.color(Math.random(), Math.random(), Math.random()));
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

    @Override
    public void setFit(Node node) {
        this.fit = node;
    }

    @Override
    public Node getFit() {
        return fit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangular that = (Rectangular) o;
        return Double.compare(that.wid, wid) == 0 && Double.compare(that.hei, hei) == 0;
    }
}
