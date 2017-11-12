import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExtraSweet {
	TreeMap<Integer, Integer> left_ends;
	public ExtraSweet() {
		left_ends = new TreeMap<>();
    }
    
    public void addRange(int left, int right) { // range includes only available pieces
    	left_ends.put(left, right);
    }
    
    public int findLeft(int left) {
    	if(left_ends.isEmpty() || left == 0)
    		return 0;
    	Integer prev_left = left_ends.lowerKey(left);// <
    	
    	if(prev_left != null) {
    		Integer prev_right = left_ends.get(prev_left);
    		if(prev_right < left)
    			return prev_right;
    		else
    			return left - 1;
    	}
    	
    	return 0;
    }
    
    public int findRight(int right) {
    	if(left_ends.isEmpty())
    		return 0;
    	Integer next_right = left_ends.higherKey(right);// >
    	Integer prev_left = left_ends.floorKey(right);// <=
    	if(prev_left != null) {
    		Integer prev_right = left_ends.get(prev_left);
    		if(prev_right > right)
    			return right+1;
    	}
    	
    	if(next_right != null) {
    		return next_right;
    	}
    	
    	return 0;
    }
    
    public void removeRange(int left, int right) {
    	if(left > 0) left--;
    	right++;
    	Integer next_left = left_ends.higherKey(left);// >
    	Integer prev_left = left_ends.floorKey(left); // <=
    	Integer prev_right = null;
    	Integer next_right = null;
    	
    	if(next_left != null) 
    		next_right = left_ends.get(next_left);
    	
    	if(prev_left != null) 
    		prev_right = left_ends.get(prev_left);;
    	 	
    	
    	if(prev_left != null && prev_right > left) { // 
    		if(prev_left <= left)
    			left_ends.put(prev_left, left);
    		
			if(right < prev_right) 
				left_ends.put(right, prev_right);
			
    	}
    	while(next_left != null && next_left < right) {
    		left_ends.remove(next_left);
    		if(next_right >= right) { // replace
    			left_ends.put(right, next_right);
    			next_left = null;
    		}
    		else {
    			next_left = left_ends.higherKey(left);
    			if(next_left != null) 
    	    		next_right = left_ends.get(next_left);
    		}
    		
    	}
    }
    public int calcSweetness(int left, int right) {
    	int extraLeft = 0, extraRight = 0;
    	extraLeft = findLeft(left);
    	extraRight = findRight(right);
    	removeRange(extraLeft, extraRight == 0 ? right : extraRight);
    	return extraLeft + extraRight + (right*(right+1)/2 - (left)*(left-1)/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        ExtraSweet obj = new ExtraSweet();
        obj.addRange(0, n-1);
        for(int a0 = 0; a0 < s; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            // Write Your Code Here
            System.out.println(obj.calcSweetness(l, r));
        }
        in.close();
    }
}