import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import org.junit.Test;

public class KdTreeTest {
    private KdTree kdTree = null;
    @Test
    public void testIsEmpty() {
        kdTree = new KdTree();
        assertTrue(kdTree.isEmpty());
        kdTree.insert(new Point2D (0.5, 0.5));
        assertFalse(kdTree.isEmpty());
    }

    @Test
    public void testSize() {
        kdTree = new KdTree();
        assertEquals(kdTree.size(), 0);
        kdTree.insert(new Point2D (0.5, 0.5));
        assertEquals(kdTree.size(), 1);
        kdTree.insert(new Point2D (0.7, 0.7));
        assertEquals(kdTree.size(), 2);
        kdTree.insert(new Point2D (0.7, 0.7)); // no duplicates
        assertEquals(kdTree.size(), 2);
    }

    @Test
    public void testInsert() {
        kdTree = new KdTree();
        kdTree.insert(new Point2D (0.5, 0.5));
        assertFalse(kdTree.isEmpty());
    }

    @Test
    public void testContains() {
        kdTree = new KdTree();
        kdTree.insert(new Point2D (0.5, 0.5));
        assertTrue(kdTree.contains(new Point2D (0.5, 0.5)));
    }

    @Test
    public void testRange() {
        kdTree = new KdTree();
        kdTree.insert(new Point2D (0.5, 0.5));
        kdTree.insert(new Point2D (0.7, 0.7));
        //assertEquals(kdTree.range(new RectHV())., 2);
    }

    @Test
    public void testNearest() {
        kdTree = new KdTree();
        kdTree.insert(new Point2D (0.5, 0.5));
        kdTree.insert(new Point2D (0.7, 0.7));
        assertEquals(kdTree.nearest(new Point2D (0.55, 0.55)), new Point2D (0.5, 0.5));
    }
    public void testDraw() {
        kdTree = new KdTree();
        StdDraw.clear();
        kdTree.insert(new Point2D (0.206107, 0.095492));
        kdTree.draw();
        StdDraw.show();
        kdTree.insert(new Point2D (0.975528, 0.654508));
        kdTree.insert(new Point2D (0.024472, 0.345492));
        kdTree.insert(new Point2D (0.793893, 0.095492));
        kdTree.insert(new Point2D (0.793893, 0.904508));
        kdTree.insert(new Point2D (0.975528, 0.345492));
        kdTree.insert(new Point2D (0.206107, 0.904508));
        kdTree.insert(new Point2D (0.500000, 0.000000));
        kdTree.insert(new Point2D (0.024472, 0.654508));
        kdTree.insert(new Point2D (0.500000, 1.000000));
        StdDraw.enableDoubleBuffering();
        kdTree.draw();
        StdDraw.show();
        StdDraw.pause(50);
    }
}
