import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;

public class BurrowsWheelerTest {
    private static int R = 256;
    public static String encode(String str)
    {
        StringBuffer sb = new StringBuffer();
        CircularSuffixArray arr =  new CircularSuffixArray(str);
        for (int i = 0; i < str.length(); i++)
            if (arr.index(i) == 0)
                sb.append(i);
        for (int i = 0; i < str.length(); i++)
            sb.append(str.charAt(((arr.index(i) - 1 + str.length()) % str.length())));
        return sb.toString();
    }
    

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static String decode(String s)
    {
        int idx = Character.getNumericValue(s.charAt(0));
        StringBuffer sb = new StringBuffer();
        
        int[] n = new int[s.length() - 1];
        char[] origin = s.substring(1).toCharArray();
        char[] sorted = s.substring(1).toCharArray();
        java.util.Arrays.sort(sorted);
        
        int[] seacher = new int[R];
        char prev = sorted[0];
        seacher[prev] = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            char c = sorted[i];
            if (c != prev) {
                seacher[c] = i;
                prev = c;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++)
            n[seacher[origin[i]]++] = i;
        
        for (int i = 0; i < sorted.length; i++) {
            sb.append(sorted[idx]);
            idx = n[idx];
        }
        return sb.toString();
    }

    @Test
    public void testEncode() {
        assertEquals("3ARD!RCAAAABB", encode("ABRACADABRA!"));
    }
    @Test
    public void testDecode() {
        
        String s = "ABDBCABB";
        StdOut.print(encode(s));
        assertEquals(s, decode(encode(s)));
    }

}
