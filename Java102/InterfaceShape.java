package Java102;

import Java102.Classes.Circle;
import Java102.Classes.Point;
import Java102.Classes.Shape;
import Java102.Classes.Square;

public class InterfaceShape {
    static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }
    static Shape[] scaleAll(Shape[] shapes, double k) {
        Shape[] scaled = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            scaled[i] = shapes[i].scale(k);
        }
        return scaled;
    }
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(new Point(1.8, -20), 2), 
			new Square(new Point(100, 2.1), 5.4),
			new Circle(new Point(0, 0), 1),
			new Circle(new Point(4, 9.123), 98.32),
			new Square(new Point(-321, 0), 0.02)
        };
        System.out.println(sumArea(shapes));

        Shape[] scaled = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++){
            scaled[i] = shapes[i].scale(2);
        }
        System.out.println(sumArea(scaled));
    }
}
