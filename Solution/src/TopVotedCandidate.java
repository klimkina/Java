import java.util.TreeMap;

public class TopVotedCandidate {
	private TreeMap<Integer, Integer> tree = new TreeMap<>();
	public TopVotedCandidate(int[] persons, int[] times) {
        int[] winners = new int[persons.length];
        int max = -1;
        for (int i = 0; i < times.length; i++)
        {
        	winners[persons[i]]++;
        	if (max == -1 || winners[persons[i]] >= winners[max])
        		max = persons[i];
        	tree.put(times[i], max);
        }
    }
    
    public int q(int t) {
        return tree.get(tree.floorKey(t));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] persons = {0,1,1,0,0,1,0};
		int[] times = {0,5,10,15,20,25,30};
		TopVotedCandidate can = new TopVotedCandidate(persons, times);
		System.out.println(can.q(3));
		System.out.println(can.q(12));
		System.out.println(can.q(25));
		System.out.println(can.q(15));
		System.out.println(can.q(24));
		System.out.println(can.q(8));		
		
	}

}
