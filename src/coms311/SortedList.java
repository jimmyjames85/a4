package coms311;

public class SortedList implements Comparable<SortedList>
{

	private int[] data;
	private int itr;

	public SortedList(int[] unsortedList)
	{
		data = new int[unsortedList.length];

		for (int i = 0; i < unsortedList.length; i++)
			data[i] = unsortedList[i];
		
		mergeSort(data, 0, data.length - 1);
		itr = 0;

	}

	private void mergeSort(int[] arr, int left, int right)
	{
		if (left >= right)
			return;
		else if (left +1 == right )
		{
			if (arr[left] > arr[right])
			{
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
			return;
		}

		int mid = (right + left) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		
		
		// COMBINE
		int[] tmp = new int[right - left + 1];
		int k = 0;
		int i = left;
		int j = mid + 1;

		while (i <= mid && j <= right)
		{
			if (arr[i] <= arr[j])
			{
				tmp[k]= arr[i];
				k++;
				i++;
			}
			else
			{
				tmp[k] = arr[j];
				k++;
				j++;
			}
		}

		while (i <= mid)
			tmp[k++] = arr[i++];
		while (j <= right)
			tmp[k++] = arr[j++];

		for (i = 0; i < tmp.length; i++)
			arr[left++] = tmp[i];

		// END COMBINE
	}

	public boolean isEmpty()
	{
		return itr == data.length;
	}

	public int pop()
	{
		return data[itr++];
	}

	@Override
	public int compareTo(SortedList o)
	{
		return data[itr] - o.data[o.itr];
	}
	
	public int peek()
	{
		if(isEmpty())
			throw new Error("emtpy sorted list");

		return data[itr];
	}

	public String toString()
	{
		String ret = "[ ";

		for (int i = itr; i < data.length; i++)
			ret += data[i] + " ";
		
		ret += "]";

		return ret;
	}

}
