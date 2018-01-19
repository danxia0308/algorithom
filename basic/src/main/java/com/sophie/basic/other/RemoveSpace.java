package com.sophie.basic.other;

public class RemoveSpace
{

	public static void main(String[] args)
	{
		test();
	}

	static void test()
	{
		String str = "It   is a girl! ";
		String result = removeSpaces(str);
		System.out.println(result);
		System.out.println(result.length());
	}
	
	static String removeSpaces(String str)
	{
		if (str == null || str.isEmpty())
			return str;
		char[] array = str.toCharArray();
		int current = 0;
		int nextUnSpace = 0;
		while (nextUnSpace < array.length)
		{
			if (array[nextUnSpace] == ' ')
			{
				while (nextUnSpace < array.length && array[nextUnSpace] == ' ')
				{
					nextUnSpace++;
				}
				if (nextUnSpace < array.length)
				{
					array[current++] = ' ';
				}
			}
			
			if (nextUnSpace < array.length)
			{
				array[current++] = array[nextUnSpace++];
			}
		}
		
		return String.copyValueOf(array, 0, current);
	}
}
