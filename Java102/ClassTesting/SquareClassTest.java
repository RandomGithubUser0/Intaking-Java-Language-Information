package Java102.ClassTesting;

import Java102.Classes.Point;
import Java102.Classes.Square;

public class SquareClassTest {
    private static final int length = 3;
    private static final Point cornerPoint = new Point(0, 0);

    public static void main(String[] args) {
        Square mySquare = new Square(cornerPoint, length);
        System.out.println(mySquare.area());
        System.out.println(mySquare.perimeter());
        for (int i = 0; i < 4; i++){
            System.out.println(mySquare.corners()[i]);
        }
    }
}
