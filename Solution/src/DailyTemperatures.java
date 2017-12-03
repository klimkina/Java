
public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		for(int i = 0; i < temperatures.length; i++) {
			res[i] = 0;
			for(int j = i + 1; j < temperatures.length; j++)
				if(temperatures[j] > temperatures[i]) {
					res[i] = j - i;
					break;
				}
					
		}
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		DailyTemperatures sol = new DailyTemperatures();
		int[] res = sol.dailyTemperatures(temperatures);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i] + ", ");
		}
	}

}
