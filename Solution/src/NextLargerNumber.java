import java.util.Arrays;

public class NextLargerNumber {
	public long getNextLarger(int num) { // returns next larger number with the same digits
		char[] charr = ("" + num).toCharArray();
		for(int i = charr.length-1; i > 0; i--) {
			if(charr[i-1] < charr[i]) {
				rearrange(charr, i-1);
				return makeLong(charr);
			}
		}
		return - 1;
	}
	private void rearrange(char[] charr, int start) {
		//swap digits
		char temp = charr[start];
		charr[start] = charr[start+1];
		charr[start+1] = temp;
		Arrays.sort(charr, start+1, charr.length);
	}
	private long makeLong(char[] charr) {
		long res = 0;
		for(int i = 0; i < charr.length; i++)
			res = res*10 + (charr[i] - '0');
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextLargerNumber obj = new NextLargerNumber();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(obj.getNextLarger(Integer.MAX_VALUE));
		System.out.println(obj.getNextLarger(454321));
	}

}
