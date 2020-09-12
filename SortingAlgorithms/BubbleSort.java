// Bubble Sort
// in bubble sort we swap the adjacent elements if they are not in the required order(ascending here)
/* 5 4 3 2 1== 4 5 3 2 1==4 3 5 2 1==4 3 2 5 1==4 3 2 1 5 (this process will be repeated)
called bubble sort since the elements bubble up the surface while being swaped
*/
import java.util.*;
public class BubbleSort{

	//function for bubbleSort
	public static void bubbleSort(int[] a) {
	    boolean sorted = false;
	    int temp;
	    //as declaring temp inside, would do cope problem
	    //doing the loop till our sorted variable is false
	    while(!sorted) {
	        sorted = true;
	        //loop till a.length-1 as last element need not to be swaped, since it doesn't have a adjacent element
	        for (int i = 0; i < a.length - 1; i++) {
	            if (a[i] > a[i+1]) {
	                temp = a[i];
	                a[i] = a[i+1];
	                a[i+1] = temp;
	                sorted = false;//as we had to swap
								}
													}

	    }
	    System.out.println("\nSorted array-");
	    for(int i=0;i<a.length;i++)
	    	System.out.print(a[i]+" ");
}
	public static void main(String args[]){
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
			bubbleSort(a);
		}
}