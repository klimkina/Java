import java.util.Arrays;
import java.util.HashMap;

public class Codec {

    // Encodes a URL to a shortened URL.
	public static int minEatingSpeed(int[] piles, int H) {
		if(piles.length == H)
			return findMax(piles);
        double total = 0;
        for(int i = 0; i < piles.length; i++)
            total += piles[i];
        
        int K = (int)Math.ceil((total)/H);
        while (!eatAll (piles, H, K))
            K++;
        return K;
    }
    private static boolean eatAll(int[] piles, int H, int K)
    {
        int hours = 0;
        for (int i = 0; i < piles.length; i++)
            hours += (int)Math.ceil(((double)piles[i])/K);
        return hours <= H;
    }
    private static int findMax(int[] piles)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++)
            if( max < piles[i])
            	max = piles[i];
        return max;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
				
		System.out.println(minEatingSpeed(piles, 823855818));
	}

}
