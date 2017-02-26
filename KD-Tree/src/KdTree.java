import java.util.LinkedList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private Node root = null;
    private int size = 0;
    
    public KdTree() { // construct an empty set of points
    }
    
    private static class Node {
        private Point2D point;      // the point
        private RectHV rectangle;    // the axis-aligned rectangle corresponding to this node
        private Node lb = null;        // the left/bottom subtree
        private Node rt = null;        // the right/top subtree
        private boolean isOdd;
        
        private Node(Point2D p, Node prev) {
            this.point = new Point2D(p.x(), p.y());
            
            if (prev == null) {
                rectangle = new RectHV(0, 0, 1, 1);
                this.isOdd = true;
                return;
            }
            
            this.isOdd = !prev.isOdd;
            if (prev.isOdd) 
                if (p.x() < prev.point.x())
                    rectangle = new RectHV(prev.rectangle.xmin(), prev.rectangle.ymin(), prev.point.x(), prev.rectangle.ymax());
                else
                    rectangle = new RectHV(prev.point.x(), prev.rectangle.ymin(), prev.rectangle.xmax(), prev.rectangle.ymax());
            else
                if (p.y() < prev.point.y())
                    rectangle = new RectHV(prev.rectangle.xmin(), prev.rectangle.ymin(), prev.rectangle.xmax(), prev.point.y());
                else
                    rectangle = new RectHV(prev.rectangle.xmin(), prev.point.y(), prev.rectangle.xmax(), prev.rectangle.ymax());
        }
        
        private int compare(Point2D p) {
            if (this.point.equals(p))
                return 0;
            if (isOdd) {
                if (this.point.x() <= p.x())
                    return -1;
                else if (this.point.x() > p.x())
                    return 1;
            }
            else {
                if (this.point.y() <= p.y())
                    return -1;
                else if (this.point.y() > p.y())
                    return 1;
            }
            return this.point.compareTo(p);
        }
        
        private void draw() {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            StdDraw.point(point.x(), point.y());
            StdDraw.setPenRadius();
            if (isOdd) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(point.x(), rectangle.ymin(), point.x(), rectangle.ymax());
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(rectangle.xmin(), point.y(), rectangle.xmax(), point.y());
            }
            if (lb != null)
                lb.draw();
            if (rt != null)
                rt.draw();
        }
        private int intersect(RectHV rect) { //-1 at left +1 at right 0 in the middle
            if (isOdd) { // check if vertical line intersects
                if (rect.xmin() < point.x() && rect.xmax() < point.x())
                    return -1;
                else if (rect.xmin() > point.x() && rect.xmax() > point.x())
                    return 1;
                return 0;
            } else { // check if horizontal line intersects
                if (rect.ymin() < point.y() && rect.ymax() < point.y())
                    return -1;
                else if (rect.ymin() > point.y() && rect.ymax() > point.y())
                    return 1;
                return 0;
            }
        }
        private LinkedList<Point2D> range(RectHV rect) {
            if (!this.rectangle.intersects(rect))
                return null;
            LinkedList<Point2D> res = new LinkedList<Point2D>();
            if (rect.contains(point))
                res.add(point);
            int cmp = this.intersect(rect);
            if (cmp != 1 && lb != null && lb.rectangle.intersects(rect)) // check left
                res.addAll(lb.range(rect));
            if (cmp != -1 && rt != null && rt.rectangle.intersects(rect)) // check right
                res.addAll(rt.range(rect));
            return res;
        }
        private Point2D nearest(Point2D p) {
            Point2D res = new Point2D(point.x(), point.y());
            Point2D res1 = null;
            Node next = null;
            if (this.compare(p) > 0) { // go left first
                if (lb != null && lb.rectangle.distanceSquaredTo(point) < res.distanceSquaredTo(point))
                    res1 = lb.nearest(p);
                next = rt;
            } else if (this.compare(p) < 0) {
                if (rt != null && rt.rectangle.distanceSquaredTo(point) < res.distanceSquaredTo(point))
                    res1 = rt.nearest(p);
                next = lb;
            }
            else
                return res;
            if (res1 != null && res1.distanceSquaredTo(p) < res.distanceSquaredTo(p)) 
                res = res1;
            if (next != null && next.rectangle.distanceSquaredTo(p) < res.distanceSquaredTo(p))
                res1 = next.nearest(p);
            if (res1 != null && res1.distanceSquaredTo(p) < res.distanceSquaredTo(p)) 
                res = res1;
            return res;
        }
    }

    public boolean isEmpty() { // is the set empty?
        return size == 0;
    }

    public int size() { // number of points in the set
        return size;
    }

    public void insert(Point2D p) { // add the point to the set (if it is not
                                    // already in the set)
        if (p == null)
            throw new java.lang.NullPointerException();
        if (root == null) {
            root = new Node(p, null);
            size++;
            return;
        }
        Node searchNode = search(p); 
        if (!searchNode.point.equals(p)) {
            if (searchNode.compare(p) > 0)
                searchNode.lb = new Node(p, searchNode);
            else
                searchNode.rt = new Node(p, searchNode);
            size++;
        }
    }

    public boolean contains(Point2D p) { // does the set contain point p?
        if (p == null)
            throw new java.lang.NullPointerException();
        Node searchNode = search(p);          
        if (searchNode.compare(p) == 0)
            return true;
        return false;
    }

    public void draw() { // draw all points to standard draw
        if (root != null)
            root.draw();
    }

    public Iterable<Point2D> range(RectHV rect) { // all points that are inside
                                                  // the rectangle
        if (rect == null)
            throw new java.lang.NullPointerException();
        if (root == null || !root.rectangle.intersects(rect))
            return null;
        return root.range(rect);
    }

    public Point2D nearest(Point2D p) { // a nearest neighbor in the set to
                                        // point p; null if the set is empty
        if (p == null)
            throw new java.lang.NullPointerException();
        if (root == null)
            return null;
        return root.nearest(p);
    }
    
    private Node search(Point2D p) {
        Node searchNode = root;
        if (root != null) {
            int compare = searchNode.compare(p);
            Node next = (compare > 0) ? searchNode.lb : searchNode.rt;
            while (next != null && compare != 0) {
                searchNode = next;
                compare = searchNode.compare(p);
                next = (compare > 0) ? searchNode.lb : searchNode.rt;
            }          
        }
        return searchNode;
    }
    public static void main(String[] args) {    // unit testing of the methods
                                                // (optional)
        String filename = args[0];
        In in = new In(filename);

        StdDraw.enableDoubleBuffering();

        // initialize the data structures with N points from standard input
        KdTree kdTree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdTree.insert(p);
        }
        StdDraw.clear();
        
        StdDraw.enableDoubleBuffering();
        
        // draw the range search results for kd-tree in blue
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (Point2D p : kdTree.range(new RectHV(0.25, 0.250, 0.75, 0.75)))
            p.draw();
        Point2D point = kdTree.nearest(new Point2D(0.847, 0.905));
        StdDraw.show();
        StdDraw.pause(50);
    }
}
