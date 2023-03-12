package P09Polymorphism.P02Shapes;

public class Rectangle extends  Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.calculatePerimeter());
    }
    @Override
    public Double calculatePerimeter(){
        super.setPerimeter(2 * width + 2 * height);
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(width * height);
        return super.getArea();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
