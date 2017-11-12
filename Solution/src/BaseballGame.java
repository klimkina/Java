
public class BaseballGame {
	public int calPoints(String[] ops) {
		int res = 0;
		int[] rounds = new int[ops.length];
		int i = 0;
		for(String str : ops){
			if(str.equals("C")) {
				i--;
				if (i > 0)
					res -= rounds[i];	
				i--;
			}
			else if(str.equals("D")) {
				if (i > 0)
					rounds[i] = 2 * rounds[i - 1];
				res += rounds[i];
			}
			else if(str.equals("+")) {
				if (i > 1)
					rounds[i] = rounds[i - 1] + rounds[i - 2];
				res += rounds[i];
			}
			else {
				rounds[i] = Integer.parseInt(str);
				res += rounds[i];
			}
			i++;
		}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseballGame sol = new BaseballGame();
		String[] game = {"5","-2","4","C","D","9","+","+"};
		System.out.println(sol.calPoints(game));

	}

}
