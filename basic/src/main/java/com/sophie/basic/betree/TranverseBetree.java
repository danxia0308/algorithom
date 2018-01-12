package com.sophie.basic.betree;

import java.util.Stack;

import com.sophie.basic.onehundredalgorithm.util.BeTreeNode;

public class TranverseBetree
{

	public static void main(String[] args)
	{
		test();
	}
	
	/**
	 * 输入
	 *      8
    	  /   \
  	    6      10
 	    /\     / \
	   5  7   9   11	   
	 */
	static void test()
	{
		// 创建二叉树
		BeTreeNode top = new BeTreeNode(8);
		top.leftNode = new BeTreeNode(6);
		top.rightNode = new BeTreeNode(10);
		top.leftNode.leftNode = new BeTreeNode(5);
		top.leftNode.rightNode = new BeTreeNode(7);
		top.rightNode.leftNode = new BeTreeNode(9);
		top.rightNode.rightNode = new BeTreeNode(11);
		
		tranversePreOrder_Recursive(top);
		System.out.println();
		tranversePreOrder_NonRecursive(top);
		System.out.println();
		tranverseMidOrder_Recursive(top);
		System.out.println();
		tranverseMidOrder_NonRecursive(top);
		System.out.println();
		tranversePostOrder_Recursive(top);
		System.out.println();
		tranversePostOrder_NonRecursive(top);
	}
	
	public static void tranversePreOrder_Recursive(BeTreeNode head)
	{
		if (head == null)
		{
			return;
		}
		
		System.out.print(head.value+" ");
		
		tranversePreOrder_Recursive(head.leftNode);
		tranversePreOrder_Recursive(head.rightNode);
	}

	/**
	 * 功能：使用非递归的方式实现先序二叉树遍历
	 * 方法：因为递归就是栈的调用，所以使用栈来完成。
	 * 1. 打印当前结点，并放入栈。
	 * 2. 取左结点作为当前结点，放入栈。直到没有左结点。
	 * 3. 从栈中取数，作为当前结点，取其右孩子，如果右孩子为空，则从栈中继续取数，直到右孩子不为空或者栈为空。取右孩子作为当前结点。
	 *    打印右孩子结点，并入栈。
	 * 4. 从第二步开始重复。
	 * @param head
	 */
	static void tranversePreOrder_NonRecursive(BeTreeNode head)
	{
		if (head ==null)
			return;
		
		Stack<BeTreeNode> stack = new Stack<BeTreeNode>();
		System.out.print(head.value + " ");
		stack.push(head);
		BeTreeNode node = head;
		
		while(!stack.isEmpty())
		{
			while(node.leftNode != null)
			{
				node = node.leftNode;
				System.out.print(node.value + " ");
				stack.push(node);
			}
			
			node = stack.pop();
			while (node.rightNode == null && !stack.isEmpty())
			{
				node = stack.pop();
			}
			
			if (node.rightNode != null)
			{
				node = node.rightNode;
				System.out.print(node.value + " ");
				stack.push(node);
			}
		}
	}
	
	public static void tranverseMidOrder_Recursive(BeTreeNode head)
	{
		if (head == null)
			return;
		
		tranverseMidOrder_Recursive(head.leftNode);
		System.out.print(head.value+" ");
		tranverseMidOrder_Recursive(head.rightNode);
	}
	
	static void tranverseMidOrder_NonRecursive(BeTreeNode head)
	{
		if (head == null)
			return;
		
		Stack<BeTreeNode> stack = new Stack<BeTreeNode>();
		BeTreeNode node = head;
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			while(node.leftNode != null)
			{
				node = node.leftNode;
				stack.push(node);
			}
			
			node = stack.pop();
			System.out.print(node.value + " ");
			while (node.rightNode == null && !stack.isEmpty())
			{
				node = stack.pop();
				System.out.print(node.value + " ");
			}
			
			if (node.rightNode != null)
			{
				node = node.rightNode;
				stack.push(node);
			}
		}
	}
	
	static void tranversePostOrder_Recursive(BeTreeNode head)
	{
		if (head == null)
			return;
		
		tranversePostOrder_Recursive(head.leftNode);
		tranversePostOrder_Recursive(head.rightNode);
		System.out.print(head.value + " ");
	}
	/**
	 * 功能：使用非递归实现二叉树的后续遍历。
	 * 分析：三种遍历中，后续遍历是最难的。因为结点要在左孩子和右孩子都访问完以后再访问。
	 * 1. 首先将head放入stack中，当前结点指向head结点。
	 * 2. 开始循环，首先寻找当前结点左结点，并压入stack，直到左孩子为空。
	 * 3. 如果右孩子为空，则此结点为叶子节点，从stack中弹出并打印。接下来看看stack中的top结点的子孩子，如果为空或者等于此结点，则弹出。否则取stack中的top结点作为当前结点。
	 * 4. 如果右孩子不为空，则当前结点为右结点，并入栈。接着开始第2步。
	 * @param head
	 */
	static void tranversePostOrder_NonRecursive(BeTreeNode head)
	{
		if (head == null)
			return;
		
		Stack<BeTreeNode> stack = new Stack<BeTreeNode>();
		stack.add(head);
		BeTreeNode node = head;
		
		while(!stack.isEmpty())
		{
			while(node.leftNode != null)
			{
				node = node.leftNode;
				stack.add(node);
			}
			
			if (node.rightNode == null)
			{
				System.out.print(node.value + " ");
				node = stack.pop();
				while (!stack.isEmpty() && (stack.peek().rightNode == node || stack.peek().rightNode == null))
				{
					node = stack.pop();
					System.out.print(node.value + " ");
				}
				
				if (stack.isEmpty())
					return;

				node = stack.peek();
			}
			
			if (node.rightNode != null)
			{
				node = node.rightNode;
				stack.add(node);
			}
			
		}
	}
}
