/*
Boolean Parenthesization
Hard
Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Example 1:

Input: N = 7
S = T|T&F^T
Output: 4
Explaination: The expression evaluates
to true in 4 ways ((T|T)&(F^T)),
(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: N = 5
S = T^F|F
Output: 2
Explaination: ((T^F)|F) and (T^(F|F)) are the
only ways.


Your Task:
You do not need to read input or print anything. Your task is to complete the function countWays() which takes N and S as input parameters and returns number of possible ways modulo 1003.



Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)



Constraints:
1 = N = 200
*/

class BooleanParenthesizationRecursion{
    static int util(String s, int i, int j, boolean exp)
    {
        //base condition
        if(i>j)
            return 0;
        if(i==j)
        {
            if(exp==true)
                return s.charAt(i)=='T' ? 1 : 0;
            else
                return s.charAt(i)=='F' ? 1 : 0;
        }

        //loop
        int ans=0;

        for(int k=i+1;k<=j-1;k+=2)
        {
            //temp ans
            int lt = util(s, i, k-1, true);
            int lf = util(s, i, k-1, false);
            int rt = util(s, k+1, j, true);
            int rf = util(s, k+1, j, false);

            //final answer
            if(s.charAt(k) == '&')
            {
                if(exp==true)
                    ans+= lt*rt;
                else
                    ans+= lt*rf + lf*rt + lf*rf;
            }
            if(s.charAt(k) == '|')
            {
                if(exp==true)
                    ans+= lt*rt + lt*rf + lf*rt;
                else
                    ans+= lf*rf;
            }
            if(s.charAt(k) == '^')
            {
                if(exp==true)
                    ans+= lt*rf + lf*rt;
                else
                    ans+= lt*rt + lf*rf;
            }
        }
        return ans;
    }
    static int countWays(int N, String S){
        // code here
       
        return util(S, 0, N-1 , true);
    }
}
