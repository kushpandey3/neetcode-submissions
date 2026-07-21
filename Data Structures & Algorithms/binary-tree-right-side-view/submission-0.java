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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root==null) return ret;
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            ret.add(q.peek().val);
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                if(curr.right!=null) q.add(curr.right);
                if(curr.left!=null) q.add(curr.left);
            }
        }
        return ret;
    }
}
