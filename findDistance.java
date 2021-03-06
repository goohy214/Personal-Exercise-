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
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q) return 0;
        return findDistance(root, p, q, 0);
    }
    
    private int findDistance(TreeNode root, int p, int q, int depth) {
        if(root == null) return 0;
        
        int left = findDistance(root.left, p, q, depth + 1);
        int right = findDistance(root.right, p, q, depth + 1);
        
        if(root.val == p || root.val == q) return Math.abs(Math.max(left, right) - depth);
        
        if(left != 0 && right != 0) return left + right;
        
        return Math.abs(left - right);
    }
}