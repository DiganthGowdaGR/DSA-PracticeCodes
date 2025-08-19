import java.util.Stack;

class bracketCheck {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket → push
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            // If closing bracket → check top of stack
            else {
                if (stack.isEmpty()) {
                    return false; // No opening bracket available
                }

                char top = stack.pop(); // Get last opening bracket
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false; // Mismatched bracket
                }
            }
        }

        // At the end, stack must be empty
        return stack.isEmpty();
    }
}
