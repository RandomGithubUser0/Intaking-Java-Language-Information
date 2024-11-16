package Java102.Classes;

public class Point {
    // Declared but but initialized
    public final double x; // We won't use static since these being to their own objects
    public final double y; // final makes it so the variable cannot be changed after it is initialized

    public Point(double x, double y) { // Constructor
        this.x = x; // "this" keyword == self in lua and python
        this.y = y;
        // Automatically returns the object
    }

    public Point translateX(Double X) {
        return new Point(x + X, y);
    }

    public Point translateY(Double Y) {
        return new Point(x, y + Y);
    }

    public Point TranslateWithPoint(Point p) {
        return new Point(x + p.x, y + p.y);
    }

    public Point Rotate(double Rotation){
        double angle = Point.angle(this); 
        double targetAngle = angle + Rotation; // the atan of the new angle
        double targetAngleRad = Math.toRadians(targetAngle);
        // keep in mind magnitude stays the same
        double Magnitude = Point.distance(new Point(0, 0), this);
        double newx = Math.cos(targetAngleRad) * Magnitude; 
        // math.cos will give us the x position of the unit vector of the point
        // (cos theta, sin theta) btw
        double newy = Math.sin(targetAngleRad) * Magnitude;
        return new Point(newx, newy);
    }

    // static methods

    public static Point centerOfMass(Point[] points){
        double x = 0; double y = 0; 
        int Terms = points.length;
        for (int i = 0; i < Terms; i++){
            x += points[i].x; y += points[i].y;
        }
        return new Point(x / Terms, y / Terms);
    }

    public static double angle(Point p) {
        double angleRad = Math.atan2(p.y, p.x);
        double toDeg = Math.toDegrees(angleRad);
        return toDeg;
    }

    public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

    public static double angleBetweenTwoVectors(Point p1, Point p2) {
        double Angle1 = Point.angle(p1);
        double Angle2 = Point.angle(p2);
        return Math.abs(Angle1 - Angle2);
    }

    // Essentially just metamethods
    @Override // Overrides default metamethod
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
