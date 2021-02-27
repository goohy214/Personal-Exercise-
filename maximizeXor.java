import java.util.*;

class Solution {
    
    public class Node {
        Node[] children;
        
        private Node() {
            children = new Node[2];
        }
    }
    
    public Node root;
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        root = new Node();
        
        Arrays.sort(nums);
        
        List<List<Integer>> sortedQueries = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            sortedQueries.add(Arrays.asList(queries[i][0], queries[i][1], i));
        }
        Collections.sort(sortedQueries, (a, b) -> a.get(1) - b.get(1));
        
        int numIdx = 0;
        for(int i = 0; i < queries.length; i++) {
            
            int numi = nums[i];
            int xi = sortedQueries.get(i).get(0);
            int mi = sortedQueries.get(i).get(1);
            int idx = sortedQueries.get(i).get(2);
            
            while(numIdx < nums.length && nums[numIdx] <= mi) {
                insert(nums[numIdx++]);
            }
            
            int resi = searchMaxXOR(xi);
            
            res[idx] = resi;
        
        }
        
        return res;
    }
    
    private void insert(int num) {
        Node curr = root;
        
        for(int i = 0; i < 30; i++) {
            int bit = (num & (1 << (29 - i))) == 0 ? 0 : 1;
            if(curr.children[bit] == null) curr.children[bit] = new Node();
            curr = curr.children[bit];
        }
    }
    
    private int searchMaxXOR(int x) {
        Node curr = root;
        
        if(curr.children[0] == null && curr.children[1] == null) return -1;
        
        int res = 0;
        
        for(int i = 0; i < 30; i++) {
            int bit = (x & (1 << (29 - i))) == 0 ? 0 : 1;
            if(curr.children[1 - bit] != null) {
                res += (1 << (29 - i));
                curr = curr.children[1 - bit];
            } else curr = curr.children[bit];
        }
        
        return res;
    }
}