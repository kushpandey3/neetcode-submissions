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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return bfs(root.left, Integer.MIN_VALUE, root.val) && bfs(root.right, root.val, Integer.MAX_VALUE);
    }
    public boolean bfs(TreeNode root, int min, int max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return bfs(root.left, min, root.val) && bfs(root.right, root.val, max);
    }
}
