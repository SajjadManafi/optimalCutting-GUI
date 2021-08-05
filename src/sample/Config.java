package sample;


public class Config {
    public static Config config;
    public static final double MAX_WIDTH = 1200.0;
    public static final double MAX_HEIGHT = 650.0;
    private double width;
    private double height;
    private  double originalWidth;
    private  double originalHeight;
    private final double coefficient;

    public Config(double originalWidth, double originalHeight) {

        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;

        coefficient = setDifferenceCoefficient();
        if (getCoefficient() > 1.0){
            setWidth(originalWidth / getCoefficient());
            setHeight(originalHeight / getCoefficient());
        }
        else {
            setWidth(originalWidth);
            setHeight(originalHeight);
        }
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    // get difference coefficient between user input and MAX_SIZES
    public double setDifferenceCoefficient() {
        return Math.max(Math.max(originalWidth / MAX_WIDTH, originalHeight / MAX_HEIGHT), 1.0);
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setOriginalWidth(double originalWidth) {
        this.originalWidth = originalWidth;
    }

    public void setOriginalHeight(double originalHeight) {
        this.originalHeight = originalHeight;
    }
}
