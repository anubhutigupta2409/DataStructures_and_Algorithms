class PostOrderIterative
{
	public void postorderI(Node root)
	{
		//empty stack for our use, and push the root node
		Stack<Node> stk = new Stack<Node>;
		stk.push(root);

		//stack to store the postorder traversal
		Stack<Integer> res = new Stack<Integer>;

		while(!stk.empty())
		{
			//pop the node, then push it in the result stack
			Node curr = stk.pop();
			res.push(curr.data);

			//push left and right childs
			if(curr.left!=null)
				stk.push(curr.left);

			if(curr.right!=null)
				stk.push(curr.right);
		}

		//print the result
		while(!res.empty())
			System.out.print(res.pop() + " ");
	}
}