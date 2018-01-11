package com.sophie.basic;

public class BitOperation
{

	public static void main(String[] args)
	{
		BitOperation mb = new BitOperation();
		System.out.println(mb.count1InBinaryNumber2(100));
	}
	
	private int count1InBinaryNumber(int n)
	{	
		int count = 0;
		while(n != 0)
		{
			count += n & 1;
			n = n >> 1;
		}
		return count;
	}
	
	private int count1InBinaryNumber2(int n)
	{	
		int count = 0;
		int flag = 1;
		while(flag > 0)
		{
			if ((n & flag) != 0)
			{
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	private void moveBit()
	{
		int i=2;
		int j = i<<1;
		System.out.println(j);
		
		Integer k = Integer.MAX_VALUE;
		System.out.println(k);
		System.out.println(k>>1);
		System.out.println(k<<1);
	}
}
