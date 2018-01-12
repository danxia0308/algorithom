package com.sophie.basic.jianzhi.offer;

import com.sophie.basic.betree.TranverseBetree;
import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class Seven_RebuildBeTree
{

	int topIndex = 0;
	
	public static void main(String[] args)
	{
		Seven_RebuildBeTree instance = new Seven_RebuildBeTree();
		instance.test();
	}
	
	void test()
	{
		int[] preOrderResult = {1,2,4,7,3,5,6,8};
		int[] midOrderResult = {4,7,2,1,5,3,8,6};
		
		BeTreeNode top = rebuildBeTree(preOrderResult, midOrderResult);
		if (top == null)
		{
			System.out.println("Fail to rebuild betree!");
		}
		TranverseBetree.tranversePreOrder_Recursive(top);
		System.out.println();
		TranverseBetree.tranverseMidOrder_Recursive(top);
	}
	
	/**
	 * 题目：根据前序和中序遍历的结果，重建二叉树。假设前序和中序遍历结果中不含有重复字符。
	   例如：前序遍历结果{1,2,4,7,3,5,6,8} 中序遍历结果{4,7,2,1,5,3,8,6}
	   分析：前序遍历的第一个结点是根节点。中序遍历的根节点在中间，左侧为左子树，右侧为右子树。适合用递归来实现。
	  1. 指针从前序遍历结果第一位开始，依次后移。取出第一个，将中序遍历结果分为两个子数组，分别对应做子树和右子树。分别对左右子树进行遍历。
	  2. 遍历左子树时，如果左子树数组不为空，则前序遍历数组的下一个结点为左子树结点。递归遍历左右子树。
	  3. 遍历右子树是，如果右子树数组不为空，则前序遍历数组的下一个结点为右子树结点。递归遍历左右子树。
	 * @param preOrderResult
	 * @param midOrderResult
	 */
	BeTreeNode rebuildBeTree(int[] preOrderResult, int[] midOrderResult)
	{
		if (preOrderResult == null || midOrderResult == null || preOrderResult.length != midOrderResult.length)
			return null;
		
		int topValue = preOrderResult[0];
		int topIndexInMidOrderResult = findIndex(midOrderResult, topValue,0, preOrderResult.length);
		if (topIndexInMidOrderResult == -1)
			return null;
		BeTreeNode top = new BeTreeNode(topValue);
		buildBeTree_Recursive(preOrderResult, midOrderResult, top, 0, topIndexInMidOrderResult-1, true);
		buildBeTree_Recursive(preOrderResult, midOrderResult, top, topIndexInMidOrderResult+1, preOrderResult.length-1, false);

		return top;
	}
	
	void buildBeTree_Recursive(int[] preOrderResult, int[] midOrderResult, BeTreeNode top, int start, int end, boolean leftTree)
	{
		if (leftTree)
		{
			if (start > end)
			{
				return;
			}
			
			int nextValue = preOrderResult[++topIndex];
			BeTreeNode next = new BeTreeNode(nextValue);
			top.leftNode = next;
			
			int nextIndexInMidOrderResult = findIndex(midOrderResult, nextValue, start, end);
			if (nextIndexInMidOrderResult == -1)
				return;
			
			buildBeTree_Recursive(preOrderResult, midOrderResult, next, start, nextIndexInMidOrderResult-1, true);
			buildBeTree_Recursive(preOrderResult, midOrderResult, next, nextIndexInMidOrderResult+1, end, false);
		}
		else
		{
			if (start > end)
				return;
			
			int nextValue = preOrderResult[++topIndex];
			BeTreeNode next = new BeTreeNode(nextValue);
			top.rightNode = next;
			
			int nextIndexInMidOrderResult = findIndex(midOrderResult, nextValue, start, end);
			if (nextIndexInMidOrderResult == -1)
				return;
			
			buildBeTree_Recursive(preOrderResult, midOrderResult, next, start, nextIndexInMidOrderResult-1, true);
			buildBeTree_Recursive(preOrderResult, midOrderResult, next, nextIndexInMidOrderResult+1, end, false);
		}
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
