package com.sophie.basic.onehundredalgorithm.util;

public class LinkNodeUtil
{
	public static void printLinkNode(LinkNode node)
	{
		while (node != null)
		{
			System.out.print(node.value+" ");
			node = node.nextNode;
		}
		System.out.println();
	}

}
