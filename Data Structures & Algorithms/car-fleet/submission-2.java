class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] elements = new int[n][2];
        for(int i=0; i<n; i++){
            elements[i] = new int[]{position[i],speed[i]};
        }

        Arrays.sort(elements, (o1, o2) -> o2[0]-o1[0]);
        int count = 1;
        double prevTime = (target - elements[0][0])/(double)elements[0][1];
        for(int i=1; i<n; i++){
            int[] currElement = elements[i];
            double t2 = (target - currElement[0])/(double)currElement[1];

            if(Double.compare(prevTime, t2) < 0){
                count++;
                prevTime = t2;   
            }
        }

        return count;  
    }
}
