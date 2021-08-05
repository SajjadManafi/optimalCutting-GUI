package sample;

import java.util.ArrayList;

public class Cut {

    public static ArrayList<Shape> shapes = new ArrayList<>();

    public static ArrayList<Shape> cut(ArrayList<Shape> initialShapes) {
        //TODO: check initials 100% fit so run this method
        Material mat = new Material(Config.config.getWidth(), Config.config.getHeight());
        sort(initialShapes);
        for (Shape initialShape : initialShapes) {
            shapes.add(shapeCloner(initialShape));
        }
        if (!allFit(initialShapes)) {
            System.exit(0);
        }
        int counter = 0;
        while(counter < initialShapes.size()) {

            Shape tmpShape = shapeCloner(initialShapes.get(counter));
            Shape tmpShapeH = horizontalShapeCloner(initialShapes.get(counter));
            if (canBeAdd(shapes , tmpShape)) {
                shapes.add(tmpShape);
                mat.cut(tmpShape);
            }
            else if (tmpShapeH != null  && canBeAdd(shapes , tmpShapeH)){
                shapes.add(tmpShapeH);
                mat.cut(tmpShapeH);
            }
            else {
                counter += 1;
            }
        }
        System.out.println(mat.getArea());
        return shapes;
    }


    public static void sort(ArrayList<Shape> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size() - i - 1; j++) {

                double maxJ = Math.max(shapes.get(j).getShapeHeight(), shapes.get(j).getShapeWidth());
                double minJ = Math.min(shapes.get(j).getShapeHeight(), shapes.get(j).getShapeWidth());

                double maxJ1 = Math.max(shapes.get(j + 1).getShapeHeight(), shapes.get(j + 1).getShapeWidth());
                double minJ1 = Math.min(shapes.get(j + 1).getShapeHeight(), shapes.get(j + 1).getShapeWidth());

                if (maxJ < maxJ1) {
                    Shape temp = shapes.get(j);
                    shapes.set(j , shapes.get(j + 1));
                    shapes.set(j + 1 , temp);
                }
                else if (maxJ == maxJ1 && minJ < minJ1) {
                    Shape temp = shapes.get(j);
                    shapes.set(j , shapes.get(j + 1));
                    shapes.set(j + 1 , temp);
                }
            }
        }
    }

    public static Shape shapeCloner (Shape tmp) {
        if (tmp.getClass().getName().equals("sample.Rectangular"))
            return new Rectangular(tmp.getShapeWidth(), tmp.getShapeHeight());
        else if (tmp.getClass().getName().equals("sample.Circular"))
            return new Circular(0.0, 0.0, tmp.getShapeWidth() / 2);

        return null;
    }
    public static Shape horizontalShapeCloner(Shape tmp) {
        if (tmp.getClass().getName().equals("sample.Rectangular"))
            return new Rectangular(tmp.getShapeHeight(), tmp.getShapeWidth());
        else if (tmp.getClass().getName().equals("sample.Circular"))
            return null;

        return null;
    }


    public static Boolean allFit(ArrayList<Shape> shapes) {
        Node tmpNode = new sample.Node();
        tmpNode.shapes = shapes;
        tmpNode.sort();
        tmpNode.fit();
        return tmpNode.allPlaced();
    }

    public static Boolean canBeAdd(ArrayList<Shape> shapes , Shape shape){
        ArrayList<Shape> newShapes = new ArrayList<>();
        for (Shape value : shapes) {
            newShapes.add(shapeCloner(value));
        }

        newShapes.add(shapeCloner(shape));
        return allFit(newShapes);
    }
}
