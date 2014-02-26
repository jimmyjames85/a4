package coms311;

import java.util.ArrayList;

//MIN HEAP
public class BinaryHeap<E extends Comparable<? super E>>
{

	/*
	 * If a node's index is i, its children's indices are 2i+1 and 2i+2, and its
	 * parent's index is floor((i-1)/2).
	 * 
	 * No child has a key that is smaller than its parent's key
	 */

	private ArrayList<E> theHeap;

	public BinaryHeap()
	{
		theHeap = new ArrayList<E>();
	};

	public BinaryHeap(E[] list)
	{
		theHeap = new ArrayList<E>();

		// copy data to our arrayList
		for (int i = 0; i < list.length; i++)
			theHeap.add(list[i]);

		// now we heapify by starting with the last internal node and
		// percolating down and continuing to do do this until we get to the
		// node
		int curNode = (theHeap.size() - 2) / 2 + 1;
		while(curNode>=0)
			percolateDown(curNode--);
		
	}

	public E peek()
	{
		if (theHeap.isEmpty())
			return null;
		else
			return theHeap.get(0);
	}

	public void add(E elem)
	{
		int loc = theHeap.size();
		theHeap.add(elem);
		percolateUp(loc);
	}

	private void percolateUp(int x)
	{
		E theItem = theHeap.get(x);

		int parent = (x - 1) / 2;
		while (parent != x && theItem.compareTo(theHeap.get(parent)) < 0)
		{

			theHeap.set(x, theHeap.get(parent));
			x = parent;
			parent = (x - 1) / 2;
		}
		theHeap.set(x, theItem);
	}

	private void percolateDown(int x)
	{
		E pdown = theHeap.get(x);

		boolean foundIt = false;
		while (!foundIt)
		{
			int leftChild = 2 * x + 1;
			int rightChild = leftChild + 1;

			// assume we have two children
			int smallestChild = rightChild;

			// right child doesn't exist
			if (rightChild >= theHeap.size())
				smallestChild = leftChild;

			// no children
			if (leftChild >= theHeap.size())
				smallestChild = -1;

			// we have no children
			if (smallestChild == -1)
				foundIt = true;
			// we have two children
			else if (smallestChild == rightChild)
				smallestChild = theHeap.get(leftChild).compareTo(theHeap.get(rightChild)) < 0 ? leftChild : rightChild;
			// else smallestChild = leftChild

			if (!foundIt && pdown.compareTo(theHeap.get(smallestChild)) > 0)
			{
				theHeap.set(x, theHeap.get(smallestChild));
				x = smallestChild;
			}
			else
				foundIt = true;
		}

		theHeap.set(x, pdown);
	}

	public E remove()
	{
		if (theHeap.size() == 0)
			return null;
		else if (theHeap.size() == 1)
			return theHeap.remove(0);

		E ret = theHeap.get(0);
		E pdown = theHeap.remove(theHeap.size() - 1);
		theHeap.set(0, pdown);
		percolateDown(0);
		return ret;
	}

	public boolean isEmpty()
	{
		return theHeap.isEmpty();
	}

	public String toString()
	{
		String ret = "";

		for (int i = 0; i < theHeap.size(); i++)
			ret += theHeap.get(i) + " ";

		return ret;
	}

}
