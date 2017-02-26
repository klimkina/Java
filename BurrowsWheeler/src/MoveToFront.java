import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    private static final int R = 256;
    private static char[] set() {
        char[] arr = new char[R];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (0x0 + i);
        }
        return arr;
    }
    private static void move(int idx, char[] arr, char c) {
        if (idx != 0)
            System.arraycopy(arr, 0, arr, 1, idx);
        arr[0] = c;
    }
    
    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode()
    {
        char[] count = set();
        while (!BinaryStdIn.isEmpty()) {            
            char c = BinaryStdIn.readChar();
            char index = 0;
            for (int j = 0; j < count.length; j++, index++) {
                if (c == count[j]) break;
            }
            move(index, count, c);
            BinaryStdOut.write(index);
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }
    

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode()
    {
        char[] decoder = set();
        while (!BinaryStdIn.isEmpty()) {  
            char c = BinaryStdIn.readChar();
            BinaryStdOut.write(decoder[c]);
            move(c, decoder, decoder[c]);
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }
    

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
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