import java.util.*;

class AutocompleteSystem {
    public class TrieNode {
        private TrieNode[] children;
        private int trieNodeFreq;
        
        private TrieNode() {
            children = new TrieNode[27];
            trieNodeFreq = 0;
        }
    }
    
    public class Pair {
        private String sentence;
        private int pairFreq;
        
        private Pair(String sentence, int pairFreq) {
            this.sentence = sentence;
            this.pairFreq = pairFreq;
        }
    }
    
    private TrieNode root;
    private StringBuilder prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = new StringBuilder();
        
        for(int i = 0; i < sentences.length; i++) 
            insert(sentences[i], times[i]);
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        
        if(c == '#') {
            insert(prefix.toString(), 1);
            prefix = new StringBuilder();
            return res;
        }
        
        prefix.append(c);
        PriorityQueue<Pair> candidates = search(prefix.toString());
                
        int cnt = 0;
        while(!candidates.isEmpty() && cnt < 3) {
            res.add((candidates.poll()).sentence);
            cnt ++;
        }
                   
        return res;
    }
    
    private void insert(String sentence, int time) {
        TrieNode curr = root;
        
        char[] sentenceCharArray = sentence.toCharArray();
        for(char ac: sentenceCharArray) {
            int index = ac == ' ' ? 26 : ac - 'a';
            if(curr.children[index] == null) curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        
        curr.trieNodeFreq += time;
    }
    
    private PriorityQueue<Pair> search(String prefix) {
        PriorityQueue<Pair> candidates = new PriorityQueue<>((a, b) -> (a.pairFreq == b.pairFreq ? a.sentence.compareTo(b.sentence) : b.pairFreq - a.pairFreq));
        
        TrieNode curr = root;
        
        char[] prefixCharArray = prefix.toCharArray();
        for(char ac: prefixCharArray) {
            int index = ac == ' ' ? 26 : ac - 'a';
            if(curr.children[index] == null) return candidates;
            curr = curr.children[index];
        }
        
        StringBuilder currsb = new StringBuilder();
        currsb.append(prefix);
        findSentence(curr, currsb, candidates);
        
        return candidates;
    }
    
    private void findSentence(TrieNode curr, StringBuilder currsb, PriorityQueue<Pair> candidates) {
        if(curr.trieNodeFreq > 0) {
            Pair candidate = new Pair(currsb.toString(), curr.trieNodeFreq);
            candidates.add(candidate);
        }
        
        for(int i = 0; i < 27; i++) {
            if(curr.children[i] == null) continue;
            char ac = i == 26 ? ' ' : (char)(i + 'a');
            currsb.append(ac);
            findSentence(curr.children[i], currsb, candidates);
            currsb.setLength(currsb.length() - 1);
        }   
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */