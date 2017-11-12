import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sort {
     private static int lonelyInteger(int[] a) {
         java.util.Arrays.sort(a);
         for (int i = 0; i < a.length - 1; ) {
             if(a[i] != a[i+1])
                 return a[i];
             i = 1 + 2;
         }
        return a[a.length - 1];
    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        //int[] a = new int[n];
       // for (int i = 0; i < n; i++) {
        //    a[i] = in.nextInt();
        //}
        int[] a = {0, 0, 1, 2, 1};
        System.out.println(lonelyInteger(a));
    }

}
 
