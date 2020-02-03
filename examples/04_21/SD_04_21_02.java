public void inorderTraversal(TreeNode root) {
	TreeNode cur = firstNode(root);
	System.out.println(cur.val);
	while (cur != null) {
		cur = nextNode(cur);
		System.out.println(cur.val);
	}
}

private TreeNode firstNode(TreeNode root) {
	if (root == null) return null;
	while (root != null) {
		root = root.left;
	}
	return root;
}

private TreeNode nextNode(TreeNode cur) {
	if (cur == null) return null;
	if (cur.right != null) return firstNode(root.right);

	// find the first node that the left subtree of it is finished
	while (cur.parent != null && cur = cur.parent.right) {
		cur = cur.parent;
	}
	return cur.parent;
}

// Time = O(n)
// Space = O(1)