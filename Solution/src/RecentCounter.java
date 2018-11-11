import java.util.TreeMap;

class RecentCounter {
    private TreeMap<Integer, Integer> tree = new TreeMap<>();
    private int counter = 0;
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        tree.put(t, counter++);
        int count = 0;
        if (tree.ceilingKey(t-3000) != null)
        	count = tree.ceilingEntry(t-3000).getValue();
        return counter - count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecentCounter rc = new RecentCounter();
		System.out.println(rc.ping(1));
		System.out.println(rc.ping(100));
		System.out.println(rc.ping(3001));
		System.out.println(rc.ping(3002));
		System.out.println(rc.ping(4152));
	}

}
