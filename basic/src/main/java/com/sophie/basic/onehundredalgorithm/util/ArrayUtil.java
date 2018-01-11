package com.sophie.basic.onehundredalgorithm.util;

public class ArrayUtil
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static void printArray(int[] array)
	{
		int size = array.length;
		for (int i=0; i<size; i++)
		{
			System.out.print(array[i]);
			if (i < size -1)
			{
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
