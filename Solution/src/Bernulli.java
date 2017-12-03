import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bernulli {
	public static class Fraction {
		int dividend,divider;//dividend/divider
		Fraction(){
			dividend=0;
		}
		
		public Fraction(int dividend, int divider) {
			init(dividend,divider);
		}

		public Fraction(int dividend) {
			init(dividend,1);
		}

		public void init(int dividend, int divider){
			this.dividend=dividend;
			this.divider=divider;
		}
		
		public String specialString(boolean latex){
			String s=dividend>=0?"+":"-";
			
			if(divider==1){
				s+= Math.abs(dividend)==1 ? "" : dividend ;
			}
			else{
				s+=String.format(latex?"\\frac{%d}{%d}":"%d/%d", Math.abs(dividend),divider);
			}
			return s;
		}

		public boolean equalsZero() {
			return dividend==0;
		}

		public void normilize() {
			if(divider==1){
				return;
			}
			
			if(dividend==0){
				divider=1;
				return;
			}
			
			int g=gcd(Math.abs(dividend),Math.abs(divider));
			if(g!=1){
				dividend/=g;
				divider/=g;
			}
		}
		
		public int gcd(int num1, int num2){
			int pof2, tmp;
		  if (num1==0 || num2==0) {
		  	return (num1 | num2);
		  }
		 
		    /* pof2 is the greatest power of 2 deviding both numbers . We will use pof2 to multiply the returning number . */
		  pof2 = 0;
		  while((num1 & 1)==0 && (num2 & 1)==0) {
		  	/* gcd(even1, even1) = pof2 * gcd(even1/pof2, even2/pof2) */
		    num1 >>=1;
		    num2 >>=1;
		    pof2++;
		  }
		 
		  do {
		    while ((num1 & 1)==0) {
		      num1 >>=1;
		    }
		    while ((num2 & 1)==0) {
		      num2 >>=1;
		    }
		    /* At this point we know for sure that num1 and num2 are odd */
		    if (num1 >= num2) {
		      num1 = (num1 - num2) >> 1;
		    }
		    else {
		      tmp = num1;
		      num1 = (num2 - num1) >> 1;
		      num2 = tmp;
		    }
		  }while (!(num1 == num2 || num1 == 0));
		 
		  return (num2 << pof2);
		}

		public double toDouble() {
			return ((double)(dividend))/divider;
		}

		public Fraction mul(int dividend, int divider) {
			Fraction f=new Fraction(dividend*this.dividend,divider*this.divider);
			f.normilize();
			return f;
		}

		//*this-=fraction
		public void subEqual(Fraction fraction) {
			dividend = dividend*fraction.divider-divider*fraction.dividend;
			divider *= fraction.divider;
			normilize();
		}

	}
	private static Fraction f[];//f^0*n+f[1]*n^2+...+f[power]*n^{power+1} // f[i-1]*n^i , f[i]*n^{i+1}

	
	public static void makeCoef(int power){
		f=new Fraction[power+1];
		f[0] = new Fraction(1);
		
		if(power<=0){
			return;
		}
		
		int i,j;
		for(i=1; i<=power; i++){
			f[i]=new Fraction();
		}
		
		for(i=1; i<=power; i++){
			
			for(j = i-1; j>=0; j--){//f[j]*n^[j+1] -> (n^{j+2}-n)/(j+1)
				f[j+1]=f[j].mul(i, j+2);
			}
			
			f[0]=new Fraction(1);
			for(j=1; j<=i; j++){
				f[0].subEqual(f[j]);
			}
			
		}
	}
	
	
	public static int count(int power, long v){
		double r = 0;
		for(int i = power; i > -1; i--){
			r = r*v + f[i].toDouble();
		}
		return ((int)(r*v)%10000009);
	}
	
	

    static int highwayConstruction(long n, int k) {
        // Complete this function
    	makeCoef(k);
    	return (count(k, n-1) - 1);
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int q = in.nextInt();
        //for(int a0 = 0; a0 < q; a0++){
       //     long n = in.nextLong();
       //     int k = in.nextInt();
            int result = highwayConstruction(4, 2);
            System.out.println(result);
       // }
      //  in.close();
    }
}