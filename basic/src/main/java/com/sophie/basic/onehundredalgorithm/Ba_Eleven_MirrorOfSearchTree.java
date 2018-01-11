package com.sophie.basic.onehundredalgorithm;

import java.util.Stack;

import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class Ba_Eleven_MirrorOfSearchTree
{

	public static void main(String[] args)
	{
		test();
	}
	
	/**
	 * 输入
	 *      8
    	  /   \
  	    6      10
 	    /\     / \
	   5  7   9   11
	        输出
	        8
    	  /   \
  	    10      6
 	    /\     / \
	   11  9   7   5	   
	 */
	static void test()
	{
		BeTreeNode top = new BeTreeNode(8);
		top.leftNode = new BeTreeNode(6);
		top.rightNode = new BeTreeNode(10);
		top.leftNode.leftNode = new BeTreeNode(5);
		top.leftNode.rightNode = new BeTreeNode(7);
		top.rightNode.leftNode = new BeTreeNode(9);
		top.rightNode.rightNode = new BeTreeNode(11);
		printTree(top);
		System.out.println();
		
		mirrorOfSearchTree_Recursive(top);
		printTree(top);
		System.out.println();
		
		mirrorOfSearchTree_UnRecursive(top);
		printTree(top);
		System.out.println();
	}
	
	static void printTree(BeTreeNode top)
	{
		if (top == null)
			return;
		System.out.print(top.value+" ");
		printTree(top.leftNode);
		printTree(top.rightNode);
	}
	
	/**
	 * 题目：输入一颗二元查找树，将该树转换为它的镜像，即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
	 * 分析：使用递归，交换左右子树。
	 * @param top
	 */
	static void mirrorOfSearchTree_Recursive(BeTreeNode top)
	{
		if (top == null)
		{
			return;
		}
		
		BeTreeNode temp = top.leftNode;
		top.leftNode = top.rightNode;
		top.rightNode = temp;
		
		mirrorOfSearchTree_Recursive(top.leftNode);
		mirrorOfSearchTree_Recursive(top.rightNode);
	}
	
	/**
	 * 分析：使用非递归。因为递归也是栈调用，所以使用一个辅助栈。
	 * @param top
	 */
	static void mirrorOfSearchTree_UnRecursive(BeTreeNode top)
	{
		Stack<BeTreeNode> stack = new Stack<BeTreeNode>();
		stack.push(top);
		while(!stack.isEmpty())
		{
			BeTreeNode node = stack.pop();
			BeTreeNode left = node.leftNode;
			BeTreeNode right = node.rightNode;
			node.leftNode = right;
			node.rightNode = left;
			if (left != null)
			{
				stack.push(left);
			}
			if (right != null)
			{
				stack.push(right);
			}
		}
	}

}
