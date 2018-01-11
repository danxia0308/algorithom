package com.sophie.basic.onehundredalgorithm;

import java.util.ArrayList;
import java.util.List;

public class Ab_Two_BuildAStack
{

	public static void main(String[] args)
	{
		Ab_Two_BuildAStack instance = new Ab_Two_BuildAStack();
		instance.testMyStack();
	}

	/**
	 *  程序员面试题精选100题(02)－设计包含min函数的栈[数据结构]
	 *  题目：定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。要求函数min、push以及pop的时间复杂度都是O(1)。
	 *  分析：
	 * @author dxchen
	 *
	 */
	class MyStack
	{
		private List<Integer> dataList = new ArrayList<Integer>();
		private List<Integer> indexList = new ArrayList<Integer>();
		
		public Integer pop()
		{
			if (dataList.size() == 0)
				return null;
			indexList.remove(indexList.size()-1);
			return dataList.remove(dataList.size()-1);
		}
		
		public void push(Integer value)
		{
			dataList.add(value);
			
			if (indexList.isEmpty())
			{
				indexList.add(0);
			}
			else
			{
				Integer minValue = dataList.get(indexList.get(indexList.size()-1));
				if (value < minValue)
				{
					indexList.add(dataList.size()-1);
				}
				else
				{
					indexList.add(indexList.get(indexList.size()-1));
				}
			}
		}
		
		public Integer min()
		{
			if (indexList.isEmpty())
				return null;
			return dataList.get(indexList.get(indexList.size()-1));
		}
		
	}
	
	private void testMyStack()
	{
		MyStack ms = new MyStack();
		ms.push(3);
		System.out.println(ms.min()); // It should be 3.
		ms.push(4);
		System.out.println(ms.min()); // It should be 3.
		ms.push(1);
		System.out.println(ms.min()); // It should be 1.
		ms.push(2);
		System.out.println(ms.min()); // It should be 1.
		ms.pop();
		System.out.println(ms.min()); // It should be 1.
		ms.pop();
		System.out.println(ms.min()); // It should be 3.
	}
}
