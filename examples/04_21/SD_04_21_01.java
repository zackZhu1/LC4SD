public List<Integer> inorderTraversal(TreeNode root) {
  List<Integer> res = new ArrayList<>();
  if (root == null) return res;

  Deque<TreeNode> stack = new ArrayDeque<>();
  pushLeft(root, stack);

  while (!stack.isEmpty()) {
    TreeNode cur = stack.pollFirst();
    result.add(cur.val);

    // two options: 
    // cur.right != null
    // cur.right == null
    pushLeft(result.right, stack);
  }
  return result;
}

private void pushLeft(TreeNode cur, Deque<TreeNode> stack) {
  while (cur != null) {
    stack.offerFirst(cur);
    cur = cur.left;
  }
}

// Time = O(n)
// Space = O(height)