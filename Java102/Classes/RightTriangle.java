package Java102.Classes;

public class RightTriangle implements Shape {
    final Double base;
    final Double height; 
    final Point rightAngleVertex;

    final Double hypotenuse;

    // Corner describes the bottom left corner
    public RightTriangle(Double base, Double height, Point rightAngleVertex){
        this.base = base;
        this.height = height;
        this.rightAngleVertex = rightAngleVertex;

        // Get Hyp
        this.hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    public RightTriangle scale(double k){
        return new RightTriangle(base * 2, height * k, rightAngleVertex);
    }

    public double perimeter(){
        return base + height + hypotenuse;
    }

    public double area() {
        return base * height * (1/2);
    }

    public boolean isInside(Point p) {
        /*
            Split triangle into two subtriangles!
            If the sum of the area of the subtriangles > the original triangles, then the point IS NOT in the triangle.
            To prevent false positives (eg. the point is (-1, -1) and corner is (0, 0)), we will check if the point is in the bounding rectangle.
            This additionally reduces calculations if the point isn't in the rectangle.
        */ 

        Point boundingRecPoint = rightAngleVertex.TranslateWithPoint(new Point(base, height));
        if ((rightAngleVertex.x <= p.x) && (p.x <= boundingRecPoint.x)
        && (rightAngleVertex.y <= p.y) && (p.y <= boundingRecPoint.y)) {
            // Create subtriangles
            Point top = rightAngleVertex.translateX(height);
            Point bottom = rightAngleVertex.translateY(base);
            
            if (heronsFormulaFromPoints(top, rightAngleVertex, p) + heronsFormulaFromPoints(bottom, rightAngleVertex, p) <= area()) {
                return true;
            }
        }

        return false;
    }

    public boolean isOn(Point p) {
        Point v1 = rightAngleVertex;
        Point v2 = new Point(v1.x + base, v1.y);
        Point v3 = new Point(v1.x, v1.y + height); 
    
        return isCollinearAndWithinBounds(v1, v2, p) || 
               isCollinearAndWithinBounds(v1, v3, p) || 
               isCollinearAndWithinBounds(v2, v3, p); 
    }
    
    private boolean isCollinearAndWithinBounds(Point a, Point b, Point p) {
        if (a.x == b.x && a.x == p.x) {
            return (a.y <= p.y && p.y <= b.y) || (a.y >= p.y && p.y >= b.y);
        }
    
        double slope = (a.y - b.y) / (a.x - b.x);
        double comparisonSlope = (a.y - p.y) / (a.x - p.x);
        if (Math.abs(slope - comparisonSlope) < 1e-9) { 
            return (a.y < p.y && p.y < b.y) || (a.y > p.y && p.y > b.y);
        }
    
        return false;
    }

    private double heronsFormulaFromPoints(Point PointA, Point PointB, Point PointC) {
        double a = Point.distance(PointA, PointB);
        double b = Point.distance(PointB, PointC);
        double c = Point.distance(PointC, PointA);

        double semiPerimeter = (0.5) * (a + b + c);
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }
    
    public RightTriangle translate(double x, double y) {
        return new RightTriangle(base, height, rightAngleVertex.TranslateWithPoint(new Point(x, y)));
    }

    public static boolean similar(RightTriangle a, RightTriangle b) {
        double ratioH = a.height / b.height;
        double ratioB = a.base / b.base;
        return ratioH == ratioB;
    }
}