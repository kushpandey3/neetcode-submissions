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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null) return null;
        if(p.val==root.val) return p;
        if(q.val==root.val) return q;
        boolean pOnLeft = false, qOnLeft = false;
        if(p.val<root.val) pOnLeft = true;
        if(q.val<root.val) qOnLeft = true;
        if(pOnLeft==qOnLeft){
            if(pOnLeft) return lowestCommonAncestor(root.left, p, q);
            return lowestCommonAncestor(root.right, p, q);
        }
        else return root;
    }
}
