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
        if(root==null) return 0;
        int lDep = getDepth(root.left);
        int rDep = getDepth(root.right);
        if(lDep+rDep>maxDiam) maxDiam = lDep + rDep;
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxDiam;
    }
    public int getDepth(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
