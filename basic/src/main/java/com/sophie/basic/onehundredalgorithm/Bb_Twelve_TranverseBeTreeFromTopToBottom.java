package com.sophie.basic.onehundredalgorithm;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class Bb_Twelve_TranverseBeTreeFromTopToBottom
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
		
		printBeTreeTopToBottom(top);
	}
	
	static void printBeTreeTopToBottom(BeTreeNode top)
	{
		if (top == null)
			return;
		
		Queue<BeTreeNode> queue = new LinkedBlockingQueue<BeTreeNode>();
		queue.add(top);
		
		while(!queue.isEmpty())
		{
			BeTreeNode node = queue.poll();
			System.out.print(node.value + " ");
			
			if (node.leftNode != null)
			{
				queue.add(node.leftNode);
			}
			if (node.rightNode != null)
			{
				queue.add(node.rightNode);
			}
		}
		System.out.println();
	}
}
