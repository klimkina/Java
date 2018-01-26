
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
        int count = 0;
        int num = 0;
        while (count < n)
        	if(isUgly(++num, primes))
        		count++;
        return num;
    }
	private boolean isUgly(int n, int[] primes) {
		int pos = 0;
		while(pos < primes.length) {
			if(n % primes[pos] != 0)
				pos++;
			else
				n /= primes[pos];
		}
		return n == 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] primes = {2, 7, 13, 19};
		SuperUglyNumber obj = new SuperUglyNumber();
		System.out.println(obj.nthSuperUglyNumber(12, primes));
	}

}
