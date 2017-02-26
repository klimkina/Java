/******************************************************************************
 *  Compilation:  javac BruteCollinearPoints.java
 *
 *  Liudmila Klimkina 11/15/2016
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    private int size = 0;
    public BruteCollinearPoints(Point[] points) {    // finds all line segments containing 4 points
        checkNulls(points);
        checkDuplicates(points);
        LineSegment[] temp = new LineSegment[points.length];
        for (int i = 0; i < points.length - 3; i++)
           for (int j = i + 1; j < points.length - 2; j++)
               for (int k = j + 1; k < points.length - 1; k++)
                   for (int l = k + 1; l < points.length; l++)
                       if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&
                               points[i].slopeTo(points[j]) == points[i].slopeTo(points[l]))
                           temp[size++] = makeSegment(points[i], points[j], points[k], points[l]);
        segments = new LineSegment[size];
        for (int i = 0; i < size; i++)
           segments[i] = temp[i];
    }
   
    public int numberOfSegments() {        // the number of line segments
        return size;
    }
   
    public LineSegment[] segments() {                // the line segments
        LineSegment[] res = new LineSegment[size];
        for (int i = 0; i < size; i++)
            res[i] = segments[i];
        return res;
    }
    
    private static void checkNulls(Point[] points) {
        for (int i = 0; i < points.length; i++)
            if (points[i] == null)
                throw new java.lang.NullPointerException();
    }
    private static Point getMax(Point p, Point q) {
        if (p.compareTo(q) >= 0)
            return p;
        return q;
    }
    private static Point getMin(Point p, Point q) {
        if (p.compareTo(q) <= 0)
            return p;
        return q;
    }
    private static LineSegment makeSegment(Point p1, Point p2, Point p3, Point p4)
    {
        Point min = getMin(p1, getMin(p2, getMin(p3, p4)));
        Point max = getMax(p1, getMax(p2, getMax(p3, p4)));   
        return new LineSegment(min, max);
    }
    private static void checkDuplicates(Point[] points) {
        for (int i = 0; i < points.length - 1; i++)
            for (int j = i + 1; j < points.length; j++)
                if (points[i].compareTo(points[j]) == 0)
                    throw new java.lang.IllegalArgumentException();
    }
    
    public static void main(String[] args) {
       // read the n points from a file
       In in = new In(args[0]);
       int n = in.readInt();
       Point[] points = new Point[n];
       for (int i = 0; i < n; i++) {
           int x = in.readInt();
           int y = in.readInt();
           points[i] = new Point(x, y);
       }

       // draw the points
       StdDraw.enableDoubleBuffering();
       StdDraw.setXscale(0, 32768);
       StdDraw.setYscale(0, 32768);
       for (Point p : points) {
           p.draw();
       }
       StdDraw.show();

       // print and draw the line segments
       BruteCollinearPoints collinear = new BruteCollinearPoints(points);
       for (LineSegment segment : collinear.segments()) {
           StdOut.println(segment);
           segment.draw();
       }
       StdDraw.show();

    }

}
