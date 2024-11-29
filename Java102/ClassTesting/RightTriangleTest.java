package Java102.ClassTesting;

import Java102.Classes.Point;
import Java102.Classes.RightTriangle;

public class RightTriangleTest {
    public static void main(String[] args) {
        RightTriangle right = new RightTriangle(4.0, 3.0, new Point(0, 0));
        System.out.println(right.isOn(new Point(0, 3)));
        System.out.println(right.isInside(new Point(3, 2)));
        RightTriangle rightB = new RightTriangle(8.0, 6.0, new Point(1, 4));
        System.out.println(RightTriangle.similar(right, rightB));
    }
}
