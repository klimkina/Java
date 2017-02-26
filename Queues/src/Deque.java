import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    private class Node
    {
        private Item item;
        private Node next;
        private Node prev;
    }
    private Node first = null;
    private Node last = null;
    private int size = 0;
    
   public Deque()                           // construct an empty deque
   {
       
   }
   
   public boolean isEmpty()                 // is the deque empty?
   {
       return first == null && last == null;
   }
   
   public int size()                        // return the number of items on the deque
   {
       return size;
   }
   
   public void addFirst(Item item)          // add the item to the front
   {
       if (item == null)
           throw new java.lang.NullPointerException();
       Node oldfirst = first;
       first = new Node();
       first.item = item;
       first.next = oldfirst;
       first.prev = null;
       if (oldfirst != null)
           oldfirst.prev = first;
       if (last == null)
           last = first;
       size++;
   }
   
   public void addLast(Item item)           // add the item to the end
   {
       if (item == null)
           throw new java.lang.NullPointerException();
       Node oldlast = last;
       last = new Node();
       last.item = item;
       last.prev = oldlast;
       if (oldlast != null)
           oldlast.next = last;
       if (first == null)
           first = last;
       size++;
   }
   
   public Item removeFirst()                // remove and return the item from the front
   {
       if (first == null)
           throw new NoSuchElementException();
       Item item = first.item;
       first = first.next;
       if (first == null)
           last = null;
       else
           first.prev = null;
       size--;
       return item;
   }
   
   public Item removeLast()                 // remove and return the item from the end
   {
       if (last == null)
           throw new NoSuchElementException();
       Item item = last.item;
       last = last.prev;
       if (last == null)
           first = null;
       else
           last.next = null;
       size--;
       return item;
   }
   
   public Iterator<Item> iterator() { return new DequeIterator(); }
   private class DequeIterator implements Iterator<Item>
   {
       private Node current = null;
       public DequeIterator()
       {
           current = first;
       }
       public boolean hasNext() { return current != null; }
       public void remove() { throw new java.lang.UnsupportedOperationException(); }
       public Item next()
       {
           if (current == null)
               throw new java.util.NoSuchElementException();
           Item item = current.item;
           current = current.next;
           return item;
       }
   }
   
   
   public static void main(String[] args)   // unit testing
   {
       // Create an array list
       Deque<String> test = new Deque<String>();
       
       // add elements to the front of deque
       test.addFirst("C");
       test.addFirst("A");
       test.addFirst("E");
       test.addFirst("B");
       test.addFirst("D");
       test.addFirst("F");

       // Use iterator to display contents of test
       StdOut.print("Original contents of test: ");
       Iterator<String> itr = test.iterator();
       
       while (itr.hasNext()) {
          Object element = itr.next();
          StdOut.print(element + " ");
       }
       StdOut.println();
       
    // add elements to the end of deque
       test.addLast("C");
       test.addLast("A");
       test.addLast("E");
       test.addLast("B");
       test.addLast("D");
       test.addLast("F");

       // Use iterator to display contents of test
       StdOut.print("New contents of test: ");
       itr = test.iterator();
       
       while (itr.hasNext()) {
          Object element = itr.next();
          StdOut.print(element + " ");
       }
       StdOut.println();
       for (int i = 0; i < 6; i++)
           test.removeFirst();
       
       // Use iterator to display contents of test
       StdOut.print("After remove first contents of test: ");
       itr = test.iterator();
       
       while (itr.hasNext()) {
          Object element = itr.next();
          StdOut.print(element + " ");
       }
       StdOut.println();
       for (int i = 0; i < 6; i++)
           test.removeLast();
       
       // Use iterator to display contents of test
       StdOut.print("After remove last contents of test: ");
       itr = test.iterator();
       
       while (itr.hasNext()) {
          Object element = itr.next();
          StdOut.print(element + " ");
       }
       StdOut.println();
   }
}
