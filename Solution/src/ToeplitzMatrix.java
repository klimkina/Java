
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return false;
        for(int i = 0; i < matrix.length; i++) {
        	if(!check(matrix, i, 0) || !check(matrix, 0, i))
        		return false;     		
        }
        return true;
    }
	private boolean check(int[][] matrix, int row_start, int col_start) {
		for(int i = 0; i < matrix.length; i++) {
			int row = row_start + i;
			int col = col_start + i;
			if(row > matrix.length -1 || col > matrix.length - 1)
				break;
			if(matrix[row][col] != matrix[row_start][col_start])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		ToeplitzMatrix obj =  new ToeplitzMatrix();
		System.out.print(obj.isToeplitzMatrix(matrix));
	}

}
