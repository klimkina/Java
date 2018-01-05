import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	int min;

    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<>();
    }
    
    public void push(int x) {
    	if(stack.isEmpty())
    		min = x;
    	stack.push(x-min);
    	min = Math.min(x, min);
    }
    
    public void pop() {
    	if(stack.isEmpty()) return;
    	int x = stack.pop().intValue();
    	if(x < 0) min -= x;
    }
    
    public int top() {
    	int x = stack.peek().intValue();
    	if(x > 0)
    		return stack.peek() + min;
    	return min;
    }
    
    public int getMin() {
        return min;
    }
	

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();
		obj.push(2);
		obj.push(3);
		obj.push(5);
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}

}
