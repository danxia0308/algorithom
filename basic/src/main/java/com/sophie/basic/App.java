package com.sophie.basic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String str = "Site.getSiteName.";
        String[] array = str.split("\\.");
        System.out.println(array.length);
        System.out.println(array[0]);
        System.out.println(array[1]);
        
        str = "Nice to meet you";
        System.out.println(str.split("\\.").length);
    }
    
    public static void change(int a)
    {
    	a = 5;
    	System.out.println(a);
    }
}
