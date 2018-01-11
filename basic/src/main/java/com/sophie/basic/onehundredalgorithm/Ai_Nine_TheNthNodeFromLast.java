package com.sophie.basic.onehundredalgorithm;

import com.sophie.basic.onehundredalgorithm.util.LinkNode;
import com.sophie.basic.onehundredalgorithm.util.LinkNodeUtil;

public class Ai_Nine_TheNthNodeFromLast
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		int current = 1;
		LinkNode node = new LinkNode(current);
		LinkNode nextNode = node;
		while(current < 10)
		{
			nextNode.nextNode = new LinkNode(++current);
			nextNode = nextNode.nextNode;
		}
		LinkNodeUtil.printLinkNode(node);
		
		LinkNode result = getTheNthNodeFromLast(node, 5);
		System.out.println(result.value);
	}

	static LinkNode getTheNthNodeFromLast(LinkNode node, int n)
	{
		if (node == null)
			return null;
		
		LinkNode before = node;
		LinkNode after = before;
		for(int i=1; i<n;i++)
		{
			after = after.nextNode;
			// 链表总长度比n小，返回null
			if (after == null)
			{
				return null;
			}
		}
		
		while(after.nextNode != null)
		{
			after = after.nextNode;
			before = before.nextNode;
		}
		return before;
	}
}
