/*
print all the prime numbers below or equal to n
*/

import java.util.*;

public class SieveOfEratosthenes{
	public static void main(String args[])
		{	Scanner sc = new Scanner(System.in);
			System.out.println("Enter your no.=");
			int n = sc.nextInt();
			boolean isPrime[] = new boolean[n+1]; // to update each no. below or equal to n

			for(int i=0;i<=n;i++)
				isPrime[i] = true; // each updated as true

			// "0" and "1" are neither prime nor composite
			// to find a factor of a partcular no. -
			// p<=sqrt(n) SBS
			// = p*p<= n

			for(int p = 2 ; p*p<=n ; p++)
				{	if(isPrime[p]== true)
						{	//all the multiples of the above no. are not prime
							for(int i = p*2 ; i<=n ; i+=p)
								isPrime[i]=false;
						}
				}

			System.out.println("All the prime nos. below n or equal to n are =");
			for(int i= 2; i<=n ; i++)
				{if(isPrime[i]==true)
					System.out.print(i + " ");
				}
		}
				  }