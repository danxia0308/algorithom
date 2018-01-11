package com.sophie.basic.onehundredalgorithm;

import com.sophie.basic.basic_algorithm.MergeSort;
import com.sophie.basic.onehundredalgorithm.util.ArrayUtil;

public class Ae_Five_FindMinKElement
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		int[] array = {9,4,1,5,3,7,11,2,10,6};
		int[] result = findMinKElement(array, 1);
		ArrayUtil.printArray(result);
		ArrayUtil.printArray(findMinKElement(array,9));
	}
	
	/**
	 * 题目：输入n个整数，输出其中最小的k个。
	 * 分析：
	 * 	使用大小为k的辅助数组。
	 * 	先取前k个数放入辅助数组，并排序。从第k+1个数开始，如果比辅助数组的最后一个小，则插入排序好的数组中。
	 * 	复杂度为nk+klogk。如果最后一步使用最大堆或者红黑树，复杂度为nlogk。
	 * @param array
	 * @param k
	 * @return
	 */
	static int[] findMinKElement(int[] array, int k)
	{
		if (array == null || array.length <= k || k < 0)
		{
			return array;
		}
		
		int[] result = new int[k];
		
		for (int i=0; i<k; i++)
		{
			result[i] = array[i];
		}
		
 		MergeSort.mergeSort(result, 0, result.length-1);
		
		for(int i=k; i<array.length;i++)
		{
			if (array[i] >= result[k-1])
			{
				continue;
			}
			
			//将第i个元素插入到排序好的k个元素中，并删除k个元素中的最后一个。
			for(int j=k-1; j>=1;j--)
			{
				if (array[i] < result[j-1])
				{
					result[j] = result[j-1];
				}
				else
				{
					result[j] = array[i];
					break;
				}
			}
			
			if (k == 1)
			{
				result[k-1] = array[i];
			}
		}
		return result;
	}
}
