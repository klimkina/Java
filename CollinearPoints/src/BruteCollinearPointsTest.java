import static org.junit.Assert.*;

import org.junit.Test;

public class BruteCollinearPointsTest {

    @Test(expected = java.lang.IllegalArgumentException.class) 
    public void duplicates() { 
        Point[] points = new Point[2];
        points[0] = new Point(0,0);
        points[1] = new Point(0,0);
        new BruteCollinearPoints(points); 
    }

}
