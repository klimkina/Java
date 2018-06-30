import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length,v2.length);
        for(int i=0;i<len;i++){
            int c1 = 0;
            int c2 = 0;
            if(v1.length>i) c1 = Integer.parseInt(v1[i]);
            if(v2.length>i) c2 = Integer.parseInt(v2[i]);            
            if(c1>c2) return 1;
            if(c2>c1) return -1;
        }
        return 0;
	}
	
    public static void main(String[] args) {
    	String version1 = "1.1", version2 = "1";
    	System.out.println(compareVersion(version1, version2));
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
