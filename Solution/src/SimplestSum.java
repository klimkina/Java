
public class SimplestSum {
	static int simplestSum(int k, int a, int b) {
        // Complete this function
		long sum = 0;
		long start_pow = (int)(Math.log(a)/Math.log(k));
		//long end_pow = (int)(Math.log(b)/Math.log(k));
		
		long curr_pow = (long)Math.pow(k, start_pow);
		long next_pow = k*curr_pow;
		long count = k *(1-next_pow)/(1-k);
		
		while(count < b) {
			sum += curr_pow * ((start_pow + 1) - (1-next_pow)/(1-k))/(1-k) * Math.min(count, b);
			curr_pow = next_pow;
			next_pow *= k;
			count += next_pow;
		}
		
		return (int)sum % 1000000007;
    }
	public static long idx(int k, int a) {
		long pow = (long)(Math.log(a)/Math.log(k));
		long k2pow = (long)Math.pow(k, pow + 2);
		
		return ((k2pow - 1)/(k-1) - pow - 1)/(k-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplestSum obj = new SimplestSum();
		/*System.out.println(obj.sum(2, 15));
		System.out.println(obj.sum(2, 16));
		System.out.println(obj.sum(2, 32));*/
		System.out.println(obj.idx(3, 1));
		System.out.println(obj.idx(3, 2));
		System.out.println(obj.idx(3, 3));
		System.out.println(obj.idx(3, 4));
		System.out.println(obj.idx(3, 5));
		System.out.println(obj.idx(3, 6));
		System.out.println(obj.idx(3, 7));
		System.out.println(obj.idx(3, 8));
		System.out.println(obj.idx(3, 9));
		System.out.println(obj.idx(3, 10));
		System.out.println(obj.idx(3, 11));
		System.out.println(obj.idx(3, 12));
		System.out.println(obj.idx(3, 13));
		System.out.println(obj.idx(3, 14));
		System.out.println(obj.idx(3, 15));
		System.out.println(obj.simplestSum(2, 1, 10000));//74260636
		System.out.println(obj.simplestSum(3, 1, 10000));//38637504
		System.out.println(obj.simplestSum(4, 1, 10000));//40987560
		System.out.println(obj.simplestSum(5, 1, 10000));//32922750
	}

}
