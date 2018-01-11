package com.sophie.basic.onehundredalgorithm;

import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class Aa_One_BeTreeToTwoWayLinkTable
{

	public static void main(String[] args)
	{
		Aa_One_BeTreeToTwoWayLinkTable instance = new Aa_One_BeTreeToTwoWayLinkTable();
		instance.testBetreeToTwoWaySortedLinkTable();
	}

	private void testBetreeToTwoWaySortedLinkTable()
	{
		/** 创建一个二叉树如下。
		 *     10
             /    \
         	6       14
          /  \     /　 \
         4    8  12 　 16
		 */
		BeTreeNode head = new BeTreeNode(10);
		BeTreeNode left = new BeTreeNode(6);
		BeTreeNode right = new BeTreeNode(14);
		head.leftNode = left;
		head.rightNode = right;
		
		left.leftNode = new BeTreeNode(4);
		left.rightNode = new BeTreeNode(8);
		right.leftNode = new BeTreeNode(12);
		right.rightNode = new BeTreeNode(16);
		
		betreeToTwoWaySortedLinkTable(head, true);
		
		//找到最左侧结点
		BeTreeNode leftSideNode = head;
		while (head != null)
		{
			leftSideNode = head;
			head = head.leftNode;
		}
		//从头到尾打印排序后的双链表
		while(leftSideNode != null)
		{
			System.out.println(leftSideNode.value);
			leftSideNode = leftSideNode.rightNode;
		}
		
	}
	/**
	 * 标题：程序员面试题精选100题(01)－把二元查找树转变成排序的双向链表[数据结构]
	 * 题目：输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。要求不能创建任何新的结点，只调整指针的指向。
	 * 思路：使用中序遍历的递归方法，排序后的左子树返回最右结点，排序后的右子树返回最左结点。
	 */
	private BeTreeNode betreeToTwoWaySortedLinkTable(BeTreeNode head, boolean leftTree)
	{
		if (head == null)
		{
			return null;
		}
		
		BeTreeNode rightNode = betreeToTwoWaySortedLinkTable(head.leftNode, true);
		if (rightNode != null)
		{
			rightNode.rightNode = head;
		}
		head.leftNode = rightNode;
		
		BeTreeNode leftNode = betreeToTwoWaySortedLinkTable(head.rightNode, false);
		if (leftNode != null)
		{
			leftNode.leftNode = head;
		}
		head.rightNode = leftNode;
		
		//找到左子树的最右结点，右子树的最左结点
		return findTheEdgeNode(head, !leftTree);
		
	}
	
	private BeTreeNode findTheEdgeNode(BeTreeNode head, Boolean leftDirection)
	{
		if (head == null)
		{
			return head;
		}
		if (leftDirection)
		{
			while(head.leftNode != null)
			{
				head = head.leftNode;
			}
			return head;
		}
		else
		{
			while(head.rightNode != null)
			{
				head = head.rightNode;
			}
			return head;
		}
	}

}
