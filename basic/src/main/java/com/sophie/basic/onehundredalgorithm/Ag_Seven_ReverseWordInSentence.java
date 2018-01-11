package com.sophie.basic.onehundredalgorithm;

public class Ag_Seven_ReverseWordInSentence
{

	public static void main(String[] args)
	{
		test();

	}

	private static void test()
	{
		String str = "I am a student!";
		String result = reverseWordsInSentence(str);
		System.out.println(result);
		
		str="student";
		result = reverseWordsInSentence(str);
		System.out.println(result);
		
		str="I   am a student!";
		result = reverseWordsInSentence(str);
		System.out.println(result);
		
		str="I   ";
		result = reverseWordsInSentence(str);
		System.out.println(result);
		
		str="   ";
		result = reverseWordsInSentence(str);
		System.out.println(result);
		
		str="   I";
		result = reverseWordsInSentence(str);
		System.out.println(result);
	}
	
	/**
	 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
	 * 分析：翻转两次
	 * input: I am a student!
	 * output: student! a am I
	 * @return
	 */
	private static String reverseWordsInSentence(String input)
	{
		if (input == null || input.isEmpty())
		{
			return "";
		}
		
		char[] inputInChar = input.toCharArray();
		tranverseWords(inputInChar,0,inputInChar.length-1);
		
		int start = 0;
		int end=0;
		while(end < inputInChar.length)
		{
			if (inputInChar[end] != ' ')
			{
				end++;
			}
			else
			{
				tranverseWords(inputInChar, start, end-1);
				end++;
				start=end;
			}
		}
		if (start < end)
		{
			tranverseWords(inputInChar, start, end-1);
		}
		
		return String.valueOf(inputInChar);
	}
	
	private static void tranverseWords(char[] input, int start, int end)
	{
		if (input == null || input.length <= 1 || start >= end)
		{
			return;
		}
		
		while (start < end)
		{
			char temp = input[start];
			input[start++] = input[end];
			input[end--] = temp;
		}
	}

}
