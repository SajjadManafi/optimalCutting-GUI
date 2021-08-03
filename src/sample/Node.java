package sample;

import java.util.ArrayList;

public class Node {
    private static final Node root = new Node(Config.config.getWidth() , Config.config.getHeight());
    private Node down;
    private Node right;

    private double width;
    private double height;

    private double x;
    private double y;

    private boolean used;

    public static ArrayList<Shape> shapes = new ArrayList<>();


    public Node() {
        this.down = null;
        this.right = null;
        this.width = 0.0;
        this.height = 0.0;
        this.x = 0.0;
        this.y = 0.0;
        this.used = false;
    }

    public Node(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public Node(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public static void addShape(Shape shape) {
        shapes.add(shape);
    }
    

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
