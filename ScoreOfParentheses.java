// solution 1: using stack

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}


// solution 2: using tree idea
// score = sum of leaf node's depth

class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0;
        int score = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='(') depth++;
            if (s.charAt(i) == ')') depth--;
            
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(')
                score += 1 << depth;
        }
        
        return score;
    }
}
