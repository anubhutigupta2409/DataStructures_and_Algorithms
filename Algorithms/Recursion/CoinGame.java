/*
Game theory-->CoinMax
_____________________
Explaining the question-->
there are even no. of coins available (can be thought of as an array), keeping in mind that both players are equally smart, the
game is to choose a coin turn by turn with the constraint that one can choose a coin from any of the corners and the other player
gets to choose the coins from the either of the corners in the range now left. Develop a logic so that you as a player always win,
--> how does one win? by chosing the coins wisely so that the sum of the value of the coins we collected will be more than the
other player.
______________________
Approach-->
Example====>

1 5 7 3 2 4
0 1 2 3 4 5 <--indices

we can either chose a[0] or a[5] in first go, but we should assume that the other player will let us choose the next coin, which
will have the minimum value out of possible picks from the rest of the range, therefore keeping in mind our next pick , we will
choose the maximum from (a[0]+min from rest range, a[5]+min from rest range)

base case here would be if we reach two coins only, then we can just return the max of the two, to track that we take as input two
integers l and r, and or base condition can be generalised as if (l+1==r)
*/

public class CoinGame
{
	static int coinMax(int a[] ,int l, int r)
	{
		if(l+1 == r)
			return Math.max(a[l],a[r]);

		return Math.max(a[l]+ Math.min(coinMax(a,l+1,r-1),coinMax(a,l+2,r)),
						a[r]+Math.min(coinMax(a,l+1,r-1),coinMax(a,l,r-2)));
	}
	public static void main(String args[])
	{
		int a[]={1,5,7,3,2,4};//12<--Answer
		/*
		explaining the approach we used in our code
		4,1,7<--us
		2,5,3<--other player
		*/
		System.out.println(coinMax(a , 0 , a.length-1));
	}
}