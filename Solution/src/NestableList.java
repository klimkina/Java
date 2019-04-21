import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/*
List<Object> a = new NestableList<Object>();
List<Object> b = new NestableList<Object>();
a.add("Hello");
a.add("world");
a.add(b);
b.add("foo");
b.add(“Mila”);
b.add(a);

System.out.println(a.toString());
[Hello, world, [foo,Mila,*]]
*/
public class NestableList<T> implements List<T> {
  Iterator<T> iter = this.iterator();

  @Override
  public String toString() {
    // your code here
	Set<String> printed = new HashSet<>();
	return helper(printed);
  }
  private String helper(Set<String> printed)   
  {
	if (iter.hasNext())
	{
	    StringBuilder sb = new StringBuilder();
		sb.append('[');
		while (iter.hasNext())
		{
			T obj = iter.next();
			if (obj instanceof NestableList) 
			{
				if (printed.contains(obj.getId()))
					sb.append("*");
				else
				{
					printed.add(((Object) obj).getId());
						sb.append(((NestableList)obj).helper(printed));
				}
			}
			else
				sb.append(obj.toString());
	           
		if (iter.hasNext())
				sb.append(",");
		}	
		sb.append("]");
		return sb.toString();
	}
	return "";

  }
@Override
public boolean add(T e) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void add(int index, T element) {
	// TODO Auto-generated method stub
	
}
@Override
public boolean addAll(Collection<? extends T> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean addAll(int index, Collection<? extends T> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void clear() {
	// TODO Auto-generated method stub
	
}
@Override
public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public T get(int index) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int indexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public ListIterator<T> listIterator() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public ListIterator<T> listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public T remove(int index) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public T set(int index, T element) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public List<T> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}

  
}


