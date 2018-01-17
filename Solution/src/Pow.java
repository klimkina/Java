
public class Pow {
	public double myPow(double x, int n) {
        if(n == 0)
        	return 1;
        if(n == 1)
        	return x;
        if (n == -1)
        	return 1/x;
        double temp = myPow(x, n/2);
        return temp*temp*(n%2 == 1 || n%2 == -1 ? (n > 0? x : 1/x) : 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow obj = new Pow();
    	System.out.println(obj.myPow(34.00515,
    			-3));
	}

}
