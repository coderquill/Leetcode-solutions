/* https://leetcode.com/problems/binary-tree-postorder-traversal/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        int i;
        ArrayList<Integer> arr=new ArrayList<>();
         ArrayList<Integer> arrli=new ArrayList<>();
        Stack <TreeNode> stack= new Stack<>();
        if(root==null)
            return arrli;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode curr = stack.pop();
            arr.add(curr.val);
            if(curr.left!=null)
                stack.push(curr.left);
            if(curr.right!=null)
                stack.push(curr.right);
        }
        for(i=arr.size()-1;i>=0;i--)
            arrli.add(arr.get(i));
        return arrli;
    }
}
