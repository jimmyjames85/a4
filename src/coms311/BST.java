package coms311;

public class BST
{
	int data;
	BST left, right; 
	public BST(int d)
	{
		data = d;
		left = null;
		right = null;
	}
	
	
	public void add(int toAdd)
	{
		if(toAdd<data)
		{
			if(left==null)
				left = new BST(toAdd);
			else 
				left.add(toAdd);
		}
		else 
		{
			if(right==null)
				right = new BST(toAdd);
			else
				right.add(toAdd);
		}
	}
	
	public static BST buildBst(int [] list)
	{
		if(list.length<0)
			return null;
		
		
		BST root = new BST(list[0]);
		for(int i=1;i<list.length;i++)
			root.add(list[i]);

		return root;
	}

}
