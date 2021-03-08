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
    List<Integer> valueList;
    List<TreeNode> nodeList;
    public void recoverTree(TreeNode root) {
        valueList = new ArrayList<>();
        nodeList = new ArrayList<>();
        inorder(root);
        Collections.sort(valueList);
        for(int i = 0; i < nodeList.size(); i++)
            (nodeList.get(i)).val = valueList.get(i);
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        valueList.add(root.val);
        nodeList.add(root);
        inorder(root.right);
    }
}

