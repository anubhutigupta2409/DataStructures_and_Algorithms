class InOrderIterative
{
	public void inorderI(Node root)
	{
		//base case
		if(root == null)
			return;

		Stack<Node> stk = new Stack<Node>;

		//current node
		Node curr= root;

		//loop works till the time either the stack is not empty or, the current node is not null
		while(curr!=null || !stk.empty())
		{
			//till the time curr is not null, traverse the left node and push it into the stack
			//since it is inorder

			if(curr!=null)
			{
				stk.push(curr);
				curr = curr.node;
			}

			else
			{
				//if it is null, pop it, print it, and set the current node to it's right child
				curr=stk.pop();
				System.out.print(stk.data + " ");
				curr = curr.right;
			}
		}
	}
}