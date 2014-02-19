package coms311;

import java.util.ArrayList;

public class HeapOnSortedLists
{

	/*
	 * If a node's index is i, its children's indices are 2i+1 and 2i+2, and its
	 * parent's index is floor((i-1)/2).
	 * 
	 * No child has a key that is smaller than its parent's key
	 */

	private ArrayList<SortedList> theHeap;

	public HeapOnSortedLists()
	{
		theHeap = new ArrayList<SortedList>();
	};

	public int peek()
	{
		if (theHeap.isEmpty())
			throw new Error("Heap is empty");
		else
			return theHeap.get(0).peek();
	}

	public void add(SortedList elem)
	{
		int loc = theHeap.size();
		theHeap.add(elem);
		percolateUp(loc);
	}

	private void percolateUp(int x)
	{
		SortedList theItem = theHeap.get(x);

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
		SortedList theItem = theHeap.get(x);

		boolean foundIt = false;
		while (!foundIt)
		{
			int leftChild = 2 * x + 1;
			int rightChild = leftChild + 1;
			
			//assume we have two children
			int smallestChild = rightChild;
			
			//right child doesn't exist
			if(rightChild>=theHeap.size())
				smallestChild = leftChild;
			
			//no children
			if(leftChild>=theHeap.size())
				smallestChild = -1;
			
			//Now to make our swaps
			
			//if we have no children then we found if
			if(smallestChild==-1)
				foundIt=true;
			//else if we have two children figure out which of the two is the smallest
			else if(smallestChild==rightChild)
				smallestChild = theHeap.get(leftChild).compareTo(theHeap.get(rightChild)) < 0 ? leftChild : rightChild;
			//otherwise the smallest child will be the leftchild due to heap's data structure
			
			if(!foundIt && theItem.compareTo(theHeap.get(smallestChild))>0)
			{
				theHeap.set(x, theHeap.get(smallestChild));
				x = smallestChild;
			}
			else
				foundIt = true;
		}
		theHeap.set(x, theItem);
	}
	
	
	public int remove()
	{
		if(theHeap.isEmpty())
			throw new Error("the heap is empty");

		SortedList root = theHeap.get(0); 
		int ret = root.pop();

		if(root.isEmpty())
		{
			SortedList newRoot = theHeap.remove(theHeap.size()-1);
			if(newRoot==root)
				return ret;//We have a completely empty heap
			
			theHeap.set(0, newRoot);
			percolateDown(0);
		}
		else
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
