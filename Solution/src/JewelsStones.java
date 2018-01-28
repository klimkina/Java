
public class JewelsStones {
	public int numJewelsInStones(String J, String S) {
        int res = 0;
        char[] charr = S.toCharArray();
        for(char ch:charr)
        	if(J.indexOf(ch) >= 0)
        		res++;
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "z", S = "ZZ";
		JewelsStones obj = new JewelsStones();
		System.out.println(obj.numJewelsInStones(J, S));
	}

}
