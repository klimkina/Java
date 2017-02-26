import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;
import java.util.LinkedList;

public class PointSET {
    private static final double MAX_COORDINATE = 2.0;
    private SET<Point2D> pointsHashSet = null;
    public PointSET() { // construct an empty set of points
        pointsHashSet = new SET<Point2D>();
    }

    public boolean isEmpty() { // is the set empty?
        return pointsHashSet.size() == 0;
    }

    public int size() { // number of points in the set
        return pointsHashSet.size();
    }

    public void insert(Point2D p) { // add the point to the set (if it is not
                                    // already in the set)
        if (p == null)
            throw new java.lang.NullPointerException();
        pointsHashSet.add(p);
    }

    public boolean contains(Point2D p) { // does the set contain point p?
        if (p == null)
            throw new java.lang.NullPointerException();
        return pointsHashSet.contains(p);
    }

    public void draw() { // draw all points to standard draw
        for (Point2D p : pointsHashSet)
            StdDraw.point(p.x(), p.y());
        StdDraw.show();
    }

    public Iterable<Point2D> range(RectHV rect) { // all points that are inside
                                                  // the rectangle
        if (rect == null)
            throw new java.lang.NullPointerException();
        LinkedList<Point2D> res = new LinkedList<Point2D>();
        for (Point2D p : pointsHashSet)
            if (rect.contains(p))
                res.add(p);
        return res;
    }

    public Point2D nearest(Point2D p) { // a nearest neighbor in the set to
                                        // point p; null if the set is empty
        if (p == null)
            throw new java.lang.NullPointerException();
        Point2D res = new Point2D(MAX_COORDINATE, MAX_COORDINATE);
        for (Point2D myPoint : pointsHashSet)
            if (myPoint.distanceTo(p) < res.distanceTo(p))
                res = myPoint;
        if (res.x() < MAX_COORDINATE && res.y() < MAX_COORDINATE)
            return res;
        return null;
    }
    
    public static void main(String[] args) { // unit testing of the methods
                                             // (optional)
        String filename = args[0];
        In in = new In(filename);

        // initialize the data structures with N points from standard input
        PointSET brute = new PointSET();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            brute.insert(p);
        }      
            
        StdDraw.setPenRadius(0.1);
        StdDraw.setPenColor(StdDraw.BLUE);
        Point2D p = brute.nearest(new Point2D(0.5, 0.5));
        p.draw();       
    }
}
