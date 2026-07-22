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
    int curr = 0;
    int[] pre;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        map = new HashMap<>(); //maps an integer from the inorder traversal to its index
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(0, inorder.length - 1);
    }
    public TreeNode build(int left, int right){
        if(left>right) return null;
        TreeNode root = new TreeNode(pre[curr]);
        curr++;
        int cent = map.get(root.val);
        root.left = build(left, cent - 1);
        root.right = build(cent + 1, right);
        return root;
    }
}
