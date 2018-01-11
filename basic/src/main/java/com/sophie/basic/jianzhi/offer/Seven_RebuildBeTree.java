package com.sophie.basic.jianzhi.offer;

import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class Seven_RebuildBeTree
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Seven_RebuildBeTree instance = new Seven_RebuildBeTree();
		instance.test();
	}
	
	void test()
	{
		
	}
	
	/**
	 * 题目：根据前序和中序遍历的结果，重建二叉树。假设前序和中序遍历结果中不含有重复字符。
	   例如：前序遍历结果{1,2,4,7,3,5,6,8} 中序遍历结果{4,7,2,1,5,3,8,6}
	   分析：
	 * @param preOrderResult
	 * @param midOrderResult
	 */
	boolean rebuildBeTree(int[] preOrderResult, int[] midOrderResult)
	{
		if (preOrderResult == null || midOrderResult == null || preOrderResult.length != midOrderResult.length)
			return false;
		
		int topValue = preOrderResult[0];
		int topIndexInMidOrderResult = findIndex(midOrderResult, topValue,0, preOrderResult.length);
		if (topIndexInMidOrderResult == -1)
			return false;
		BeTreeNode top = new BeTreeNode(topValue);
		boolean resultLeft = buildBeTree_Recursive(preOrderResult, midOrderResult, top, 0, topIndexInMidOrderResult, true);
		boolean resultRight = buildBeTree_Recursive(preOrderResult, midOrderResult, top, topIndexInMidOrderResult+1, preOrderResult.length-1, false);
		return resultLeft && resultRight;
	}
	
	boolean buildBeTree_Recursive(int[] preOrderResult, int[] midOrderResult, BeTreeNode top, int start, int end, boolean leftTree)
	{
		if (leftTree)
		{
			if (start == end)
			{
				return true;
			}
			
			int nextValue = preOrderResult[start+1];
			int nextIndexInMidOrderResult = findIndex(midOrderResult, nextValue, start, end-1);
			if (nextIndexInMidOrderResult == -1)
				return false;
			BeTreeNode next = new BeTreeNode(nextValue);
			top.leftNode = next;
			
		}
		else
		{
			
		}
		return false;
	}
	
	int findIndex(int[] array, int value, int start, int end)
	{
		for (int i=start; i<= end; i++)
		{
			if (array[i] == value)
			{
				return i;
			}
		}
		return -1;
	}
}
