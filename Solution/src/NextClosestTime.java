
public class NextClosestTime {
	public String nextClosestTime(String time) {
	    String[] timeVal = time.split(":"); 
	    int[] numbers = new int[4];
	    numbers[0] = Integer.parseInt(timeVal[0])/10;
	    numbers[1] = Integer.parseInt(timeVal[0])%10;
	    numbers[2] = Integer.parseInt(timeVal[1])/10;
	    numbers[3] = Integer.parseInt(timeVal[1])%10;
	    int[] res = new int[2];
	    
	    res[0] = Integer.parseInt(timeVal[0]);
	    res[1] = Integer.parseInt(timeVal[1]);
	    int[] mytime = res;
	    
	    while(true) {
	    	res = addMinute(res[0], res[1]);
	    	boolean matched = true;
	    	if(res[0] != mytime[0]) {
	    		if(res[0]/10 != mytime[0]/10)
	    			matched = isExist(numbers, res[0]/10, 0);
	    		if(res[0]%10 != mytime[0]%10)
	    			matched &= isExist(numbers, res[0]%10, 1);
	    	}
	    	if(res[1]/10 != mytime[1]/10)
    			matched &= isExist(numbers, res[1]/10, 2);
    		if(res[1]%10 != mytime[1]%10)
    			matched &= isExist(numbers, res[1]%10, 3);
    		if(matched)
    			return (res[0] < 10 ? "0" : "") + res[0] + ":" + (res[1] < 10 ? "0" : "") + res[1];
	    }
	    
	}
	private boolean isExist(int[] numbers, int num, int skip) {
		for(int i = 0; i < 4; i++) {
			if(i != skip && numbers[i] == num)
				return true;
		}
		return false;
	}
	private int[] addMinute(int hour, int minute) {
		int[] res = new int[2];
		res[0] = hour;
		res[1] = minute;
		res[1]++;
		if(res[1] > 59) {
			res[1] -= 60;
			res[0]++;
		}
		if(res[0] > 23)
			res[0] -=24;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextClosestTime sol = new NextClosestTime();
		System.out.println(sol.nextClosestTime("20:48"));
	}

}
