import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
	
	private static long[] pow;
    private static HashMap<Long, Long> map = new HashMap<>();
    private static HashMap<Long, Long> same = new HashMap<>();
    
    public static int strangelyCompatible(List<String> students) {
    // Write your code here
        int m = students.get(0).length();
        pow = new long[m+1];
        pow[0] = 1;
        for (int i = 1; i <= m; i++)
            pow[i] = pow[i-1] *31;
        for (String s: students)
            get_hash(s);
        
        int res = 0;
        for (long l : map.values())
            res += l*(l-1)/2L;
        for (long l : same.values())
            res -= (l*(l-1)/2L) * m;
        return res;
    }
    private static void get_hash(String s)
    {
        int m = s.length();
        char[] charr = s.toCharArray();
        long[] res = new long [m];
        res[0] = charr[0] - 'a'+1;
        for (int i = 1; i < charr.length; i++)
            res[i] = res[i-1] + (charr[i] - 'a'+1) * pow[i];
        same.put(res[m-1], same.getOrDefault(res[m-1], 0L) +1L);    
        
        for(int i = 0; i < m; i++){
            long h = 0L;
            if(i == 0){
                h = res[m - 1] - res[i];
                h += 27;
            }else if(i == m - 1){
                h = res[i - 1];
                h += 27 * pow[i];
            }else{
                h = res[i - 1];
                h += res[m - 1] - res[i];
                h += 27 * pow[i];
            }
            map.put(h, map.getOrDefault(h, 0L) +1L);
        }
    }
	
	public static void main(final String[] args) {
		String[] M = {"abc", "abd", "cbd"};
		System.out.print(strangelyCompatible(Arrays.asList(M)));
	}
}
