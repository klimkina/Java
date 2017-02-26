import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import org.junit.Test;

public class PointSETTest {
    private PointSET pSet;
    @Test
    public void testIsEmpty() {
        pSet = new PointSET();
        assertTrue(pSet.isEmpty());
        pSet.insert(new Point2D (0.5, 0.5));
        assertFalse(pSet.isEmpty());
    }

    @Test
    public void testSize() {
        pSet = new PointSET();
        assertEquals(pSet.size(), 0);
        pSet.insert(new Point2D (0.5, 0.5));
        assertEquals(pSet.size(), 1);
        pSet.insert(new Point2D (0.7, 0.7));
        assertEquals(pSet.size(), 2);
        pSet.insert(new Point2D (0.7, 0.7)); // no duplicates
        assertEquals(pSet.size(), 2);
    }

    @Test
    public void testInsert() {
        pSet = new PointSET();
        pSet.insert(new Point2D (0.5, 0.5));
        assertFalse(pSet.isEmpty());
    }

    @Test
    public void testContains() {
        pSet = new PointSET();
        pSet.insert(new Point2D (0.5, 0.5));
        assertTrue(pSet.contains(new Point2D (0.5, 0.5)));
    }

    @Test
    public void testRange() {
        pSet = new PointSET();
        pSet.insert(new Point2D (0.5, 0.5));
        pSet.insert(new Point2D (0.7, 0.7));
        Double x, y;
        for (Point2D p : pSet.range(new RectHV(0, 0, 1, 1))) {
            x = p.x();
            y = p.y();
        }
    }

    @Test
    public void testNearest() {
        pSet = new PointSET();
        pSet.insert(new Point2D (0.5, 0.5));
        pSet.insert(new Point2D (0.7, 0.7));
        assertEquals(pSet.nearest(new Point2D (0.55, 0.55)), new Point2D (0.5, 0.5));
    }

}
