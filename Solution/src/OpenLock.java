import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenLock {
	private int[] memo = new int[10000];
	private int[] path_to = new int[10000];
	private int[] dead_ends;
	private int target_num;
	private List<Integer> q;
	public int openLock(String[] deadends, String target) {
		target_num = str2int(target);
		dead_ends = new int[deadends.length];
		for(int i = 0; i < deadends.length; i++)
			dead_ends[i] = str2int(deadends[i]);
		Arrays.fill(path_to, 99999);
		q = new ArrayList<>();
		q.add(0);
		path_to[0] = 0;
		int n;
		while(!q.isEmpty()) {
			n = q.remove(0);
			if(addNext(n))
				break;
		}
		if(q.isEmpty())
			return -1;
		int res = printPath();
        return res;
    }
	private int printPath() {
		int res = 0;
		int n = path_to[target_num];
		while(n != 0) {
			System.out.print("" + n + " ");
			n = path_to[n];
			res++;
		}
		System.out.println();
		return res;
	}
	private boolean addNext(int n) {
		int pow = 1;
		int temp = 0;
		int digit = 0;
		for(int i = 0; i < 4; i++) {
			temp = n / pow;
			digit = temp % 10;
			if(digit == 9)
				temp = n - 9*pow;
			else
				temp = n + pow;
			if(addNum(n, temp))
				return true;
			if(digit == 0)
				temp = n + 9*pow;
			else
				temp = n - pow;
			if(addNum(n, temp))
				return true;
			
			pow *= 10;
			
		}
		return false;
	}
	private boolean addNum(int n, int temp) {
		if(!check_deadend(temp) && path_to[temp] > 9999) {
			path_to[temp] = n;
			q.add(temp);
			if(temp == target_num)
				return true;
		}
		return false;
	}
	private boolean check_deadend(int n) {
		for(int i : dead_ends)
			if(n == i)
				return true;
		return false;
	}
	private int str2int(String s) {
		int res = 0;
		for(int i = 0; i < 4; i++)
			res = 10*res + (s.charAt(i) - '0');
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		OpenLock obj = new OpenLock();
    	System.out.println(obj.openLock(deadends, target));
	}

}
