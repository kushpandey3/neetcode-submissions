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
    public int maxDiam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        complete(root);
        return maxDiam;
    }
    public int complete(TreeNode root){
        if(root==null) return 0;
        int lDep = complete(root.left);
        int rDep = complete(root.right);
        maxDiam = Math.max(maxDiam, lDep + rDep);
        return 1 + Math.max(lDep, rDep);
    }
}
