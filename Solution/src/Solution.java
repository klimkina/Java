import java.util.*;

public class Solution {
	static int[] solve(int[] grades){
        // Complete this function
		int[] res = new int[grades.length];
		for(int i = 0; i < grades.length; i++)
			res[i] = ((grades[i] > 38 && grades[i] < 100 && grades[i] % 5 > 2) ? (grades[i]/5 + 1) * 5 : grades[i]);
		return res;
    }

    public static void main(String[] args) {
        //int n = 100;
        //int[] grades = new int[n];
        //Random rand = new Random();
        //for(int i = 0; i < n; i++)
        //	grades[i] = rand.nextInt(100);
    	Scanner in = new Scanner(System.in);
    	System.out.println("Input number of grades:");
        int n = in.nextInt();
        int[] grades = new int[n];
        System.out.println("Input grades:");
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        System.out.println("Resulting grades:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        
        in.close();

    }
}