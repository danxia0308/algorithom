package com.sophie.basic.other;

public class NumberGame
{
	private static float calTheChangeByFirstChoiceFound(int firstPos, int total, int select_count)
	{
		float firstPart=1;
		float secondPart=0;
		StringBuilder firstPartStr = new StringBuilder();
		StringBuilder secondPartStr = new StringBuilder();
		for(float i=1; i<=select_count; i++)
		{
			float base=total+1-i;
			if (i==firstPos)
			{
				firstPart=1/base;
				firstPartStr.append("1/");
				firstPartStr.append(String.valueOf((int)base));
			}
			if (i>firstPos)
			{
				secondPart=secondPart+1/base;
				if (secondPartStr.length() == 0)
				{
					secondPartStr.append("1/");
				}
				else
				{
					secondPartStr.append("+1/");
				}
				secondPartStr.append(String.valueOf((int)base));
			}
		}
		System.out.println(firstPartStr.toString()+"*("+secondPartStr.toString()+")");
		return firstPart*secondPart;
		
	}
	private static void calTheChange(int total, int select_count)
	{
		float sum=0;
		for(int i=1; i< select_count; i++)
		{
			sum=sum+calTheChangeByFirstChoiceFound(i, total, select_count);
		}
		sum=sum*2;
		System.out.println(sum);
	}
	

	public static void main(String[] args)
	{
//		NumberGame.calTheChange(40, 10);
		float sum=0;
		for(float i=31;i<=40;i++)
		{
			sum=sum+2/i;
		}
		System.out.println(sum);
	}

}
