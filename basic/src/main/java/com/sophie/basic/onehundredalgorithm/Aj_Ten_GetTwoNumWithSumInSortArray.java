package com.sophie.basic.onehundredalgorithm;

public class Aj_Ten_GetTwoNumWithSumInSortArray
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		int[] array = {1,2,4,7,11,15};
		System.out.println(findTwoNumWithSumInSortArray(array, 15));
		
		int[] array2 = {1,2,4,7,11,15};
		System.out.println(findTwoNumWithSumInSortArray(array2, 16));
		
		int[] array3 = {1,2,4,7,11,15};
		System.out.println(findTwoNumWithSumInSortArray(array3, 18));
		
		int[] array4 = {1,2,4,7,11,15};
		System.out.println(findTwoNumWithSumInSortArray(array4, 27));
		
		int[] array5 = {1,2,4,7,11,15};
		System.out.println(findTwoNumWithSumInSortArray(array5, 10));
	}

	/**
	 * 程序员面试题精选100题(10)－排序数组中和为给定值的两个数字[算法]
	 * 题目：输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
	 * 分析：
	 * 1. 使用两个指针，初始化为第一个和第二个数。
	 * 2. 移动第二个数，知道两个数和比给定值大。第二个数及其以后的任何数都放弃，因为和最小的数相加都大于给定值，所以第二个数及其以后数和任何数相加都大于给定数。
	 * 3. 循环将两个数求和，如果和大于给定值，则第二个数往前移动一位。如果和小于给定值，则第一个数往后移动一位。
	 * 证明：
	 * 在第2步结束后，如果没有找到和为指定值，则第一个数没有找到一个符合条件的数，同时因为数组是排序的，第二个数和最小的数相加都大于给定值，所以第二个数和以后的任何数都不满足条件。
	 * 在第3步的循环中，两个数和大于给定值，则放弃第二个数；两个数和小于给定值，则放弃第一个数，因为第二个数以后的任何数都被证明不满足条件。
	 * @param array
	 * @param sum
	 * @return
	 */
	static boolean findTwoNumWithSumInSortArray(int[] array, int sum)
	{
		if (array == null || array.length < 2)
		{
			return false;
		}
		
		int numIndex1 = 0;
		int numIndex2 = 1;
		
		while (numIndex2 < array.length)
		{
			int currentSum = array[numIndex1] + array[numIndex2];
			if (currentSum == sum)
			{
				//找到两个符合条件的数
				System.out.println("The two number is:" + array[numIndex1] + " and " + array[numIndex2]);
				return true;
			}
			if (currentSum > sum)
			{
				break;
			}
			numIndex2++;
		}
		
		if (numIndex2 == array.length)
		{
			numIndex2--;
		}
		
		while(numIndex1 < numIndex2)
		{
			int currentSum = array[numIndex1] + array[numIndex2];
			if (currentSum > sum)
			{
				numIndex2--;
			}
			else if (currentSum < sum)
			{
				numIndex1++;
			}
			else
			{
				//找到两个符合条件的数
				System.out.println("The two number is:" + array[numIndex1] + " and " + array[numIndex2]);
				return true;
			}
		}
		
		return false;
	}
}
