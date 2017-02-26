import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DutchFlag {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Enter number of buckets!");
        int N = StdIn.readInt();
        char[] buckets = new char[N];
        int b = 0;
        int k = buckets.length - 1;
        for (int i = 0 ; i < buckets.length; i++) {
            buckets[i] = (char) ('0' + StdRandom.uniform(3));
        }
        for (int i = 0 ; i < buckets.length; i++) {
            StdOut.print(buckets[i]);
        }
        StdOut.println("!");
        int i = 0;
        int j = -1;
        
        while((i < buckets.length) && (i <= k)) {
            if(buckets[i] == '0') {
                if(j >= 0)
                {
                    buckets[i] = buckets[j];
                    buckets[j] = '0';
                    if (j < i )
                        j++;
                    else
                        j = -1;
                }
            }
            else if (buckets[i] == '1'){
                if ( j < 0)
                    j = i;
                i++;
            }
            else if (buckets[i] == '2')
            {
                while (buckets[k] == '2')
                    k--;
                if(k > i){
                    buckets[i] = buckets[k];
                    buckets[k] = '2';
                    k--;
                }
            }
        }
        for (i = 0 ; i < buckets.length; i++) 
            StdOut.print(buckets[i]);
        
    }

}
