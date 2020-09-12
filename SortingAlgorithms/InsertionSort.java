//Insertion Sort
//Insertion sort, sorts the array by dividing it into sorted and unsorted sub arrays
//That is while we traverse through the array we have our left mosts sub-array as sorted
// it deals with a current element and it's leftmost element
/* 5 4 3 2 1 == 4 5 3 2 1== 4 3 5 2 1== 3 4 5 2 1 ==3 4 2 5 1==3 2 4 5 1 == 2 3 4 5 1 == 2 3 4 1 5== 2 3 1 4 5== 2 1 3 4 5== 1 2 3 4 5
     !(starts from here that is "1" position)
*/
import java.util.*;

public class InsertionSort{

public static void insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
				int current= a[i];
				int j=i-1;
				/*loop works till the time we reach the left most element and current element is less than it's leftmost element*/
				while(j>=0 && current<a[j])
					{a[j+1]=a[j];/*therefore, the name is insertion sort, as the unfit element gets inserted right away*/
					j--;//since we have to move till the left
					}
				a[j+1]=current;//now current element gots inserted
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
	insertionSort(a);
}
}