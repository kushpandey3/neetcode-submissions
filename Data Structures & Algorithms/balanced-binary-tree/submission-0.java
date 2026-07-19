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
    public boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int lDep = dfs(root.left);
        int rDep = dfs(root.right);
        if(Math.abs(lDep-rDep)>1) isBalanced = false;
        return 1 + Math.max(lDep, rDep);
    }
}
