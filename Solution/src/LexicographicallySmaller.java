import java.util.ArrayList;

public class LexicographicallySmaller {
	String[] words;
	LexicographicallySmaller(String[] init) {
		words = new String[init.length];
		System.arraycopy( init, 0, words, 0, init.length );
	}
	public int countLexicographicallySmaller(int l, int r, String s) {
		int res = 0;
		for(int i = l-1; i < r; i++)
			res += isLexicographicallySmaller(words[i], s);
		return res;
	}
	
	private int isLexicographicallySmaller(String x, String y) {
		if(y.startsWith(x))
			return 1;
		int i = 0;
		int len = Math.min(x.length(), y.length());
		i = len/2;
		
		while(x.charAt(i) <= y.charAt(i))
			i++;
		if(i >= y.length() && i < x.length())
			return 0;
		if(i >= x.length() || i >= y.length() || x.charAt(i) < y.charAt(i))
			return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] z = new String[5];
		z[0] = "aab"; 
		z[1] = "za"; 
		z[2] = "a"; 
		z[3] = "aa"; 
		z[4] = "aaa";
		LexicographicallySmaller obj = new LexicographicallySmaller(z);
		System.out.println(obj.countLexicographicallySmaller(1, 1, "bc"));
		System.out.println(obj.countLexicographicallySmaller(3, 5, "aaaa"));
	}

}
