package coms311;

public class HashTableChained
{

	private final static int TABLE_SIZE = 9;

	HashLink[] table;

	public HashTableChained()
	{
		table = new HashLink[TABLE_SIZE];
	}

	public void put(int key, int value)
	{
		int hash = key % TABLE_SIZE;

		if (table[hash] == null)
			table[hash] = new HashLink(key, value);
		else
		{
			HashLink entry = table[hash];
			while (entry.next != null && entry.key != key)
				entry = entry.next;
			
			if (entry.key == key)
				entry.value = value;
			else
				entry.next = new HashLink(key, value);
		}
	}

	public String toString()
	{

		String ret = "";

		for (int i = 0; i < 9; i++)
		{
			if (table[i] == null)
				ret += "[]";
			else
			{
				ret += "[";
				HashLink cur = table[i];
				while (cur != null)
				{
					ret += " " + cur.value;
					cur = cur.next;
				}

				ret += " ]";
			}

			ret += "\n";
		}
		return ret;
	}

	private class HashLink
	{
		private int value;
		private int key;
		private HashLink next;

		public HashLink(int key, int value)
		{
			this.key = key;
			this.value = value;
			next = null;
		}
	}

}
