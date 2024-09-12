package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesis {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(4, 0, 0, stack, res);
        System.out.print(res);
        
    }

    private static void backtrack(int n, int openN, int closedN, Stack<Character> stack, List<String> res) {
        if (openN == closedN && openN == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            stack.push('(');
            backtrack(n, openN + 1, closedN, stack, res);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(n, openN, closedN + 1, stack, res);
            stack.pop();
        }
    }
    
}
