import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyQue<T> implements Iterable<T>
{

	private Node<T> first;
	private Node<T> last;
	private int size;
	
	private static class Node<T>
	{
		private T item;
		private Node<T> next;
	}
	
	public MyQue()
	{
		first = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void clear()
	{
		first = null;
		last = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public T peek()
	{
		if(isEmpty()) throw new NoSuchElementException("ERROR: Empty");
		return first.item;
	}
	
	public void enque(T item)
	{
		Node<T> tempLast = last;
		last = new Node<T>();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
			first = last;
		else
			tempLast.next = last;
		size++;
		
	}
	
	public T deque()
	{
		if(isEmpty()) throw new NoSuchElementException("ERROR: Empty");
		T item = first.item;
		first = first.next;
		size--;
		if(isEmpty())
			last = null;
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {

		return new ListIterator<T>(first);
	}
	
	private class ListIterator<T> implements Iterator<T>
	{
		private Node<T> current;
		
		public ListIterator(Node<T> first)
		{
			current = first;
		}
		
		public boolean hasNext()
		{
			return current != null;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
		public T next()
		{
			if(!hasNext()) 
				throw new NoSuchElementException();
			
			T item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	public void addToQue(MyQue<T> que)
	{
		if(!que.isEmpty())
		{
			Node<T> tempFirst = first;
			
			if(isEmpty())
			{
				first = que.first;
				last = que.last;
			}
			else 
			{
				first = que.first;
				que.last.next = tempFirst;
			}
			
			size = size + que.size();
		}
	}

}
