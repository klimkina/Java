/*Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
	/** Initialize your data structure here. */
	private HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean res = set.contains(val);
        set.add(val);
        return !res;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	boolean res = set.contains(val);
        set.remove(val);
        return res;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random rand = new Random();
    	int idx = rand.nextInt(set.size());
    	List asList = new ArrayList(set);
    	Collections.shuffle(asList);
    	return (int)asList.get(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Init an empty set.
		RandomizedSet randomSet = new RandomizedSet();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomSet.insert(1);

		// Returns false as 2 does not exist in the set.
		randomSet.remove(2);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 2 is the only number in the set, getRandom always return 2.
		randomSet.getRandom();

	}

}
