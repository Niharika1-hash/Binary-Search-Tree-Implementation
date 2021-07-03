/*
 Name:-    Niharika Poddar
 Date:-    03 July, 2021
 Project:- Binary Search Tree Implementation from scratch
 Main class acting as a Menu.
 */


import java.util.*;

public class Main 
{
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		BST b = new BST();
		int ch;
		int key;
		System.out.println("----------BINARY SEARCH TREE IMPLEMENTATION----------");
		while(true)
		{
			System.out.println("1.Insert a node\n2.Delete a Node\n3.Find Minimum\n4.Find Maximum\n5.Traverse the BST\n6.Calculate height of tree\n7.Search a value\n8.Exit");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:b.insert(); break;
				case 2:b.delete(); break;
				case 3:b.findmin(b.root); break;
				case 4:b.findmax(b.root); break;
				case 5:traversal(b); break;
				case 6:b.height = b.findheight(b.root); System.out.println("Height :"+b.height);break;
				case 7:System.out.println("Enter value to be searched:");
					   key = sc.nextInt();
					   boolean ans = b.search(key);
					   if(ans==false)
					   {
						   System.out.println("Key: "+key+" not found in BST");
					   }
					   break;
				default:System.out.println("BST Implementation exited."); sc.close(); System.exit(0);
					
			}
		}
		
	}
	static void traversal(BST b)
	{
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true)
		{
			System.out.println("1.Preorder\n2.Inorder\n3.Postorder\n4.Level order\n5.Return to Main Menu");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1: b.preorder(b.root); break;
				case 2: b.inorder(b.root); break;
				case 3: b.postorder(b.root); break;
				case 4: b.level_order(); break;
				default : System.out.println("--Returning to Main Menu--"); return;
			}
		}
			
		
	}
	
}
