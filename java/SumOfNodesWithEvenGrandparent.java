/*https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/*/


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
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
       if(root==null){
           return ans;
       }
        if(root.val%2==0){
            if(root.left!=null){
                if(root.left.left!=null){
                    ans = ans + root.left.left.val; 
                }
                if(root.left.right!=null){
                    ans = ans + root.left.right.val; 
                }
            }
            if(root.right!=null){
                if(root.right.left!=null){
                    ans = ans + root.right.left.val; 
                }
                if(root.right.right!=null){
                    ans = ans + root.right.right.val; 
                }
            }
            
        }
        
        sumEvenGrandparent(root.left);
        
        sumEvenGrandparent(root.right);
        
        return ans;
    }
}
