class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftBracket = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftBracket.push(i);
            }
            else if(ch == '*'){
                stars.push(i);
            }
            else{
                if(!leftBracket.isEmpty()){
                    leftBracket.pop();
                }
                else{
                    if(!stars.isEmpty()){
                        stars.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }

        while(!leftBracket.isEmpty() && !stars.isEmpty()){
            int leftIdx = leftBracket.pop();
            int starIdx = stars.pop();
            if(leftIdx > starIdx){
                return false;
            }
        }

        return leftBracket.isEmpty();
        
    }
}
