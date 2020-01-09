//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        
        if(root!=NULL){
            inorder(ans,root);
        }
        
        return ans;
        
    }
    
    void inorder(vector<int> &ans, TreeNode* root){
        if(root!=NULL){
            inorder(ans,root->left);
            ans.push_back(root->val);
            inorder(ans, root->right);
        }
        
    }
};
