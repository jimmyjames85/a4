package coms311;

import java.util.ArrayList;
import java.util.Random;

public class Tester
{
	public static void main(String[] args)
	{
		int size = 10;
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			sortedList.add(i);

		Random rand = new Random(System.nanoTime());

		int[] randList = new int[size];
		for (int i = 0; i < size; i++)
		{
			int j = rand.nextInt(size - i);
			randList[i] = sortedList.remove(j);
		}

		BST bt = BST.buildBst(randList);
			
		System.out.println(bt);
		

	}
}
