// In-Order Iterator of binary tree without parent pointer
class InOrderIterator {
	Deque<TreeNode> stack;

	public InOrderIterator(TreeNode root) {
		stack = new ArrayDeque<>();
		firstNode(root);
	}

	public TreeNode next() {
		if (!hasNext()) throw Exception();
		TreeNode cur = stack.pollFirst();
		firstNode(cur.right);
		return cur;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void firstNode(TreeNode root) {
		while (root != null) {
			stack.offerFirst(root);
			root = root.left;
		}
	}
}