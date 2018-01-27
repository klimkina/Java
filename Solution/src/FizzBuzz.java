import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
	
	public void printFizzBuzz() {
		String text = IntStream.range(1, 50).mapToObj(i -> (i%15 == 0 ? "FizzBuzz" : 
										(i%3 == 0 ? "Fizz" : 
										(i%5 == 0 ? "Buzz" :
										(i + "")))))
			    .collect(Collectors.joining(", "));
		System.out.println(text);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FizzBuzz obj = new FizzBuzz();
		obj.printFizzBuzz();
	}

}
