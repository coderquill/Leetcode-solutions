/* https://leetcode.com/problems/deepest-leaves-sum/
Given a binary tree, return the sum of values of its deepest leaves.
 

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
*/


class Solution {
    private int maxlevel=0;
    private int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        traverse(root,0);
        return sum;
    }
    private void traverse(TreeNode root,int level){
        if(root==null)return;
        if(level==maxlevel){
            sum+=root.val;
        }
        if(level>maxlevel){
            maxlevel=level;
            sum=root.val;
        }
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}
