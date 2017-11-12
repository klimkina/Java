
public class StringCompression {
	public int compress(char[] chars) {
		if (chars.length <= 1)
			return chars.length;
		char curr = chars[0];
		int count = 1;
		int res = 0;
		for(int i = 1; i < chars.length; i++)
			if(chars[i] == curr)
				count++;
			else {
				res += modify(chars, res, curr, count);
				curr = chars[i];
				count = 1;
			}
		
		res += modify(chars, res, curr, count);
		return res;
    }
	private int modify(char[] chars, int res, char curr, int count) {
		int ret = 1;
		chars[res] = curr;
		if (count > 1) {
			char[] newChars = Integer.toString(count).toCharArray();
			for(int j = 0; j < newChars.length; j++)
				chars[res + j + 1] = newChars[j];
			ret += newChars.length;
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompression obj = new StringCompression();
		char[] chars1 = {'a'};
		System.out.println(obj.compress(chars1));
		System.out.println(chars1);
		char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(obj.compress(chars2));
		System.out.println(chars2);
		char[] chars3 = {'a','a','b','b','c','c','c'};
		System.out.println(obj.compress(chars3));
		System.out.println(chars3);
	}

}
