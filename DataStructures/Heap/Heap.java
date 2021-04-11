/*
A complete binary tree, where every node has a child and the leaf nodes are set as left as possible. Such a property makes a tree
to be able to be represented as an array too, that is it's level order traversal.

Heap can be Max or Min Heap-->
1.Max Heap= if i is the node of a heap than such that A[parent(i)] > A[i]
2.Min Heap= A[parent(i) < A[i]]

Making of heap from a given set of values is called heapifying those values.
1. we should know that the array representation of a final heap is nothing but the level order traversal of the tree
2. to heapify, we start from the leaf nodes and start heapifying them till required(that is if we are making max heap, we will
check if the current node we are working on is less than its parent or not, if not we swap the parent node, with it's larger
child, and we keep on doing the process till required)
3.to optimise the above approach we notice that we need to start heapifying from the last non-leaf node and not the leaf nodes
(Tracking the last non-leaf node-->)
=parent of the last leaf node=parent of node at (n-1)th index=node at ((n-1) - 1) / 2 th index = mode at (n/2) - 1 th index
4. now heapify these non-leaf nodes in reverse order

the above explained properly by GFG-->

Array = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}

Corresponding Complete Binary Tree is:

                 1
              /     \
            3         5
         /    \     /  \
        4      6   13  10
       / \    / \
      9   8  15 17

The task to build a Max-Heap from above array.

Total Nodes = 11.
Last Non-leaf node index = (11/2) - 1 = 4.
Therefore, last non-leaf node = 6.

To build the heap, heapify only the nodes:
[1, 3, 5, 4, 6] in reverse order.

Heapify 6: Swap 6 and 17.

                 1
              /     \
            3         5
         /    \      /  \
        4      17   13  10
       / \    /  \
      9   8  15   6

Heapify 4: Swap 4 and 9.

                 1
              /     \
            3         5
         /    \      /  \
        9      17   13  10
       / \    /  \
      4   8  15   6

Heapify 5: Swap 13 and 5.

                 1
              /     \
            3         13
         /    \      /  \
        9      17   5   10
       / \    /  \
      4   8  15   6

Heapify 3: First Swap 3 and 17, again swap 3 and 15.

                 1
              /     \
            17         13
          /    \      /  \
         9      15   5   10
        / \    /  \
       4   8  3   6

Heapify 1: First Swap 1 and 17, again swap 1 and 15,
           finally swap 1 and 6.

                 17
              /      \
            15         13
          /    \      /  \
         9      6    5   10
        / \    /  \
       4   8  3    1
*/

import java.util.*;

public class Heap
{
	public static void heapify(int arr[],int n,int i)
	{
		int largest = i;

		int left = 2*i + 1;
		int right = 2*i + 2;

		if(left<n && arr[left] > arr[largest])
			largest = left;

		if(right<n && arr[right] > arr[largest])
			largest = right;

		if(largest!=i)
		{
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr,n,largest);
		}
	}

	public static void buildHeap(int arr[], int n)
	{
		int lastLeafNode = (n/2) - 1;

		for(int i = lastLeafNode;i>=0;i--)
			heapify(arr,n,i);
	}

	public static void printHeap(int arr[], int n)
	{
		System.out.println("The Max Heap (as represented in an array) -->");

		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter value of n-->");
		int n= sc.nextInt();
		System.out.println("Enter "+n+" elements-->");
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		buildHeap(arr,n);
		printHeap(arr,n);
	}
}
