package sample;

/***
 * shapes interface
 */
public interface Shape {

    void calculateArea();

    double getArea();

    double getActualArea();

    double getShapeWidth();

    double getShapeHeight();

    double getShapeX();

    double getShapeY();

    void setShapeWidth(double width);

    void setShapeHeight(double height);

    void setShapeX(double x);

    void setShapeY(double y);

    void setFit(Node node);

    Node getFit();
}
