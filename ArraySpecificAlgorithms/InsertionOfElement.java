// insertion of an element inside an array

import java.util.*;
public class InsertionOfElement{
	public static void main(String args[]){
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the no. of elements in the array(less than 100)-");
			int n= sc.nextInt();
			int a[] = new int[100];
			System.out.println("Enter the elements of the array-");
			for(int i=0;i<n;i++)
				a[i]= sc.nextInt();
			System.out.println("Enter the position at which you want to enter the element-");
			int pos= sc.nextInt();// assuming the user knows abt indexing
			while(pos<0 || pos>=n)
				{
					System.out.println("Not possible to add element at this position, enter again-");
					pos= sc.nextInt();
				}
			System.out.println("Enter the element to be added -");
			int ele= sc.nextInt();
			System.out.println("Original array-");
			for(int i=0;i<n;i++)
				System.out.print(a[i]+" ");
			n++;
			for(int i=n;i>pos;i--)
				a[i]=a[i-1];

			a[pos]=ele;
			System.out.println("\nEdited array-");
			for(int i=0;i<n;i++)
				System.out.print(a[i]+" ");
		}
}
