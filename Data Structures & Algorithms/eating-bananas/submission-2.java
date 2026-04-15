class Solution {
    private int getTimeTaken(int[] piles, int speed){
        int t = 0;
        for(int i=0; i<piles.length; i++){
            t += (piles[i]/speed);
            if(piles[i]%speed != 0){
                t++;
            }
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int minSpeed = 1;
        int maxSpeed = piles[n-1];
        while(minSpeed <= maxSpeed){
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            int timeTaken = getTimeTaken(piles, midSpeed);
            if(timeTaken > h){
                minSpeed = midSpeed + 1;
            }
            else{
                maxSpeed = midSpeed - 1;
            }
        }

        return minSpeed;   
    }
}
