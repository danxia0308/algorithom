package com.sophie.basic;

public class LeetCode
{

	public static void main(String[] args)
	{
		LeetCode  lc = new LeetCode();
		int[] nums = {2, 7, 11, 15};
		int[] result = lc.twoSum(nums, 13);
		System.out.println("0="+result[0] + " 1="+result[1]);

	}
	public int[] twoSum(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<end)
        {
            if(nums[start] + nums[end] < target)
            {
                start++;
                continue;
            }               
            if(nums[start] + nums[end] > target)
            {
                end--;
                continue;
            }
            if (nums[start] + nums[end] == target)
            {
                int[] result = new int[2];
                result[0] = start;
                result[1] = end;
                return result;
            }
                
        }
        return new int[2];
    }

}
