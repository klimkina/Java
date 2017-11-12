
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		if(A.length() > 0) {
			StringBuilder res = new StringBuilder(A);
			int i = 0;
			for (i = 0; i <= B.length()/A.length(); i++)
				res.append(A);
			for(int j = 0; j < res.length() - B.length(); j++)
				if(res.substring(j, B.length() + j).equals(B))
					return i + 1 - ((res.length() - j - B.length())/A.length());
		}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcd";
		String b = "";
		RepeatedStringMatch obj = new RepeatedStringMatch();
		System.out.println(obj.repeatedStringMatch(a, b));
	}

}
