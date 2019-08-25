import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DinnerPlates {
	class PlateStack
    {
        int[] vals;
        int last = -1;
        PlateStack(int size)
        {
            vals = new int[size];
        }
        public boolean isFull()
        {
            return (last == vals.length - 1);
        }
        public boolean isEmpty()
        {
            return (last == - 1);
        }
        public int pop()
        {
            if (last == -1)
                return -1;
            return vals[last--];
        }
        public int push(int v)
        {
            if (last == vals.length - 1)
                return -1;
            vals[++last] = v;
            return last;
        }
    }
    List<PlateStack> plates = new ArrayList<>();
    int cap = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public DinnerPlates(int capacity) {
        cap = capacity;
    }
    
    public void push(int val) {
        if (pq.isEmpty())
        {
            PlateStack ps = new PlateStack(cap);
            ps.push(val);
            plates.add(ps);
            if (cap > 1)
                pq.offer(plates.size()-1);
        }
        else
        {
            int idx = pq.peek();
            plates.get(idx).push(val);
            if (plates.get(idx).isFull())
                pq.poll();
        }
    }
    
    public int pop() {
        if (plates.size() <= 0)
            return -1;
        int idx = plates.size() - 1;
        int val = plates.get(idx).pop();
        if (plates.get(idx).isEmpty())
        {
            plates.remove(idx);
            if (cap > 1)
                pq.remove(idx);
        }
        else if (plates.get(idx).last == cap - 2)
            pq.offer(idx);
        return val;
    }
    
    public int popAtStack(int index) {
        if (plates.get(index).isEmpty())
            return -1;
        int val = plates.get(index).pop();
        if (plates.get(index).last == cap - 2)
            pq.offer(index);
        return val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DinnerPlates obj = new DinnerPlates(2);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		System.out.println(obj.popAtStack(0));
		obj.push(20);
		obj.push(21);
		System.out.println(obj.popAtStack(0));
		System.out.println(obj.popAtStack(2));
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}

}
