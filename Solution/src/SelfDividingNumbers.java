import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		for(int i = left; i <= right; i++) {
			if(checkSelfDivision(i))
				res.add(i);
		}
        return res;
    }
	public boolean checkSelfDivision(int num) {
		boolean res = true;
		int temp = Math.abs(num);
		int single = 0;
		while(temp > 0) {
			single = temp%10;
			if(single == 0)
				return false;
			if(num%single != 0)
				return false;
			temp = temp/10;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22};
		SelfDividingNumbers obj = new SelfDividingNumbers();
		List<Integer> output = obj.selfDividingNumbers(1, 22);
		Iterator<Integer> itr = output.iterator();
		for(int i = 0; i < res.length; i++) {
			Integer temp = itr.next();
			if(!temp.equals(res[i]))
				System.out.println("Error!");
			System.out.println(temp + ", ");
		}

	}

}
