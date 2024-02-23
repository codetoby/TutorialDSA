package Week1;
import java.util.HashMap;

import Utils.Node;
import Utils.Stack.Stack;

public class BalancedParenthesesChecker {

    Stack<Character> stack;
    HashMap<Character, Character> parantheses = new HashMap<>();

    public BalancedParenthesesChecker() {
        stack = new Stack<>();
        parantheses.put('{', '}');
        parantheses.put('(', ')');
        parantheses.put('[', ']');
    }

    public boolean checkString(String sequence) {

        char[] charSequence = sequence.toCharArray();
        int n = charSequence.length;

        for (int i = 0; i < n; i++) {
            if (parantheses.containsKey(charSequence[i])) {
                Node<Character> node = new Node<Character>(charSequence[i]);
                stack.add(node);
            }
            if (parantheses.containsValue(charSequence[i])) {
                Node<Character> character = stack.top();
                if (stack.isEmpty()) {
                    return false;
                }
                if (parantheses.get(character.data) != charSequence[i]) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        
        BalancedParenthesesChecker checker = new BalancedParenthesesChecker();

        System.out.println(checker.checkString("{[(a + b) * c] - d}]"));

    }


    
}
