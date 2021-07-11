/*
Diameter of Binary Tree

Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).



Example 1:

Input:
       1
     /  \
    2    3
Output: 3
Example 2:

Input:
         10
        /   \
      20    30
    /   \
   40   60
Output: 4
Your Task:
You need to complete the function diameter() that takes root as parameter and returns the diameter.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000




*/

// User function Template for Java

/*class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/
class ans
{
    int a;
    ans(int a)
    {
        this.a = a;
    }
}
class Diameter {
    // Function to return the diameter of a Binary Tree.

    int solve(Node root, ans res)
    {
        //base case
        if(root==null)
            return 0;

        //hypothesis
        int leftD = solve(root.left,res);
        int rightD = solve(root.right,res);

        //induction
        int temp = 1 + Math.max(leftD , rightD);//choice 1
        int ans = Math.max(temp, 1+leftD+rightD);//choice 2

        res.a = Math.max(ans , res.a);

        return temp;
    }
    int diameter(Node root) {
        // Your code here
       //using a class, since we want changes made to reflect, analogous to
       //pass by reference
        ans res = new ans(Integer.MIN_VALUE);
        int x = solve(root, res);
        return res.a;
    }
}
