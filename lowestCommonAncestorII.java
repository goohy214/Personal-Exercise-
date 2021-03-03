/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean foundp = false, foundq = false;
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        
        if(root == p) {
            foundp = true;
            return root;
        }
        
        if(root == q) {
            foundq = true;
            return root;
        }
        
        if(left != null && right != null) return root;
            
        return left != null ? left : right;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);
        
        if(foundp && foundq) return res;
        
        return null;
    }
}