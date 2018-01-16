/* Given a 2D matrix matrix, find the sum of the elements inside the rectangle 
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/
class NumMatrix {
	private int[][] sums = null;
    public NumMatrix(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return;
    	sums = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
        	for(int j = 0; j < matrix[0].length; j++)
        		sums[i][j] = (i > 0 ? sums[i-1][j] : 0) + 
			        		(j > 0 ? sums[i][j-1] : 0) - 
			        		(i > 0 && j > 0 ? sums[i-1][j-1] : 0) + 
			        		matrix[i][j];
    }
    
    public void update(int row, int col, int val) {
    	if(sums != null && sums.length > 0 && sums[0].length > 0) {
	    	int diff = val - (sums[row][col] - 
	    			(col > 0 ? sums[row][col-1] : 0) - 
	    			(row > 0 ? sums[row -1][col] : 0) + 
	    			( row > 0 && col > 0 ? sums[row-1][col-1] : 0));
	    	for(int i = row; i < sums.length; i++)
	        	for(int j = col; j < sums[0].length; j++)
	        		sums[i][j] += diff;
    	}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(sums != null && sums.length > 0 && sums[0].length > 0)
    		return sums[row2][col2] - 
        		(row1 > 0 ? sums[row1-1][col2] : 0) - 
        		(col1 > 0 ? sums[row2][col1-1] : 0) + 
        		(row1 > 0 && col1 > 0 ? sums[row1-1][col1-1] : 0);
    	return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                {3, 0, 1, 4, 2},
		                {5, 6, 3, 2, 1},
		                {1, 2, 0, 1, 5},
		                {4, 1, 0, 1, 7},
		                {1, 0, 3, 0, 5}
		              };
		int[][] null_matrix = {{}};
		NumMatrix obj = new NumMatrix(null_matrix);
		System.out.println(obj.sumRegion(2, 1, 4, 3)); // -> 8
		obj.update(3, 2, 2);
		System.out.println(obj.sumRegion(2, 1, 4, 3)); // -> 10
	}

}
