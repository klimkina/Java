import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RevisedRussianRoulette {

    static int[] revisedRussianRoulette(int[] doors) {
        // Complete this function
    	int[] res = new int[2];
    	boolean prevUnlocked = false;
    	for(int i = 0; i < doors.length; i++)
    		if(doors[i] == 1) {
    			if(!prevUnlocked)
    				res[0]++;
    			res[1]++;
    			prevUnlocked = !prevUnlocked;
    		} else
    			prevUnlocked = false;
    	return res;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();*/
        int[] doors = {1, 1, 1, 0, 0, 1};
        /*for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }*/
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");

        //in.close();
    }
}
