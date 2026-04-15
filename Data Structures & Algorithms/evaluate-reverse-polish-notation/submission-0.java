class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = Set.of("+", "-", "*", "/");
        Stack<String> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(operators.contains(tokens[i])){
                int r = Integer.parseInt(stack.pop());
                int l = Integer.parseInt(stack.pop());
                String result = switch(tokens[i]){
                    case "*" -> {
                        yield String.valueOf(r * l);
                    }
                    case "/" -> {
                        yield String.valueOf(l / r);
                    }
                    case "+" -> {
                        yield String.valueOf(l + r);
                    }
                    case "-" -> {
                        yield String.valueOf(l - r);
                    }
                    default -> {
                        yield "";
                    }
                };

                stack.push(result);
            }
            else{
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
        
    }
}
