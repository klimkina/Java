import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static String[] reorderLogFiles(String[] logs) {
        ArrayList<String> let = new ArrayList<>();
        ArrayList<String> dig = new ArrayList<>();
        for(int i = 0; i < logs.length; i++)
        {
            int idx = logs[i].indexOf(' ');
            idx = logs[i].indexOf(' ');
            char ch = logs[i].charAt(idx+1);
            if (ch >= '0' && ch <= '9')
                dig.add(logs[i]);
            else
                let.add(logs[i].substring(idx).trim() + ";" + logs[i].substring(0, idx));
        }
        Collections.sort(let);
        String[] res = new String[logs.length];
        for(int i = 0; i < let.size(); i++)
        {
            String[] spl = let.get(i).split(";");
            res[i] = spl[1] + ' ' + spl[0];
        }
        int len = let.size();
        for(int i = 0; i < dig.size(); i++)
        {
            res[i + len] = dig.get(i);
        }
        return res;
    }
	
    public static void main(String[] args) 
    {
    	String[] arr = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
    	arr = reorderLogFiles(arr);
    	for(int i = 0; i < arr.length; i++)
    		System.out.println(arr[i]);
    }
}
