package P09Polymorphism.P02Shapes;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Rectangle(4.5, 5.3);
        System.out.println(shape.calculateArea());

        shape = new Circle(10d);
        System.out.println(shape.calculateArea());

    }
}
