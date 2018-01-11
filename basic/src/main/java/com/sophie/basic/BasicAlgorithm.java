package com.sophie.basic;

import java.util.LinkedList;
import java.util.Queue;

public class BasicAlgorithm
{

	public static void main(String[] args)
	{
		BasicAlgorithm ba = new BasicAlgorithm();
//		String str = "Sophie, Nice to meet you!";
//		System.out.println(ba.strRotation(str, 7));
		ba.useQueue();
		
	}
	
	private String strRotation(String input, int sizeToRotate)
	{
		int count = input.length();
		if (sizeToRotate > count)
		{
			return null;
		}
		int current = 0;
		char[] charArray = new char[count];
		for(int i=sizeToRotate; i < count; i++)
		{
			charArray[current++] = input.charAt(i);
		}
		for (int i=0; i<sizeToRotate; i++)
		{
			charArray[current++] = input.charAt(i);
		}
		return String.valueOf(charArray);
	}
	
	private void useQueue()
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add("1");
		queue.add("2");
		queue.add("3");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
