import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	public static String addBoldTag(String s, String[] dict) {
        int[] bolds = new int[s.length()+1];
        for (int i = 0; i < dict.length; i++)
        {
            int first = s.indexOf(dict[i], 0);
            while (first >= 0)
            {
                bolds[first]++;
                bolds[first + dict[i].length()]--;
                first = s.indexOf(dict[i], first + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < bolds.length; i++)
        {
        	counter += bolds[i];
            if(bolds[i] > 0 && (counter == 1 || i == 0))
                sb.append("<b>");
            else if (counter == 0 && bolds[i] < 0)
                sb.append("</b>");
            if (i < bolds.length - 1)
            	sb.append(s.charAt(i));
        }
        return sb.toString();
    }
	
	public static void main(final String[] args) {
		String s = "aaabbcc";
		String[] dict = {"aaa","aab","bc","aaabbcc"};
		System.out.println(addBoldTag(s, dict));
	}
}
