class WordFilter {   
    public class Node {
        Node[] children;
        List<Integer> indexs;
        
        private Node() {
            children = new Node[26];
            indexs = new ArrayList<>();
        }
    }
    
    public Node preTrie;
    public Node suffTrie;

    public WordFilter(String[] words) {
        preTrie = new Node();
        suffTrie = new Node();
        for(int i = 0; i < words.length; i++)
            addWord(words[i], i);
    }
    
    private void addWord(String word, int idx) {
        Node preCurr = preTrie;
        Node suffCurr = suffTrie;
        for(int i = 0; i < word.length(); i++) {
            char prec = word.charAt(i);
            char suffc = word.charAt(word.length()-1-i);
            
            if(preCurr.children[prec-'a'] == null) 
                preCurr.children[prec-'a'] = new Node();
            
            if(suffCurr.children[suffc-'a'] == null) 
                suffCurr.children[suffc-'a'] = new Node();
            
            preCurr = preCurr.children[prec-'a'];
            suffCurr = suffCurr.children[suffc-'a'];
            
            preCurr.indexs.add(idx);
            suffCurr.indexs.add(idx);
        } 
    }
    
    public int f(String prefix, String suffix) {
        Node preCurr = preTrie;
        Node suffCurr = suffTrie;
        
        for(int i = 0; i < prefix.length(); i++) {
            char prec = prefix.charAt(i);
            if(preCurr.children[prec-'a'] != null) 
                preCurr = preCurr.children[prec-'a'];
            else return -1;
        }
        
        for(int j = suffix.length()-1; j >= 0; j--) {
            char suffc = suffix.charAt(j);
            if(suffCurr.children[suffc-'a'] != null) 
                suffCurr = suffCurr.children[suffc-'a'];
            else return -1;
        }
        
        List<Integer> preList = preCurr.indexs;
        List<Integer> suffList = suffCurr.indexs;
        int m = preList.size()-1;
        int n = suffList.size()-1;    
        while(m >=0 && n >= 0) {
            if(preList.get(m) > suffList.get(n))
                m--;
            else if(preList.get(m) < suffList.get(n))
                n--;
            else return preList.get(m);
        }
        
        return -1;
    }
    
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */