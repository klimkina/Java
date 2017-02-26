import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/******************************************************************************
 *  Compilation:  javac FastCollinearPoints.java
 *
 *  Liudmila Klimkina 11/15/2016
 *
 ******************************************************************************/

public class FastCollinearPoints {
    private LineSegment[] segments;
    private class PointPair {
        private Point p;
        private Point q;
        
        public PointPair(Point p, Point q) {
            if (p == null || q == null) {
                throw new NullPointerException("argument is null");
            }
            this.p = p;
            this.q = q;
        }   
        public boolean isSubSegment(PointPair that)
        {
            
            if (this.p.slopeTo(this.q) == that.p.slopeTo(that.q))
                if (this.p.compareTo(that.p) == 0) // the same initial point
                    return true;
                else if (this.p.slopeTo(this.q) == this.p.slopeTo(that.p))
                    return true;
            return false;
        }
        public boolean alreadyIn(PointPair[] arr, int size) {
            for (int i = 0; i < size; i++)
                if (this.isSubSegment(arr[i]))
                    return true;
            return false;
        }
        public Point getLeftBound() {
            return p;
        }
        public Point getRightBound() {
            return q;
        }
         
    }
    
    public FastCollinearPoints(Point[] points) {   // finds all line segments containing 4 or more points
       checkNulls(points);
       checkDuplicates(points);
       
       Point[] newPoints = new Point[points.length]; // copy points
       for (int i = 0; i < points.length; i++)
           newPoints[i] = points[i];
       Arrays.sort(newPoints, null);
       int size = 0;
       PointPair[] temp = new PointPair[newPoints.length * (newPoints.length - 1) / 2];
       
       for (int i = 0; i < newPoints.length - 3; i++) {
           Arrays.sort(newPoints, i + 1, newPoints.length, newPoints[i].slopeOrder());
           int j = i + 1; // first point would be itself
           
           while (j < newPoints.length - 2) {
               if (newPoints[j].slopeTo(newPoints[i]) == newPoints[j + 1].slopeTo(newPoints[i]) 
                   && newPoints[j + 2].slopeTo(newPoints[i]) == newPoints[j].slopeTo(newPoints[i])) {
                   
                   Point min = getMin(newPoints[i], getMin(newPoints[j], getMin(newPoints[j + 1], newPoints[j + 2])));
                   Point max = getMax(newPoints[i], getMax(newPoints[j], getMax(newPoints[j + 1], newPoints[j + 2]))); 
                   j += 2;
                   while (j < newPoints.length - 1 
                           && newPoints[j].slopeTo(newPoints[i]) == newPoints[j + 1].slopeTo(newPoints[i])) {
                       max = getMax(max, newPoints[j + 1]);
                       min = getMin(min, newPoints[j + 1]);
                       j++;
                   }
                   PointPair newSegment = new PointPair(min, max);
                   if (!newSegment.alreadyIn(temp, size)) // do not insert duplicates
                           temp[size++] = newSegment;
               }
               j++;
           }
       }
       
       segments = new LineSegment[size];
       for (int i = 0; i < size; i++)
          segments[i] = new LineSegment(temp[i].getLeftBound(), temp[i].getRightBound());
    }
   
    public int numberOfSegments() {     // the number of line segments
       return segments.length;
    }
   
    public LineSegment[] segments() {              // the line segments
        LineSegment[] res = new LineSegment[segments.length];
        for (int i = 0; i < segments.length; i++)
            res[i] = segments[i];
        return res;
    }
    
    private static void checkNulls(Point[] points) {
        for (int i = 0; i < points.length; i++)
            if (points[i] == null)
                throw new java.lang.NullPointerException();
    }
    
    private static void checkDuplicates(Point[] points) {
        for (int i = 0; i < points.length - 1; i++)
            for (int j = i + 1; j < points.length; j++)
                if (points[i].compareTo(points[j]) == 0)
                    throw new java.lang.IllegalArgumentException();
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
    
    public static void main(String[] args) {
        // read the n points from a file
                In in = new In(args[0]);
                int n = in.readInt();
                Point[] points = new Point[n];
                for (int j = 0; j < n; j++) {
                    int x = in.readInt();
                    int y = in.readInt();
                    points[j] = new Point(x, y);
                }
        
                // draw the points
                StdDraw.enableDoubleBuffering();
                StdDraw.setXscale(0, 32768);
                StdDraw.setYscale(0, 32768);
                for (Point p : points) {
                    p.draw();
                }
                StdDraw.show();
                Stopwatch timer = new Stopwatch(); 
                // print and draw the line segments
                FastCollinearPoints collinear = new FastCollinearPoints(points);
                double statTime = timer.elapsedTime();
                for (LineSegment segment : collinear.segments()) {
                    StdOut.println(segment);
                    segment.draw();
                }
                StdDraw.show();
                StdOut.println("Elapsed time            = " + statTime);
            }
//        }
//    }
}
