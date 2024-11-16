package Java102.ClassTesting;

import Java102.Classes.Point;

public class PointClassUsage {
    static String PointToString(Point p){
        return "(" + p.x + ", " + p.y + ")" ;
    }

    public static void main(String[] args) {
        // Basic Printing
        Point newp = new Point(1, 2);
        System.out.println(PointToString(newp));
        
        // Basic Translation
        Point TranslateBy = new Point(1, -2);
        Point TranslatedPoint = newp.TranslateWithPoint(TranslateBy);
        System.out.println(PointToString(TranslatedPoint));

        // MultiTranslation
        Point MultiTranslated = newp.TranslateWithPoint(new Point(1, 2)).TranslateWithPoint(new Point(3, -6));
        System.out.println(PointToString(MultiTranslated));

        // with toString method
        System.out.println(MultiTranslated);

        // Get distance between two points
        System.out.println(Point.distance(TranslatedPoint, MultiTranslated));

        // Center of mass
        Point[] COMpoints = {new Point(0, 0), new Point(3, 0), new Point(3, 3), new Point(0, 3)};
        System.out.println(Point.centerOfMass(COMpoints));

        // atan2
        System.out.println(Point.angle(new Point(1, 1)));

        // rotate
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        System.out.println(p1.Rotate(90));
        System.out.println(p1.Rotate(20));
        System.out.println(p2.Rotate(45));

        // theta between two angles
        Double Theta = Point.angleBetweenTwoVectors(p1, p2);
        System.out.println(Theta);
    }
}
