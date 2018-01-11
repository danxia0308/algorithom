package com.sophie.basic.onehundredalgorithm;

public class Ac_Three_SubListWithMaxSum
{

	public static void main(String[] args)
	{
		test();
	}
	
	private static void test()
	{
		int[] array= {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(getMaxSum(array)); // It should be 18
		
		int[] array1 = {-4,-1,0,-3,-6};
		System.out.println(getMaxSum(array1)); // It should be -1
	}
	
	/**
	 * 题目：输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。求所有子数组的和的最大值。要求时间复杂度为O(n)。
	 * 分析：此题分两种情况
	 * 1. 序列中有正数。
	 * 	最大值初始化为第一个值，从头到尾求加和，不断更新最大值。一旦和出现负数，则从零开始。因为前面序列为负数，肯定会减小后面序列之和，所以清零来寻找更大的子序列。
	 * 2. 序列中全部为负数。
	 * 在情况1列出的方法中，最大值初始化为第一个值，在循环求和中，先求和，再更新最大和，再判断清零。循环中的这个顺序，保证每次求和后都是当前数组第i个数值，也就转换成了数组求最大值。
	 * 优点：原文题解中对两种情况分别遍历。此方法通过调整循环内的次序，一次性解决了1和2两种情况。
	 * @return
	 */
	private static int getMaxSum(int[] array)
	{
		if (array == null || array.length == 0)
			return -1;
		
		int sum = 0;
		int maxSum = array[0];
		for (int i=0; i< array.length; i++)
		{
			sum = sum+array[i];
			if (maxSum < sum)
			{
				maxSum = sum;
			}
			if (sum < 0)
				sum = 0;
			
		}
		return maxSum;
	}

}
