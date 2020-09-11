// Selection Sort
// in this every element is checked with the entire array ,whether it is the least or not
/*3 5 1 2 4==1 5 3 2 4==1 2 3 5 4==1 2 3 5 4==1 2 3 4 5
  !   !    	   !   !	    !			 ! !
  (replaced with the least element available)
*/

/*
Although insertion and selection sort both have a time complexity of O(n^2) but insertion is way better since it skips
running the code when the sorted array is passed but selection sort's code does run even though we pass a sorted array.
*/

import java.util.*;

public class SelectionSort
{
public static void selectionSort(int a[])
{	for(int i=0;i<a.length;i++)
	{	int min=a[i];
		int pos=i;
		for(int j=i+1;j<a.length;j++)
		{	if(a[j]<min)
			{	min=a[j];
				pos=j;
			}
		}
		//swaping
		int temp=a[i];
		a[i]=min;// putting the minimum element in current element
		a[pos]=temp;//putting the current elemet at that position

	}
	System.out.println("\nSorted array-");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
}

public static void main(String args[])
{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the no. of elements- ");
			int n=sc.nextInt();
			int a[]= new int[n];
			System.out.println("Enter the elements of array-");
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			System.out.println("Original Array-");
			for(int i=0;i<n;i++)
				System.out.print(a[i]+" ");
			selectionSort(a);
}
}