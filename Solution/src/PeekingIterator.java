import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    Integer curr = null;
    Iterator<Integer> my_iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    my_iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(curr != null)
            return curr;
        if(my_iterator.hasNext()) {
        	curr = my_iterator.next();
        	return curr;
        }
        return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(curr != null){
            Integer res = curr;
            curr = null;
            return res;
        }
	    if(my_iterator.hasNext())
	    	return my_iterator.next();
	    return null;
	}

	@Override
	public boolean hasNext() {
	    if(curr != null)
            return true;
        return my_iterator.hasNext();
	}

    public static void main(String[] args) {
    	Integer[] arr = {1,2,3,4};
    	Integer[] arr2 = {0,1,1,2,2,1,1,2,0,1,0,2,0};
    	List<Integer> nums = Arrays.asList(arr);
    	List<Integer> nums2 = Arrays.asList(arr2);
    	Iterator itr = nums.iterator();
    	Iterator itr2 = nums2.iterator();
    	PeekingIterator obj = new PeekingIterator(itr);
    	PeekingIterator obj2 = new PeekingIterator(itr2);
    	System.out.println(obj.peek());
    	System.out.println(obj.next());
    	System.out.println(obj.peek());
    	System.out.println(obj.next());
    	System.out.println(obj.peek());
    	System.out.println(obj.next());
    }
}