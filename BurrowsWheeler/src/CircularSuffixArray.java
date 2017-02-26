public class CircularSuffixArray {
    private static int radix = 256;
    private String str;
    private int[] iSuffix;
    
    public CircularSuffixArray(String s)  // circular suffix array of s
    {
        if (s == null)
            throw new java.lang.NullPointerException("Can't create suffixes from null");
        str = s;
        iSuffix = circularLSD(str);
    }
    public int length()                   // length of s
    {
        return str.length();
    }
    public int index(int i)               // returns index of ith sorted suffix
    {
        if (i < 0 || i > str.length() - 1)
            throw new java.lang.IndexOutOfBoundsException("Index out of bounds!");
        return iSuffix[i];
    }
    
    private int[] circularLSD(String a)
    {
        int n = a.length();
        int[] aux = new int[n];
        int[] indeces = new int[n];
        for (int i = 0; i < n; i++)
            indeces[i] = i;
        // key-index counting
        for (int d = a.length()-1; d >= 0; d--)
        {
            int[] count = new int[radix+1];
            for (int i = 0; i < n; i++)
                count[a.charAt((d + indeces[i]) % n) + 1]++;
            for (int r = 0; r < radix; r++)
                count[r+1] += count[r];
            for (int i = 0; i < n; i++)
                aux[count[a.charAt((d + indeces[i]) % n)]++] = indeces[i];
            for (int i = 0; i < n; i++)
                indeces[i] = aux[i];
        }
        return indeces;
    }
    public static void main(String[] args)// unit testing of the methods (optional)
    {
        
    }
}