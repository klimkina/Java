
public class BinaryCalc {
	double convert(String s) {
		s = s.trim();
		String fraction = s.split("\\.")[1];
		s = s.split("\\.")[0];
		
		double res = 0;
		double pow = 1;
		char[] charr = s.toCharArray();
		for(int i = charr.length - 1; i >= 0; i--) {
			res = pow*Character.getNumericValue(charr[i]) + res;
			pow *= 2;
		}
		pow = (double)1/2;
		charr = fraction.toCharArray();
		for(int i = 0; i < charr.length; i++) {
			res = pow*Character.getNumericValue(charr[i]) + res;
			pow /= 2;
		}
		return res;
	}
	String convert(double d) {
		if (d == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		int n = (int)d;
		double frac = d - n;
		while (n > 0) {
			sb.append(n&1);
			n >>= 1;
		}
		sb.reverse();
		if(frac > 0) {
			sb.append(".");
			for(int i = 0; i < 10; i++) {//output only 10 first bits
				frac *= 2;
				if(frac > 1) {
					sb.append("1");
					frac--;
				}
				else
					sb.append("0");
			}
		}
		return sb.toString();	
	}
	int hex2int(String s) {
		int res = 0;
		int pow = 1;
		char[] charr = s.toCharArray();
		for(int i = charr.length - 1; i >= 0; i--) {
			if(Character.getNumericValue(charr[i]) < 0)
				res = pow* ((charr[i] - 'A') + 10) + res;
			else
				res = pow*Character.getNumericValue(charr[i]) + res;
			pow *= 16;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryCalc obj = new BinaryCalc();
		//System.out.println(obj.convert(8));
		/*String[] s = {"1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001"};
		for(int i = 0; i < s.length; i++)
			System.out.println(obj.convert(s[i]));*/
		System.out.println(obj.convert(22.33));
	}

}
