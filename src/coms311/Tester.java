package coms311;

import java.util.ArrayList;
import java.util.Random;

public class Tester
{
	
	public int[] randList(int n)
	{

		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		for (int i = 0; i < n; i++)
			sortedList.add(i);

		Random rand = new Random(System.nanoTime());
		int[] randList = new int[n];
		for (int i = 0; i < n; i++)
		{
			int j = rand.nextInt(n - i);
			randList[i] = sortedList.remove(j);
		}
		
		return randList;
	}
	
	public static void main(String[] args)
	{
		int[] list = {0,1,2,3,4,5};
		
		ArrayList<Integer> sortedList = new ArrayList<Integer>();


		BST bt = BST.buildBst(list);
		
		System.out.println(bt.toString());
		
		bt.add(6);
			
		//System.out.println(bt);
		

	}
}
