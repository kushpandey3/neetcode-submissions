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
    public int ans = 0;
    public int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        ans = root.val;
        dfs(root,k);
        return ans;
    }
    public void dfs(TreeNode node, int tar){
        if(node.left!=null) dfs(node.left, tar);
        num++;
        if(num==tar) ans = node.val;
        if(node.right!=null) dfs(node.right,tar);
    }
}
