/*Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
*/
class Solution {
	public int countPrimeSetBits(int L, int R) {
		int res = 0;
		for(int i = L; i <= R; i++)
			if(isPrime(countBits(i)))
				res++;
        return res;
    }
	private int countBits(int num) {
		int res = 0;
		while(num != 0) {
			if((num&1) != 0)
				res++;
			num >>>= 1;
		}
		return res;
	}
	private boolean isPrime(int num) {
		if(num < 2) return false;
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
    
    public static void main(String[] args) {   	
    	Solution obj = new Solution();
    	System.out.print(obj.countPrimeSetBits(6, 10));
    }
}