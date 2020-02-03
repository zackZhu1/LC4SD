// find kth largest node in BST without parent pointer
// reverse inorder sequence (right -> root -> left)

// solution1: recursion
public void inOrder(TreeNode root, List<TreeNode> result, int k) {
	if (root == null) return null;
	if (result.size() == k) return;

	inOrder(root.left, result, k);
	result.add(root);
	inOrder(root.right, result, k);
}

// solution2: iterative
// use stack to implement an InOrderIterator 
// use the iterator to decouple the traversal logic
InOrderIterator iter = new InOrderIterator(root);
TreeNode result = null;
while (iter.hasNext() && k > 0) {
	result = iter.next();
	k--;
}

return k == 0 ? result : null;