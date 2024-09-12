package Java;

import java.util.Stack;

public class TempIncrToTheRightStack {
    public static void main(String[] args) {
        for(int i : dailyTemperatures(new int[]{30, 38, 30, 36, 40, 28})){
            System.out.println(i);
        }
    }
        public static int[] dailyTemperatures(int[] temperatures) {
            Stack<int[]> stack = new Stack<>();
            int[] res = new int[temperatures.length];
            for(int tem=0; tem< temperatures.length; tem++)
            {
                int t = temperatures[tem];
                while(!stack.isEmpty() && t > stack.peek()[0] ){
                    int pair[] = stack.pop();
                    res[pair[1]] = tem - pair[1];
    
                }
                stack.push(new int[]{t, tem});
                printStack(stack);
                System.out.println();
                
            }
            return res;
        }
    
          public static void printStack(Stack<int[]> stack) {
            if (stack.isEmpty()) {
                return;
            }
    
            // Step 1: Remove the top element
            int[] topElement = stack.pop();
    
            // Step 2: Recursively print the rest of the stack
            printStack(stack);
    
            // Step 3: Print the current top element
            System.out.print(topElement[0]+ " ");
    
            // Step 4: Push the element back to restore the original stack
            stack.push(topElement);
        }
    }
    