class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] freq = new int[1001];
        int min = Integer.MAX_VALUE;
        for(int h : hand){
            freq[h]++;
            min = Math.min(min,h);
        }

        int pickedCardCount = 0;
        int minCard = min;
        while(pickedCardCount != hand.length){
            
            int nextCard = minCard;
            for(int i=0; i<groupSize; i++){
                freq[nextCard]--;
                if(freq[nextCard] < 0){
                    return false;
                }
                pickedCardCount++;
                nextCard++;
            }

            while(minCard < 1001 && freq[minCard] <= 0){
                minCard++;
            }
        }

        return true;        
    }
}
