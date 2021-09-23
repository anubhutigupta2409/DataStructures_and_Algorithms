/*
Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class  GenerateParentheses{
    private void solve(List<String> res, int open, int close, String op)
    {
        if(open==0 && close==0)
        {
            res.add(op);
            return;
        }
        if(open!=0)
        {
            solve(res,open-1,close,op+"(");
        }
        if(close>open)
        {
            solve(res,open,close-1,op+")");
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        
        //res
        List<String> res = new ArrayList<>();
        
        int open = n, close = n;
        
        solve(res,open,close,"");
        
        return res;
        
    }
}