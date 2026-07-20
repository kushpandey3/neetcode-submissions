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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root==null) return ret;
        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> levels = new LinkedList<>();
        int currLevel = 0;
        q.add(root);
        levels.add(0);
        while(!q.isEmpty()){
            List<Integer> list = new LinkedList<>();
            while(!levels.isEmpty()&&levels.peek()==currLevel){
                TreeNode curr = q.poll();
                list.add(curr.val);
                levels.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                    levels.add(currLevel+1);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    levels.add(currLevel+1);
                }
            }
            ret.add(list);
            currLevel++;
        }
        return ret;
    }
}
