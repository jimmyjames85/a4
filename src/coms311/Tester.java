package coms311;

import java.util.ArrayList;
import java.util.Random;

public class Tester
{

	public static int[] randList(int n, int max)
	{
		int[] randList = new int[n];
		Random rand = new Random(System.nanoTime());

		for (int i = 0; i < randList.length; i++)
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

	public static void testHashTableChain()
	{
		HashTableChained htc = new HashTableChained(9);
		int arr[] = {0,39,7,12,42,4,17,13,3};
		for(int i=0;i<arr.length;i++)
			htc.put(arr[i],arr[i]);
		
		System.out.println(htc.toString());
	}

	public static void main(String[] args)
	{

		testHashTableChain();
		
	}
}
