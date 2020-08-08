/*https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        inorder(root, ls);
        return ls;
    }
    
    public void inorder(TreeNode root, List<Integer> ls) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode temp = root;
        while(temp != null || stack.size() != 0) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            
            temp = stack.pop();
            ls.add(temp.val);
            temp = temp.right;
        }
    }
}
