
public class AlternatingBits {
	public boolean hasAlternatingBits(int n) {
		boolean[] ret = new boolean[31];
		boolean isAlt = true;
		boolean isZeroes = false;
	    for (int i = 0; i < 31; i++) {
	        ret[31 - 1 - i] = (1 << i & n) != 0;
	        if(i > 0 && !isZeroes)
	        	isAlt = ret[31 - 1 - i] != ret[31 - i];
	        if(!isAlt && !ret[31 - 1 - i] && !isZeroes) {
	        		isZeroes = true;
	        		isAlt = true;
	        }
	        else if (!isAlt || (isZeroes && ret[31 - 1 - i]))
	        	return false;
	    }
	    
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlternatingBits obj = new AlternatingBits();
		System.out.println(obj.hasAlternatingBits(10));
	}

}
