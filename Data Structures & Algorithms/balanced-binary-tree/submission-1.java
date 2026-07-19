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
    public boolean isBalanced(TreeNode root) {
        return (dfs(root)!=-1);
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int lDep = dfs(root.left);
        if(lDep==-1) return -1;
        int rDep = dfs(root.right);
        if(rDep==-1) return -1;
        if(Math.abs(lDep-rDep)>1) return -1;
        return 1 + Math.max(lDep, rDep);
    }
}
