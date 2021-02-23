class WordDictionary {
    
    public class Node {
        char ac;
        Node[] children;
        boolean isWord;
        
        private Node(char ac) {
            this.ac = ac;
            children = new Node[26];
            isWord = false;
        }
    }
    
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ac = word.charAt(i);
            if(curr.children[ac-'a'] == null) curr.children[ac-'a'] = new Node(ac);
            curr = curr.children[ac-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        return searchHelper(word, 0, curr);      
    }
    
    private boolean searchHelper(String word, int i, Node curr) {
        if(i == word.length()) return curr.isWord;
        // char ac = word.charAt(i);
        // if(ac == '.') {
        //     boolean res = false;
        //     for(Node child: curr.children) {
        //         if(child != null) res = res || searchHelper(word, i+1, child);
        //     }
        //     return res;
        // } else {
        //     if(curr.children[ac-'a'] == null) return false;
        //     else return searchHelper(word, i+1, curr.children[ac-'a']);
        // }
        
        char ac = word.charAt(i);
        if(ac == '.') {
            for(Node child : curr.children){
                if (child != null && searchHelper (word, i+1, child)) return true; 
            }
            return false;
        } else 
            return (curr.children[ac - 'a'] != null  && 
                   searchHelper(word, i+1, curr.children[ac - 'a']));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */