public class findMaximumXOR {
    public class Node {
        Node[] children;
        
        private Node() {
            children = new Node[2];
        }
    }
    
    public Node root;
    
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        int maxXOR = 0;
        
        for(int num: nums) 
            insert(num);
        
        for(int num: nums) {
            int tmpMax = findMaximumXOR(num);
            maxXOR = Math.max(maxXOR, tmpMax);
        }
            
        return maxXOR;
    }
    
    private void insert(int num) {
        Node curr = root;
        
        for(int i = 0; i < 31; i++) {

            int bit = (num & (1 << (30 - i))) == 0 ? 0 : 1;
            
            if(curr.children[bit] == null) curr.children[bit] = new Node();
            
            curr = curr.children[bit];
        }
        
    }
    
    private int findMaximumXOR(int num) {
        Node curr = root;
        int res = 0;
        
        for(int i = 0; i < 31; i++) {
            
            int bit = (num & (1 << (30 - i))) == 0 ? 0 : 1;
            
            if(curr.children[1 - bit] != null) {  
                res += (1 << (30 - i));
                curr = curr.children[1 - bit];
            }else curr = curr.children[bit];
             
        }
        
       return res; 
    }

}
