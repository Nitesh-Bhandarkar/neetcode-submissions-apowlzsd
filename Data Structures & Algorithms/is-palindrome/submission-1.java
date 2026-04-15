class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length()-1;
        while(leftPointer < rightPointer){
            if(!Character.isLetterOrDigit(s.charAt(leftPointer))){
                leftPointer++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(rightPointer))){
                rightPointer--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(leftPointer)) == Character.toLowerCase(s.charAt(rightPointer))){
                leftPointer++;
                rightPointer--;
            }
            else{
                return false;
            }
        }

        return true;   
    }
}
