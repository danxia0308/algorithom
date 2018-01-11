package com.sophie.basic.onehundredalgorithm;

import java.util.Hashtable;

public class Bc_Thirteen_FirstCharWithOneOccurrence
{

	public static void main(String[] args)
	{
		test();
	}
	
	static void test()
	{
		char result = findFirstCharWithOneOccurrence("abaccdeff".toCharArray());
		System.out.println(result);
	}
	
	/**
	 * 题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
	 * 分析：字符占一个字节，可以用一个256的hash table涵盖所有字符。
	 * @param chars
	 * @return
	 */
	static char findFirstCharWithOneOccurrence(char[] chars)
	{
		if (chars == null || chars.length == 0)
			return '\0';
		Hashtable<Object, Integer> ht = new Hashtable(256);
		for(char c : chars)
		{
			if (ht.containsKey(c))
			{
				int value = (Integer) ht.get(c);
				ht.put(c, ++value);
			}
			else
			{
				ht.put(c, 1);
			}
			
		}
		
		for (char c : chars)
		{
			if (ht.get(c) == 1)
				return c;
		}
		return '\0';
	}
}
