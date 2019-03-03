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
	
	public static boolean isValid(String S) {
        if (S.isEmpty() || S.equals("abc"))
            return true;
        if(S.indexOf("abc") < 0)
            return false;
        return isValid(S.replace("abc", ""));
    }
	
	public static void main(final String[] args) {
		System.out.println(isValid("cabcabc"));
	}
}
