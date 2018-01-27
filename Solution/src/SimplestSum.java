
public class SimplestSum {
	static int simplestSum(int k, int a, int b) {
        // Complete this function
		long sum = 0;
		long idx = 1;
		long next_idx = 1 + k;
		long count = k;
		long pow = k;
		long f = 1;
		while (count < a) {
			idx = next_idx;	
			f += idx;
			pow *= k;
			next_idx += pow;
			count += pow;
		}
		
		long prev_count = (b < count ? b : count);
		sum += f * (prev_count - a + 1);
		sum = sum % 1000000007;
		
		while (count < b) {
			
			idx = next_idx;		
			f += idx;
			pow *= k;
			count += pow;
			next_idx += pow;
			count = Math.min(b, count);
			sum += f * (count - prev_count);
			sum = sum % 1000000007;
			prev_count = count;
		}
		return (int)sum % 1000000007;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplestSum obj = new SimplestSum();
		System.out.println(obj.simplestSum(2, 1, 10000));//74260636
		System.out.println(obj.simplestSum(3, 1, 10000));//38637504
		System.out.println(obj.simplestSum(4, 1, 10000));//40987560
		System.out.println(obj.simplestSum(5, 1, 10000));//32922750
	}

}
