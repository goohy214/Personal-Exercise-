/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        TreeNode p = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            if (p == nodes[i])
                continue;
            p = lowestCommonAncestorTwoNode(root, p, nodes[i]);
        }
        return p;
    }

    private TreeNode lowestCommonAncestorTwoNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestorTwoNode(root.left, p, q);
        TreeNode right = lowestCommonAncestorTwoNode(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
