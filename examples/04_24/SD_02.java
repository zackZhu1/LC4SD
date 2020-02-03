
    	  5
 		/   \ 
	   1      9
	   /\   /   \
      0  3 8   11
        /
      2

Top view: [1, 5, 9, 11]
Bottom view: [2, 3(8), 9, 11]

// top view 
public List<Integer> topView(TreeNode root) {
	Queue<NodeWithCol> q = new ArrayDeque<>(); // BFS
	q.offer(new NodeWithCol(root, 0));

	Deque<Integer> res = new ArrayDeque<>();
	res.offer(root.val);
	int leftMost = 0;
	int rightMost = 0;

	while (!q.isEmpty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {

			NodeWithCol cur = q.pollFirst();

			if (cur.node.left != null) {
				if (cur.col == leftMost) {
					res.offerFirst(cur.node.left.val);
					leftMost--;
				}
				q.offer(new NodeWithCol(cur.node.left, cur.col - 1));
			}

			if (cur.node.right != null) {
				if (cur.col == rightMost) {
					res.offerLast(cur.node.right.val);
					rightMost++;
				}
				q.offer(new NodeWithCol(cur.node.right, cur.col + 1));
			}
		}
	}
	return new ArrayList<>(res);
}



// bottom view
class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class NodeWithCol {
	int col;
	TreeNode node;
	
	NodeWithCol(int col, TreeNode node) {
		this.col = col;
		this.node = node;
	}
}

public class test {
	public static TreeMap<Integer, Integer> map = new TreeMap<>(); // col: node.val
	
	public static void bottomView(TreeNode root) {
		if (root == null) return;
		
		Queue<NodeWithCol> queue = new LinkedList<>();
		queue.offer(new NodeWithCol(0, root));
		
		while (!queue.isEmpty()) {
			NodeWithCol cur = queue.poll();
			map.put(cur.col, cur.node.val);
			
			if (cur.node.left != null) {
				queue.offer(new NodeWithCol(cur.col - 1, cur.node.left));
			}
			if (cur.node.right != null) {
				queue.offer(new NodeWithCol(cur.col + 1, cur.node.right));
			}
		}
	}
	
	public static void display() { // print the bottom view.
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.print(map.get(key));
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		bottomView(root);
		display();
	}
}


// vertical list view
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (root == null) return res;
        
        Map<Integer, List<Integer>> map = new HashMap<>(); // col: [node.val]
        int min = 0;
        int max = 0;
        
        Queue<NodeWithCol> queue = new LinkedList<>();
        queue.offer(new NodeWithCol(root, 0));
        
        while (!queue.isEmpty()) {
            NodeWithCol cur = queue.poll();
            
            if (!map.containsKey(cur.col)) {
                map.put(cur.col, new ArrayList<>());
            }
            map.get(cur.col).add(cur.node.val);
            
            
            if (cur.node.left != null) {
                queue.offer(new NodeWithCol(cur.node.left, cur.col - 1));
                min = Math.min(min, cur.col - 1);
            }
            if (cur.node.right != null) {
                queue.offer(new NodeWithCol(cur.node.right, cur.col + 1));
                max = Math.max(max, cur.col + 1);
            }
        }
        
        // generate res from map, min, max
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}

class NodeWithCol {
    TreeNode node;
    int col;
    NodeWithCol(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

// border view
// leftMost path: DFS, preorder, left -> right
// rightmost path: DFS, postorder, left -> right
// leaf nodes: DFS, pre/in/post, left -> right
public void borderView(TreeNode root) {
	if (root == null) return;
	dfs(root, true, true);
}

private void dfs(TreeNode root, boolean leftMost, boolean rightMost) {
	if (root == null) return;

	if (leftMost || root.left == null && root.right == null) {
		System.out.print(root.val + " ");
	}
	dfs(root.left, leftMost, false);
	dfs(root.right, false, rightMost);
	if (rightMost && (root.left != null || root.right != null)) {
		System.out.print(root.val + " ");
	}
}


































