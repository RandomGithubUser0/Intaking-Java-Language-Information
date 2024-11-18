package Java102.ClassTesting;

import Java102.Classes.Circle;
import Java102.Classes.Point;

public class CircleClassTest {
    public static void main(String[] args) {
        Circle randomCircle = Circle.fromPoints(new Point(0, 0), new Point(2, 0), new Point(1, 2));
        Circle randomCircle2 = Circle.fromPoints(new Point(0, 0), new Point(1, 2), new Point(2, 0));

        System.out.println("Circumcenter: " + randomCircle.center);
        System.out.println("Circumradius: " + randomCircle.radius);

        System.out.println("CircumcenterA: " + randomCircle2.center);
        System.out.println("CircumradiusA: " + randomCircle2.radius);
    }
}
