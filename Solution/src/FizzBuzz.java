import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
	
	public void printFizzBuzz() {
		IntStream in = IntStream.range(1, 50);
		String text = in.mapToObj(i -> (i%15 == 0 ? "FizzBuzz" : 
										(i%3 == 0 ? "Fizz" : 
										(i%5 == 0 ? "Buzz" :
										((Integer) i).toString()))))
			    .collect(Collectors.joining(", "));
			System.out.println(text);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FizzBuzz obj = new FizzBuzz();
		obj.printFizzBuzz();
	}

}
