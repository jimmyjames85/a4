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
		if (toAdd < data)
		{
			if (left == null)
				left = new BST(toAdd);
			else
				left.add(toAdd);
		}
		else
		{
			if (right == null)
				right = new BST(toAdd);
			else
				right.add(toAdd);
		}
	}

	
	//TODO
	private String toString(int tab)
	{

		String sTab = "";
		for (int i = 0; i < tab; i++)
			sTab += ".";

		String ret = sTab + data + "\n";

		if (left != null)
			ret += sTab + "." + left.toString(tab + 1) + "\n";
		else
			ret += sTab + "." + "()\n";

		if (right != null)
			ret = sTab + "." + right.toString(tab + 1) + "\n" + ret;
		else
			ret = sTab + "." + "()\n" + ret;

		return ret;

	}

	public String toString()
	{
		return this.toString(0);
	}

	public int size()
	{
		int rsize = 0;
		int lsize = 0;

		if (this.left != null)
			lsize = left.size();
		if (this.right != null)
			rsize = right.size();

		return rsize + lsize + 1;
	}

	public static BST buildBst(int[] list)
	{
		if (list.length < 0)
			return null;

		BST root = new BST(list[0]);
		for (int i = 1; i < list.length; i++)
			root.add(list[i]);

		return root;
	}

}
