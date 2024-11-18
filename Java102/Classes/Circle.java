package Java102.Classes;

public class Circle implements Shape {
    public final Point center;
	public final double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	/** 
	* @return Whether point p is inside of the circle.
	*/
	public boolean isInside(Point p) {
		return Point.distance(center, p) < radius;
	}

	/** 
	* @return Whether point p part of/on the border of the circle.
	*/
	public boolean isOn(Point p) {
		return Point.distance(center, p) == radius;
	}

	/** 
	* @param x How much to translate the circle by in the + x direction.
	* @param y How much to translate the circle by in the + y direction.
	* @return The circle that results from the translation.
	*/
	public Circle translate(double x, double y) {
		return new Circle(center.translateX(x).translateY(y), radius);
	}

	/** 
	* @return The circle that results from scaling by k.
	*/
	public Circle scale(double k) {
		return new Circle(center, radius * k);
	}

	/** 
	* @return The circle that results from 3 points.
	*/
	public static Circle fromPoints(Point p1, Point p2, Point p3) {
		/* 
		* Keep in mind it is also possible to find the the circumradius via the formula + heron's formula.
		* Then, find circumcenter by using the circumradius and extending the perpendicular bisector.
		*/ 
        Point midpointA = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        Point midpointB = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);

        Double slopeA = (p1.y - p2.y) / (p1.x - p2.x);
        Double slopeB = (p2.y - p3.y) / (p2.x - p3.x);

        Double perpSlopeA = -1 / slopeA;
        Double perpSlopeB = -1 / slopeB;

        Double xIntersection = 0.0;
        Double yIntersection = 0.0;

        if (slopeA == 0.0) { 
            xIntersection = midpointA.x;
            yIntersection = perpSlopeB * (xIntersection - midpointB.x) + midpointB.y;
        } else if (slopeB == 0.0) {
            xIntersection = midpointB.x;
            yIntersection = perpSlopeA * (xIntersection - midpointA.x) + midpointA.y;
        } else {
			xIntersection = ((perpSlopeA * midpointA.x) - (perpSlopeB * midpointB.x)) / (perpSlopeA - perpSlopeB);
            yIntersection = perpSlopeA * (xIntersection - midpointA.x) + midpointA.y;
        }

        // Circumcenter
        Point circumcenter = new Point(xIntersection, yIntersection);
        Double circumradius = Point.distance(circumcenter, p1); // Equal distances throughout all points

        return new Circle(circumcenter, circumradius);
    }
	@Override
	public String toString() {
		return "(center: " + center + "; radius: " + radius + ")";
	}   
}
