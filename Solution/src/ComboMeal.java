import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ComboMeal {

    static int profit(int b, int s, int c) {
        // Return the fixed profit.
    	return b + s - c;
    }

    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int b = in.nextInt();
            int s = in.nextInt();
            int c = in.nextInt();*/
            int result = profit(275, 214, 420);
            System.out.println(result);
            result = profit(6, 9, 11);
            System.out.println(result);
            result = profit(199, 199, 255);
            System.out.println(result);
        /*}
        in.close();*/
    }
}
