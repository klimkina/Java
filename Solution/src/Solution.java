import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
	public static int[] sortedSquares(int[] A) {
        List<Integer> integers = Arrays.stream(A).boxed().collect(Collectors.toList());
		int[] res = integers.stream().map(x -> (x*x)).mapToInt(i -> i).toArray();
        Arrays.sort(res);
        return res;
    }
	
	public static void main(final String[] args) {
		int numCrates = 3;
	}
}
