package P04ExerciseEncapsulation.P01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        checkForNegativeArg(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkForNegativeArg(width,"Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkForNegativeArg(height, "Height");
        this.height = height;
    }
    private void checkForNegativeArg(double argument, String argumentType){
        if (argument <= 0){
            throw new IllegalStateException(argumentType + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea(){
        return 2 * (length * height + width * height + length * width);
    }
    public double calculateLateralSurfaceArea(){
        return 2 * length * height + 2 * width * height;
    }
    public double calculateVolume(){
        return width * height * length;
    }
}
