import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinStack {
	PriorityQueue<Integer> my_pq;
	private ArrayList<Integer> my_list;

	    /** initialize your data structure here. */
	    public MinStack() {
	    	my_list = new ArrayList<Integer>();
	    	my_pq = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
				@Override
				public int compare(Integer n1, Integer n2) {
					return Integer.compare(my_list.get(n1), my_list.get(n2));
				}
			});
	    }
	    
	    public void push(int x) {
	    	int min;
	    	my_list.add(x);
	    	my_pq.add(my_list.size()-1);
	    }
	    
	    public void pop() {
	    	my_pq.remove(my_list.size()-1);
	        my_list.remove(my_list.size()-1);
	    }
	    
	    public int top() {
	    	return my_list.get(my_list.size()-1).intValue();
	    }
	    
	    public int getMin() {
	        return my_list.get(my_pq.peek()).intValue();
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
		int param_3 = obj.top();
		int param_4 = obj.getMin();
	}

}
