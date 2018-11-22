package algorithms.line.intersection;

/**
 * https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 */
public class Main {

    private static Orientation orientation(Point one, Point two) {
        Double t = one.x * two.y - one.y * two.x;
        if (t > 0) return Orientation.CLOCKWISE;
        else if (t < 0) return Orientation.COUNTER_CLOCKWISE;
        else return Orientation.COLLINEAR;
    }

    private static boolean isLineIntersect(Line one, Line two) {
        if (generalCase(one, two))
            return true;
        if (specialCase(one, two))
            return true;
        return false;
    }

    private static boolean generalCase(Line one, Line two) {
        Point oneB = Point.minus(one.b, one.a);
        Point twoA = Point.minus(two.a, one.a);
        Point twoB = Point.minus(two.b, one.a);
        if (orientation(oneB, twoA) != orientation(oneB, twoB)) {

            Point twoB_twoA = Point.minus(two.b, two.a);
            Point oneA_twoA = Point.minus(one.a, two.a);
            Point oneB_twoA = Point.minus(one.b, two.a);
            if (orientation(twoB_twoA, oneA_twoA) != orientation(twoB_twoA, oneB_twoA)) {
                return true;
            }
        }
        return false;
    }

    private static boolean specialCase(Line one, Line two) {
        Point oneB = Point.minus(one.b, one.a);
        Point twoA = Point.minus(two.a, one.a);
        Point twoB = Point.minus(two.b, one.a);

        Point twoB_twoA = Point.minus(two.b, two.a);
        Point oneA_twoA = Point.minus(one.a, two.a);
        Point oneB_twoA = Point.minus(one.b, two.a);
        if (orientation(oneB, twoA) == Orientation.COLLINEAR &&
                orientation(oneB, twoB) == Orientation.COLLINEAR &&
                orientation(twoB_twoA, oneA_twoA) == Orientation.COLLINEAR &&
                orientation(twoB_twoA, oneB_twoA) == Orientation.COLLINEAR) {
            // if lines are collinear then if xIntersects then y also intersects
            return xIntersect(one, two);
        }
        return false;
    }

    private static boolean xIntersect(Line one, Line two) {
        double aMinX = Double.min(one.a.x, one.b.x);
        double aMaxX = Double.max(one.a.x, one.b.x);

        if (aMinX <= two.a.x && two.a.x <= aMaxX) {
            return true;
        }
        else if (aMinX <= two.b.x && two.b.x <= aMaxX) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLineIntersect(
                new Line(
                        new Point(0d,1d),
                        new Point(5d,1d)
                ),
                new Line(
                        new Point(0d,1d),
                        new Point(5d,1d)
                )
        ));
    }
}
