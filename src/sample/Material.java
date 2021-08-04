package sample;

public class Material {
    private final double width;
    private final double height;

    private final double InitialArea;
    private double area;
    private double actualArea;


    public Material(double width, double height) {
        this.width = width;
        this.height = height;
        this.InitialArea = width * height;
        this.area = this.InitialArea;
        this.actualArea = this.InitialArea;
    }

    public void cut(Shape shape){
        setArea(getArea() - shape.getArea());
        setActualArea(getActualArea() - shape.getActualArea());
    }

    public double getArea() {
        return area;
    }

    public double getActualArea() {
        return actualArea;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setActualArea(double actualArea) {
        this.actualArea = actualArea;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double calUsedArea() {
        return ( area / InitialArea ) * 100;
    }

    public double calUsedActualArea() {
        return ( area / InitialArea ) * 100;
    }

}
