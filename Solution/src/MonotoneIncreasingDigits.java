
public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int N) {
		String s = String.valueOf(N);
		char[] chars = s.toCharArray();
		int[] num = new int[chars.length];
		for(int i = 0; i < chars.length; i++)
			num[i] = Character.getNumericValue(chars[i]);
		while(!checkIncrease(num)) {
			decrease(num);
		}
		return toInteger(num);
        
    }
	private boolean checkIncrease(int[] num) {
		for(int i = 1; i < num.length; i++)
			if(num[i] < num[i-1])
				return false;
		return true;
	}
	private int toInteger(int[] num) {
		int res = 0;
		for(int i = 0; i < num.length; i++) 
			res = res*10 + num[i];
		
		return res;
	}
	private void decrease(int[] num) {
		
		for(int i = 1; i < num.length; i++) {
			if(num[i-1] > num[i]) {
				num[i-1] = num[i-1] - 1;
				for(int j = i; j < num.length; j++)
					num[j] = 9;
				break;
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonotoneIncreasingDigits sol = new MonotoneIncreasingDigits();
		int res = sol.monotoneIncreasingDigits(768343908);
		System.out.println(res);
	}

}
