package com.sophie.basic.onehundredalgorithm;

public class Bd_Seventeen_StringToInteger
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		
	}

	static int stringToInteger(String str)
	{
		if (str == null || str.isEmpty())
			return -1;
		
		char[] array = str.toCharArray();
		int length = array.length;
		
		int maxInt = Integer.MAX_VALUE;
		int digits = 0;
		while(maxInt != 0)
		{
			maxInt = maxInt/10;
			digits++;
		}
		
		maxInt = Integer.MAX_VALUE;
		if (length > digits)
			return -1;
		if (length == digits)
		{
			for (int i= length-1; i >= 0; i--)
			{
//				if (maxInt % 10)
			}
		}
		
		int result = 0;
		for (int i= length-1; i>=0; i--)
		{
			result = result*10 + array[i];
		}
		return result;
	}
}
