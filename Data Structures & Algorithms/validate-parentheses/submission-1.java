class Solution {
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Set.of('(', '[', '{').contains(ch)) {
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char poppedChar = stack.pop();
                boolean isValid = switch (ch) {
                    case ')' -> {
                        yield (poppedChar == '(');
                    }
                    case ']' -> {
                        yield (poppedChar == '[');
                    }
                    case '}' -> {
                        yield (poppedChar == '{');
                    }
                    default -> {
                        yield false;
                    }

                };

                if (!isValid) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
