/*https://leetcode.com/problems/find-leaves-of-binary-tree

Given a imbalance binary tree, print the leaf nodes then remove those leaf node, print the new leaf nodes until only root node left.

For example:

          1
         / \
        2   3
       / \     
      4   5    
Print: [4 5 3], [2], [1]

*/




public class PrintAndRemoveLeafNodes {

	private static List<List<Integer>> leaves;

	public static List<List<Integer>> printAndRemoveLeafNodes(TreeNode root) {
		leaves = new ArrayList<List<Integer>>();

		if (root == null)
			return leaves;
               
          
		TreeNode dummy = new TreeNode(-1);
		dummy.left = root;
		printAndRemoveLeafNodes(dummy, root, true);

		return leaves;
	}

	private static int printAndRemoveLeafNodes(TreeNode parent, TreeNode child, boolean left) {
		int level = 0;

		if (child.left != null)
			level = printAndRemoveLeafNodes(child, child.left, true);
		if (child.right != null)
			level = Math.max(level, printAndRemoveLeafNodes(child, child.right, false));
                
		if (left)
			parent.left = null;
		else
			parent.right = null;

		if (leaves.size() < level + 1)
			leaves.add(new ArrayList<Integer>());
                
		leaves.get(level).add(child.val);
		return level + 1;
	}

}
