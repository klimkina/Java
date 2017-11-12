import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppleAndOrange {
	public static int countFruits(int start, int left, int right, int[] fruits) {
		int res = 0;
		for(int i = 0; i < fruits.length; i++)
			if(start + fruits[i] <= right && start + fruits[i] >= left)
				res++;
		return res;
	}

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }*/
    	int[] apple = {-2, 2, 1};
    	int[] orange = {5, -6};
        System.out.println(countFruits(5, 7, 11, apple));
        System.out.println(countFruits(15, 7, 11, orange));
    }
}