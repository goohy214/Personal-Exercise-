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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        TreeNode p  = nodes[0];
        for(int i = 1; i < nodes.length; i++) {            
            if(p == nodes[i]) continue;
            p = lowestCommonAncestorTwoNode(root, p, nodes[i]);            
        }
        return p;
    }
    
    private TreeNode lowestCommonAncestorTwoNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestorTwoNode(root.left, p, q);
        TreeNode right = lowestCommonAncestorTwoNode(root.right, p, q);
        
        if(left != null && right != null) return root;
        
        return left != null ? left : right;
    }
}

class Solution {   
    Set<Integer> set;    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        set = new HashSet<>();
        for(TreeNode node: nodes)
            set.add(node.val);
        
        return lowestCommonAncestor(root);
    }

    private TreeNode lowestCommonAncestor(TreeNode root) {
        if(root == null) return root;
        
        if(set.contains(root.val)) return root;
        
        TreeNode left = lowestCommonAncestor(root.left);
        TreeNode right = lowestCommonAncestor(root.right);
        
        if(left != null && right != null) return root;
        
        if(left != null) return left;
          
        return right;
    }
}




