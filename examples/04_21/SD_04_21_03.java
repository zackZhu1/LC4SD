// preOrder
TreeNode firstNode(TreeNode root) {
	return root;
}

TreeNode nextNode(TreeNode cur) {
	if (cur == null) return null;
	// case1: 
	if (cur.left != null) return firstNode(cur.left);
	// case2:
	if (cur.right != null) return firstNode(cur.right);
	// case3: if left and right subtree are both null
	// cur == cur.parent.right: go up
	// cur == cur.parent.left:
	//		if parent.right == null: go up
	// 		else: parent.right
	while (cur.parent != null && (cur == cur.parent.right || cur.parent.right == null)) {
		cur = cur.parent;
	}

	return cur.parent == null ? null : firstNode(cur.parent.right);
}


// postOrder

// recursion
TreeNode firstNode(TreeNode root) {
	if (root == null) return null;
	if (root.left != null) return firstNode(root.left);
	if (root.right != null) return firstNode(root.right);
	return root;
}

// iteration
TreeNode firstNode(TreeNode root) {
	if (root == null) return null;
	while (root.left != null || root.right != null) {
		if (root.left != null) {
			root = root.left;
		} else {
			root = root.right;
		}
	}
	return root;
}


TreeNode nextNode(TreeNode cur) {
	if (cur == null) return null;
	if (cur.parent == null) return cur.parent;
	if (cur = cur.parent.right || (cur == cur.parent.left && cur.parent.right == null)) return cur.parent;
	return firstNode(cur.parent.right);
}















