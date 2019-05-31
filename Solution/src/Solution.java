import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public List<String> removeComments(String[] source) {
		 List<String> res = new ArrayList<>();
	        if (source == null || source.length == 0)
	            return res;
	        boolean block = false;
	        int i = 0;
	        String str = source[i];
	        String prev = "";
	        while (i < source.length-1 || !str.isEmpty())
	        {
	            if (block) // look for closing
	            {
	                int start = str.indexOf("*/");
	                if (start >= 0)
	                {
	                    str = prev + str.substring(start+2, str.length());
	                    block = false;
	                    prev = "";
	                }
	                else
	                    str = source[++i];
	            }
	            else // look for // or /*
	            {
	                int start1 = str.indexOf("//");
	                int start2 = str.indexOf("/*");
	                if (start1 >= 0 && (start1 < start2 || start2 < 0))
	                {
	                    str = str.substring(0, start1);
	                    if (!str.isEmpty())
	                        res.add(str);
	                    if (i < source.length-1)
	                        str = source[++i];
	                    else
	                        str = "";
	                }
	                else if (start1 < 0 && start2 < 0)
	                {
	                    if (!str.isEmpty())
	                        res.add(str);
	                    if (i < source.length-1)
	                        str = source[++i];
	                    else
	                        str = "";
	                }
	                else
	                {
	                    int end = str.indexOf("*/", start2 + 2);
	                    if (end >= 0)
	                        str = str.substring(0, start2) + str.substring(end +2, str.length());
	                    else
	                    {
	                        prev = str.substring(0, start2);
	                        //if (!str.isEmpty())
	                        //    res.add(str);
	                        if (i < source.length-1)
	                            str = source[++i];
	                        else
	                            str = "";
	                        block = true;
	                    }
	                }
	            }
	        }
	        return res;
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
		List<String> res = obj.removeComments(source);
		for (String s : res)
			System.out.println(s);
		
	}
}
