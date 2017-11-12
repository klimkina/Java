import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReverseTest {
		
    @Test
    public void testDoubleReverse() {
    	ReverseString sol = new ReverseString();
        String str = "Some very long text";
        System.out.println(sol.reverse(str));
        assertEquals(sol.reverse(str), "txet gnol yrev emoS");
        assertEquals(str, sol.reverse(sol.reverse(str)));
    }

    @Test
    public void testEmpty() {
    	ReverseString sol = new ReverseString();
    	String str = "";
    	assertTrue(sol.reverse(str).equals(""));
    }
}
