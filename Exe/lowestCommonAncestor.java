/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

// runtime: 20ms. memory: 39.8MB
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        while(p != null) {
            if(isNodeExist(p, q)) return p;
            p = p.parent;
        }
        
        return null;
    }
    
    public boolean isNodeExist(Node root, Node target) {
        if(root == target) return true;
        if(root == null) return false;
        
        boolean existInLeft = isNodeExist(root.left, target);
        boolean existInRight = isNodeExist(root.right, target);
        
        return existInLeft || existInRight;
    }
}


//runtime: 20ms, memory: 39.6MB
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pointera = p, pointerb = q;
        
        while(pointera != pointerb) {
            pointera = pointera.parent == null ? q : pointera.parent;
            pointerb = pointerb.parent == null ? p : pointerb.parent;
        }
        
        return pointera;
    }
}