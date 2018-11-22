package algorithms.line.intersection;

public class Point {
    public double x;
    public double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point minus(Point a, Point b){
        return new Point(a.x - b.x, a.y - b.y);
    }
}