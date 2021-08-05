package sample;
/***
 * Drawing shapes on the page are done in this class.
 * This class only has the task of forming shapes and arranging them on the page in the most optimal way.
 * And specifying the number of shapes for the optimal state is not the task of this class.
 */

import java.util.ArrayList;

public class Node {
    private static Node root = new Node(Config.config.getWidth(), Config.config.getHeight());
    private Node down;
    private Node right;

    private double width;
    private double height;

    private double x;
    private double y;

    private boolean used;

    public ArrayList<Shape> shapes = new ArrayList<>();


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

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void sort() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size() - i - 1; j++) {

                double maxJ = Math.max(shapes.get(j).getShapeHeight(), shapes.get(j).getShapeWidth());
                double minJ = Math.min(shapes.get(j).getShapeHeight(), shapes.get(j).getShapeWidth());

                double maxJ1 = Math.max(shapes.get(j + 1).getShapeHeight(), shapes.get(j + 1).getShapeWidth());
                double minJ1 = Math.min(shapes.get(j + 1).getShapeHeight(), shapes.get(j + 1).getShapeWidth());

                if (maxJ < maxJ1) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                } else if (maxJ == maxJ1 && minJ < minJ1) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
    }

    public void fit() {
        root = new Node(Config.config.getWidth(), Config.config.getHeight());
        Shape temp;
        for (int i = 0; i < shapes.size(); i++) {
            Node node = null;
            temp = shapes.get(i);
            node = findNode(root, temp.getShapeWidth(), temp.getShapeHeight());
            if (node != null)
                shapes.get(i).setFit(splitNode(node, temp.getShapeWidth(), temp.getShapeHeight()));


        }
    }

    public Node findNode(Node root, double w, double h) {
        if (root.used) {
            Node tmpNode = findNode(root.right, w, h);
            if (tmpNode != null)
                return tmpNode;
            Node tmpNode2 = findNode(root.down, w, h);
            if (tmpNode2 != null)
                return tmpNode2;
        } else if ((w <= root.width) && (h <= root.height))
            return root;

        return null;
    }

    public Node splitNode(Node node, double w, double h) {
        node.used = true;
        node.down = new Node(node.width, node.height - h, node.x, node.y + h);
        node.right = new Node(node.width - w, h, node.x + w, node.y);
        return node;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double fillPercent() {
        int all = shapes.size();
        double fit = 0.0;
        for (Shape shape : shapes) {
            if (shape.getFit() != null)
                fit += 1.0;
        }
        return (fit / all) * 100;
    }

    public boolean allPlaced() {
        return fillPercent() == 100.0;
    }

}
