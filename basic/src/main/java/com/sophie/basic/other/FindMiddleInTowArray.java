package com.sophie.basic.other;
/**
 * 问题：已知两个排序后的数组，求其中值。
 * 要求：复杂度为lnN
 * @author chendanxia
 *
 */
public class FindMiddleInTowArray
{
	int[] findMiddle(int[] array1, int[] array2)
	{
		int start1=0, end1=array1.length-1,start2=0, end2=array2.length-1;
		while(start1 < end1 && start2 < end2)
		{
			if(start1 == end1 && start2==end2)
			{
				return new int[] {array1[start1],array2[start2]};
			}
			int candidate1 = array1[start1+(end1-start1)/2]; //从start1～end1个数为奇数，则取中间值。若为偶数，取中间两个值的第一个。
			int candidate2 = array2[start2+(end2-start2)/2];
			int edgeToRemove = (end1-start1)<(end2-start2)?(end1-start1)/2+1:(end2-start2)/2+1;
			
			if (candidate1 < candidate2)
			{
				start1=start1+edgeToRemove;
				end2 = end2-edgeToRemove;
			}
			else if (candidate1 > candidate2)
			{
				end1 = end1-edgeToRemove;
				start2 = start2+edgeToRemove;
			}
			else
			{
				return new int[]{candidate1};
			}
			
		}
		if (start1 >= end1)
		{
			return (end2-start2)%2==0? new int[] {array2[start2+(end2-start2)/2]} : new int[]{array2[start2+(end2-start2)/2],array2[start2+(end2-start2)/2+1]};
		}
		else
		{
			return (end1-start1)%2==0? new int[] {array1[start1+(end1-start1)/2]} : new int[]{array1[start1+(end1-start1)/2],array1[start1+(end1-start1)/2+1]};
		}
	}

	public static void main(String[] args)
	{
		FindMiddleInTowArray instance = new FindMiddleInTowArray();
		int[] a= {1,3,5,7,9};
		int[] b= {2,4,6};
		int[] result = instance.findMiddle(a, b);
		for(int i: result)
			System.out.println();

	}

}
