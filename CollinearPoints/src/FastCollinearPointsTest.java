import static org.junit.Assert.*;

import org.junit.Test;

public class FastCollinearPointsTest {

    @Test
    public void testHorizontalFastCollinearPoints() {
        Point[] points = new Point[20];
        points[0] = new Point(15616, 18274);
        points[1] = new Point(12973,7441);
        points[2] = new Point(18994,20763);
        points[3] = new Point( 3480,4835);
        points[4] = new Point( 16746,20763);
        points[5] = new Point(17849,20768);
        points[6] = new Point( 20246,4835);
        points[7] = new Point(14399, 18274);
        points[8] = new Point(20435, 20768);
        points[9] = new Point(8174, 7441);
        points[10] = new Point(17206, 7441);
        points[11] = new Point(19619, 20768);
        points[12] = new Point(11698, 18274);
        points[13] = new Point(3662, 20768);
        points[14] = new Point(19220, 4835);
        points[15] = new Point(17634, 20763);
        points[16] = new Point(20496, 20763);
        points[17] = new Point(10520, 7441);
        points[18] = new Point(4770, 4835);
        points[19] = new Point(16086, 18274);
        FastCollinearPoints test = new FastCollinearPoints(points); 
        assertEquals( test.segments().length, 4);
    }

    @Test 
    public void testFastCollinearPoints5x5Duplicates() {
        Point[] points = new Point[36];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 5000);
        points[2] = new Point(0, 10000);
        points[3] = new Point( 0, 15000);
        points[4] = new Point( 0, 20000);
        points[5] = new Point(5000, 25000);
        points[6] = new Point(5000, 0);
        points[7] = new Point(5000, 5000);
        points[8] = new Point(5000, 10000);
        points[9] = new Point( 5000, 15000);
        points[10] = new Point( 5000, 20000);
        points[11] = new Point(5000, 25000);
        points[12] = new Point(10000, 0);
        points[13] = new Point(10000, 5000);
        points[14] = new Point(10000, 10000);
        points[15] = new Point(10000, 15000);
        points[16] = new Point(10000, 20000);
        points[17] = new Point(10000, 25000);
        points[18] = new Point(15000, 0);
        points[19] = new Point(15000, 5000);
        points[20] = new Point(15000, 10000);
        points[21] = new Point(15000, 15000);
        points[22] = new Point(15000, 20000);
        points[23] = new Point(15000, 25000);
        points[24] = new Point(20000, 0);
        points[25] = new Point(20000, 5000);
        points[26] = new Point(20000, 10000);
        points[27] = new Point(20000, 15000);
        points[28] = new Point(20000, 20000);
        points[29] = new Point(20000, 25000);
        points[30] = new Point(25000, 0);
        points[31] = new Point(25000, 5000);
        points[32] = new Point(25000, 10000);
        points[33] = new Point(25000, 15000);
        points[34] = new Point(25000, 20000);
        points[35] = new Point(25000, 25000);
        FastCollinearPoints test = new FastCollinearPoints(points); 
        assertEquals( test.segments().length, 25);
    }

}
