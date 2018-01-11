package com.sophie.basic.onehundredalgorithm;

import java.util.ListIterator;
import java.util.Stack;

import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class Ad_Four_PrintPathWithASum
{
	Stack<Integer> pathStack = new Stack<Integer>();
	int currentSum = 0;
	
	public static void main(String[] args)
	{
		Ad_Four_PrintPathWithASum instance = new Ad_Four_PrintPathWithASum();
		instance.test();
	}
	
	/**
	 * 创建如下二叉树
	 * 	   10
		 /    \
		5     12
	  /   \   
	 4     7 
	 求和值为22，则打印两条路径：10,5,7和10,12
	 */
	private void test()
	{
		//创建二叉树
		BeTreeNode head = new BeTreeNode(10);
		head.leftNode = new BeTreeNode(5);
		head.rightNode = new BeTreeNode(12);
		head.leftNode.leftNode = new BeTreeNode(4);
		head.leftNode.rightNode = new BeTreeNode(7);
		
		printPathWithASum(head,22);
	}
	
	/**
	 * 题目：输入一个整数和一棵二元树。从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。打印出和与输入整数相等的所有路径。
	 * 分析：遍历二叉树，使用一个stack来记录path。解题的关键是，在为null，叶子节点，普通节点三种情况下，总和的加减和pathStack的pop和push。
	 * 
	 * @param head
	 * @param sum
	 */
	private void printPathWithASum(BeTreeNode head, int sum)
	{
		if (head == null)
		{
			return;
		}
		
		currentSum+=head.value;
		if (head.value > sum)
		{
			currentSum-=head.value;
			return;
		}
		
		pathStack.push(head.value);
		
		if (head.leftNode == null && head.rightNode == null)
		{
			if (currentSum == sum)
			{
				// 找到Path，打印。
				ListIterator<Integer> li = pathStack.listIterator();
				while(li.hasNext())
				{
					System.out.print(li.next());
					if (li.hasNext())
						System.out.print(",");
				}
				System.out.println();
				
			}
			pathStack.pop();
			currentSum-=head.value;
			return;
		}
		
		printPathWithASum(head.leftNode, sum);
		printPathWithASum(head.rightNode,sum);
		
		currentSum-=head.value;
		pathStack.pop();
		
	}
}
