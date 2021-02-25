
// Runtime: 42ms Memory Usage: 50.9MB
// class Trie {
//     class Node {
//         Map<Character, Node> charMap;
//         boolean isWord;
        
//         private Node() {
//             charMap = new HashMap<>();
//             isWord = false;
//         }
//     }
    
//     Node root;

//     /** Initialize your data structure here. */
//     public Trie() {
//         root = new Node();
//     }
    
//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         Node curr = root;
//         for(int i = 0; i < word.length(); i++) {           
//             if((curr.charMap).containsKey(word.charAt(i)))  
//                 curr = (curr.charMap).get(word.charAt(i));
//             else {
//                 Node child = new Node();
//                 (curr.charMap).put(word.charAt(i), child);
//                 curr = child;
//             }           
//         }
//         curr.isWord = true;
//     }
    
//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         if(searchPrefix(word) == null) return false;
//         else return searchPrefix(word).isWord;
//     }
    
//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         if(searchPrefix(prefix) == null) return false;
//         else return true;
//     }
    
//     private Node searchPrefix(String prefix) {
//         Node curr = root;
//         for(int i = 0; i < prefix.length(); i++) {
//             if((curr.charMap).containsKey(prefix.charAt(i))) {
//                 curr = (curr.charMap).get(prefix.charAt(i));
//             } else return null;
//         }
//         return curr;
//     }
// }

//runtime:29ms memory usage:47.9MB

public class Trie {

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
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {           
            char ac = word.charAt(i);
            if(curr.children[ac - 'a'] == null) curr.children[ac - 'a'] = new Node(ac);
            curr = curr.children[ac - 'a'];                      
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(searchPrefix(word) == null) return false;
        else return searchPrefix(word).isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    
    private Node searchPrefix(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ac = prefix.charAt(i);
            if(curr.children[ac - 'a'] != null) curr = curr.children[ac - 'a'];
            else return null;
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
