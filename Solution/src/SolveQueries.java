import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class SolveQueries {
	int[] a;
	SolveQueries(int[] a) {
		this.a = a.clone();
	}
	public void set(int i, int j, int x) {
		Arrays.fill(a, i-1, j, x);
	}
	private long multiplyRange(int i, int j) {
		long res = 1;
		for(int start = i; start < j; start++)
			res *= a[start];
		return res;
	}
	public int ask(int i, int j, int k, int l, int m) {
		if(i > k && j < l)
			return -1;
		long res = 1;
		long bottom = 1;
		
		if (i < k) 
			res *= multiplyRange(i-1, Math.min(j, k-1));
		else 
			bottom *= multiplyRange(k-1, Math.min(l, i-1));
		
		res *= multiplyRange(Math.max(i-1,l), j);			
		bottom *= multiplyRange(Math.max(j,k-1), l);
		
		if(res % bottom > 0)
			return -1;
		else
			return (int)(res / bottom % m);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        SolveQueries obj = new SolveQueries(A);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            // Write Your Code Here
            int type = in.nextInt();
            if(type == 1) // set
            	obj.set(in.nextInt(),in.nextInt(),in.nextInt());
            else // ask
            	System.out.println(obj.ask(in.nextInt(), in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
        }
        in.close();
		// TODO Auto-generated method stub

	}

}
