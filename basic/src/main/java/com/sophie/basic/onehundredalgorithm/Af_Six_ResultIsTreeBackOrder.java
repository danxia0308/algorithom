package com.sophie.basic.onehundredalgorithm;

public class Af_Six_ResultIsTreeBackOrder
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		int[] array = {5,7,6,9,11,10,8};
		System.out.println(resultIsTreeBackOrder(array,0,array.length-1));
		int[] array2 = {5,7,6,8,8,8,8};
		System.out.println(resultIsTreeBackOrder(array2,0,array2.length-1));
		int[] arrayFalse = {7,4,6,5};
		System.out.println(resultIsTreeBackOrder(arrayFalse,0,arrayFalse.length-1));
	}
	
	/**
	 * 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。
	 * 分析：最后一个数为根节点，除去根节点的数组中，分为两部分，前半部分比根节点小，后部分不比根节点小。
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	static boolean resultIsTreeBackOrder(int[] array, int start, int end)
	{
		if (end-start <= 1)
		{
			return true;
		}
		
		int firstGreater = -1;
		for(int i=start; i<end; i++)
		{
			if (array[i] > array[end])
			{
				firstGreater = i;
				break;
			}
		}
		if (firstGreater != -1)
		{
			for(int i=firstGreater; i<end;i++)
			{
				if (array[i] < array[end])
				{
					return false;
				}
			}
		}
		else
		{
			return resultIsTreeBackOrder(array, start, end-1);
		}
		
		return resultIsTreeBackOrder(array, start, firstGreater-1) && resultIsTreeBackOrder(array, firstGreater, end-1);
	}

}
