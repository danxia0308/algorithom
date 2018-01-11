package com.sophie.basic;

import java.io.UnsupportedEncodingException;

public class Byte
{

	public static void main(String[] args) throws UnsupportedEncodingException
	{
		Byte b = new Byte();
		b.byteForChar();
	}
	
	private void byteForChar() throws UnsupportedEncodingException
	{
		String strEn = "c";
		String strCh = "中";
		System.out.println("一个英文字符占字节数：" + strEn.getBytes().length);
		System.out.println("一个utf-8编码的中文字符占字节数：" + strCh.getBytes("utf-8").length);
		System.out.println("一个gbk编码的中文字符占字节数：" + strCh.getBytes("gbk").length);
	}
	
	private void test()
	{
		System.out.println("Integer bytes="+Integer.BYTES+" max="+Integer.MAX_VALUE +" min="+Integer.MIN_VALUE);
		System.out.println("Long bytes=" + Long.BYTES);
		Integer maxInt = 18;
	}

	
}
