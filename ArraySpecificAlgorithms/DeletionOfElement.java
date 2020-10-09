// deletion of an element from an array
import java.util.*;
public class DeletionOfElement{
	public static void main(String args[]){
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the no. of elements in the array(less than 100)-");
			int n= sc.nextInt();
			int a[] = new int[100];
			System.out.println("Enter the elements of the array-");
			for(int i=0;i<n;i++)
				a[i]= sc.nextInt();
			System.out.println("Enter the element you want to delete-");
			int ele= sc.nextInt();
			int i;
			for(i=0;i<n;i++)
				if(a[i]==ele)
					break;
			while(!(i<n))
				{
					System.out.println("Not possible to delete this element, enter again-");
					ele= sc.nextInt();
					for(i=0;i<n;i++)
						if(a[i]==ele)
						break;
				}
			int pos=i;
			System.out.println("Original array-");
			for(i=0;i<n;i++)
				System.out.print(a[i]+" ");
			n--;
			for(i=pos;i<n;i++)
				a[i]=a[i+1];
			System.out.println("\nEdited array-");
			for(i=0;i<n;i++)
				System.out.print(a[i]+" ");
		}
}