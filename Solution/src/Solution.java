import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int size = 0;
        int[] union = new int[m * n +1]; 
        for (int i = 0; i < positions.length; i++)
        {
            int pos = positions[i][0]*n + positions[i][1] + 1;
            add(pos, union);
            size++;
            if (pos - n > 0 && union[pos-n] > 0)
                size += connect(pos, pos-n, union);
            if (pos + n <= m*n && union[pos + n] > 0)
                size += connect(pos, pos+n, union);
            if (positions[i][1] < n-1 && union[pos + 1] > 0)
                size += connect(pos, pos+1, union);
            if (positions[i][1] > 0 && union[pos - 1] > 0)
                size += connect(pos, pos-1, union);
            res.add(size);
        }
        return res;
    }
    private void add(int pos, int[] union)
    {
        union[pos] = pos;
    }
    private int connect(int pos1, int pos2, int[] union)
    {
    	int par1 = find(pos1, union);
    	int par2 = find(pos2, union);
        if (par1 != par2)
        {
            union[par1] = par2;            
            return -1;
        }
        return 0;
    }
    private int find(int pos, int[] union)
    {
        while (union[pos] != pos)
        {
        	union[pos] = union[union[pos]];
            pos = union[pos];
        }
        return pos;
    }
	
	public static void main(final String[] args) {
		//System.out.print(recoverFromPreorder("1-2--3---4-5--6---7"));
	}
}
