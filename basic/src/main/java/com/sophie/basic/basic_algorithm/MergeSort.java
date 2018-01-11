package com.sophie.basic.basic_algorithm;

import com.sophie.basic.onehundredalgorithm.util.ArrayUtil;

public class MergeSort
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		int[] array = { 3, 5, 10, 8, 7, 2, 8, 1, 20, 6 };
		mergeSort(array, 0, array.length-1);
		ArrayUtil.printArray(array);
	}
	
	/**
	 * 使用递归实现归并排序
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void mergeSort(int[] array, int start, int end)
	{
		if (start == end)
		{
			return;
		}
		
		int mid = (start+end)/2;
		
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		mergeArray(array, start, mid, end);
	}
	
	static void mergeArray(int[] array, int start, int mid, int end)
	{
		int size = end-start+1;
		int[] mergedArray = new int[size];
		int index = 0;
		int i = start;
		int j= mid+1;
		while(i <= mid && j<=end)
		{
			mergedArray[index++] = array[i] < array[j] ? array[i++] : array[j++];
		}
		
		while(i <= mid)
		{
			mergedArray[index++] = array[i++];
		}
		
		while(j <= end)
		{
			mergedArray[index++] = array[j++];
		}
		
		index = 0;
		while (index < size)
		{
			array[start++] = mergedArray[index++];
		}
	}

}
