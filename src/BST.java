/*
 Name:-    Niharika Poddar
 Date:-    03 July, 2021
 Project:- Binary Search Tree Implementation from scratch
 BST class containing all functions pertaining to BST.
 */

import java.util.*;
public class BST 
{
	Node root=null;
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	int height = 1;
	int left = 0;
	int right = 0;
	Scanner sc = new Scanner(System.in);
	void insert()
	{
		System.out.println("Enter data to be inserted to the BST:");
		int val;
		val = sc.nextInt();
		Node new_node = new Node(val);
		
		if(root ==null)
		{
			root = new_node;
			System.out.println("Inserted new node:"+val+" successfully!");
			return;
		}
		Node cur = root;
		Node prev = null;
		while(cur!=null)
		{
			prev = cur;
			if(cur.data<val)
			{
				cur = cur.right;
			}
			else 
			{
				cur = cur.left;
			}
		}
		if(prev.data<val)
		{
			prev.right = new_node;
		}
		else
		{
			prev.left = new_node;
		}
		System.out.println("Inserted new node:"+val+" successfully!");
	}
	boolean search(int key)
	{
		
		Node cur = root;
		int level = 1;
		while(cur!=null)
		{
			if(cur.data==key)
			{
				System.out.println("Key : "+key+" found at level "+level);
				return true;
				
			}
			else if(cur.data<key)
			{
				cur = cur.right;
			}
			else
			{
				cur = cur.left;
			}
			level++;
		}
		return false;
	}
	void delete()
	{
		Node cur,parent,lchild,rchild;
		int key;
		System.out.println("Enter value to be deleted:");
		key = sc.nextInt();
		if(search(key))
		{
			parent = null;
			cur = root;
			lchild = cur.left;
			rchild = cur.right;
			//locate the node to be deleted
			while(true)
			{
				if(key == cur.data)
				{
					break;
				}
				else if(key>cur.data)
				{
					parent = cur;
					cur = cur.right;
				}
				else
				{
					parent = cur;
					cur = cur.left;
				}
			}
			//leaf node
			if(cur.left==null && cur.right==null)
			{
				if(parent.left == cur)
				{
					parent.left = null;
					
				}
				else
				{
					parent.right = null;
					
				}
				System.out.println("Deleted :"+key);
			}
			//node with either left or right child
			else if(cur.left == null || cur.right==null)
			{
				if(cur.left == null)
				{
					rchild = cur.right;
					if(parent.left==cur)
					{
						parent.left = rchild;
					}
					else
					{
						parent.right = rchild;
					}
				}
				if(cur.right == null)
				{
					lchild = cur.left;
					if(parent.left==cur)
					{
						parent.left = lchild;
					}
					else
					{
						parent.right = lchild;
					}
					System.out.println("Deleted :"+key);
				}
				
			}
			//if both children exist
			//find maximum value node on the leftmost side
			else
			{
				Node predparent = cur.left;
				Node leftpred = cur.left;
				while(leftpred.right!=null)
				{
					predparent = leftpred;
					leftpred = leftpred.right;
				}
				cur.data = leftpred.data;
				predparent.right = null;
				
			}
			System.out.println("Deleted :"+key);
			
		}
		else
		{
			System.out.println("Deletion failed, couldn't locate node in BST!");
		}
	}
	void level_order()
	{
		Node cur = root;
		Queue <Node> q = new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			System.out.println(temp.data);
			if(temp.left!=null)
			{
				q.add(temp.left);
			}
			if(temp.right!=null)
			{
				q.add(temp.right);
			}
		}
		
	}
	void preorder(Node cur)
	{
		if(cur==null)
		{
			return;
		}
		System.out.println(cur.data);
		preorder(cur.left);
		preorder(cur.right);
		
		
	}
	void inorder(Node cur)
	{
		if(cur==null)
		{
			return;
		}
		inorder(cur.left);
		System.out.println(cur.data);
		inorder(cur.right);
	}
	void postorder(Node cur)
	{
		if(cur==null)
		{
			return;
		}
		postorder(cur.left);
		postorder(cur.right);
		System.out.println(cur.data);
	}
	void findmax(Node cur)
	{
		if(cur == null)
		{
			System.out.println("Max value : "+max);
			return ;
		}
		if(cur.data>max)
		{
			max = cur.data;
		}
		findmax(cur.right);
	}
	void findmin(Node cur)
	{
		if(cur == null)
		{
			System.out.println("Min value : "+min);
			return ;
		}
		if(cur.data<min)
		{
			min = cur.data;
		}
		findmin(cur.left);
	}
	int findheight(Node cur)
	{
		
		
		if(cur.left == null && cur.right==null)
		{
			return 1;
		}
		if(cur.left!=null)
		{
			left = height + findheight(cur.left);
		}
		if(cur.right!=null)
		{
			right = height + findheight(cur.right);
		}
		
		if(left>right)
		{
			return left;
		}
		else
		{
			return right;
		}
		
	}
	

}
