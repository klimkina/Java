import java.util.HashMap;

public class AnagramMappings {
	
	public int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < B.length; i++)
        	map.put(B[i], i);
        for(int i = 0; i < A.length; i++)
        	res[i] = map.get(A[i]);
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		AnagramMappings obj = new AnagramMappings();
		int[] res = obj.anagramMappings(A, B);
		for(int i = 0; i < A.length; i++)
			System.out.print(res[i] + " ");
	}

}
