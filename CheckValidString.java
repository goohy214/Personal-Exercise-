class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stars = new Stack<>();
        char top = '/';
        
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '*') stack.push(c);
            else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    top = stack.pop();
                    stars.push(top);
                }
                if (stack.isEmpty() && !stars.isEmpty()) stars.pop();
                else if (stack.isEmpty() && stars.isEmpty()) return false;
                else stack.pop();
                while(!stars.isEmpty()) stack.push(stars.pop());
            }
        }
        
        while(!stack.isEmpty()) {
            top = stack.pop();
            if (top == '*') stars.push(top);
            else {
                if (stars.isEmpty()) return false;
                else stars.pop();
            }
        }
        
        return true;
    }
}

class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c:s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c == ')' ? -1 : 1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
