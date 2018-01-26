import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
		SuperUglyNumber obj = new SuperUglyNumber();
		System.out.println(obj.nthSuperUglyNumber(100000, primes));
	}

}
