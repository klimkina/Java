import  java.lang.String;

public class Sort {
    private static void quickSort(String[] a)
    { sort(a, 0, a.length - 1, 0); }
    private static void sort(String[] a, int lo, int hi, int d)
    {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo].charAt(d);
        int i = lo + 1;
        while (i <= gt)
        {
            int t = a[i].charAt(d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }

    private static void exch(String[] a, int i, int j) {
        // TODO Auto-generated method stub
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] a = {"3215", "3533", "6125", "1564", "1666", "6243", "3366", "5343", "3535", "5313"};
        quickSort(a);
    }

}
