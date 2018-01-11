import java.util.HashMap;
import java.util.Map;

public class FizzBuzz {
	public static class Pair<Key,Value> {
	    private Key key;
	    private Value value;

	    public Pair(Key key, Value value){
	        this.key = key;
	        this.value = value;
	    }
	}
	public void printFizzBuzz(int start, int end, Map<Integer, String> map) {
		int increment = (start < end) ? 1 : -1;
		int index = start;
		StringBuilder sb = new StringBuilder();
		while(true) {
			sb.setLength(0);
			for(int i : map.keySet())
				if(index % i == 0)
					sb.append(map.get(i));
			if(sb.length() == 0)
				sb.append("" + index);
			if(index == end) {
				System.out.println(sb.toString());
				break;
			}
			sb.append(", ");
			System.out.print(sb.toString());
			index += increment;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<>();
		map.put(3, "Fizz"); map.put(5, "Buzz"); map.put(7, "Fuzz"); map.put(9, "Bizz");
		FizzBuzz obj = new FizzBuzz();
		obj.printFizzBuzz(0, 10, map);
		obj.printFizzBuzz(20, 10, map);
	}

}
