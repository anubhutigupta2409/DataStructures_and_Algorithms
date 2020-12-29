//So, the coin change problem is the problem where we are given a certain amount of money and we are given coins of
//different denominations and we are supposed to give the output in the form of how many minimum coins we require
//in order to get that certain amount of money.
//----> For example over here ---->

//Denominations given --> {1,5,7} , Money to make=18
//--> following greedy approach --> (7)*2 + (1)*4 --> Total 6 coins, failed
//Better approach--> (7)*1 + (5)*2 + (1)*1 --> Total 4 coins, minimum possible coins

//here's how to develop the above approach in the code
/*

	    18 {1,5,7}
              /   |   \
          (1)/ (5)| (7)\		<---(used coin in brackets)
            /     |     \
           17     13     11		<---(subtracting to get the left money)
          /|\ 	  /|\    /|\
         / | \   / | \  / | \
       16 12 10 12 8 6 10 6  4

*/


public class CoinChangeNormal {

	public static void main(String[] args) {
		int rs = 18;
		int denominations[] = {1,5,7};
		int ans= minCoins(rs, denominations);
		System.out.println(ans);
	}

	static int minCoins(int rs, int denominations[])
	{
		//base case
		if(rs==0)
				return 0;
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<denominations.length;i++)
		{
			//recursion
			if(rs-denominations[i] >= 0)
			{
				int subAns = minCoins(rs-denominations[i], denominations);
				if(subAns!= Integer.MAX_VALUE && subAns + 1< ans)
				{
					ans = subAns+1;//why +1, as we have used 1 coin
				}
			}
		}
		return ans;
	}

}
