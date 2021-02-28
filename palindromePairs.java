import java.util.*;

// runtime: 136ms memory: 47.7MB
class Solution {
    public class Node {
        Node[] children;
        Boolean isWord;
        int index;
        
        private Node() {
            children = new Node[26];
            isWord = false;
            index = -1;
        }
    }
    
    public Node root;
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        root = new Node();
        
        for(int i = 0; i < words.length; i++)
            insert(words[i], i);
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() == 0) {
                for(int j = 0; j < words.length; j++) 
                    if(j != i && isPalindrome(words[j]))
                        res.add(new ArrayList<>(Arrays.asList(i, j)));
            } else {
                List<List<Integer>> resi = findPalindromePairs(words[i], i);
                for(List<Integer> tmpres: resi)
                    if(tmpres != null) res.add(tmpres);
            }    
        }
        
        return res;      
    }
    
    private void insert(String word, int idx) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            char ac = word.charAt(i);
            if(curr.children[ac - 'a'] == null) curr.children[ac - 'a'] = new Node();            
            curr = curr.children[ac - 'a'];
        }
        
        curr.index = idx;
        curr.isWord = true;
    }
    
    private int contains(String word) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            char ac = word.charAt(word.length() - 1 - i);
            if(curr.children[ac - 'a'] == null) return -1;
            curr = curr.children[ac - 'a'];
        }
        
        if(curr.isWord) return curr.index;
        else return -1;
        
    }
    
    private List<List<Integer>> findPalindromePairs(String word, int idx) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            int idxleft = contains(word.substring(0, i));
            int idxright = contains(word.substring(i));

            if(isPalindrome(word.substring(0, i)) && idxright >= 0)
                if(idxright != idx)
                    res.add(new ArrayList<>(Arrays.asList(idxright, idx)));

            if(isPalindrome(word.substring(i)) && idxleft >= 0)
                if(idxleft != idx)
                    res.add(new ArrayList<>(Arrays.asList(idx, idxleft)));            
        }
        return res;
    }
    
    private Boolean isPalindrome(String str) {
        if(str.length() == 0) return true;
        
        int left = 0, right = str.length() - 1;
        char[] charArr = str.toCharArray();
        
        while(left <= right) {
            if(charArr[left] == charArr[right]) {
                left ++;
                right --;
            }
            else return false;
        }
        
        return true;
    }
}

//runtime: 146ms memory: 41.7MB
class Solution {
    Map<String, Integer> strmap;
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        strmap = new HashMap<>();
        
        for(int i = 0; i < words.length; i++)
            strmap.put(stringReverse(words[i]), i);
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() == 0) {
                for(int j = 0; j < words.length; j++) 
                    if(j != i && isPalindrome(words[j]))
                        res.add(new ArrayList<>(Arrays.asList(i, j)));
            } else {
                List<List<Integer>> resi = findPalindromePairs(words[i], i);
                for(List<Integer> tmpres: resi)
                    if(tmpres != null) res.add(tmpres);
            }    
        }
        
        return res;      
    }
    
    private String stringReverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
    
    private List<List<Integer>> findPalindromePairs(String word, int idx) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < word.length(); i++) {
            int idxleft = strmap.containsKey(word.substring(0, i)) ? strmap.get(word.substring(0, i)) : -1;
            int idxright = strmap.containsKey(word.substring(i)) ? strmap.get(word.substring(i)) : -1;
            
            if(isPalindrome(word.substring(0, i)) && idxright >= 0)
                if(idxright != idx)
                    res.add(new ArrayList<>(Arrays.asList(idxright, idx)));
            
            if(isPalindrome(word.substring(i)) && idxleft >= 0)
                if(idxleft != idx)
                    res.add(new ArrayList<>(Arrays.asList(idx, idxleft)));            
        }
        return res;
    }
    
    private Boolean isPalindrome(String str) {
        if(str.length() == 0) return true;
        
        int left = 0, right = str.length() - 1;
        char[] charArr = str.toCharArray();
        
        while(left <= right) {
            if(charArr[left] == charArr[right]) {
                left ++;
                right --;
            }
            else return false;
        }
        
        return true;
    }

}