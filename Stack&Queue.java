import java.text.*;
import java.util.concurrent.*;
import javax.xml.ws.*;
import java.util.*;

public class StackOfStrings {
	StackOfStrings(); //create an empty stack
	void push(String item); // insert a new string onto stack
	String pop(); // remove and return the string most recently added
	boolean isEmpty(); // is the stack empty?
	int size();
	
	public static void main(String[] args) 
	{
		StackOfStrings stack = new StackOfStrings();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("-")) {
				StdOut.print(stack.pop());
			else {
				stack.push(s);
			}
			}
		}
	}
	
	// linked list implementation
	private class Node{
		String item;
		Node next;
	}
	
	// save item to return
	String item = first.item;
	//delete first node
	first = first.next;
	return item;
	
	// save a link to the list 
	Node oldfirst = first;
	first = new Node();
	first.item = "not";
	first.next = oldfirst;
}



public class LinkedStackOfStrings
{
	private Node first = null;
	private class Node
	{
		String item;
		Node next;
	}
	public boolean isEmpty()
	{
		return first == null;
	}
	public void push(String item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public pop()
	{
		String item = first.item;
		first = first.next;
		return item;
	}
}

// array implementation

public class FixedCapacityStackOfStrings
{
	private String[] s;
	private int N = 0;
	
	public FixedCapacityStackOfStrings(int capacity)
	{
		s = new String[capacity];
	}
	public boolean isEmpty()
	{
		return N == 0;
	}
	public void push(String item)
	{
		s[N++] = item;
	}
	public String pop()
	{
		return s[--N];
	}
}



	public ResizingArrayStackOfStrings()
	{
		s = new String[1];
		
	}

	public void push(String item)
	{
		if(N == s.length) resize(2*s.length);
		s[N++] = item;
	}
	private void resize(int capacity)
	{
		String[] copy = new String[capacity];
		
		for(int i = 0; i<N; i++)
		{
			copy[i] = s[i];
		}
		s = copy;
		
	}
	public String pop()
	{
		String item = s[--N];
		s[N] = null;
		if(N > 0 && N == s.length/4) resize(s.length/2);
		return item;
	}
	


public class QueueOfStrings
{
	QueueOfStrings(); // create a new empty queue
	void enqueue(String item);
	String dequeue();
	boolean isEmpty();
	private Node first, last;
	//linked list 
	// maintain pointer to first and last nodes in a linked list 
	public boolean isEmpty()
	{
		return first == null;
	}
	private class Node
	{
		Stirng item;
		Node next;
	}
	public void enqueue(String item);
	{
		Node oldlast = last;
		Node last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
	}
	public String dequeue()
	{
		String item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}
	
	
}
	public void resize()
	{
		String[] copy = new String[];
		for(int i=head;i<tail;i++)
		{
			copy[i-head] = q[i];
		}
		q = copy;
		tail = tail - head;
		head = 0;
	}
	
	public void enqueue(String item)
	{
		if(tail == queue.length)
		{
			if(N<=queue.length/2) resize(queue.length);
			else resize(2*queue.length);
		}
		queue[tail++] = item;
		N++;
	}
	
	public String dequeue()
	{
		if(!isEmpty())
		{
			item = queue[head];
			queue[head++] = null;
			N--;
			if(n<size/4)
			{
				resize(queue.length/2);
			}
			return item;
		}
	}
	



