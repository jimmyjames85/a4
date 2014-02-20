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

	public static void main(String[] args)
	{
		int size = 15;

		int[] arr = randList(size, 20);

		ArrayList<Integer> increasingLeft = new ArrayList<Integer>();
		ArrayList<Integer> increasingRight = new ArrayList<Integer>();

		int lHighest = arr[0];
		increasingLeft.add(lHighest);
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] > lHighest)
			{
				lHighest = arr[i];
				increasingLeft.add(lHighest);
			}
		}

		int rHighest = 0;
		rHighest = arr[arr.length - 1];
		increasingRight.add(rHighest);
		for (int i = arr.length - 2; i >= 0 && rHighest < lHighest; i--)
		{
			if (arr[i] > rHighest)
			{
				rHighest = arr[i];
				increasingRight.add(rHighest);
			}
		}

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		System.out.println(new SortedList(arr));
		System.out.println();
		System.out.println(increasingLeft);
		System.out.println(increasingRight);
	}
}
