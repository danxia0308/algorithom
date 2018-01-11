package com.sophie.basic;

import java.util.ArrayList;
import java.util.List;

public class OneHundredAlgorithm
{

	public static void main(String[] args)
	{
//		testTranverseWordsInSentence();
		OneHundredAlgorithm instance = new OneHundredAlgorithm();
//		instance.testBetreeToTwoWaySortedLinkTable();
//		instance.testTakeTheFifthFromLastOfLinkTable();
	}
	

	
	
	private void testTakeTheFifthFromLastOfLinkTable()
	{
		LinkNode head = new LinkNode();
		LinkNode top = head;
		head.value = 0;
		for (int i=1; i<=10; i++)
		{
			LinkNode next = new LinkNode();
			next.value = i;
			head.nextNode = next;
			head = next;
		}
		printLinkNode(top);
		System.out.println();
		System.out.println(takeTheFifthFromLastOfLinkTable(top));
	}
	
	private void printLinkNode(LinkNode head)
	{
		while (head != null)
		{
			System.out.println(head.value);
			head = head.nextNode;
		}
	}
	
	/**
	 * 求链表的倒数第5个值
	 * @param head
	 * @return
	 */
	private int takeTheFifthFromLastOfLinkTable(LinkNode head)
	{
		LinkNode fifth = head;
		LinkNode end = fifth;
		for(int i=1; i< 5; i++)
		{
			end = end.nextNode;
			if (end == null)
			{
				return -1;
			}
		}
		while(end.nextNode != null)
		{
			fifth = fifth.nextNode;
			end = end.nextNode;
		}
		return fifth.value;
	}
	
	class LinkNode
	{
		int value;
		LinkNode nextNode;
	}
	
	
}
