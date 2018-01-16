import java.util.Arrays;

/*In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, 
 * except those cells in the given list mines which are 0. 
 * What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. 
 * If there is none, return 0.

 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 
 * along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. 
 * This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, 
 * only the relevant area of the plus sign is checked for 1s. 
*/
class Solution {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++)
        	Arrays.fill(matrix[i], 1);
        for(int i = 0; i < mines.length; i++)
        	matrix[mines[i][0]][mines[i][1]] = 0;
        int[][][] res = new int[N][N][4];
        countMax(res, matrix, N);
        int max = 0;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		if(matrix[i][j] == 1) {
        			int curr = Integer.MAX_VALUE;
	        		for(int k = 0;k < 4;k++){
	        			curr = Math.min(curr, res[i][j][k]);
	        		}
        			if(curr > max)
        				max = curr;
        		}
        
        return max;
    }
	
	private void countMax(int[][][] res, int[][] matrix, int N) {
		for (int i = 0; i < N; i++)
            for (int j=0; j < N; j++) 
                if (matrix[i][j] == 1) {
                    res[i][j][0] = (j == 0 ? 1 : res[i][j-1][0] + 1);//left
                    res[i][j][1] = (i == 0 ? 1 : res[i-1][j][1] + 1);//up
                }
        for (int i = N-1; i >= 0; i--)
            for (int j = N-1; j >= 0; j--) 
                if (matrix[i][j] == 1) {
                	res[i][j][2] = (j == N-1 ? 1 : res[i][j+1][2] + 1);//right
                	res[i][j][3] = (i == N-1 ? 1 : res[i+1][j][3] + 1);//down
                }
	}
    
    public static void main(String[] args) {   	
    	Solution obj = new Solution();
    	int[][] mines = {{4,2}};
    	System.out.println(obj.orderOfLargestPlusSign(5, mines));
    }
}