
public class ReachNumber {
	public int reachNumber(int target) {
		int pos = 0;
        for(int i = 1;;i++){
        	pos += i;
        	if(Math.abs(target) <= pos && (pos - Math.abs(target)) % 2 == 0){
        		return i;
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 2;
		ReachNumber obj = new ReachNumber();
    	System.out.println(obj.reachNumber(target));
	}

}
