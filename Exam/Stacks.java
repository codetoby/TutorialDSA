package Exam;

import java.util.Stack;

public class Stacks {

    public static Stack<Integer> reOrder(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();

        int min = stack.peek();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num < min) {
                min = num;
            }
            result.add(num);
        }
        
        while (!result.isEmpty()) {
            int num = result.pop();
            if (num != min) {
                stack.push(num);
            }
        }
        stack.push(min);
        
        return stack;
        
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(-2);
        stack.push(4);
        stack.push(-6);

        System.out.println(reOrder(stack));
        
    }
    
}
