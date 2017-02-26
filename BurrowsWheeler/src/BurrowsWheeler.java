import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    private static final int R = 256;
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode()
    {
        StringBuffer sb = new StringBuffer();
        while (!BinaryStdIn.isEmpty()) 
            sb.append(BinaryStdIn.readChar());
        
        String str = sb.toString();
        CircularSuffixArray arr =  new CircularSuffixArray(str);
        for (int i = 0; i < str.length(); i++)
            if (arr.index(i) == 0)
                BinaryStdOut.write(i);
        for (int i = 0; i < str.length(); i++)
            BinaryStdOut.write(str.charAt(((arr.index(i) - 1 + str.length()) % str.length())));
        BinaryStdIn.close();
        BinaryStdOut.close();
        
    }
    

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode()
    {
        int idx = BinaryStdIn.readInt();
        StringBuffer sb = new StringBuffer();
        while (!BinaryStdIn.isEmpty()) 
            sb.append(BinaryStdIn.readChar());
        
        int[] n = new int[sb.length()];
        char[] origin = new char[sb.length()];
        sb.getChars(0, sb.length(), origin, 0);
        char[] sorted = new char[sb.length()];
        sb.getChars(0, sb.length(), sorted, 0);
        java.util.Arrays.sort(sorted);
        
        int[] seacher = new int[R];
        char prev = sorted[0];
        seacher[prev] = 0;
        for (int i = 1; i < sb.length(); i++) {
            char c = sorted[i];
            if (c != prev) {
                seacher[c] = i;
                prev = c;
            }
        }
        
        for (int i = 0; i < sb.length(); i++)
            n[seacher[origin[i]]++] = i;
        
        if (idx > sorted.length)
            throw new java.lang.IndexOutOfBoundsException("First index out of bounds!" + idx);
        for (int i = 0; i < sorted.length; i++) {
            BinaryStdOut.write(sorted[idx]);
            idx = n[idx];
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }
    
    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
        if (args[0].equals("-")) 
            encode();        
        else if (args[0].equals("+"))
            decode();
        else BinaryStdOut.write("No parameters");
        BinaryStdIn.close();
        BinaryStdOut.close();
    }
}