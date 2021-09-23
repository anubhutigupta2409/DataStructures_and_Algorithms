/*
Letter Case Permutation

Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.



Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: s = "12345"
Output: ["12345"]
Example 4:

Input: s = "0"
Output: ["0"]


Constraints:

s will be a string with length between 1 and 12.
s will consist only of letters or digits.
*/

class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ans=new ArrayList<>();
        compute(ans,S.toCharArray(),0);
        return ans;
    }

    public void compute(List<String> ans, char[] chars, int index)
    {
        if(index==chars.length)
            ans.add(new String(chars));
        else
        {
            if(Character.isLetter(chars[index]))
            {
                chars[index]=Character.toLowerCase(chars[index]);
                compute(ans,chars,index+1);
                chars[index]=Character.toUpperCase(chars[index]);
            }
            compute(ans,chars,index+1);
        }
    }
}