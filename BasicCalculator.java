import java.util.*;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(eval(basicCalculator("1+2*3")));
    }

    public static String basicCalculator(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> opStack = new Stack<>();

        HashMap<Character, Integer> order = new HashMap<>();

        order.put('(', 0);
        order.put(')', 0);
        order.put('+', 1);
        order.put('-', 1);
        order.put('*', 2);
        order.put('/', 2);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(Character.toString(c));
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                char top = opStack.pop();
                while (!opStack.isEmpty() && top != '(') {
                    sb.append(Character.toString(top));
                    top = opStack.pop();
                }
            } else if (!Character.isWhitespace(c)) {
                while (!opStack.isEmpty() && order.get(opStack.peek()) >= order.get(c)) {
                    sb.append(Character.toString(opStack.pop()));
                }
                opStack.push(c);
            } else {
                continue;
            }
        }

        while (!opStack.isEmpty())
            sb.append(Character.toString(opStack.pop()));

        return sb.toString();
    }

    public static int eval(String postfix) {
        Stack<Character> operandStack = new Stack<>();

        for(int i = 0; i < postfix.length(); i++){
            char c = postfix.charAt(i);
            if(Character.isDigit(c))
                operandStack.push(c);
            else {
                int operand2 = operandStack.pop() - '0';
                int operand1 = operandStack.pop() - '0';
                int res = doMath(operand1, operand2, c);
                operandStack.push((char)(res+'0'));
            }
        }

        return operandStack.pop() - '0';
    }

    private static int doMath(int operand1, int operand2, char token) {
        if(token == '+')
            return operand1 + operand2;
        else if(token == '-')
            return operand1 - operand2;
        else if(token == '*')
            return operand1 * operand2;
        else 
            return operand1 / operand2;
    }
}
