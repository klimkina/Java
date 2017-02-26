import static org.junit.Assert.*;
import org.junit.Test;

public class CircularSuffixArrayTest {
 
    @Test
    public void test() {
        
        CircularSuffixArray arr = new CircularSuffixArray("ABRACADABRA!");
        assertEquals(arr.length(), 12);
        assertEquals(arr.index(0), 11);
        assertEquals(arr.index(1), 10);
        assertEquals(arr.index(2), 7);
        assertEquals(arr.index(3), 0);
        assertEquals(arr.index(4), 3);
        assertEquals(arr.index(5), 5);
        assertEquals(arr.index(6), 8);
        assertEquals(arr.index(7), 1);
        assertEquals(arr.index(8), 4);
        assertEquals(arr.index(9), 6);
        assertEquals(arr.index(10), 9);
        assertEquals(arr.index(11), 2);
        
    }

}
