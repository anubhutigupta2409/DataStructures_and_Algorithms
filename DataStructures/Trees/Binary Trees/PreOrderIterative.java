class PreOrderIterative
{
	public void preorderI(Node root)
	{
		//base case
		if(root==null)
			return;

		//create an empty stack and push the root node
		Stack<Node> stk= new Stack<Node>;
		stk.push(root);

		//make a current node, starting from the root of the tree
		Node curr = root;

		//loop's gonna work till the stack is empty
		while(!stk.empty())
		{
			if(curr!=null)
			{
				//since it's preorder, process the current node
				//then push the right of the current(for left to be processed first, right needs to be pushed, coz FIFO)

				System.out.print(stk.data + " ");
				if(curr.right!=null)
					stk.push(curr.right);

				//move to left
				curr = curr.left;
			}
			else
			{
				//set the current node = the popped node
				curr=stk.pop();
			}
		}
	}
}