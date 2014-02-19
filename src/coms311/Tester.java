package coms311;

import java.util.ArrayList;
import java.util.Random;

public class Tester
{
	
	
	public static int[] randList(int n, int max)
	{
		int[] randList = new int[n];
		Random rand = new Random (System.nanoTime());

		for(int i=0;i<randList.length;i++)
			randList[i] = rand.nextInt(max);
		
		return randList;
	}
	
	public static int[] randList(int n)
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
		HeapOnSortedLists hosl = new HeapOnSortedLists();
		
				
		int[] r = randList(9);
		for(int i=0;i<r.length;i++)
			hosl.add(new SortedList(randList(9,90)));
	
		
		while(!hosl.isEmpty())
			System.out.print(hosl.remove()+" ");
		

	}
}
