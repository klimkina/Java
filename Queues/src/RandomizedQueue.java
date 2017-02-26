import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INITIAL_SIZE = 10;
    private int size = 0;
    private Item[] arr;
    
   public RandomizedQueue()                 // construct an empty randomized queue
   {
       arr = (Item[]) new Object[INITIAL_SIZE];
   }
   public boolean isEmpty()                 // is the queue empty?
   {
       return size == 0;
   }
   
   public int size()                        // return the number of items on the queue
   {
       return size;
   }
   public void enqueue(Item item)           // add the item
   {
       if (item == null)
           throw new java.lang.NullPointerException();
       if (size == arr.length)
           resize(size * 2);
       arr[size++] = item;
   }
   
   public Item dequeue()                    // remove and return a random item
   {
       if (size == 0)
           throw new NoSuchElementException();
       if (size == arr.length/4) 
           resize(arr.length/2);
       int i = StdRandom.uniform(size);
       
       Item rez = arr[i];
       arr[i] = arr[--size];
       return rez;
   }
   public Item sample()                     // return (but do not remove) a random item
   {
       if (size == 0)
           throw new java.util.NoSuchElementException();
       return arr[StdRandom.uniform(size)];
   }
   
   private void resize(int newsize)
   {
       Item[] arr1 = (Item[]) new Object[newsize];
       
       for (int i = 0; i < size; i++)
           arr1[i] = arr[i];
       
       arr = arr1;
   }
   
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   { 
       return new RandomizedQueueIterator(); 
   }
   
   private class RandomizedQueueIterator implements Iterator<Item>
   {
       private int current = 0;
       private Item[] arr1;
       public RandomizedQueueIterator()
       {
           arr1 = (Item[]) new Object[size];
           for (int i = 0; i < size; i++)
               arr1[i] = arr[i];
           StdRandom.shuffle(arr1);
       }
       public boolean hasNext() { return current < size; }
       public void remove() { throw new java.lang.UnsupportedOperationException(); }
       public Item next()
       {
           if (current >= size)
               throw new java.util.NoSuchElementException();
           return arr1[current++];
       }
   }
   public static void main(String[] args)   // unit testing
   {
    // Create an array list
       RandomizedQueue<String> test = new RandomizedQueue<String>();
       
       // add elements to the front of deque
       test.enqueue("C");
       test.enqueue("A");
       test.enqueue("E");
       test.enqueue("B");
       test.enqueue("D");
       test.enqueue("F");

       // Use iterator to display contents of test
       StdOut.print("Original contents of test: ");
       Iterator<String> itr = test.iterator();
       
       while (itr.hasNext()) {
          Object element = itr.next();
          StdOut.print(element + " ");
       }
       StdOut.println();
       
       // Use iterator to display contents of test
       StdOut.print("Remove: ");
       
       while (!test.isEmpty()) {
          Object element = test.dequeue();
          StdOut.print(element + " ");
       }
       StdOut.println();
       
   }
}
